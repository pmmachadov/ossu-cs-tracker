#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import json
import os

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
SRC_JSON = os.path.join(ROOT, "public", "data", "examenes", "examen-java.json")
OUT_TEST = os.path.join(ROOT, "public", "data", "examenes", "examen-java-test.json")
OUT_EJER = os.path.join(ROOT, "public", "data", "examenes", "examen-java-ejercicios.json")

def main():
    with open(SRC_JSON, "r", encoding="utf-8") as f:
        data = json.load(f)

    all_cards = data.get("cards", [])

    test_cards = []
    ejer_cards = []

    for card in all_cards:
        front = card.get("front", "")
        # Determinamos si es de opción múltiple / verdadero y falso
        # 1. Tiene opciones a), b), c), etc. o es V/F
        # 2. O la sección es Parte 1 (Opción múltiple y Verdadero/Falso)
        is_test = False
        lines = front.split("\n\n")
        
        # Revisamos si tiene líneas con a), b), c) o es Verdadero/Falso
        has_options = any(line.strip().startswith(("a)", "b)", "c)", "d)")) for line in lines)
        is_vf = "Verdadero/Falso" in front or "V/F" in front or "\nV\n" in front or "Verdadero\n" in front or any("Verdadero" in l and "Falso" in l for l in lines)
        is_part_1 = len(lines) > 1 and "Parte 1:" in lines[1] and ("Opción múltiple" in lines[1] or "Verdadero" in lines[1])

        if is_part_1 or has_options:
            is_test = True
        elif len(lines) > 1 and lines[1].startswith("Parte 1:") and not ("Ejercicios" in lines[1] or "programación" in lines[1]):
            is_test = True

        if is_test:
            test_cards.append(card)
        else:
            ejer_cards.append(card)

    print(f"Total: {len(all_cards)}")
    print(f"Test / Verdadero-Falso: {len(test_cards)}")
    print(f"Ejercicios y Desarrollo: {len(ejer_cards)}")

    deck_test = {
        "id": "examen-java-test",
        "name": "Múltiple opción",
        "description": "Preguntas de opción múltiple y Verdadero/Falso de los 20 exámenes oficiales de Java.",
        "subject": "",
        "cards": test_cards
    }

    deck_ejer = {
        "id": "examen-java-ejercicios",
        "name": "Ejercicios",
        "description": "Ejercicios prácticos de programación, desarrollo y análisis de código de los 20 exámenes.",
        "subject": "",
        "cards": ejer_cards
    }

    with open(OUT_TEST, "w", encoding="utf-8") as f:
        json.dump(deck_test, f, ensure_ascii=False, indent=2)

    with open(OUT_EJER, "w", encoding="utf-8") as f:
        json.dump(deck_ejer, f, ensure_ascii=False, indent=2)

    print(f"Creado {OUT_TEST}")
    print(f"Creado {OUT_EJER}")

if __name__ == "__main__":
    main()
