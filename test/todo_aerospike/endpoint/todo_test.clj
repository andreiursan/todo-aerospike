(ns todo-aerospike.endpoint.todo-test
  (:require [clojure.test :refer :all]
            [todo-aerospike.endpoint.todo :as todo]))

(def handler
  (todo/todo-endpoint {}))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))
