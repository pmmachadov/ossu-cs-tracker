import os

asar_path = 'C:\\Users\\Pablo\\Desktop\\Hermes_Agent_Desktop\\resources\\app.asar'
with open(asar_path, 'rb') as f:
    data = f.read()

# Get the full startGatewayDetailed function
idx = data.find(b'function startGatewayDetailed')
start = max(0, idx - 100)
end = min(len(data), idx + 3000)
context = data[start:end].decode('utf-8', errors='replace')
print(context[:3000])
