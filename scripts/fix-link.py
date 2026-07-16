import json, re

with open('/c/Users/Pablo/anki-cards/public/data/preguntas-directas/pd-all.json', 'r', encoding='utf-8') as f:
    data = json.load(f)

card = data['cards'][0]
assert card['id'] == 'pd-ed-013', f"Expected pd-ed-013, got {card['id']}"

# Replace the markdown link syntax with a bare URL
old = '📊 **Diagrama visual:** [`/diagrama-flujo.html`](/diagrama-flujo.html)'
new = '📊 Diagrama visual:\n/diagrama-flujo.html'
card['back'] = card['back'].replace(old, new)

with open('/c/Users/Pablo/anki-cards/public/data/preguntas-directas/pd-all.json', 'w', encoding='utf-8') as f:
    json.dump(data, f, ensure_ascii=False, indent=2)

print("Done. Back now ends with:", repr(card['back'][-200:]))
