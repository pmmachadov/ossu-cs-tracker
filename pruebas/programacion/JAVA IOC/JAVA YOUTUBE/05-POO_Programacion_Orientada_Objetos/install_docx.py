#!/usr/bin/env python3
"""Generate exam in DOCX format."""
import subprocess, sys

# Install python-docx
result = subprocess.run(
    [sys.executable, "-m", "pip", "install", "python-docx"],
    capture_output=True, text=True
)
print(result.stdout[-200:])
print(result.stderr[-200:])
print("Exit:", result.returncode)
