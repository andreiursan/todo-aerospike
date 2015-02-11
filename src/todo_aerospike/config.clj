(ns todo-aerospike.config
  (:require [environ.core :refer [env]]))

(def defaults
  ^:displace {:http {:port 9000}})

(def environ
  {:http {:port (some-> env :port Integer.)}
   :db   {:port 3000 :host "127.0.0.1"}})
