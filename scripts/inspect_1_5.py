import json, sys
sys.stdout.reconfigure(encoding='utf-8')

with open('public/data/examenes/examen-java-ejercicios.json', 'r', encoding='utf-8') as f:
    cards = json.load(f)['cards']

for c in cards:
    tag = next((t for t in c.get('tags', []) if t.startswith('examen-')), 'otros')
    if tag in ['examen-1', 'examen-2', 'examen-3', 'examen-4', 'examen-5']:
        print(f"ID: {c['id']}")
        print("FRONT:\n" + c['front'][:150])
        print("BACK:\n" + c['back'][:150])
        print("-" * 50)
