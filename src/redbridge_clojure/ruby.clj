(ns redbridge-clojure.ruby
  (:require [redbridge-clojure.redbridge :as redbridge])
  (:import [org.jruby.embed ScriptingContainer]))

(defn execute
  "Takes a string of Ruby code and runs it.

   Usage: (execute \"'hello'.reverse\") ;=> \"olleh\""
  [rb-string]
  (. redbridge/container runScriptlet rb-string))

;; TODO: This needs some work. callMethod has many signatures.
(defn call-method
  "Calls a method on an object.

   Usage: (call-method (execute \"String\") \"class\") ;=> #<RubyClass Class>"
  ([obj method]
     (. redbridge/container callMethod obj method Object))
  ([obj method arg]
     (. redbridge/container callMethod obj method arg Object)))