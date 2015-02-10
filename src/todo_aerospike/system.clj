(ns todo-aerospike.system
  (:require [com.stuartsierra.component :as component]
            [duct.component.endpoint :refer [endpoint-component]]
            [duct.component.handler :refer [handler-component]]
            [duct.middleware.not-found :refer [wrap-not-found]]
            [meta-merge.core :refer [meta-merge]]
            [ring.component.jetty :refer [jetty-server]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [todo-aerospike.component.aerospike-component :refer [aerospike-component]]
            [todo-aerospike.endpoint.home :refer [home-endpoint]]
            [todo-aerospike.endpoint.status :refer [status-endpoint]]
            [todo-aerospike.endpoint.todo :refer [todo-endpoint]]))

(def base-config
  {:app {:middleware [[wrap-not-found :not-found]
                      [wrap-defaults :defaults]]
         :not-found  "Resource Not Found"
         :defaults   api-defaults}})

(defn new-system [config]
  (let [config (meta-merge base-config config)]
    (-> (component/system-map
         :app  (handler-component (:app config))
         :http (jetty-server (:http config))
         :db     (aerospike-component "127.0.0.1" 3000)
         :home   (endpoint-component home-endpoint)
         :status (endpoint-component status-endpoint)
         :todo   (endpoint-component todo-endpoint))
        (component/system-using
         {:http [:app]
          :app  [:home :status :todo]
          :home []
          :status [:db]
          :todo [:db]}))))
