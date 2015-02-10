(ns todo-aerospike.component.aerospike-component
  (:require [com.stuartsierra.component :as component])
  (:import '(com.aerospike.client AerospikeClient Info)
           '(com.aerospike.client.policy Policy WritePolicy)
           '(com.aerospike.client.cluster Node)))

(defrecord AerospikeComponent []
  component/Lifecycle
  (start [this] this)
  (stop [this] this))

(defn aerospike-component []
  (->AerospikeComponent))
