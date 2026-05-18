import json

with open('public/data/preguntas-directas/pd-all.json', 'r', encoding='utf-8') as f:
    content = f.read()

# Find pd-ed-013
idx = content.find('"pd-ed-013"')
print(f"Found pd-ed-013 at position {idx}")

# Find the "back" field
back_key = content.find('"back"', idx)
colon = content.find(':', back_key)
quote_start = content.find('"', colon + 1)
print(f"back value starts at {quote_start}")

# Find the closing quote - parse properly
# We're looking for the unescaped " that closes the string
i = quote_start + 1
in_str = True
while in_str and i < len(content):
    c = content[i]
    if c == '\\':
        i += 2  # skip escaped char
        continue
    if c == '"':
        # This is the closing quote
        end_quote = i
        break
    i += 1

print(f"back value ends at {end_quote}")
print(f"After end quote: {repr(content[end_quote:end_quote+50])}")

# Show what's between the end quote and "tags"
comma = content.find(',', end_quote)
next_key = content.find('"tags"', end_quote)
print(f"Comma found at {comma}")
print(f"tags key at {next_key}")
print(f"Whitespace between: {repr(content[end_quote+1:next_key])}")

if comma < 0 or comma > next_key:
    print("MISSING COMMA before tags field!")
    # Insert comma
    before = content[:end_quote+1]
    after = content[end_quote+1:]
    # Remove whitespace before tags
    after_stripped = after.lstrip('\r\n ')
    content = before + ',' + after_stripped[len(after)-len(after_stripped):]
    print("Comma inserted")
    
    with open('public/data/preguntas-directas/pd-all.json', 'w', encoding='utf-8') as f:
        f.write(content)
    
    # Verify
    with open('public/data/preguntas-directas/pd-all.json', 'r', encoding='utf-8') as f:
        data = json.load(f)
    print("JSON valid!")
    
    # Print the card back
    for card in data['cards']:
        if card['id'] == 'pd-ed-013':
            print("\n=== BACK (formatted) ===")
            print(card['back'])
            print("=== END ===")
            break
else:
    print("JSON is OK")
