"""
Generate preguntas directas for ED and SI from existing decks.
Reads entornos-desarrollo.json and sistemas-informaticos.json,
creates pd-format cards for topics not already covered.
"""

import json, re
from collections import Counter

def load_json(path):
    with open(path, encoding='utf-8') as f:
        return json.load(f)

def save_json(path, data):
    with open(path, 'w', encoding='utf-8') as f:
        json.dump(data, f, ensure_ascii=False, indent=2)

# Load current pd-all
pd_all = load_json('public/data/preguntas-directas/pd-all.json')
existing_ids = {c['id'] for c in pd_all['cards']}

# Map tag groups to EAC
ED_EAC_MAP = {
    # EAC1: Fundamentals
    'software': 'EAC1', 'ide': 'EAC1', 'lenguaje': 'EAC1', 'compilacion': 'EAC1',
    'compilador': 'EAC1', 'jvm': 'EAC1', 'maquina-virtual': 'EAC1', 'lenguaje-maquina': 'EAC1',
    'ciclo-vida': 'EAC1', 'fases': 'EAC1', 'metodologia': 'EAC1', 'analisis': 'EAC1',
    'requisitos': 'EAC1', 'diseno': 'EAC1', 'implementacion': 'EAC1', 'pruebas-concepto': 'EAC1',
    'despliegue': 'EAC1', 'mantenimiento': 'EAC1', 'concepto': 'EAC1', 'definicion': 'EAC1',
    'clasificacion': 'EAC1', 'tipos': 'EAC1', 'programacion': 'EAC1', 'codigo-fuente': 'EAC1',
    'codigo-objeto': 'EAC1', 'enlazado': 'EAC1', 'linker': 'EAC1', 'portable': 'EAC1',
    'estructurado': 'EAC1', 'top-down': 'EAC1', 'modular': 'EAC1',
    
    # EAC2: UML + Eclipse + Project management
    'uml': 'EAC2', 'diagrama': 'EAC2', 'casos-uso': 'EAC2', 'diagrama-clases': 'EAC2',
    'diagrama-secuencia': 'EAC2', 'diagrama-actividades': 'EAC2', 'diagramas-interaccion': 'EAC2',
    'generalizacion': 'EAC2', 'clase-asociativa': 'EAC2', 'relaciones': 'EAC2',
    'composicion': 'EAC2', 'agregacion': 'EAC2', 'herencia': 'EAC2', 'polimorfismo': 'EAC2',
    'encapsulacion': 'EAC2', 'abstraccion': 'EAC2', 'visibilidad': 'EAC2',
    'eclipse': 'EAC2', 'editor': 'EAC2', 'plugins': 'EAC2', 'conectores': 'EAC2',
    'depuracion': 'EAC2', 'variables-entorno': 'EAC2', 'instalacion': 'EAC2',
    'pmbok': 'EAC2', 'planificacion': 'EAC2', 'tiempo': 'EAC2', 'calidad': 'EAC2',
    'integracion': 'EAC2', 'control-versiones': 'EAC2', 'svn': 'EAC2',
    'poo': 'EAC2', 'objetos': 'EAC2', 'clases': 'EAC2',
    
    # EAC3: Testing + Git + Documentation + Refactoring
    'pruebas': 'EAC3', 'testing': 'EAC3', 'junit': 'EAC3', 'junit5': 'EAC3',
    'pruebas-unitarias': 'EAC3', 'caja-negra': 'EAC3', 'caja-blanca': 'EAC3',
    'validacion': 'EAC3', 'aceptacion': 'EAC3', 'funcionales': 'EAC3',
    'carga': 'EAC3', 'rendimiento': 'EAC3', 'estres': 'EAC3',
    'refactorizacion': 'EAC3', 'calidad-codigo': 'EAC3',
    'git': 'EAC3', 'merge': 'EAC3', 'conflictos': 'EAC3', 'control-versiones-git': 'EAC3',
    'documentacion': 'EAC3', 'javadoc': 'EAC3', 'comentarios': 'EAC3',
    'metrica': 'EAC3', 'metrica-v3': 'EAC3', 'complejidad': 'EAC3',
    'analisis-estatico': 'EAC3', 'cobertura': 'EAC3', 'tdd': 'EAC3',
    
    # Proyecto
    'java': 'Proyecto', 'spring': 'Proyecto', 'servlet': 'Proyecto', 'tomcat': 'Proyecto',
    'web': 'Proyecto', 'jsp': 'Proyecto', 'maven': 'Proyecto', 'swing': 'Proyecto',
    'apache': 'Proyecto', 'servidor': 'Proyecto', 'despliegue-web': 'Proyecto',
    'biblioteca': 'Proyecto', 'ejercicio': 'Proyecto', 'ejemplo': 'Proyecto',
}

def guess_eac(tags):
    """Guess EAC from tags"""
    eac_scores = {'EAC1': 0, 'EAC2': 0, 'EAC3': 0, 'Proyecto': 0}
    for t in tags:
        t_lower = t.lower()
        for key, eac in ED_EAC_MAP.items():
            if key in t_lower:
                eac_scores[eac] += 1
    best = max(eac_scores, key=eac_scores.get)
    return best if eac_scores[best] > 0 else 'EAC1'


def generate_ed_pd():
    """Generate preguntas directas for ED"""
    ed = load_json('public/data/entornos-desarrollo.json')
    
    new_cards = []
    existing_fronts_norm = set()
    for c in pd_all['cards']:
        if c['front'].startswith('(ED'):
            existing_fronts_norm.add(normalize(c['front']))
    
    next_id = max((int(c['id'].split('-')[-1]) for c in pd_all['cards'] if c['id'].startswith('pd-ed-')), default=0) + 1
    
    # Process each card from the main deck
    for i, card in enumerate(ed['cards']):
        front = card['front'].strip()
        back = card['back'].strip()
        tags = card.get('tags', [])
        
        # Skip if question starts with Verdadero/Falso
        if front.startswith('Verdadero') or front.startswith('La respuesta'):
            continue
            
        # Get EAC from tags
        eac = guess_eac(tags)
        
        # Get main topic from tags (first meaningful tag)
        important_tags = [t for t in tags if t not in ['ejercicio', 'ejemplos', 'actividad', 'concepto', 'definicion']]
        main_topic = important_tags[0].capitalize() if important_tags else 'Conceptos'
        
        # Create new front in PD format - remove "¿" and "?" styling, make it direct
        clean_front = front.replace('¿', '').replace('?', '').strip()
        pd_front = f"(ED — {eac} / {main_topic}) {clean_front}"
        
        # Check if this topic already has a PD card
        norm = normalize(pd_front)
        if norm in existing_fronts_norm:
            continue
        
        # Create concise back
        # Take first 400 chars and clean up
        pd_back = back[:500].strip()
        if len(back) > 500:
            pd_back += '...'
        
        card_id = f"pd-ed-{next_id:03d}"
        
        # Create tags
        pd_tags = ['ed'] + [t.lower() for t in tags[:5]]
        
        new_card = {
            "id": card_id,
            "front": pd_front,
            "back": pd_back,
            "tags": sorted(set(pd_tags)),
            "difficulty": "medium"
        }
        
        new_cards.append(new_card)
        existing_fronts_norm.add(norm)
        next_id += 1
    
    return new_cards

def normalize(s):
    """Normalize string for comparison"""
    return re.sub(r'\s+', ' ', s.strip().lower())

if __name__ == '__main__':
    ed_new = generate_ed_pd()
    print(f'Generated {len(ed_new)} new ED preguntas directas')
    for c in ed_new[:10]:
        print(f'  {c["id"]}: {c["front"][:100]}')
