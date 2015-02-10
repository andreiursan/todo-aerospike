(ns todo-aerospike.endpoint.todo
  (:require [compojure.core :refer :all]))

(defn todo-endpoint [config]
  (routes
   (GET "/todos" [] "Hello World")))
