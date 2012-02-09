(ns cljs-crypto-rand.core)

(def have-crypto? js/window.crypto)

;; make native arrays sequable
;; should this be elseewhere?
;; need conditional compilation - because of extending
;; assume if have crypto then have native arrays
(if have-crypto?
  (extend-protocol ISeqable 
    js/Int32Array
    (-seq [array] (array-seq array 0))
    js/Int16Array
    (-seq [array] (array-seq array 0))
    js/Int8Array
    (-seq [array] (array-seq array 0))
    js/Uint32Array
    (-seq [array] (array-seq array 0))
    js/Uint16Array
    (-seq [array] (array-seq array 0))
    js/Uint8Array
    (-seq [array] (array-seq array 0))
    ))


(defn get-random [arr]
  (. js/window.crypto getRandomValues arr)
  arr)

(defn rand-u8 
  ([] (first (rand-u8 1)))
  ([n]
    (let [arr (js/Uint8Array. n)]
      (get-random arr))))

(defn rand-u16 
  ([]  (first (rand-u16 1)))
  ([n] (let [arr (js/Uint16Array. n)]
         (get-random arr))))

(defn rand-u32 
  ([]  (first (rand-u32 1)))
  ([n] (let [arr (js/Uint32Array. n)]
         (get-random arr))))

(defn rand-8 
  ([]  (first (rand-8 1)))
  ([n] (let [arr (js/Int8Array. n)]
         (get-random arr))))

(defn rand-16 
  ([]  (first (rand-16 1)))
  ([n] (let [arr (js/Int16Array. n)]
         (get-random arr))))

(defn rand-32
  ([]  (first (rand-32 1)))
  ([n] (let [arr (js/Int32Array. n)]
         (get-random arr))))


(def pow2-32 4294967296)

(defn safe-rand-int
  "This function should be safe across browsers

   same semantics as core/rand-int  
   will use window.crypto if available  
   for consistency, 
     - max random int is 4294967296 = 2**32 (unsigned 32 bit int)
  "
  ([]  (if have-crypto? (rand-u32) (rand-int pow2-32)))
  ([n] 
    {:pre [(<= n pow2-32) (>= n 0)]}
    (let [r32 (safe-rand-int)]
      (.round js/Math (* n (/ r32 pow2-32))))))

(defn log-str 
  ([x]
    (do
      (.log js/console (pr-str x))
      x))
  ([m x]
    (do 
      (log-str {:msg m :data x})
      x)))

(log-str (safe-rand-int))

(log-str (rand-u8))
(log-str (rand-u8 4))
(log-str (vec (rand-u8 4)) )
(log-str (rand-u16))
(log-str (rand-u16 4))
(log-str (vec(rand-u16 4)))
(log-str (rand-u32))
(log-str (rand-u32 4))
(log-str (vec (rand-u32 4)))
(log-str (rand-8))
(log-str (rand-8 4))
(log-str (vec (rand-8 4)))
(log-str (rand-16))
(log-str (rand-16 4))
(log-str (vec (rand-16 4)))
(log-str (rand-32))
(log-str (rand-32 4))
(log-str (vec (rand-32 4)))




