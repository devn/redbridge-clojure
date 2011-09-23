(ns redbridge-clojure.gem
  (:require [redbridge-clojure.ruby :as rb]))

(defn require-gem
  "Requires a Ruby gem.

   Usage: (require-gem \"rubygems\") ;=> true"
  [gem]
  (execute (str "require '" gem "'")))

(defn require-gems
  "Requires multiple Ruby gems.

   Usage: (require-gems \"rubygems\" \"haml-3.1.3/gem/haml\") ;=> true"
  [& gems]
  (doseq [gem gems]
    (require-gem gem)))