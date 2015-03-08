(ns todo-aerospike.domain.todo
  (:require [todo-aerospike.domain.utils.db :as db]))

(def todo-set "todos")
(def todo-namespace "test")

(defn create-key
  ([] create-key (str (java.util.UUID/randomUUID)))
  ([uuid] ({:namespace todo-namespace :set todo-set :uuid uuid})))

(defn add [conn todo]
  (db/upsert conn (create-key) todo))

(defn delete [conn uuid]
  (db/delete conn (create-key uuid)))
