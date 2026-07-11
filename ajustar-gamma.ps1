Add-Type -TypeDefinition @'
using System;
using System.Runtime.InteropServices;
public class GammaFix {
    [DllImport("gdi32.dll")] public static extern IntPtr CreateDC(string d, string dev, string o, IntPtr i);
    [DllImport("gdi32.dll")] public static extern bool DeleteDC(IntPtr h);
    [DllImport("gdi32.dll")] public static extern bool SetDeviceGammaRamp(IntPtr h, ref RAMP r);
    [DllImport("gdi32.dll")] public static extern bool GetDeviceGammaRamp(IntPtr h, ref RAMP r);
    [StructLayout(LayoutKind.Sequential)]
    public struct RAMP {
        [MarshalAs(UnmanagedType.ByValArray, SizeConst=256)] public ushort[] R;
        [MarshalAs(UnmanagedType.ByValArray, SizeConst=256)] public ushort[] G;
        [MarshalAs(UnmanagedType.ByValArray, SizeConst=256)] public ushort[] B;
    }
}
'@ -ErrorAction Stop

$hdc = [GammaFix]::CreateDC("DISPLAY", "\\.\DISPLAY5", $null, [IntPtr]::Zero)
if ($hdc -eq [IntPtr]::Zero) { $hdc = [GammaFix]::CreateDC($null, "\\.\DISPLAY5", $null, [IntPtr]::Zero) }

Write-Host "=== Aplicando gamma 2.6 al monitor externo (PCC-27200QHD) ==="

$ramp = New-Object GammaFix+RAMP
$ramp.R = New-Object System.UInt16[] 256
$ramp.G = New-Object System.UInt16[] 256
$ramp.B = New-Object System.UInt16[] 256

# Leer rampa actual
$ok = [GammaFix]::GetDeviceGammaRamp($hdc, [ref]$ramp)
Write-Host "Rampa actual:"
Write-Host "  R[0]=$($ramp.R[0]) R[32]=$($ramp.R[32]) R[64]=$($ramp.R[64])"
Write-Host "  R[96]=$($ramp.R[96]) R[128]=$($ramp.R[128]) R[192]=$($ramp.R[192]) R[255]=$($ramp.R[255])"

# Calcular gamma 2.6 - oscurece medios tonos y profundiza negros
write-Host "`nAplicando gamma 2.6..."
$gamma = 2.6
for ($i = 0; $i -lt 256; $i++) {
    $v = [int]([Math]::Pow($i / 255.0, $gamma) * 65535.0)
    if ($v -gt 65535) { $v = 65535 }
    if ($v -lt 0) { $v = 0 }
    $ramp.R[$i] = $v
    $ramp.G[$i] = $v
    $ramp.B[$i] = $v
}

$ok2 = [GammaFix]::SetDeviceGammaRamp($hdc, [ref]$ramp)
if ($ok2) {
    Write-Host "`nGamma 2.6 aplicada correctamente al monitor PCC-27200QHD! (DISPLAY5)"
    Write-Host "Nuevos valores:"
    Write-Host "  R[0]=$($ramp.R[0]) R[32]=$($ramp.R[32]) R[64]=$($ramp.R[64])"
    Write-Host "  R[96]=$($ramp.R[96]) R[128]=$($ramp.R[128]) R[192]=$($ramp.R[192]) R[255]=$($ramp.R[255])"
    Write-Host "`n(Valores guia: gamma 1.0 R[128]=32896, gamma 2.6 R[128]=~9660)"
} else {
    $err = [Runtime.InteropServices.Marshal]::GetLastWin32Error()
    Write-Host "Error al aplicar gamma: $err"
}

[GammaFix]::DeleteDC($hdc)
