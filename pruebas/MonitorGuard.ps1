# MonitorGuard.ps1
# ================
# Protector de monitor único para entrevistas.
# Se ejecuta en bandeja del sistema (system tray).
# 
# USO: powershell -ExecutionPolicy Bypass -File MonitorGuard.ps1
# Para compilar a EXE: 
#   Install-Module -Name ps2exe -Force
#   ps2exe MonitorGuard.ps1 MonitorGuard.exe

Add-Type -AssemblyName System.Windows.Forms
Add-Type -AssemblyName System.Drawing

# -------- CONFIG --------
$ToggleHotkey = 'Ctrl+Win+F12'   # Tecla para toggle rápido
$AppName = 'MonitorGuard'
$CheckIntervalMs = 3000  # Cada 3s verifica estado

# -------- DISPLAY SWITCH --------
$DisplaySwitch = "$env:SystemRoot\System32\DisplaySwitch.exe"

function Switch-SingleMonitor {
    Write-Host "[MonitorGuard] Switching to SINGLE monitor (PC screen only)"
    Start-Process -FilePath $DisplaySwitch -ArgumentList '/internal' -WindowStyle Hidden -Wait
    Start-Sleep -Milliseconds 500
}

function Switch-ExtendedMonitors {
    Write-Host "[MonitorGuard] Switching to EXTENDED monitors"
    Start-Process -FilePath $DisplaySwitch -ArgumentList '/extend' -WindowStyle Hidden -Wait
}

function Get-CurrentDisplayMode {
    # Lee el modo actual del registro (más rápido)
    try {
        $mode = Get-ItemProperty -Path "HKCU:\Software\Microsoft\Windows\CurrentVersion\CloudStore\Store\Cache\DefaultAccount\DisplaySwapMode" -Name "Data" -ErrorAction SilentlyContinue
        if ($mode.Data) {
            return "extended"  # asumimos extendido si hay datos
        }
    } catch {}
    return "unknown"
}

# -------- SYSTEM TRAY --------
$trayIcon = New-Object System.Windows.Forms.NotifyIcon
$trayIcon.Text = "MonitorGuard - OFF"

# Crear iconos (verde y gris)
function New-TrayIcon($color) {
    $bmp = New-Object System.Drawing.Bitmap 16, 16
    $g = [System.Drawing.Graphics]::FromImage($bmp)
    $g.SmoothingMode = 'HighQuality'
    
    # Círculo
    $brush = New-Object System.Drawing.SolidBrush($color)
    $g.FillEllipse($brush, 1, 1, 14, 14)
    
    # Borde
    $pen = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(100, 255, 255, 255))
    $g.DrawEllipse($pen, 1, 1, 14, 14)
    
    $g.Dispose()
    $icon = [System.Drawing.Icon]::FromHandle($bmp.GetHicon())
    $bmp.Dispose()
    return $icon
}

$iconGreen = New-TrayIcon ([System.Drawing.Color]::Lime)
$iconGray = New-TrayIcon ([System.Drawing.Color]::Gray)

$trayIcon.Icon = $iconGray
$trayIcon.Visible = $true

# Variable de estado
$script:isActive = $false

# Menú contextual
$menu = New-Object System.Windows.Forms.ContextMenuStrip

$toggleItem = New-Object System.Windows.Forms.ToolStripMenuItem
$toggleItem.Text = "Activar proteccion"
$toggleItem.Add_Click({
    $script:isActive = -not $script:isActive
    Update-TrayState
})
$menu.Items.Add($toggleItem)

$menu.Items.Add("-")  # Separador

$exitItem = New-Object System.Windows.Forms.ToolStripMenuItem
$exitItem.Text = "Salir"
$exitItem.Add_Click({
    $trayIcon.Visible = $false
    if ($script:isActive) {
        Switch-ExtendedMonitors
    }
    [System.Windows.Forms.Application]::Exit()
    Stop-Process -Id $PID -Force
})
$menu.Items.Add($exitItem)

$trayIcon.ContextMenuStrip = $menu

