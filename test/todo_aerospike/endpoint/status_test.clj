(ns todo-aerospike.endpoint.status-test
  (:require [clojure.test :refer :all]
            [todo-aerospike.endpoint.status :as status]))

(def handler
  (status/status-endpoint {}))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))
