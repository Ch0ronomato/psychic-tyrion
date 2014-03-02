(ns climbing)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; part  a ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; lower is the lower bound of our recursion
; upper is the upper bound of our recursion
; level is our current level iteration
(defn quick-rec-add [lower, upper, level]
  ; (println [lower, upper])
  (if (or (= level 1) (= upper lower))
    level
    (for [x (range lower (+ upper 1))]
      x)))

(defn simple-path-count
  "How many ways are there to climb a mountain of size n?"
  [n]
  
  ; *Disclosure* The reason I am not immediatly returning 2^n
  ; is because this will be a nice abstraction to solve 
  ; part B with, and considering I want to work at prismatic
  ; it might be a good idea to impress as a programmer, not
  ; a mathmatician ;)

  ; The number of paths we can take in our 8-bit mountain is a 
  ; representation of pascals triangle (I know! Cool huh?!)
  ;         0                 1
  ;        1 1               1 2
  ;       1 2 1             1 2 3
  ;      1 3 3 1           1 2 3 4
  ;     1 4 6 4 1         1 2 3 4 5
  ; So we can simply find utilize this model to find our total number of
  ; paths. Once we calculate our height
  ; The count of zeros for our 8 bit mountain is a representation of 
  ; an arithmetic sequence, with our common difference being 1.
  ; sigma(i = 0, k, i) = n. Using a little arithmetic, we can
  ; derive a formula to find "k" with only n (LUCKY our common difference is only a one)
  ; that k2 + k -2n.
  
  ; we will always have 2 distinct paths, straight up the sides
  ; sush is our suspected height. This being a derivation of pascals
  ; triangle, i suspect all possible paths will be 2 to the power of n
  (let [consts 2
    sush (Math/pow consts n)]
    (def paths 0)
    (for [x (range 1 (+ n 1))] 
      (if (or (= x 1 ) (= x n))
        (def paths (+ 1 paths))
        (quick-rec-add (- x 1) x (- n 1))
        )))
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

(println (simple-path-count 5))