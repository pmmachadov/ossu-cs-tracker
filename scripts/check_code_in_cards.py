import json

with open('public/data/examenes/examen-java-ejercicios.json', 'r', encoding='utf-8') as f:
    data = json.load(f)

cards = data['cards']
print(f"Total cards: {len(cards)}")

has_code_in_back = 0
no_code_in_back = 0

for i, c in enumerate(cards):
    cid = c.get('id', '')
    front = c.get('front', '')
    back = c.get('back', '')
    has_java = '```java' in back or '```' in back
    if has_java:
        has_code_in_back += 1
    else:
        no_code_in_back += 1

print(f"Cards with code in back: {has_code_in_back}")
print(f"Cards without code in back: {no_code_in_back}")
