# cljs-crypto-rand

cljs access to javascript crypto random numbers

## Usage

* clojars [cljs-crypto-rand "0.0.1"]

```clojure

; One cross browser safe fn is provided, matching the semantics of rand-int
; if window.crypto is not available (rand-int) will be used.
(safe-rand-int)
; 80062837246355

(safe-rand-int 200)
; 143


; The following functions require the browser to have "window.crypto"

(rand-u8)
(rand-u8 4)
(vec (rand-u8 4) )
; 217
; #<[object Uint8Array]>
; [22 231 12 142]

(rand-u16)
(rand-u16 4)
(vec(rand-u16 4)
; 65370
; #<[object Uint16Array]>
; [33465 26676 44997 7479]

(rand-u32)
(rand-u32 4)
(vec (rand-u32 4))
; 3415327091
; #<[object Uint32Array]>
; [269941158 2762388159 3880954986 4217866754]

(rand-8)
(rand-8 4)
(vec (rand-8 4))
; -64
; #<[object Int8Array]>
; [-13 62 -55 7]


(rand-16)
(rand-16 4)
(vec (rand-16 4))
; -31110
; #<[object Int16Array]>
; [28193 7793 19507 -4736]


(rand-32)
(rand-32 4)
(vec (rand-32 4))
; -288590794
; #<[object Int32Array]>
; [-354384416 67845353 840434753 -1041931204]

```

## License

Copyright (C) 2012 Dave Sann

Distributed under the Eclipse Public License, the same as Clojure.
