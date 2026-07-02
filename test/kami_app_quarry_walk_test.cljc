(ns kami-app-quarry-walk-test
  "Test for the restored kami-app-quarry-walk config data (kami-engine/
  kami-app-quarry-walk/src/lib.rs, deleted PR #82). The original had no
  #[test]s (it's a wasm-bindgen entrypoint); this provides basic shape
  coverage of the ported configuration."
  (:require [clojure.test :refer [deftest is testing]]
            [kami-app-quarry-walk :as qw]))

(deftest namespace-loads
  (testing "the restored CLJC namespace loads"
    (is (some? (the-ns 'kami-app-quarry-walk)))))

(deftest config-shape
  (is (= "quarry" qw/biome))
  (is (= [0.0 140.0 120.0] qw/spawn-position))
  (is (= :first-person (:mode qw/camera-config)))
  (is (= :wasd-fps qw/input-mode))
  (is (= 77.0 (:sea-level qw/terrain-config)))
  (is (= [:sky :terrain :water] (:pipelines qw/app-config))))
