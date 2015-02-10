(ns todo-aerospike.endpoint.status
  (:require [compojure.core :refer :all])
  (:import [com.aerospike.client Info]))

(defn status-endpoint [{db :db}]
  (routes
   (GET "/status" []
        (let [conn (:conn db)
              first-node (first (.getNodes conn))]
          (str (. Info request nil first-node))))))

