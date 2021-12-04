(ns fox-goose-bag-of-corn.puzzle)

(def start-pos [[[:fox :goose :corn :you] [:boat] []]])

(defn river-crossing-plan []
  [[[:fox :goose :corn :you] [:boat] []]
   [[:fox :corn] [:boat :you :goose] []]
   [[:fox :corn] [:boat] [:you :goose]]
   [[:fox :corn] [:boat :you] [:goose]]
   [[:fox :corn :you] [:boat] [:goose]]
   [[:fox] [:boat :you :corn] [:goose]]
   [[:fox] [:boat] [:you :goose :corn]]
   [[:fox] [:boat :you :goose] [:corn]]
   [[:fox :goose :you] [:boat] [:corn]]
   [[:goose] [:boat :you :fox] [:corn]]
   [[:goose] [:boat] [:corn :you :fox]]
   [[:goose] [:boat :you] [:fox :corn]]
   [[:goose :you] [:boat] [:fox :corn]]
   [[] [:boat :goose :you] [:fox :corn]]
   [[] [:boat] [:fox :goose :corn :you]]])



