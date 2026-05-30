# Script para reemplazar variables CSS con valores reales en el build
$cssFile = Get-ChildItem -Path "./dist/assets" -Filter "style-*.css" | Select-Object -First 1

if (-not $cssFile) {
    Write-Host "No se encontró archivo CSS"
    exit 1
}

$css = Get-Content $cssFile.FullName -Raw

# Definir las variables y sus valores (Black Theme + Google Colors)
$vars = @{
    '--bg-primary' = '#000000'
    '--bg-secondary' = '#0a0a0a'
    '--bg-tertiary' = '#141414'
    '--bg-elevated' = '#1a1a1a'
    '--text-primary' = '#f0f6fc'
    '--text-secondary' = '#8b949e'
    '--text-muted' = '#6e7681'
    '--accent-primary' = '#4285F4'
    '--accent-secondary' = '#1A73E8'
    '--accent-success' = '#34A853'
    '--accent-warning' = '#FBBC04'
    '--accent-danger' = '#EA4335'
    '--border-color' = '#1f1f1f'
    '--border-light' = '#0f0f0f'
    '--shadow-sm' = '0 1px 2px rgba(0, 0, 0, 0.3)'
    '--shadow-md' = '0 4px 12px rgba(0, 0, 0, 0.4)'
    '--shadow-lg' = '0 8px 24px rgba(0, 0, 0, 0.5)'
    '--shadow-xl' = '0 16px 48px rgba(0, 0, 0, 0.6)'
    '--radius-sm' = '6px'
    '--radius-md' = '8px'
    '--radius-lg' = '12px'
    '--transition' = 'all 0.2s ease'
}

# Reemplazar cada var(--variable) con su valor
foreach ($var in $vars.GetEnumerator()) {
    $pattern = 'var\(' + [regex]::Escape($var.Key) + '\)'
    $css = $css -replace $pattern, $var.Value
}

# Guardar el archivo modificado
$css | Set-Content $cssFile.FullName -NoNewline

Write-Host "Variables CSS reemplazadas correctamente en $($cssFile.Name)"
