# Glowberry Grove

A small vanilla-plus content mod for **Minecraft Java 1.20.1 / Fabric / Java 17**.

## Added content
- **Glowberry Tart**: restores 6 hunger and grants 25 seconds of Night Vision.
- **Glowberry Jam**: restores 4 hunger and grants 12 seconds of Glowing, making you and nearby players able to see your outline through blocks.
- **Glowberry Lantern**: a placeable light source with light level 15, crafted as a decorative alternative to the regular lantern.

## Recipes
The tart recipe makes two:
```
[   ] [Glow Berries] [   ]
[Sugar] [  Wheat  ] [Sugar]
[   ] [Honey Bottle] [   ]
```

Jam:
```
[Glow Berries] [Sugar] [Glow Berries]
[     Sugar   ] [Glass Bottle] [     Sugar]
[      empty  ] [    empty    ] [      empty]
```

Lantern: surround a torch with eight glow berries in a crafting table.

## Build and install
Use JDK 17 and Gradle 8.7, or run the GitHub Actions workflow. Install Fabric Loader and Fabric API for Minecraft 1.20.1, then place the built JAR in `.minecraft/mods`.

## Testing status
The source and resource files are committed. Do not consider it release-tested until the GitHub Actions build succeeds and the items/recipes are checked in-game.

MIT license.
