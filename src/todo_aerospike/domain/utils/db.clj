(ns todo-aerospike.domain.utils.db
  (:import [com.aerospike.client Info]
           [com.aerospike.client.cluster Node]))

(defn nodes-statuses [conn]
  "Returns a vector with the status of
  each node in the Aerospike Cluster
  [ node-01-status node-02-status ... ]"
  (let [nodes (.getNodes conn)]
    (map #(. Info request nil %) nodes)))
