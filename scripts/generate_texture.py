from pathlib import Path
import base64

# Hand-authored 16x16 Minecraft-style pixel art for Glowberry Tart.
PNG = "iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAA60lEQVR42sWToQ7CMBCGvxEwaCSCZJL6BonEzCBQpA9AgucJeAIegFRjZniEpX6TSyaQ6BnEUDRdVyAEEi6puPa+63/XK/zbIn9jMxs3r4BDdmkxfR9eytG7Sxs3SRSC59sVAHVVtEiT5gCczNUq6YXguio68HAyRSYCgKUc2VJbJchEUFcFx3UZUF6idIxMhFViFbjmwufdzS7/LNhE1x6Q6y/2A47rEqUFkAM0vWcJFvtB0Fc6xqS5bWRHgdKxleonUTp+XYJJc2QigoH+U7aaeMgu0clcbcBwMu084bM5iD6dRBf+yV/42u6C6nAOi6EOHwAAAABJRU5ErkJggg=="

target = Path("src/main/resources/assets/glowberry_tart/textures/item/glowberry_tart.png")
target.parent.mkdir(parents=True, exist_ok=True)
target.write_bytes(base64.b64decode(PNG))
print(f"Generated {target}")
