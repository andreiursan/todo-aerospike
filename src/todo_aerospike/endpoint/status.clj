(ns todo-aerospike.endpoint.status
  (:require [compojure.core :refer :all])
  (:import [com.aerospike.client Info]))

(defn node-status [conn]
  (let [first-node (.. conn getNodes first)]
    (str (. Info request nil first-node))))

(defn status-endpoint [{db :db}]
  (routes
   (GET "/status" [] (node-status (:conn db)))))
