# Double Booked

A Clojure program to detect overlapping events based on their start and end times.

## Introduction

In order to help maintain a calendar of events, it is important to know if they overlap. This program solves the "Double Booked" issue by detecting pairs of overlapping events from a given sequence.

## Input format

This program uses a sequence of maps, in which every map represents an event. Also, these maps have the following keys:

- `:start-ts`: The start timestamp of the event.
- `:end-ts`: The end timestamp of the event.

You can also see the example below:
```clojure
(def event1 {:start-ts 1 :end-ts 10})
(def event2 {:start-ts 5 :end-ts 20})
```

## Running tests

You may run all tests by running the following command:

```clojure -M:test-runner```
