import json

with open('public/data/examenes/examen-java-ejercicios.json', 'r', encoding='utf-8') as f:
    cards = json.load(f)['cards']

print(f"Total cards: {len(cards)}")
for i, c in enumerate(cards):
    print(f"--- CARD {i+1} [{c['id']}] ---")
    front_lines = c['front'].split('\n')
    header = front_lines[0] if len(front_lines) > 0 else ''
    part = front_lines[2] if len(front_lines) > 2 else ''
    q = front_lines[4] if len(front_lines) > 4 else (front_lines[1] if len(front_lines)>1 else '')
    print(f"HEADER: {header} | {part}")
    print(f"Q: {q[:100]}")
    has_code = '```' in c['back']
    print(f"Has code in back: {has_code}")
