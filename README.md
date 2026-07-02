# kotoba-lang/kami-app-quarry-walk

Zero-dep portable `.cljc` — restored from the legacy `kami-engine/kami-app-quarry-walk`
Rust crate (deleted in kotoba-lang/kami-engine PR #82 "Remove Rust workspace from
kami-engine") as part of the **clj-wgsl migration** (ADR-2607010930, `com-junkawasaki/root`).

## What this is

The original crate (76 lines) was almost entirely a `wasm-bindgen` entrypoint
(`run_quarry_walk_v2`) orchestrating `KamiApp`/`kami_pipelines`/`kami_terrain_scene`
builder calls — native WASM/wgpu substrate with no portable logic of its own ("No
pipeline code here: game logic = biome selection + spawn + camera/input wiring. All
rendering reuses kami_pipelines.", per its own doc comment).

What IS portable is the game's **configuration**: spawn position, camera mode,
terrain/water adapter parameters. This namespace captures that configuration as plain
CLJC data — a specification a native/WASM host could read to reconstruct the original
scene setup, rather than a re-implementation of the builder orchestration itself.

## Status

Restored — 2 tests / 7 assertions, 0 failures (the original had no `#[test]`s; this
provides basic shape coverage of the ported configuration).

## Develop

```bash
clojure -M:test
```
