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


; -----------------------
; Living Clojure p.227
; 각 자릿수의 세제곱의 합이 1000 미만인 수

(defn another-land-number? [x]
  (let [digits (map #(Character/digit % 10) (str x))
        sum-of-cubics (apply + (map #(* % % %) digits))]
    (< sum-of-cubics 1000)))


(defn another-land-numbers []
  (let [number-range (range 100000 999999)]
    (->> (filter another-land-number? number-range))))