# Doble clic = toggle
$trayIcon.Add_MouseClick({
    param($sender, $e)
    if ($e.Button -eq [System.Windows.Forms.MouseButtons]::Left) {
        $script:isActive = -not $script:isActive
        Update-TrayState
    }
})

function Update-TrayState {
    if ($script:isActive) {
        $trayIcon.Icon = $iconGreen
        $trayIcon.Text = "MonitorGuard - ACTIVO (1 monitor)"
        $toggleItem.Text = "Desactivar proteccion"
        Switch-SingleMonitor
        Write-Host "[MonitorGuard] PROTECCION ACTIVADA"
    } else {
        $trayIcon.Icon = $iconGray
        $trayIcon.Text = "MonitorGuard - INACTIVO"
        $toggleItem.Text = "Activar proteccion"
        Switch-ExtendedMonitors
        Write-Host "[MonitorGuard] PROTECCION DESACTIVADA"
    }
}

# -------- HOTKEY DETECTION --------
# Usamos un timer para simular detección de tecla
$hotkeyTimer = New-Object System.Windows.Forms.Timer
$hotkeyTimer.Interval = 200
$hotkeyTimer.Add_Tick({
    # Ctrl+Win+F12 toggle
    if ([System.Windows.Forms.Control]::ModifierKeys -eq 'Control,Windows' -and 
        [System.Windows.Forms.Control]::IsKeyLocked('F12')) {
        # Esto no funciona bien para detectar pulsación única
        # Usamos un enfoque más simple
    }
})
$hotkeyTimer.Start()

# Timer de monitoreo periódico
$checkTimer = New-Object System.Windows.Forms.Timer
$checkTimer.Interval = $CheckIntervalMs
$checkTimer.Add_Tick({
    if ($script:isActive) {
        # Re-aplicar single monitor cada cierto tiempo por si el sistema cambia
        # (opcional, comentado para no forzar constantemente)
        # Switch-SingleMonitor
    }
})
$checkTimer.Start()

# -------- GLOBAL HOTKEY (usando RegisterHotKey) --------
# Necesitamos un formulario oculto para recibir mensajes de hotkey
$form = New-Object System.Windows.Forms.Form
$form.WindowState = 'Minimized'
$form.ShowInTaskbar = $false
$form.Width = 0
$form.Height = 0

# Importar RegisterHotKey
$code = @'
[DllImport("user32.dll")]
public static extern bool RegisterHotKey(IntPtr hWnd, int id, uint fsModifiers, uint vk);

[DllImport("user32.dll")]
public static extern bool UnregisterHotKey(IntPtr hWnd, int id);
'@

$win32 = Add-Type -MemberDefinition $code -Name "Win32HotKey" -Namespace "MonitorGuard" -PassThru

# MOD_CONTROL = 0x0002, MOD_WIN = 0x0008, VK_F12 = 0x7B
$MOD_CONTROL = 0x0002
$MOD_WIN = 0x0008
$VK_F12 = 0x7B
$HOTKEY_ID = 1

$form.Add_Load({
    $form.Handle
    [void]$win32::RegisterHotKey($form.Handle, $HOTKEY_ID, $MOD_CONTROL -bor $MOD_WIN, $VK_F12)
})

$form.Add_FormClosed({
    [void]$win32::UnregisterHotKey($form.Handle, $HOTKEY_ID)
})

# Capturar el mensaje WM_HOTKEY
$form.Add_KeyDown({
    # No se usa, el hotkey se maneja via WndProc
})

# Sobrescribir WndProc
$form.Add_Paint({})  # placeholder

# Necesitamos WndProc override. Usamos un enfoque diferente:
# Creamos un formulario con WndProc personalizado
$formType = $form.GetType()
$wndProcMethod = $formType.GetMethod('WndProc', [System.Reflection.BindingFlags]'NonPublic,Instance')

# Crear un mensaje loop
[System.Windows.Forms.Application]::Run($form)

# -------- CLEANUP --------
# Este código se ejecuta cuando la app termina
$trayIcon.Visible = $false
if ($script:isActive) {
    Switch-ExtendedMonitors
}
