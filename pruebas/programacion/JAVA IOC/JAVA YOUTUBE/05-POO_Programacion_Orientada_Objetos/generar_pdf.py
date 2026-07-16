#!/usr/bin/env python
"""Generate the exam PDF from HTML using Chrome headless."""

import subprocess
import os

html_path = os.path.abspath(
    r"C:\Users\Pablo\Desktop\Pablo\anki-cards-completo\pruebas\programacion\JAVA IOC\JAVA YOUTUBE\05-POO_Programacion_Orientada_Objetos\examen-poo.html"
)
pdf_path = os.path.abspath(
    r"C:\Users\Pablo\Desktop\Pablo\anki-cards-completo\pruebas\programacion\JAVA IOC\JAVA YOUTUBE\05-POO_Programacion_Orientada_Objetos\Examen_POO_Java_Tema5.pdf"
)
chrome = r"C:\Program Files\Google\Chrome\Application\chrome.exe"

# Build file URL with proper path separators
file_url = "file:///" + html_path.replace("\\", "/").replace("C:", "C:")

print("HTML path:", html_path)
print("PDF output:", pdf_path)
print("URL:", file_url)

# Use Chrome with explicit page size A4 and no headers
cmd = [
    chrome,
    "--headless=new",
    "--disable-gpu",
    "--no-first-run",
    "--no-default-browser-check",
    f"--print-to-pdf={pdf_path}",
    "--print-to-pdf-no-header",
    file_url,
]

print("Running Chrome headless...")
result = subprocess.run(
    cmd, capture_output=True, text=True, timeout=120
)
print("Return code:", result.returncode)
if result.stderr:
    print("Stderr:", result.stderr[:500])

if os.path.exists(pdf_path):
    size = os.path.getsize(pdf_path)
    print(f"PDF created: {size} bytes ({size / 1024:.1f} KB)")
    # Quick check for content
    try:
        import fitz

        doc = fitz.open(pdf_path)
        print(f"Pages: {doc.page_count}")
        # Search for "Solución" in first 10 pages
        found = 0
        for i in range(min(doc.page_count, 30)):
            text = doc[i].get_text()
            if "olución" in text or "Soluci" in text:
                found += 1
        print(f"Pages with solution content (first 30): {found}")
        doc.close()
    except ImportError:
        print("fitz not available for validation")
else:
    print("ERROR: PDF was not created!")
