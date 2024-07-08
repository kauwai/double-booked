(ns double-booked.core)

(defn overlaps? [event1 event2]
  (let [start-ts1 (:start-ts event1)
        start-ts2 (:start-ts event2)
        end-ts1   (:end-ts event1)
        end-ts2   (:end-ts event2)]
    (or (and (<= start-ts1 end-ts2) (>= end-ts1 start-ts2))
        (and (<= start-ts2 end-ts1) (>= end-ts2 start-ts1)))))

(defn get-overlapping-events
  "Returns pairs of overlapping events from a sequence of events. Events must have the following keys:
   
   :start-ts - The start timestamp of the event
   :end-ts - The end timestamp of the event"
  [events]
  (let [n (count events)]
    (for [i (range n)
          j (range (inc i) n)
          :when (overlaps? (events i) (events j))]
      [(events i) (events j)])))
