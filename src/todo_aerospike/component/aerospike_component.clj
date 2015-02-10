(ns todo-aerospike.component.aerospike-component
  (:require [com.stuartsierra.component :as component])
  (:import [com.aerospike.client AerospikeClient Info]
           [com.aerospike.client.policy Policy WritePolicy]
           [com.aerospike.client.cluster Node]))

(defn connect-to-database [host port]
  (new AerospikeClient host port))

(defrecord AerospikeComponent [host port db]
  ;; Implement the Lifecycle protocol
  component/Lifecycle

  (start [component]
    (println ";; Starting database")
    (let [db (connect-to-database host port)]
      (assoc component :db db)))

  (stop [component]
    (println ";; Stopping database")
    (.close db)
    (assoc component :db nil)))

(defn aerospike-component [host port]
  (map->AerospikeComponent {:host host :port port}))
