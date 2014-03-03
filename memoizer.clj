(ns memoizer)
(defn factorial [x]
	(loop [n x f 1]
		(if (= n 1)
			f
			(recur (dec n) (* f n)))))
(defn bounded-memoize 
  "Return a bounded memoized version of fn 'f' 
   that caches the last 'k' computed values"
  [f k]
  (assert (and (fn? f) (integer? k)))

  
  )
 (println (factorial 5))