(ns todo-aerospike.component.aerospike-component
  (:require [com.stuartsierra.component :as component]))

(defrecord AerospikeComponent []
  component/Lifecycle
  (start [this] this)
  (stop [this] this))

(defn aerospike-component []
  (->AerospikeComponent))
