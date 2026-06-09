import os

asar_path = 'C:\\Users\\Pablo\\Desktop\\Hermes_Agent_Desktop\\resources\\app.asar'
with open(asar_path, 'rb') as f:
    data = f.read()

# Get broader context around gatewayProcess
idx = data.find(b'gatewayProcess')
if idx >= 0:
    # Go back 1000 bytes, forward 2000 bytes
    start = max(0, idx - 1000)
    end = min(len(data), idx + 2000)
    context = data[start:end].decode('utf-8', errors='replace')
    print(context)
