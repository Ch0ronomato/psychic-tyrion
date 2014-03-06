(ns memoizer)
; (defrecord Cache )
(defn factorial [x]
	(loop [n x f 1]
		(if (= n 1) 
			f       
			(recur (dec n) (* f n))))) 
(defn sum-from-zero [x]
	(loop [i 0 upper x sum 0]
		(if (= i x)
			(+ sum i)
			(recur (inc i) upper (+ sum i)))))
(defn bounded-memoize 
  "Return a bounded memoized version of fn 'f' 
   that caches the last 'k' computed values"
  [f k]
  (assert (and (fn? f) (integer? k)))

  ; Note: Outside is immutable, so this value will be consistent as proven
  ; below. This function adds a increasing number to the result, over two
  ; different function objects. So outside is the same value for both 
  ; bounded and bounded-two.
  (def cache {})
  (def vect [])
  (def outside 1)
  (fn [arg]  	
  	; add a cache key to our cache structure
  	(if (= (contains? cache k) false)
  		(def cache (conj cache {k {}})))

  	; execute our function
  	(def result (f arg))

  	; add to cache
  	(def cache 
  		(assoc cache k 
  			(conj 
  				(get cache k)
  				{f result})))
  	cache)
  )

 (def bounded (bounded-memoize factorial 2))
 (def bounded-two (bounded-memoize sum-from-zero 2))
 (def bounded-three (bounded-memoize sum-from-zero 3))
 (println bounded)
 (println bounded-two)
 (println (bounded 5))
 ; (println (bounded 5))
 (println (bounded-two 3))
 (println (bounded-three 6))
 ; (println (bounded-two 3))
 ; (println (bounded-two 3))
 ; (println (bounded-two 3))