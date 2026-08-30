import json

with open('public/data/examenes/examen-java-ejercicios.json', 'r', encoding='utf-8') as f:
    data = json.load(f)

cards = data['cards']

with open('scripts/cards_overview.txt', 'w', encoding='utf-8') as out:
    for i, c in enumerate(cards):
        cid = c.get('id', '')
        front = c.get('front', '')
        back = c.get('back', '')
        out.write(f"=== CARD {i+1}: {cid} ===\n")
        out.write(f"FRONT:\n{front}\n\n")
        out.write(f"BACK:\n{back}\n\n")
        out.write("="*60 + "\n\n")

print("Wrote scripts/cards_overview.txt")
