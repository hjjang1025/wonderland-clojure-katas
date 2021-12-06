(ns doublets.solver
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]
            [clojure.set :as set]))

(def words (-> "words.edn"
               (io/resource)
               (slurp)
               (read-string)))

(def words-set (set words))
(def words-frequencies
  (map frequencies words))


(defn next-doublet? [word1 word2]
  (when (and (words-set word1)
             (words-set word2)
             (= (count word1) (count word2)))
    (->> (map vector word1 word2)
         (filter (fn [[x y]] (= x y)))
         (count)
         (inc)
         (= (count word1)))))


(doublets "wheat" "bread")


(next-doublet? "wheat" "cheat")

(filter #(next-doublet? "ye" %) words)

(defn append-doublets [word-coll last-word]
  (when (and (words-set word1)
             (words-set word2)
             (= (count word1) (count word2)))
    (->> (map vector word1 word2)
         (filter (fn [[x y]] (= x y)))
         (count)
         (inc)
         (= (count word1)))))

(defn doublets [word1 word2]
  (let [word1-frequencies (frequencies word1)
        word2-frequencies (frequencies word2)]
    (if (not= (count word1) (count word2))
      []
      [1])))
