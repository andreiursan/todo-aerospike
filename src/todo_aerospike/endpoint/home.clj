(ns todo-aerospike.endpoint.home
  (:require [compojure.core :refer :all]))

(defn home-endpoint [config]
  (routes
   (GET "/" [] "HOME: Hello Berlin Clojurians!")))
