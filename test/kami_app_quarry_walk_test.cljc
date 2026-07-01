(ns kami_app_quarry_walk-test
  (:require [clojure.test :refer [deftest is testing]]
            [kami_app_quarry_walk]))
(deftest namespace-loads
  (testing "the restored CLJC namespace loads"
    (is (some? kami_app_quarry_walk))))
