(ns alphabet-cipher.coder)

(defn get-idxs [len text]
  (take len (cycle (map #(- (int %) 97)  text))))

(defn idx->alphabet [idx]
  (nth (cycle "abcdefghijklmnopqrstuvwxyz") idx))

(defn encode [keyword message]
  (let [len (max (count keyword) (count message))
        keyword-idxs (get-idxs len keyword)
        message-idxs (get-idxs len message)
        encoded-idxs (map + keyword-idxs message-idxs)]
    (->> (map idx->alphabet encoded-idxs)
         (apply str))))

(defn decode [keyword cipher]
  (let [len (max (count keyword) (count cipher))
        keyword-idxs (get-idxs len keyword)
        cipher-idxs (get-idxs len cipher)
        decoded-idxs (map (partial + 26) (map - cipher-idxs keyword-idxs))]
    (->> (map idx->alphabet decoded-idxs)
         (apply str))))


(defn get-cycle [coll]
  (let [len (count coll)]
    (->> (keep-indexed (fn [idx _]
                         (when (= coll
                                  (->> (cycle (subs coll 0 (inc idx)))
                                       (take len)
                                       (apply str))) (subs coll 0 (inc idx)))) coll)
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

