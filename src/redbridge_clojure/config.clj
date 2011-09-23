(ns redbridge-clojure.config
  (:import [org.jruby CompatVersion]))

(def default-config-path "redbridge-config.clj")

(defn config
  ([] (read-string (slurp default-config-path)))
  ([path] (read-string (slurp path))))

(defn set-container-version
  "Sets the version of a ScriptingContainer.

   Usage: (set-container-version container \"1.9\") ;=>"
  [container version]
  (let [set-version (partial (. container setCompatVersion))]
    (if (= version "1.8")
      (set-version (. CompatVersion RUBY1_8))
      (set-version (. CompatVersion RUBY1_9)))))