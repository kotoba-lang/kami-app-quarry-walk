# ADR 0001: Kotoba owns the quarry configuration contract

## Decision

`src/kami_app_quarry_walk.kotoba` is the sole production language source. Its
exports are closed, typed scalar configuration values. JVM Clojure is only a
test/compiler host and is not a production runtime.

Rendering, terrain streaming, input handling, WebGPU, physics, and game-loop
orchestration remain capability-gated Kami providers. This module cannot invoke
those effects; it only supplies admitted configuration across that boundary.

Conformance is checked by observable values, declared types, effects, and ABI
behavior in the reference evaluator, restricted JavaScript, and instantiated
typed Wasm. Generated Wasm bytes are intentionally not required to be equal.

## Consequences

- `.cljc`, `.clj`, and `.cljs` are rejected under `src`.
- Configuration maps are decomposed into typed exports, avoiding an ambient,
  extensible host-data boundary.
- Any future device or game-engine operation requires an explicit Kami
  capability and a separate admission decision.
