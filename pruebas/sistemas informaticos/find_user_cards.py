import json

with open(r'C:\Users\Pablo\Desktop\Pablo\anki-cards-completo\public\data\sistemas-informaticos.json', encoding='utf-8') as f:
    si = json.load(f)

targets = ['crear usuari', 'grup', 'permis', 'chmod', 'chown', 'umask', 'propietari', 'usuari sistema', 'sistema usuari', 'adduser', 'useradd', 'groupadd', 'home directori', 'skel', 'userdel', 'usermod', 'passwd', 'contrasen']
for c in si['cards']:
    text = (c['front'] + ' ' + ' '.join(c.get('tags', [])) + ' ' + c.get('back', '')).lower()
    for t in targets:
        if t in text:
            print(f'--- {c.get("id","?")} ---')
            print(c['front'][:300])
            print()
            break
