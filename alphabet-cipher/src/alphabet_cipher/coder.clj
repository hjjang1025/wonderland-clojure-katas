(ns alphabet-cipher.coder)

(defn encode [keyword message]
  (let [len (max (count keyword) (count message))
        keyword-idxs (take len (cycle (map #(- (int %) 97)  keyword)))
        message-idxs (take len (cycle (map #(- (int %) 97)  message)))
        encoded-idxs (map + keyword-idxs message-idxs)
        idx->alphabet (fn [idx] (nth (cycle "abcdefghijklmnopqrstuvwxyz") idx))]
    (->> (map idx->alphabet encoded-idxs)
         (apply str))))


(defn decode [keyword cipher]
  (let [len (max (count keyword) (count cipher))
        keyword-idxs (take len (cycle (map #(- (int %) 97)  keyword)))
        cipher-idxs (take len (cycle (map #(- (int %) 97)  cipher)))
        decoded-idxs (map (partial + 26) (map - cipher-idxs keyword-idxs))
        idx->alphabet (fn [idx] (nth (cycle "abcdefghijklmnopqrstuvwxyz") idx))]
    (->> (map idx->alphabet decoded-idxs)
         (apply str))))


(defn get-cycle [coll]
  (let [len (count coll)]
    (->> (keep-indexed (fn [idx _] (when (= coll
                                            (apply str (take len (cycle (subs coll 0 (inc idx)))))) (subs coll 0 (inc idx)))) coll)
         (first))))


(defn decipher [cipher message]
  (let [len (count message)
        cipher-idxs (take len (cycle (map #(- (int %) 97)  cipher)))
        message-idxs (take len (cycle (map #(- (int %) 97)  message)))
        keyword-idxs (map (partial + 26) (map - cipher-idxs message-idxs))
        idx->alphabet (fn [idx] (nth (cycle "abcdefghijklmnopqrstuvwxyz") idx))]
    (->> (map idx->alphabet keyword-idxs)
         (apply str)
         (get-cycle))))

