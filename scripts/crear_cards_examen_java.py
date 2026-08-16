#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""Genera public/data/examenes/examen-java.json con TODOS los ejercicios
de los 20 exámenes de Java (Grado Superior) como cards del área "Examen".

Cada ejercicio (pregunta de examen) se convierte en una card con el mismo
formato que el resto de cards del proyecto: {id, front, back, tags, difficulty}.

Uso (desde la raíz del proyecto):
    python scripts/crear_cards_examen_java.py
"""
import json
import os
import re
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
sys.path.insert(0, os.path.join(ROOT, "examenes_grado_superior"))

import generar_examenes as g1  # noqa: E402  (exámenes 1-5)
import generar_examenes_2 as g2  # noqa: E402  (exámenes 6-10)
import generar_examenes_3 as g3  # noqa: E402  (exámenes 11-15)
import generar_examenes_4 as g4  # noqa: E402  (exámenes 16-20)

OUT_PATH = os.path.join(ROOT, "public", "data", "examenes", "examen-java.json")


def looks_like_code(text):
    """Heurística: ¿la respuesta es código Java (no texto explicativo)?"""
    if not text:
        return False
    if "```" in text:
        return True
    lines = [l.strip() for l in text.splitlines() if l.strip()]
    if not lines:
        return False
    score = 0
    for l in lines:
        if re.match(
            r"^(public|private|protected|class|interface|import|package|static|"
            r"final|int|String|double|boolean|void|return|for|while|if)\b", l
        ):
            score += 1
        if l.endswith(";") or l.endswith("{") or l in ("{", "}"):
            score += 1
    return score >= max(2, len(lines) // 2)


def build_front(exam_no, ex, sec, q):
    parts = [f"({ex['subtitulo']})"]
    # Sin puntuación: los puntos delatan la respuesta y no aportan al estudio
    parts.append(sec["titulo"])
    enun = q.get("enunciado", "").strip()
    parts.append(enun)
    if q.get("code"):
        parts.append("```java\n" + q["code"].rstrip() + "\n```")
    if q.get("opciones"):
        parts.extend(q["opciones"])
    return "\n\n".join(parts)


def build_back(q):
    resp = q.get("respuesta")
    if resp is None:
        return "—"
    if isinstance(resp, list):
        resp = "\n".join(str(l) for l in resp)
    resp = str(resp).strip()
    if looks_like_code(resp):
        return "RESPUESTA / SOLUCIÓN\n\n```java\n" + resp + "\n```"
    return "RESPUESTA / SOLUCIÓN\n\n" + resp


def main():
    exams = g1.EXAMENES + g2.EXAMENES + g3.EXAMENES + g4.EXAMENES
    cards = []
    stats = {"por_examen": {}, "sin_respuesta": 0, "respuesta_codigo": 0}

    for i, ex in enumerate(exams, start=1):
        qnum = 0
        for sec in ex["secciones"]:
            for q in sec["preguntas"]:
                qnum += 1
                back = build_back(q)
                if q.get("respuesta") is None:
                    stats["sin_respuesta"] += 1
                if back.startswith("RESPUESTA / SOLUCIÓN\n\n```"):
                    stats["respuesta_codigo"] += 1
                cards.append({
                    "id": f"ex-java-{i:02d}-{qnum:02d}",
                    "front": build_front(i, ex, sec, q),
                    "back": back,
                    "tags": ["java", "examen", f"examen-{i}"],
                    "difficulty": "hard" if q.get("code") else "medium",
                })
        stats["por_examen"][i] = qnum

    deck = {
        "id": "examen-java",
        "name": "Examen Java (20 exámenes)",
        "description": (
            "Todos los ejercicios de los 20 exámenes de Java (Grado Superior): "
            "fundamentos, arrays, POO, herencia, ficheros, excepciones, "
            "colecciones, recursividad, genéricos, serialización, NIO, "
            "programación funcional, hilos, JDBC, Swing, expresiones regulares, "
            "ordenación, estructuras dinámicas, flujos de texto, JUnit y "
            "patrones de diseño."
        ),
        "subject": "Examen",
        "created": "2026-08-16",
        "cards": cards,
    }

    os.makedirs(os.path.dirname(OUT_PATH), exist_ok=True)
    with open(OUT_PATH, "w", encoding="utf-8") as f:
        json.dump(deck, f, ensure_ascii=False, indent=2)

    stats["total"] = len(cards)
    with open(os.path.join(ROOT, "_gen_examen_cards_summary.json"), "w", encoding="utf-8") as f:
        json.dump(stats, f, ensure_ascii=False, indent=2)
    print(f"OK: {len(cards)} cards -> {OUT_PATH}")


if __name__ == "__main__":
    main()
