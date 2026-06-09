import os

asar_path = 'C:\\Users\\Pablo\\Desktop\\Hermes_Agent_Desktop\\resources\\app.asar'
with open(asar_path, 'rb') as f:
    data = f.read()

targets = [
    b'createWriteStream',
    b'fs.createWriteStream',
    b'fs.openSync',
    b'child_process.spawn',
    b'stdio:',
]

for t in targets:
    idx = data.find(t)
    count = data.count(t)
    if idx >= 0:
        start = max(0, idx - 80)
        end = min(len(data), idx + 300)
        context = data[start:end].decode('utf-8', errors='replace')
        print(f'=== {t.decode()} (found {count}x, first at 0x{idx:x}) ===')
        print(context)
        print()
    else:
        print(f'=== {t.decode()} NOT FOUND ===')
