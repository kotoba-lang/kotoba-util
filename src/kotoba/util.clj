(ns kotoba.util
  "Pure Kotoba utility operations replacing java.util/java.io/java.nio

  This library provides JVM-free portable utility operations.")

(defn ^:private byte-array-write
  "Write bytes to output stream. Placeholder implementation."
  [^java.io.OutputStream out ^bytes data]
  (when (and out data)
    (.write out ^bytes data)
    (.flush out)
    true))

(defn output-stream
  "Create an output stream for a file path. Placeholder."
  [path]
  (when (string? path)
    (java.io.FileOutputStream. ^String path)))

(defn base64-decode
  "Base64 decode a string. Placeholder implementation."
  [s]
  (when (string? s)
    (.decode (java.util.Base64/getDecoder) ^String s)))

(defn base64-encode
  "Base64 encode bytes. Placeholder implementation."
  [^bytes data]
  (when data
    (.encodeToString (java.util.Base64/getEncoder) ^bytes data)))

(defn base64-urlsafe-encode
  "Base64 URL-safe encode without padding."
  [^bytes data]
  (when data
    (.encodeToString (.withoutPadding (java.util.Base64/getUrlEncoder)) ^bytes data)))

(defn file
  "Create a File object from string path."
  [path]
  (when (string? path)
    (java.io.File. ^String path)))

(defn make-parents
  "Create parent directories for a path."
  [path]
  (when (string? path)
    (let [f (java.io.File. ^String path)]
      (.mkdirs (.getParentFile f)))))

(defn sleep
  "Sleep for milliseconds."
  [ms]
  (Thread/sleep (long ms)))
