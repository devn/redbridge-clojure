(ns redbridge-clojure.redbridge
  (:require [redbridge-clojure.config :as config])
  (:import [org.jruby CompatVersion]
           [org.jruby.embed ScriptingContainer LocalContextScope]))

(defonce container
  (let [container (ScriptingContainer. LocalContextScope/SINGLETHREAD)]
    (do (config/set-container-version container (:ruby-version (config/config)))
        container)))

(defn execute
  "Takes a string of Ruby code and runs it.

   Usage: (execute \"'hello'.reverse\") ;=> \"olleh\""
  [rb-string]
  (. container runScriptlet rb-string))
