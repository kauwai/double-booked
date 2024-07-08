(ns double-booked.core-test
  (:require [clojure.test :refer [deftest is testing]]
            [double-booked.core :as subject]))

(def event1 {:start-ts 10000 :end-ts 10040})
(def event2 {:start-ts 10001 :end-ts 10010})
(def event3 {:start-ts 10010 :end-ts 10052})
(def event4 {:start-ts 10050 :end-ts 10084})

(def events-with-timestamp [event1 event2 event3 event4])

(deftest double-booked-test
  (testing "Find if a pair of events overlap"
    (is (= true 
           (subject/overlaps? event1 event2)))
     (is (= false
           (subject/overlaps? event1 event4))))  
  (testing "Returns a sequence of all pairs of overlapping events"
   (is (= [[event1 event2]
           [event1 event3]
           [event2 event3]
           [event3 event4]] 
          (subject/get-overlapping-events events-with-timestamp)))))
