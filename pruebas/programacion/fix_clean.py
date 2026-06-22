#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Une líneas rotas en los archivos clean_u*.txt:
- Líneas que NO terminan en punto, signo, dos puntos o están vacías
  se unen con la siguiente
- Elimina espacios dobles
- Preserva párrafos (doble salto de línea)
"""

import re
import os

BASE = r"C:\Users\Pablo\Desktop\Pablo\anki-cards-completo\pruebas\programacion"

def fix_text(text):
    # Normalizar espacios dobles a simples
    text = re.sub(r'  +', ' ', text)
    
    # Separar en líneas
    lines = text.split('\n')
    
    result = []
    buffer = ''
    
    for line in lines:
        stripped = line.strip()
        
        # Si es línea vacía, es separador de párrafo
        if not stripped:
            if buffer:
                result.append(buffer)
                buffer = ''
            result.append('')
            continue
        
        # Si el buffer está vacío, empezamos nueva línea
        if not buffer:
            buffer = stripped
            continue
        
        # Detectar si la línea actual CONTINÚA a la anterior:
        # - La línea anterior no termina con . : ? ! ; 
        # - O la línea actual empieza con minúscula (sin número ni mayúscula)
        prev = buffer
        ends_with_terminator = bool(re.search(r'[.?!:;]\s*$', prev))
        starts_lower = bool(re.match(r'[a-záéíóúñàè]', stripped))
        starts_number_or_symbol = bool(re.match(r'[\d\-–•*·]', stripped))
        
        # También detectar URLs rotas (www. / .com partidos)
        is_url_continuation = (
            prev.endswith('.') and 
            len(stripped.split()) <= 3 and
            not ends_with_terminator  # si termina en . pero no es final de frase
        )
        
        should_join = (
            (not ends_with_terminator and not starts_number_or_symbol and stripped[0].islower()) or
            (not ends_with_terminator and len(stripped) < 60 and len(prev) > 60) or
            (prev.endswith(',') and not ends_with_terminator) or
            (prev.endswith('(') and not stripped.startswith(')'))
        )
        
        # Excepción: URLs o palabras sueltas que continúan
        if should_join:
            buffer = prev + ' ' + stripped
        else:
            result.append(prev)
            buffer = stripped
    
    if buffer:
        result.append(buffer)
    
    # Post-procesado: unir URLs rotas (ej "http://www.oracle.  com/" → "http://www.oracle.com/")
    final = '\n'.join(result)
    final = re.sub(r'(https?://\S+)\.\s+(\S+)', r'\1.\2', final)
    final = re.sub(r'(\S+)\.\s+(com|org|net|edu|es|java)\b', r'\1.\2', final)
    
    # Limpiar espacios residuales
    final = re.sub(r'  +', ' ', final)
    
    return final.strip()

for file in os.listdir(BASE):
    if file.startswith('clean_u') and file.endswith('.txt'):
        path = os.path.join(BASE, file)
        with open(path, 'r', encoding='utf-8') as f:
            original = f.read()
        
        fixed = fix_text(original)
        
        backup = path + '.bak'
        os.rename(path, backup)
        
        with open(path, 'w', encoding='utf-8') as f:
            f.write(fixed)
        
        orig_lines = len(original.split('\n'))
        new_lines = len(fixed.split('\n'))
        print(f'✓ {file}: {orig_lines} líneas → {new_lines} líneas (respaldado como {file}.bak)')

print('\n✅ Listo. Todos los clean_u*.txt corregidos.')
