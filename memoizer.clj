(ns memoizer)
(defn factorial [n]
	(loop [n x f 1]
		(if (= i 1))
			f
			(recur (dec n) (* f i))))
(defn bounded-memoize 
  "Return a bounded memoized version of fn 'f' 
   that caches the last 'k' computed values"
  [f k]
  (assert (and (fn? f) (integer? k)))

  
  )
 (println (factorial 5))