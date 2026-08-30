import json, sys
sys.stdout.reconfigure(encoding='utf-8')

with open('public/data/examenes/examen-java-ejercicios.json', 'r', encoding='utf-8') as f:
    cards = json.load(f)['cards']

for c in cards:
    tag = next((t for t in c.get('tags', []) if t.startswith('examen-')), 'otros')
    if tag in ['examen-6', 'examen-7', 'examen-8', 'examen-9', 'examen-10']:
        print(f"ID: {c['id']}")
        print("FRONT:\n" + c['front'][:160])
        print("BACK:\n" + c['back'][:160])
        print("-" * 50)
