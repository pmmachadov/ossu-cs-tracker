# -*- coding: utf-8 -*-
"""Genera ilustraciones PNG pedagógicas (tema exámenes morado) para el PPTX."""
import matplotlib
matplotlib.use("Agg")
import matplotlib.pyplot as plt
from matplotlib.patches import FancyBboxPatch, FancyArrowPatch, Rectangle, Circle
from matplotlib.patches import FancyArrow
import os

OUT = r"C:\Users\Pablo\Desktop\Pablo\anki-cards-completo\ilustraciones"
os.makedirs(OUT, exist_ok=True)

# Paleta del tema exámenes
BG = "#141527"
CARD = "#25263D"
ACCENT = "#7C6CF0"
PURPLE_L = "#A99CFF"
GREEN = "#34A853"
YELLOW = "#FFD766"
RED = "#EA4335"
BLUE = "#4285F4"
WHITE = "#F5F5F5"
GRAY = "#B0B8C8"
CODEBG = "#0E0F1A"

plt.rcParams["font.family"] = "DejaVu Sans"


def newfig(w, h):
    fig, ax = plt.subplots(figsize=(w, h), dpi=170)
    ax.set_xlim(0, 10)
    ax.set_ylim(0, 10)
    ax.axis("off")
    fig.patch.set_facecolor(BG)
    return fig, ax


def save(fig, name):
    p = os.path.join(OUT, name)
    fig.savefig(p, facecolor=BG, bbox_inches="tight", pad_inches=0.12)
    plt.close(fig)
    print("OK", name)


# ---------- 1. Array con índices ----------
def array_illustration():
    fig, ax = newfig(9.5, 3.2)
    vals = [3, 8, 5, 12, 4, 9, 2, 7]
    n = len(vals)
    cw = 1.05
    x0, y = 0.4, 3.6
    for i, v in enumerate(vals):
        x = x0 + i * cw
        if v % 2 == 0:
            c = GREEN
        else:
            c = ACCENT
        ax.add_patch(Rectangle((x, y), cw * 0.92, 1.7, facecolor=c, edgecolor="none"))
        ax.text(x + cw * 0.46, y + 1.15, str(v), ha="center", va="center",
                fontsize=24, color=BG, fontweight="bold")
        ax.text(x + cw * 0.46, y - 0.55, f"[{i}]", ha="center", va="center",
                fontsize=14, color=GRAY)
    ax.text(0.4, 8.2, "Arreglo nums[8]  —  índices 0 a 7", fontsize=17,
            color=WHITE, fontweight="bold")
    ax.text(0.4, 7.2, "Verde = par  ·  Morado = impar", fontsize=13, color=PURPLE_L)
    ax.add_patch(FancyArrow(0.5, 2.6, 0.5, 3.1, width=0.06, color=GRAY))
    ax.text(0.15, 2.2, "índice", fontsize=11, color=GRAY)
    save(fig, "array_indices.png")


# ---------- 2. Diagrama de flujo del programa ----------
def flowchart():
    fig, ax = newfig(7.6, 8.2)
    bx, by, bw, bh = 2.6, 0.5, 4.8, 1.05
    def oval(y, label, color=ACCENT, tc=BG):
        ax.add_patch(FancyBboxPatch((bx, y), bw, bh, boxstyle="round,pad=0.08,rounding_size=0.5",
                                    facecolor=color, edgecolor="none"))
        ax.text(bx + bw/2, y + bh/2, label, ha="center", va="center",
                fontsize=11.5, color=tc, fontweight="bold")
    def rect(y, label, color=CARD):
        ax.add_patch(FancyBboxPatch((bx, y), bw, bh, boxstyle="round,pad=0.02,rounding_size=0.08",
                                    facecolor=color, edgecolor=PURPLE_L, linewidth=1.5))
        ax.text(bx + bw/2, y + bh/2, label, ha="center", va="center",
                fontsize=10.5, color=WHITE)
    def arrow(y1, y2):
        ax.add_patch(FancyArrow(bx + bw/2, y1, 0, y2 - y1, width=0.035,
                                head_width=0.28, head_length=0.28, color=GRAY))
    y = 0.5
    oval(y, "INICIO", GREEN); arrow(y+bh, y+bh+0.55); y += 1.6
    rect(y, "Crear int[] nums = new int[8]"); arrow(y+bh, y+bh+0.55); y += 1.6
    rect(y, "Bucle for: leer 8 números\nnums[i] = scanner.nextInt()"); arrow(y+bh, y+bh+0.55); y += 1.6
    rect(y, "contarPares(nums)"); arrow(y+bh, y+bh+0.55); y += 1.6
    rect(y, "mayor(nums) · menor(nums)"); arrow(y+bh, y+bh+0.55); y += 1.6
    rect(y, "invertir(nums)"); arrow(y+bh, y+bh+0.55); y += 1.6
    oval(y, "FIN", RED)
    save(fig, "flowchart.png")


