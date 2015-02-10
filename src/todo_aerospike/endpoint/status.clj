(ns todo-aerospike.endpoint.status
  (:require [compojure.core :refer :all])
  (:import [com.aerospike.client Info]))

(defn status-endpoint [{db :db}]
  (routes
   (GET "/status" []
        (let [db (:db db)
              nodes (.getNodes db)
              first-node (first nodes)]
          (str (. Info request nil first-node))))))
