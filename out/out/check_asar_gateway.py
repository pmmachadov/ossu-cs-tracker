import os

asar_path = 'C:\\Users\\Pablo\\Desktop\\Hermes_Agent_Desktop\\resources\\app.asar'
with open(asar_path, 'rb') as f:
    data = f.read()

# Search for gateway-related code patterns in the actual app code
targets = [
    b'gateway',
    b'HERMES_PYTHON',
    b'hermes_gateway',
    b'hermes gateway',
    b'createWriteStream(',
    b'openSync(',
    b'stderrStream',
    b'8642',
    b'gatewayProcess',
]

for t in targets:
    idx = data.find(t)
    count = data.count(t)
    if idx >= 0:
        start = max(0, idx - 150)
        end = min(len(data), idx + 300)
        context = data[start:end].decode('utf-8', errors='replace')
        print(f'=== {t.decode()} (found {count}x, first at 0x{idx:x}) ===')
        print(context)
        print('---')

# Also search in the JSON header for file paths
hdr_end = 16 + int.from_bytes(data[4:8], 'little')
header_json = data[16:hdr_end].decode('utf-8')
# Find references to main/index.js
if 'out/main/index.js' in header_json:
    print("=== out/main/index.js exists in ASAR ===")
