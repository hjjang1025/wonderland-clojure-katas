(ns alphabet-cipher.coder)

(defn encode [keyword message]
  (let [len (max (count keyword) (count message))
        keyword-idxs (take len (cycle (map #(- (int %) 97)  keyword)))
        message-idxs (take len (cycle (map #(- (int %) 97)  message)))
        cipher-idxs (map + keyword-idxs message-idxs)
        encode-alphabet (fn [idx] (nth (cycle "abcdefghijklmnopqrstuvwxyz") idx))]
    (->> (map encode-alphabet cipher-idxs)
         (apply str))))


(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")

