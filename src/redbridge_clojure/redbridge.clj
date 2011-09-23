(ns redbridge-clojure.redbridge
  (:require [redbridge-clojure.config :as config])
  (:import [org.jruby CompatVersion]
           [org.jruby.embed ScriptingContainer LocalContextScope]))

(defn set-container-version
  "Sets the version of a container.

   Usage: (set-container-version container \"1.9\") ;=>"
  [container version]
  (. container setCompatVersion (. CompatVersion RUBY1_9)))

(defonce container
  (let [container (ScriptingContainer. LocalContextScope/SINGLETHREAD)]
    (do (set-container-version container)
        container)))

(defn execute
  "Takes a string of Ruby code and runs it.

   Usage: (execute \"'hello'.reverse\") ;=> \"olleh\""
  [rb-string]
  (. container runScriptlet rb-string))
