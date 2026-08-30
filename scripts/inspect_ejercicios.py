import json

with open('public/data/examenes/examen-java-ejercicios.json', 'r', encoding='utf-8') as f:
    data = json.load(f)

print('Total cards in ejercicios:', len(data['cards']))
for i, c in enumerate(data['cards']):
    front_preview = c['front'].replace('\n', ' ')[:70]
    has_code = '```' in c['back'] or '```' in c['front']
    has_pseudo = 'pseudocodigo' in c['back'].lower() or 'pseudocódigo' in c['back'].lower() or 'pseudocódigo' in c['front'].lower()
    print(f"{i+1}. {c['id']} | Code: {has_code} | Pseudo: {has_pseudo} | {front_preview}")
