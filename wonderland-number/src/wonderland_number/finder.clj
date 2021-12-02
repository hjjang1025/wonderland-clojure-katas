(ns wonderland-number.finder)

(defn wonderland-number? [x]
  (letfn [(hasAllTheSameDigits? [n1 n2]
           (let [s1 (set (str n1))
                 s2 (set (str n2))]
             (= s1 s2)))]
    (let [multiplied-list (map (partial * x) [2 3 4 5 6])]
      (= 5 (count (filter #(hasAllTheSameDigits? x %) multiplied-list))))))

(defn wonderland-number []
  (let [number-range (range 100000 166666)]
    (->> (filter wonderland-number? number-range)
         (first))))
