import os

asar_path = 'C:\\Users\\Pablo\\Desktop\\Hermes_Agent_Desktop\\resources\\app.asar'
with open(asar_path, 'rb') as f:
    data = f.read()

# Find pidIsAlive and GATEWAY_IMAGE_PREFIXES
for t in [b'function pidIsAlive', b'GATEWAY_IMAGE_PREFIXES', b'function isChildProcessAlive']:
    idx = data.find(t)
    if idx >= 0:
        start = max(0, idx - 50)
        end = min(len(data), idx + 400)
        context = data[start:end].decode('utf-8', errors='replace')
        print(f'=== {t.decode()} ===')
        print(context)
        print()
