(ns redbridge-clojure.config
  (:import [org.jruby CompatVersion]))

(def default-config-path (str (System/getProperty "user.dir") "/redbridge-config.clj"))

(defn config
  ([] (read-string default-config-path))
  ([path] (read-string path)))

(defn set-container-version
  "Sets the version of a ScriptingContainer.

   Usage: (set-container-version container \"1.9\") ;=>"
  [container version]
  (if (= version "1.8")
   (. container setCompatVersion (. CompatVersion RUBY1_8))
   (. container setCompatVersion (. CompatVersion RUBY1_9))))