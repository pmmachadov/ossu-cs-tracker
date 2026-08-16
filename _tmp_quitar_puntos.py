#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""Pase 2 (corregido): elimina "(N puntos — M cada pregunta/ejercicio)" del front."""
import json
import re
import sys

sys.stdout.reconfigure(encoding="utf-8", errors="replace")

PATH = "public/data/examenes/examen-java.json"

SEP = "\u00B7\u2014\u2013-"

# Formato real: (5 puntos — 0,5 cada pregunta) / (3 puntos — 1,5 cada ejercicio)
pat = re.compile(
    r"\(\s*\d+(?:[.,]\d+)?\s*(?:puntos?|ptos?)"
    r"(?:\s*[" + SEP + r"]\s*\d+(?:[.,]\d+)?\s*cada\s+(?:pregunta|ejercicio))?"
    r"\s*\)",
    re.IGNORECASE,
)

with open(PATH, encoding="utf-8") as f:
    data = json.load(f)

total = 0
for c in data["cards"]:
    hits = pat.findall(c["front"])
    total += len(hits)
    new_front = pat.sub("", c["front"])
    new_front = re.sub(r" {2,}", " ", new_front)
    new_front = re.sub(r"[ \t]+\n", "\n", new_front)
    c["front"] = new_front
print("Marcadores eliminados en pase 2:", total)

restantes = 0
for c in data["cards"]:
    for m in re.finditer(r"\b(?:puntos?|ptos?)\b", c["front"] + "\n" + c["back"], re.IGNORECASE):
        restantes += 1
        s = max(0, m.start() - 70)
        ctx = (c["front"] + "\n" + c["back"])
        e = min(len(ctx), m.end() + 70)
        print("RESTO:", c["id"], "|", repr(ctx[s:e]))
print("Restantes tras pase 2:", restantes)

with open(PATH, "w", encoding="utf-8") as f:
    json.dump(data, f, ensure_ascii=False, indent=2)
print("JSON guardado OK")
