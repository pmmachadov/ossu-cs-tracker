import os

asar_path = 'C:\\Users\\Pablo\\Desktop\\Hermes_Agent_Desktop\\resources\\app.asar'
with open(asar_path, 'rb') as f:
    data = f.read()

# Search for more specific gateway spawn code
for t in [b'gatewayProcess', b'.spawn(', b'spawn(']:
    idx = data.find(t)
    count = data.count(t)
    if idx >= 0:
        start = max(0, idx - 300)
        end = min(len(data), idx + 500)
        context = data[start:end].decode('utf-8', errors='replace')
        print(f'=== {t.decode()} (found {count}x, context around first match) ===')
        print(context)
        print('='*60)
        print()