# ---------- 3. Traza visual de invertir ----------
def invert_trace():
    fig, ax = newfig(10.5, 5.0)
    orig = [3, 8, 5, 12, 4, 9, 2, 7]
    inv = list(reversed(orig))
    cw = 1.0
    def draw(row, vals, y, color, title):
        x0 = 0.4
        ax.text(0.4, y + 2.0, title, fontsize=15, color=color, fontweight="bold")
        for i, v in enumerate(vals):
            x = x0 + i * cw
            ax.add_patch(Rectangle((x, y), cw*0.9, 1.5, facecolor=color, edgecolor="none"))
            ax.text(x + cw*0.45, y + 1.0, str(v), ha="center", va="center",
                    fontsize=20, color=BG, fontweight="bold")
            ax.text(x + cw*0.45, y - 0.42, f"[{i}]", ha="center", va="center",
                    fontsize=12, color=GRAY)
    draw(0, orig, 3.4, ACCENT, "nums (original)")
    draw(1, inv, 0.4, GREEN, "invertido")
    # flechas de mapeo
    x0 = 0.4
    for i in range(len(orig)):
        src = x0 + (len(orig)-1-i)*cw + cw*0.45
        dst = x0 + i*cw + cw*0.45
        ax.add_patch(FancyArrowPatch((src, 3.4+1.5), (dst, 0.4+1.5),  # invert
                                     arrowstyle="-|>", mutation_scale=12,
                                     color=PURPLE_L, lw=1.2, alpha=0.7,
                                     connectionstyle="arc3,rad=0.15"))
    save(fig, "invert_trace.png")


# ---------- 4. for vs for-each ----------
def for_vs_foreach():
    fig, ax = newfig(9.5, 4.6)
    vals = [3, 8, 5]
    cw = 1.1
    def draw(y, color, label):
        x0 = 2.4
        ax.text(0.4, y + 1.6, label, fontsize=13, color=color, fontweight="bold")
        for i, v in enumerate(vals):
            x = x0 + i * cw
            ax.add_patch(Rectangle((x, y), cw*0.9, 1.5, facecolor=color, edgecolor="none"))
            ax.text(x + cw*0.45, y + 0.75, str(v), ha="center", va="center",
                    fontsize=18, color=BG, fontweight="bold")
        return x0
    ax.text(0.4, 7.6, "for con índice: recorres por posición [i]", fontsize=15,
            color=YELLOW, fontweight="bold")
    x0 = draw(4.6, YELLOW, "for (int i = 0; i < n; i++)  →  nums[i]")
    for i in range(3):
        ax.add_patch(FancyArrow(x0 + i*cw + cw*0.45, 6.1, 0, 0.45, width=0.03,
                                head_width=0.15, head_length=0.2, color=YELLOW))
        ax.text(x0 + i*cw + cw*0.45, 6.7, f"[{i}]", fontsize=12, color=YELLOW,
                ha="center")
    ax.text(0.4, 3.9, "for-each: te da el valor directamente", fontsize=15,
            color=GREEN, fontweight="bold")
    draw(1.2, GREEN, "for (int valor : nums)  →  valor")
    for i in range(3):
        ax.add_patch(FancyArrow(x0 + i*cw + cw*0.45, 2.7, 0, 0.4, width=0.03,
                                head_width=0.15, head_length=0.2, color=GREEN))
        ax.text(x0 + i*cw + cw*0.45, 0.5, "valor", fontsize=12, color=GREEN,
                ha="center")
    save(fig, "for_foreach.png")


# ---------- 5. mayor/menor "candidato" ----------
def mayor_menor():
    fig, ax = newfig(9.2, 4.0)
    vals = [3, 8, 5, 12, 4, 9, 2, 7]
    cw = 1.0
    x0, y = 0.6, 3.0
    ax.text(0.4, 7.0, "mayor: cada vez que un valor supera al candidato, se actualiza",
            fontsize=14, color=YELLOW, fontweight="bold")
    ax.text(0.4, 6.3, "Inicia en nums[0] = 3", fontsize=13, color=GRAY)
    for i, v in enumerate(vals):
        x = x0 + i * cw
        if i == 0:
            c = YELLOW
        elif v == 12:
            c = GREEN
        else:
            c = CARD
        ax.add_patch(Rectangle((x, y), cw*0.9, 1.5, facecolor=c, edgecolor=PURPLE_L,
                               linewidth=1 if c != CARD else 0.4))
        ax.text(x + cw*0.45, y + 0.75, str(v), ha="center", va="center",
                fontsize=18, color=WHITE if c in (YELLOW, GREEN) else GRAY,
                fontweight="bold" if c in (YELLOW, GREEN) else False)
    ax.text(x0 + 3*cw + cw*0.45, y + 2.1, "▲ nuevo máximo", fontsize=12,
            color=GREEN, ha="center")
    ax.add_patch(FancyArrow(x0 + 3*cw + cw*0.45, y + 1.5, 0, 0.25, width=0.02,
                            head_width=0.15, head_length=0.2, color=GREEN))
    # menor
    ax.text(0.4, 1.6, "menor: mismo patrón pero con <  →  3 → 2", fontsize=14,
            color=PURPLE_L, fontweight="bold")
    save(fig, "mayor_menor.png")


if __name__ == "__main__":
    array_illustration()
    flowchart()
    invert_trace()
    for_vs_foreach()
    mayor_menor()
    print("Ilustraciones generadas en", OUT)
