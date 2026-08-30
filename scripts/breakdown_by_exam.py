import json

with open('public/data/examenes/examen-java-ejercicios.json', 'r', encoding='utf-8') as f:
    cards = json.load(f)['cards']

by_exam = {}
for c in cards:
    exam_tag = next((t for t in c.get('tags', []) if t.startswith('examen-')), 'otros')
    by_exam.setdefault(exam_tag, []).append(c)

print("Exams breakdown:")
for k, v in by_exam.items():
    print(f"  {k}: {len(v)} cards")
