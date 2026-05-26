# MCA Hat Layer Fix

A small NeoForge mod for Minecraft 1.21.1 that fixes a visual issue with [MCA Reborn](https://modrinth.com/mod/minecraft-comes-alive-reborn) villagers.

## The Problem

MCA Reborn villager skins frequently include a hat layer (the outer head overlay in the standard 64×64 skin format). When a villager is equipped with a helmet, both the hat layer and the helmet render in the same space, causing the textures to overlap and flicker.

## The Fix

When a villager has any item in their head equipment slot, the hat skin layer is suppressed for that render frame. When no helmet is present, the hat layer renders normally, so hairstyles and accessories that use the overlay are unaffected when no headwear is equipped.

## Requirements

- Minecraft 1.21.1
- NeoForge 21.1.230+
- MCA Reborn 7.7.7+

## Installation

Drop the jar into your `mods/` folder alongside MCA Reborn

## License

MIT — see [LICENSE](LICENSE).
