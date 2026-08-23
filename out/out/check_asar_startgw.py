import os

asar_path = 'C:\\Users\\Pablo\\Desktop\\Hermes_Agent_Desktop\\resources\\app.asar'
with open(asar_path, 'rb') as f:
    data = f.read()

# Search for startGatewayDetailed and the actual spawn
for t in [b'startGatewayDetailed', b'child_process', b'.spawn(']:
    idx = data.find(t)
    count = data.count(t)
    if idx >= 0:
        # For child_process, find the one in app code (not node_modules docs)
        start = max(0, idx - 200)
        end = min(len(data), idx + 500)
        context = data[start:end].decode('utf-8', errors='replace')
        print(f'=== {t.decode()} (found {count}x at 0x{idx:x}) ===')
        print(context)
        print('='*60)
