import os

asar_path = 'C:\\Users\\Pablo\\Desktop\\Hermes_Agent_Desktop\\resources\\app.asar'
with open(asar_path, 'rb') as f:
    data = f.read()

# Find profileHome and resolveProfile functions
for t in [b'function profileHome', b'function resolveProfile', b'function getProfilePort']:
    idx = data.find(t)
    if idx >= 0:
        start = max(0, idx - 50)
        end = min(len(data), idx + 500)
        context = data[start:end].decode('utf-8', errors='replace')
        print(f'=== {t.decode()} ===')
        print(context)
        print()
    else:
        print(f'=== {t.decode()} NOT FOUND ===')
