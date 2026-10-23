from pathlib import Path
import base64
import struct
import zlib

ROOT = Path("src/main/resources/assets/glowberry_tart/textures")
TART_PNG = "iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAA60lEQVR42sWToQ7CMBCGvxEwaCSCZJL6BonEzCBQpA9AgucJeAIegFRjZniEpX6TSyaQ6BnEUDRdVyAEEi6puPa+63/XK/zbIn9jMxs3r4BDdmkxfR9eytG7Sxs3SRSC59sVAHVVtEiT5gCczNUq6YXguio68HAyRSYCgKUc2VJbJchEUFcFx3UZUF6idIxMhFViFbjmwufdzS7/LNhE1x6Q6y/2A47rEqUFkAM0vWcJFvtB0Fc6xqS5bWRHgdKxleonUTp+XYJJc2QigoH+U7aaeMgu0clcbcBwMu084bM5iD6dRBf+yV/42u6C6nAOi6EOHwAAAABJRU5ErkJggg=="
ROOT.joinpath("item").mkdir(parents=True, exist_ok=True)
ROOT.joinpath("item/glowberry_tart.png").write_bytes(base64.b64decode(TART_PNG))

def png(path, pixels):
    h = len(pixels); w = len(pixels[0])
    raw = b"".join(b"\x00" + bytes(c for px in row for c in px) for row in pixels)
    def chunk(kind, data):
        return struct.pack(">I", len(data)) + kind + data + struct.pack(">I", zlib.crc32(kind + data) & 0xffffffff)
    data = b"\x89PNG\r\n\x1a\n"
    data += chunk(b"IHDR", struct.pack(">2I5B", w, h, 8, 6, 0, 0, 0))
    data += chunk(b"IDAT", zlib.compress(raw, 9)) + chunk(b"IEND", b"")
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_bytes(data)

# Tiny custom pixel-art jar of luminous purple berry jam.
jam = [[(0,0,0,0) for _ in range(16)] for _ in range(16)]
for y in range(3,14):
    for x in range(4,12):
        if y in (3,13) or x in (4,11): jam[y][x]=(90,66,50,255)
        else: jam[y][x]=(151,55,190,255)
for x in range(5,11): jam[2][x]=(204,170,93,255)
for x,y,c in [(6,5,(255,126,255,255)),(8,7,(230,110,255,255)),(5,10,(99,32,151,255)),(9,11,(105,31,160,255))]: jam[y][x]=c
png(ROOT/"item/glowberry_jam.png", jam)

# Pixel-art luminous block with berry flecks, used as a placeable light cube.
block = []
for y in range(16):
    row=[]
    for x in range(16):
        if x in (0,15) or y in (0,15): c=(69,53,88,255)
        elif (x+y)%7==0: c=(238,121,255,255)
        elif (x in (1,14) or y in (1,14)): c=(124,71,156,255)
        else: c=(156,91,191,255)
        row.append(c)
    block.append(row)
png(ROOT/"block/glowberry_lantern.png", block)
print("Generated tart, jam, and glowberry lantern textures.")
