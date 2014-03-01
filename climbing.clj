(ns climbing)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; part  a ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn simple-path-count
  "How many ways are there to climb a mountain of size n?"
  [n]
  
  ; The number of paths we can take in our 8-bit mountain is a 
  ; representation of pascals triangle (I know! Cool huh?!)
  ;         0
  ;        1 1
  ;       1 2 1
  ;      1 3 3 1
  ;     1 4 6 4 1
  ; So we can simply find utilize this model to find our total number of
  ; paths. Once we calculate our height
  ; The count of zeros for our 8 bit mountain is a representation of 
  ; an arithmetic sequence, with our common difference being 1.
  ; sigma(i = 0, k, i) = n. Using a little arithmetic, we can
  ; derive a formula to find "k" with only n (LUCKY our common difference is only a one)
  ; that k2 + k -2n.
  
  
  )


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; part  b ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn path-count-with-traps
  "How many ways are there to climb this 'mountain' with traps?
   'mountain' represents a mountain of size n = (count mountain),
   and (nth mountain i) is a String with exactly i+1 'O's or 'X's 
   and the rest spaces.
   "
  [mountain]
  
  ;; Your code here
  )

; (println (quadratic (* -2 3)))