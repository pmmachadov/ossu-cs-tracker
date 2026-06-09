import os

asar_path = 'C:\\Users\\Pablo\\Desktop\\Hermes_Agent_Desktop\\resources\\app.asar'
with open(asar_path, 'rb') as f:
    data = f.read()

# Find pidIsAliveAs function
idx = data.find(b'pidIsAliveAs')
if idx >= 0:
    start = max(0, idx - 50)
    end = min(len(data), idx + 800)
    context = data[start:end].decode('utf-8', errors='replace')
    print(context)
else:
    print("NOT FOUND")
