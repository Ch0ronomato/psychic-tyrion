(ns memoizer)
(defn now [] (new java.util.Date))
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
  	(if (false? (contains? cache f))
  		(def cache (conj cache {f {}})))

  	(if (= (contains? (cache f) arg) true)
  		(do 
  			(println "In cache") 
  			((cache f) arg))
  		(do
  			(println "Out of cache, adding to cache " k)
  			; execute our function
  			(def result (f arg))

  			; evict cache?
  			(if (>= (count (cache f)) k)
  				(do 
  					(def evicted (last (keys (cache f))))
  					(def cache (assoc cache f 
  						(apply (fn [entry] {(first entry) (last entry)}) (remove (fn [[cache-key cache-value]] 
  							(= cache-key evicted)) (cache f)))))))
  			; add to cache
  			(def cache (assoc cache f (conj (cache f) {arg result} )))
  			cache))
  		)
  )

 (def bounded (bounded-memoize factorial 2))
 (def bounded-two (bounded-memoize sum-from-zero 2))
 (def bounded-three (bounded-memoize sum-from-zero 3))

 (println (bounded 5))
 (println (bounded 5))
 (println (bounded 7))
 (println (bounded 7))
 (println (bounded 6))
 (println (bounded 5))
 
 (println (bounded-two 3))
 (println (bounded-two 3))
 (println (bounded-two 3))