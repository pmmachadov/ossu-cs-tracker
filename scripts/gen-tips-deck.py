import re

# Read the extracted text
with open('scripts/99tips.txt', 'r', encoding='utf-8', errors='replace') as f:
    text = f.read()

# Split by form feeds
blocks = text.split('\f')
print(f"Total blocks: {len(blocks)}")

# The book structure: 
# Blocks 0-1: title/copyright
# Block 2: Content/Index (table of contents)
# Then tips HTML (3+), JavaScript, CSS

# Find where actual content starts (skip index)
all_tips = []
section = None  # 'html', 'javascript', 'css'
tip_num = 0

for i, block in enumerate(blocks):
    block = block.strip()
    if not block:
        continue
    
    lines = block.split('\n')
    first_line = lines[0].strip()
    
    # Detect section headers
    if first_line == 'HTML' and i > 2:
        section = 'html'
        continue
    elif first_line == 'JavaScript' and i > 2:
        section = 'javascript'
        continue
    elif first_line == 'CSS' and i > 2:
        section = 'css'
        continue
    
    # Skip title, copyright, contents, intro
    if i <= 2:
        continue
    if 'Introducci' in first_line or 'Contenido' in first_line:
        continue
    if 'Muchas gracias' in first_line:
        continue
    
    # Extract tip title and content
    if section and len(first_line) > 5:
        tip_num += 1
        # Clean the title - remove page numbers and special chars
        title = first_line.strip()
        # Remove trailing number (page number)
        title = re.sub(r'\s+\d+$', '', title)
        
        # Content is the rest
        content_lines = lines[1:] if len(lines) > 1 else []
        content = '\n'.join(content_lines).strip()
        # Remove trailing page numbers
        content = re.sub(r'\n\d+\n?$', '', content)
        
        all_tips.append({
            'num': tip_num,
            'section': section,
            'title': title,
            'content': content
        })

print(f"Extracted {len(all_tips)} tips")
for t in all_tips:
    print(f"  [{t['num']:2d}] ({t['section'].upper():4s}) {t['title'][:60]}")

# Now generate JSON
import json

section_map = {
    'html': ('HTML', 'html', 'easy'),
    'javascript': ('JavaScript', 'javascript', 'medium'),
    'css': ('CSS', 'css', 'easy')
}

cards = []
section_counters = {'html': 0, 'javascript': 0, 'css': 0}

for tip in all_tips:
    sec_name, sec_tag, diff = section_map[tip['section']]
    section_counters[tip['section']] += 1
    
    # Clean the content - extract code blocks and format them
    content = tip['content']
    
    # Clean encoding issues
    content = content.replace('�', 'á').replace('�', 'é').replace('�', 'í').replace('�', 'ó').replace('�', 'ú')
    content = content.replace('�', 'Á').replace('�', 'É').replace('�', 'Í').replace('�', 'Ó').replace('�', 'Ú')
    content = content.replace('�', 'ñ').replace('�', 'Ñ')
    content = content.replace('�', 'ü').replace('�', 'Ü')
    
    # Build the card
    front = f"(TWD — {sec_name}) {tip['title']}"
    
    # Format back: the content as-is since pdftotext preserved the structure
    back = content
    
    card = {
        'id': f"twd-{tip['num']:03d}",
        'front': front,
        'back': back,
        'tags': ['twd', sec_tag],
        'difficulty': diff
    }
    cards.append(card)

# Build the deck JSON
deck = {
    'id': 'tips-web-dev',
    'name': '99 Tips para Web Development',
    'description': '99 consejos prácticos de HTML, CSS y JavaScript — Freddy Montes (@fmontes)',
    'subject': 'Libros',
    'created': '2026-05-17',
    'cards': cards
}

output_path = 'public/data/libros/tips-web-dev.json'
with open(output_path, 'w', encoding='utf-8') as f:
    json.dump(deck, f, ensure_ascii=False, indent=2)

print(f"\nGenerated {len(cards)} cards -> {output_path}")
print(f"  HTML: {section_counters['html']}")
print(f"  JavaScript: {section_counters['javascript']}")
print(f"  CSS: {section_counters['css']}")
