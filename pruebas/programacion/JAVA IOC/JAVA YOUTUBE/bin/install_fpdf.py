#!/usr/bin/env python3
"""Generate exam PDF using fpdf2."""

import subprocess
import sys

# Install fpdf2
result = subprocess.run(
    [sys.executable, "-m", "pip", "install", "fpdf2"],
    capture_output=True, text=True
)
print(result.stdout[-200:] if len(result.stdout) > 200 else result.stdout)
print(result.stderr[-200:] if len(result.stderr) > 200 else result.stderr)
print("Return:", result.returncode)
