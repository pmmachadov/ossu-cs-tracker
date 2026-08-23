# Compila archivos .java de la raiz a la carpeta out (outputPath del IDE).
# Uso:  .\compilar.ps1  [NombreClase]
#   Sin argumento: compila todos los .java de la raiz a out y listo.
#   Con argumento: compila y ejecuta esa clase, ej:  .\compilar.ps1 Primos
$ErrorActionPreference = 'Stop'

$dir = 'C:\Users\Pablo\Desktop\Pablo\anki-cards-completo'
$javac = 'C:\Users\Pablo\java\jdk-21.0.11+10\bin\javac.exe'
$java  = 'C:\Users\Pablo\java\jdk-21.0.11+10\bin\java.exe'
$out   = Join-Path $dir 'out'

if (!(Test-Path $out)) { New-Item -ItemType Directory -Path $out | Out-Null }

# Archivo con errores propios (ajeno al resto); se omite para no romper el build general.
$excluidos = @('MainAventureros_Resuelto.java')

$fuentes = Get-ChildItem -Path $dir -Filter *.java -File | Where-Object { $_.Name -notin $excluidos }

# Si pasas un nombre de clase, compila solo ese archivo (y crea su .class en bin).
if ($args.Count -gt 0) {
    $clase = $args[0]
    $archivo = Join-Path $dir "$clase.java"
    if (!(Test-Path $archivo)) {
        Write-Host "No existe $clase.java en la raiz." -ForegroundColor Red
        exit 1
    }
    Write-Host "Compilando $clase.java a out ..."
    & $javac -encoding UTF-8 -d $out $archivo
    if ($LASTEXITCODE -ne 0) {
        Write-Host "Compilacion de $clase con errores." -ForegroundColor Red
        exit $LASTEXITCODE
    }
    Write-Host "Ejecutando $clase ..."
    & $java -cp $out $clase
    exit $LASTEXITCODE
}

if ($fuentes.Count -eq 0) {
    Write-Host 'No hay archivos .java compilables en la raiz.'
    exit 1
}

Write-Host "Compilando $($fuentes.Count) archivo(s) .java a out ..."
& $javac -encoding UTF-8 -d $out $fuentes.FullName
if ($LASTEXITCODE -ne 0) {
    Write-Host 'Compilacion con errores. Corrige el codigo y vuelve a ejecutar.' -ForegroundColor Red
    exit $LASTEXITCODE
}
Write-Host 'Compilacion correcta.' -ForegroundColor Green
