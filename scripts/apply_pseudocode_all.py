# -*- coding: utf-8 -*-
import json
import os
import re

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))

from data_pseudo_1_5 import PSEUDO_1_5
from data_pseudo_6_10 import PSEUDO_6_10
from data_pseudo_11_15 import PSEUDO_11_15
from data_pseudo_16_20 import PSEUDO_16_20
from data_pseudo_conceptos import PSEUDO_CONCEPTOS

ALL_PSEUDO = {}
ALL_PSEUDO.update(PSEUDO_1_5)
ALL_PSEUDO.update(PSEUDO_6_10)
ALL_PSEUDO.update(PSEUDO_11_15)
ALL_PSEUDO.update(PSEUDO_16_20)
ALL_PSEUDO.update(PSEUDO_CONCEPTOS)

print(f"Total pseudocodes loaded: {len(ALL_PSEUDO)}")

EJER_PATH = os.path.join(ROOT, "public", "data", "examenes", "examen-java-ejercicios.json")
MASTER_PATH = os.path.join(ROOT, "public", "data", "examenes", "examen-java.json")
DIST_EJER_PATH = os.path.join(ROOT, "dist", "data", "examenes", "examen-java-ejercicios.json")
DIST_MASTER_PATH = os.path.join(ROOT, "dist", "data", "examenes", "examen-java.json")

def format_pseudocode_block(pseudo_code):
    return f"\n\n---\n### Pseudocódigo:\n\n```pseudocode\n{pseudo_code.strip()}\n```"

def clean_existing_pseudo(back_text):
    # Eliminar sección de pseudocódigo previa si existiera
    cleaned = re.sub(r"\n*---\n+###\s*Pseudocódigo:[\s\S]*?```\s*$", "", back_text, flags=re.IGNORECASE)
    cleaned = re.sub(r"\n*###\s*Pseudocódigo:[\s\S]*?```\s*$", "", cleaned, flags=re.IGNORECASE)
    return cleaned.rstrip()

def process_cards(cards):
    updated_count = 0
    missing = []
    for c in cards:
        cid = c.get("id")
        if cid in ALL_PSEUDO:
            base_back = clean_existing_pseudo(c["back"])
            c["back"] = base_back + format_pseudocode_block(ALL_PSEUDO[cid])
            updated_count += 1
        else:
            missing.append(cid)
    return updated_count, missing

# 1. Update examen-java-ejercicios.json
with open(EJER_PATH, "r", encoding="utf-8") as f:
    ejer_data = json.load(f)

ejer_count, ejer_missing = process_cards(ejer_data["cards"])
print(f"Updated {ejer_count} cards in {EJER_PATH}")
if ejer_missing:
    print(f"WARNING: Missing pseudocodes for {len(ejer_missing)} cards:", ejer_missing)

with open(EJER_PATH, "w", encoding="utf-8") as f:
    json.dump(ejer_data, f, ensure_ascii=False, indent=2)

# 2. Update examen-java.json
with open(MASTER_PATH, "r", encoding="utf-8") as f:
    master_data = json.load(f)

master_count, _ = process_cards(master_data["cards"])
print(f"Updated {master_count} cards in {MASTER_PATH}")

with open(MASTER_PATH, "w", encoding="utf-8") as f:
    json.dump(master_data, f, ensure_ascii=False, indent=2)

# 3. Update dist if exists
if os.path.exists(DIST_EJER_PATH):
    with open(DIST_EJER_PATH, "w", encoding="utf-8") as f:
        json.dump(ejer_data, f, ensure_ascii=False, indent=2)
    print(f"Updated {DIST_EJER_PATH}")

if os.path.exists(DIST_MASTER_PATH):
    with open(DIST_MASTER_PATH, "w", encoding="utf-8") as f:
        json.dump(master_data, f, ensure_ascii=False, indent=2)
    print(f"Updated {DIST_MASTER_PATH}")

print("Done successfully!")
