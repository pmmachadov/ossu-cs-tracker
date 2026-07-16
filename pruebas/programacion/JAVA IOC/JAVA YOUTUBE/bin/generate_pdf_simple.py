#!/usr/bin/env python3
"""Generate exam PDF from HTML using Chrome with explicit settings."""

import subprocess
import os
import sys

html_path = os.path.abspath(
    r"C:\Users\Pablo\Desktop\Pablo\anki-cards-completo\pruebas\programacion\JAVA IOC\JAVA YOUTUBE\05-POO_Programacion_Orientada_Objetos\examen-poo.html"
)
pdf_path = os.path.abspath(
    r"C:\Users\Pablo\Desktop\Pablo\anki-cards-completo\pruebas\programacion\JAVA IOC\JAVA YOUTUBE\05-POO_Programacion_Orientada_Objetos\Examen_POO_Java_Tema5.pdf"
)
chrome = r"C:\Program Files\Google\Chrome\Application\chrome.exe"

file_url = "file:///" + html_path.replace("\\", "/").lstrip("/")

print(f"Chrome: {chrome}")
print(f"HTML:   {html_path}")
print(f"URL:    {file_url}")
print(f"PDF:    {pdf_path}")
print()

cmd = [
    chrome,
    "--headless=new",
    "--disable-gpu",
    "--no-first-run",
    "--no-default-browser-check",
    "--disable-popup-blocking",
    f"--print-to-pdf={pdf_path}",
    "--print-to-pdf-no-header",
    file_url
]

print("Running Chrome...")
result = subprocess.run(cmd, capture_output=True, text=True, timeout=120)
print(f"Return code: {result.returncode}")

if result.stderr:
    # Print last 500 chars of stderr
    err = result.stderr.strip()
    if err:
        print(f"Stderr: {err[-500:]}")

if os.path.exists(pdf_path):
    size = os.path.getsize(pdf_path)
    print(f"\n✓ PDF created: {size:,} bytes ({size/1024:.0f} KB)")
    
    # Validate with PyMuPDF
    try:
        import fitz
        doc = fitz.open(pdf_path)
        print(f"  Pages: {doc.page_count}")
        
        # Check for content
        total_text = ""
        for i in range(min(doc.page_count, 5)):
            total_text += doc[i].get_text()
        
        checks = [
            ("Exercise 1.1", "Ejercicio 1.1" in total_text),
            ("Solution 1.1", "Solución 1.1" in total_text),
            ("Exercise 2.1", "Ejercicio 2.1" in total_text),
            ("Has Java code", "class" in total_text),
        ]
        for label, ok in checks:
            print(f"  {'✓' if ok else '✗'} {label}")
        
        # Count total solutions
        sol_count = 0
        for i in range(doc.page_count):
            if "Solución" in doc[i].get_text():
                sol_count += 1
        print(f"  Pages with 'Solución': {sol_count}")
        
        doc.close()
    except Exception as e:
        print(f"  Validation error: {e}")
else:
    print("✗ PDF was NOT created!")
