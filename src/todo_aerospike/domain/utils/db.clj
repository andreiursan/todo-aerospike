(ns todo-aerospike.domain.utils.db
  (:import [com.aerospike.client Bin AerospikeClient Key Record Info]
           [com.aerospike.client.cluster Node]
           [com.aerospike.client.policy WritePolicy]))

(defn nodes-statuses [conn]
  "Returns a vector with the status of
  each node in the Aerospike Cluster
  [ node-01-status node-02-status ... ]"
  (let [nodes (.getNodes conn)]
    (map #(. Info request nil %) nodes)))

(def key-namespace "todo-aerospike")
(def write-policy (new WritePolicy))

(defn uuid [] (str (java.util.UUID/randomUUID)))

(defn put [conn record]
  "[C]RUD creates a record"
  (let [bin (new Bin (:column record) (:value record))
        key (new Key key-namespace (:set record) (uuid))]
        (. conn put write-policy key (into-array [bin]))))


