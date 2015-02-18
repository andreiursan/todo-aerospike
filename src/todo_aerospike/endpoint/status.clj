(ns todo-aerospike.endpoint.status
  (:require [compojure.core :refer :all]
            [todo-aerospike.domain.utils.db :refer [nodes-statuses]]))

(defn status-endpoint [{db :db}]
  (routes
   (GET "/status" [] (nodes-statuses (:conn db)))))
