(ns todo-aerospike.domain.utils.db
  (:import [com.aerospike.client Bin AerospikeClient Key Record Info]
           [com.aerospike.client.cluster Node]
           [com.aerospike.client.policy WritePolicy]))

(def write-policy (new WritePolicy))

(defn nodes-statuses [conn]
  "Returns a vector with the status of
  each node in the Aerospike Cluster
  [ node-01-status node-02-status ... ]"
  (let [nodes (.getNodes conn)]
    (map #(. Info request nil %) nodes)))

(defn- create-key [keymap]
  (new Key (:namespace keymap) (:set keymap) (:uuid keymap)))

(defn- create-bin [binmap]
  (new Bin (:column binmap) (:value binmap)))

(defn upsert [conn keymap binmap]
  "[C]R[U]D upserts a record"
  (let [key (create-key keymap)
        bin (create-bin binmap)]
    (. conn put write-policy key (into-array [bin]))))

(defn get-record [conn keymap]
  "C[R]UD retrieves the record by its key"
  (let [key (create-key keymap)]
    (. conn get nil key)))

(defn delete [conn keymap]
  "CRU[D] deletes a record"
  (let [key (create-key keymap)]
    (. conn delete write-policy key)))
