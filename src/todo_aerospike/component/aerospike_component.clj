(ns todo-aerospike.component.aerospike-component
  (:require [com.stuartsierra.component :as component])
  (:import [com.aerospike.client AerospikeClient]))

(defn connect-to-database [host port]
  (new AerospikeClient host port))

(defrecord AerospikeComponent [host port conn]
  ;; Implement the Lifecycle protocol
  component/Lifecycle

  (start [component]
    (println ";; Starting database")
    (let [conn (connect-to-database host port)]
      (assoc component :conn conn)))

  (stop [component]
    (println ";; Stopping database")
    (.close conn)
    (assoc component :conn nil)))

(defn aerospike-component [conf]
  (map->AerospikeComponent conf))
