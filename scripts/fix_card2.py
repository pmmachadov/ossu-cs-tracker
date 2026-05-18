import json

with open('public/data/preguntas-directas/pd-all.json', 'r', encoding='utf-8') as f:
    content = f.read()

# Find pd-ed-013 back field value
idx = content.find('"pd-ed-013"')
back_key = content.find('"back"', idx)
colon = content.find(':', back_key)
quote_start = content.find('"', colon + 1)

# Parse the JSON string properly
i = quote_start + 1
string_chars = []
while i < len(content):
    c = content[i]
    if c == '\\':
        string_chars.append(('ESCAPE', content[i:i+2]))
        i += 2
        continue
    if c == '"':
        # Found closing quote
        end_quote = i
        break
    string_chars.append(('CHAR', c))
    i += 1

print(f"String spans positions {quote_start} to {end_quote}")
print(f"Total chars in string: {len(string_chars)}")

# Check for any potential issues - unescaped quotes inside
# Look for any byte that could be problematic
with open('public/data/preguntas-directas/pd-all.json', 'rb') as f:
    raw = f.read()

# Show the raw bytes around the string boundaries
print(f"\nBefore opening quote: {repr(raw[quote_start-5:quote_start+1])}")
print(f"Opening quote at {quote_start}: byte={raw[quote_start]:02x}")
print(f"After closing quote: {repr(raw[end_quote:end_quote+30])}")
print(f"Closing quote at {end_quote}: byte={raw[end_quote]:02x}")

# Count actual double-quote characters within the string value
n_raw_quotes = 0
for j in range(quote_start+1, end_quote):
    if raw[j] == ord('"') and raw[j-1] != ord('\\'):
        n_raw_quotes += 1
        context = raw[max(0,j-3):j+3]
        print(f"  Unescaped quote at byte {j}: {repr(context)}")

print(f"\nUnescaped quotes: {n_raw_quotes}")

if n_raw_quotes == 0:
    # Try to find the actual issue
    print("\nTrying json.loads with strict=False")
    import json as j2
    try:
        data = j2.loads(raw, strict=False)
        print("OK!")
    except j2.JSONDecodeError as e:
        print(f"Still failing: {e}")
        pos = e.pos
        start = max(0, pos-20)
        end = min(len(raw), pos+30)
        print(f"Around pos {pos}: {repr(raw[start:end])}")
