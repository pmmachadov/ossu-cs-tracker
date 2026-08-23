import os

asar_path = 'C:\\Users\\Pablo\\Desktop\\Hermes_Agent_Desktop\\resources\\app.asar'
with open(asar_path, 'rb') as f:
    data = f.read()

# Find all occurrences of gatewayProcess to get the actual spawn code
idx = data.find(b'gatewayProcess')
# Find the LAST occurrence (the actual function body)
last_idx = data.rfind(b'gatewayProcess')
print(f"First at: 0x{idx:x}, Last at: 0x{last_idx:x}")

# Get context around the last occurrence
start = max(0, last_idx - 500)
end = min(len(data), last_idx + 3000)
context = data[start:end].decode('utf-8', errors='replace')
print(context)
