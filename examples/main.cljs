(ns main
  (:require cljs-crypto-rand :as r))

(defn log-str 
  ([x]
    (do
      (.log js/console (pr-str x))
      x))
  ([m x]
    (do 
      (log-str {:msg m :data x})
      x)))

(log-str (r/safe-rand-int))
(log-str (r/rand-u8))
(log-str (r/rand-u8 4))
(log-str (vec (r/rand-u8 4)) )
(log-str (r/rand-u16))
(log-str (r/rand-u16 4))
(log-str (vec(r/rand-u16 4)))
(log-str (r/rand-u32))
(log-str (r/rand-u32 4))
(log-str (vec (r/rand-u32 4)))
(log-str (r/rand-8))
(log-str (r/rand-8 4))
(log-str (vec (r/rand-8 4)))
(log-str (r/rand-16))
(log-str (r/rand-16 4))
(log-str (vec (r/rand-16 4)))
(log-str (r/rand-32))
(log-str (r/rand-32 4))
(log-str (vec (r/rand-32 4)))
