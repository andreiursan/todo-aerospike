(ns todo-aerospike.endpoint.status
  (:require [compojure.core :refer :all]))

(defn status-endpoint [config]
  (routes
   (GET "/status" [] "the server status is")))
