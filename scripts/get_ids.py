import json

with open('public/data/examenes/examen-java-ejercicios.json', 'r', encoding='utf-8') as f:
    cards = json.load(f)['cards']

with open('scripts/all_card_ids.txt', 'w', encoding='utf-8') as f:
    for c in cards:
        f.write(f"{c['id']}\n")

print(f"Wrote {len(cards)} IDs")
