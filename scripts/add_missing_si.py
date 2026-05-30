"""
Add missing SI preguntas directas - key topics not yet covered.
"""
import json, sys
sys.path.insert(0, 'scripts')

def load_json(path):
    with open(path, encoding='utf-8') as f:
        return json.load(f)

def save_json(path, data):
    with open(path, 'w', encoding='utf-8') as f:
        json.dump(data, f, ensure_ascii=False, indent=2)

pd_all = load_json('public/data/preguntas-directas/pd-all.json')

def next_id():
    si_nums = [int(c['id'].split('-')[-1]) for c in pd_all['cards'] if c['id'].startswith('pd-si-') and c['id'].split('-')[-1].isdigit()]
    max_num = max(si_nums) if si_nums else 0
    return f'pd-si-{max_num + 1:03d}'

def add_card(front, back, tags, difficulty='medium'):
    cid = next_id()
    card = {"id": cid, "front": front, "back": back, "tags": sorted(set(tags)), "difficulty": difficulty}
    pd_all['cards'].append(card)
    return cid

new_si = []

# 1. FHS - Linux directory structure
new_si.append({
    "front": """(SI — EAC1 / FHS) Explica el Filesystem Hierarchy Standard (FHS) en Linux.

1. ¿Qué es el FHS?
2. ¿Para qué sirven estos directorios?
   /bin, /sbin, /etc, /home, /var, /tmp, /usr, /opt, /dev, /proc
3. ¿Qué diferencia hay entre /bin y /usr/bin?""",
    "back": """FHS: estándar que define la estructura de directorios en Linux/Unix.

Directorios principales:
● /bin: comandos esenciales del usuario (ls, cp, mv)
● /sbin: comandos de administración/sistema (fdisk, mkfs)
● /etc: archivos de configuración del sistema
● /home: directorios personales de usuarios
● /var: datos variables (logs, colas de impresión, bases de datos)
● /tmp: archivos temporales (se borran al reiniciar)
● /usr: programas y datos de usuario (segundo nivel)
● /opt: software adicional de terceros
● /dev: archivos de dispositivo (discos, terminales)
● /proc: sistema de archivos virtual con información del kernel

/bin vs /usr/bin:
● Antes: /bin para lo esencial, /usr/bin para lo no esencial
● Hoy: /bin suele ser un enlace simbólico a /usr/bin
● En sistemas modernos es prácticamente lo mismo""",
    "tags": ['si', 'linux', 'fhs', 'directorios', 'sistema-archivos']
})

# 2. Enlaces: hard links vs symlinks
new_si.append({
    "front": """(SI — EAC1 / Enlaces) Explica los enlaces en Linux.

1. ¿Qué diferencia hay entre hard link y symlink (soft link)?
2. ¿Qué limitaciones tiene un hard link?
3. Crea un enlace simbólico 'link.txt' que apunte a 'original.txt'
4. ¿Qué pasa si borras el archivo original en cada caso?""",
    "back": """Hard link:
● Es otra entrada de directorio que apunta al mismo inodo
● Comparte el mismo contenido físico en disco
● Si borras el original, el enlace sigue funcionando (tiene su propio inodo)
● NO puede cruzar sistemas de archivos
● NO puede enlazar directorios

Symlink (soft link):
● Es un archivo especial que contiene la ruta al destino
● Si borras el original, el symlink se rompe (queda colgando)
● PUEDE cruzar sistemas de archivos
● PUEDE enlazar directorios

Comandos:
```bash
# Hard link
ln original.txt hardlink.txt

# Symlink
ln -s original.txt link.txt
```

¿Qué pasa si borras original.txt?
● Hard link: el archivo sigue existiendo (el inodo se libera solo cuando se borran TODOS los hard links)
● Symlink: el symlink queda roto (ls -l muestra el destino en rojo)""",
    "tags": ['si', 'linux', 'enlaces', 'sistema-archivos', 'comandos']
})

# 3. Permisos y umask
new_si.append({
    "front": """(SI — EAC2 / Permisos) Explica los permisos en Linux.

1. Interpreta: rwxr-xr--
2. ¿Qué significa chmod 754 archivo?
3. ¿Qué es la umask? Si la umask es 022, ¿qué permisos tiene un archivo nuevo?
4. Cambia el propietario de 'archivo.txt' al usuario 'juan' y el grupo a 'admin'""",
    "back": """1. rwxr-xr--:
   Usuario (rwx): lectura, escritura y ejecución
   Grupo (r-x): lectura y ejecución
   Otros (r--): solo lectura

2. chmod 754 = rwxr-xr--
   7 = rwx (4+2+1)
   5 = r-x (4+0+1)
   4 = r-- (4+0+0)

3. Umask: define los permisos por defecto para archivos nuevos.
   Fórmula: permisos_base - umask
   ● Archivos base: 666 (rw-rw-rw-)
   ● Directorios base: 777 (rwxrwxrwx)
   ● umask 022 → archivo: 666-022 = 644 (rw-r--r--)
   ● umask 022 → directorio: 777-022 = 755 (rwxr-xr-x)

4. Cambiar propietario/grupo:
```bash
chown juan:admin archivo.txt
# o separado:
chown juan archivo.txt
chgrp admin archivo.txt
```

Otros comandos:
● chmod +x script.sh: añadir ejecución
● chmod -R 755 directorio: recursivo""",
    "tags": ['si', 'linux', 'permisos', 'chmod', 'umask']
})

# 4. Find y wildcards
new_si.append({
    "front": """(SI — EAC1 / Búsqueda) Explica cómo buscar archivos en Linux.

1. Usando find:
   a) Busca todos los .txt en /home
   b) Busca archivos > 100MB
   c) Busca archivos modificados en los últimos 7 días
   d) Busca y ejecuta un comando en cada resultado

2. Comodines (wildcards):
   ¿Qué significan *, ?, [abc]?""",
    "back": """1. Find:
```bash
# Por nombre
find /home -name "*.txt"

# Por tamaño (>100MB)
find / -size +100M

# Por fecha de modificación (últimos 7 días)
find /home -mtime -7

# Buscar solo archivos (-type f) o directorios (-type d)
find / -type f -name "*.conf"

# Ejecutar comando en resultados
find /tmp -name "*.log" -exec rm {} \;
find / -type f -size +1G -exec ls -lh {} \;
```

2. Comodines:
● * : cualquier cadena (cero o más caracteres)
  ej: *.txt, foto*, *2024*
● ? : un solo carácter cualquiera
  ej: foto?.jpg (foto1.jpg, foto2.jpg, pero NO foto10.jpg)
● [abc]: un carácter del conjunto
  ej: [abc]* (archivos que empiecen por a, b o c)
● [!abc]: un carácter NO del conjunto
  ej: [!abc]* (archivos que NO empiecen por a, b o c)""",
    "tags": ['si', 'linux', 'busqueda', 'find', 'comodines']
})

# 5. RAID levels
new_si.append({
    "front": """(SI — EAC2 / RAID) Explica los niveles RAID.

1. ¿Qué es RAID y para qué sirve?
2. Explica RAID 0, 1, 5 y 10: ¿cuántos discos mínimo? ¿tolerancia a fallos? ¿capacidad usable?
3. ¿Qué RAID usarías para:
   a) Máximo rendimiento sin redundancia
   b) Máxima seguridad de datos con 2 discos
   c) Buen equilibrio rendimiento/redundancia con 3+ discos""",
    "back": """RAID (Redundant Array of Independent Disks):
Agrupa varios discos en una sola unidad lógica para mejorar
rendimiento y/o tolerancia a fallos.

RAID 0 (Striping):
● Mínimo: 2 discos
● Datos divididos en bloques y distribuidos entre discos
● Capacidad: 100% (N discos × capacidad)
● Tolerancia: NINGUNA - si falla un disco, se pierde todo
● Uso: máximo rendimiento, datos no críticos

RAID 1 (Mirroring):
● Mínimo: 2 discos
● Los datos se duplican en ambos discos
● Capacidad: 50% (N/2)
● Tolerancia: 1 disco
● Uso: máxima seguridad, rendimiento de lectura bueno

RAID 5 (Striping with parity):
● Mínimo: 3 discos
● Datos + paridad distribuida entre discos
● Capacidad: N-1 discos
● Tolerancia: 1 disco
● Uso: buen equilibrio rendimiento/seguridad

RAID 10 (RAID 1+0):
● Mínimo: 4 discos
● Combina mirroring (RAID 1) + striping (RAID 0)
● Capacidad: 50%
● Tolerancia: hasta N/2 discos (si son del mirror adecuado)
● Uso: alto rendimiento + redundancia""",
    "tags": ['si', 'eac2', 'raid', 'discos', 'redundancia']
})

# 6. LDAP concepts
new_si.append({
    "front": """(SI — EAC3 / LDAP) Explica los conceptos básicos de LDAP.

1. ¿Qué es LDAP y para qué sirve?
2. ¿Qué es un DN, CN, OU, DC?
3. ¿Qué es un árbol LDAP (DIT)?
4. ¿Qué comando usarías para buscar usuarios en LDAP?""",
    "back": """LDAP (Lightweight Directory Access Protocol):
Protocolo para acceder a directorios de información.
Se usa principalmente para autenticación centralizada
(usuarios, grupos, recursos de red).

Estructura:
● DN (Distinguished Name): nombre único que identifica una entrada
  ej: cn=juan perez,ou=usuarios,dc=empresa,dc=com
● CN (Common Name): nombre común (persona, recurso...)
● OU (Organizational Unit): unidad organizativa (departamento)
● DC (Domain Component): componente del dominio
● O (Organization): organización

Árbol LDAP (DIT - Directory Information Tree):
```
dc=empresa,dc=com
├── ou=usuarios
│   ├── cn=juan perez
│   └── cn=maria garcia
├── ou=grupos
│   └── cn=profesores
└── ou=equipos
    └── cn=portatil01
```

Buscar usuarios en LDAP:
```bash
ldapsearch -x -b "dc=empresa,dc=com" "(objectClass=person)"
```
-x: autenticación simple
-b: base de búsqueda (desde dónde buscar)
Filtro: qué tipo de entradas buscar""",
    "tags": ['si', 'eac3', 'ldap', 'directorio', 'autenticacion']
})

# 7. LVM more depth
new_si.append({
    "front": """(SI — EAC2 / LVM) Explica la gestión de volúmenes lógicos (LVM).

1. ¿Qué es LVM y qué ventajas tiene sobre particiones tradicionales?
2. Explica los 3 niveles: PV → VG → LV
3. Comandos para:
   a) Crear PV en /dev/sdb y /dev/sdc
   b) Crear VG 'mi_vg' con ambos PV
   c) Crear LV 'datos' de 3GB
   d) Formatear como ext4 y montar en /mnt/datos
4. ¿Cómo se amplía un LV cuando se queda sin espacio?""",
    "back": """LVM (Logical Volume Manager):
Capa de abstracción entre discos físicos y sistemas de archivos.
Ventajas: redimensionar volúmenes, snapshots, striping, mirroring.

Niveles:
1. PV (Physical Volume): disco o partición marcada para LVM
2. VG (Volume Group): grupo que agrupa uno o varios PV
3. LV (Logical Volume): volumen lógico = "disco virtual"

Comandos:
```bash
# Crear PV
sudo pvcreate /dev/sdb /dev/sdc

# Crear VG
sudo vgcreate mi_vg /dev/sdb /dev/sdc

# Crear LV de 3GB
sudo lvcreate -L 3G -n datos mi_vg

# Formatear y montar
sudo mkfs.ext4 /dev/mi_vg/datos
sudo mount /dev/mi_vg/datos /mnt/datos

# Ver estado
sudo pvs       # ver PV
sudo vgs       # ver VG
sudo lvs       # ver LV
```

Ampliar LV:
```bash
# 1. Ampliar LV (ej: +1GB)
sudo lvextend -L +1G /dev/mi_vg/datos

# 2. Redimensionar el sistema de archivos
sudo resize2fs /dev/mi_vg/datos
```
O en un solo paso:
```bash
sudo lvextend -r -L +1G /dev/mi_vg/datos
```""",
    "tags": ['si', 'eac2', 'lvm', 'discos', 'almacenamiento']
})

# 8. Systemd - service management
new_si.append({
    "front": """(SI — EAC2 / Systemd) Explica la gestión de servicios con systemd.

1. ¿Qué es systemd?
2. Escribe los comandos para:
   a) Iniciar un servicio (ej: apache2)
   b) Parar un servicio
   c) Habilitar un servicio al arranque
   d) Ver el estado de un servicio
   e) Ver logs de un servicio
3. ¿Qué diferencia hay entre enable/disable y start/stop?""",
    "back": """systemd: sistema de inicio y gestor de servicios en Linux moderno.
Reemplaza a System V init (service /etc/init.d/).

Comandos principales:
```bash
# Iniciar/parar/reiniciar (sesión actual)
sudo systemctl start apache2
sudo systemctl stop apache2
sudo systemctl restart apache2

# Habilitar/deshabilitar (al arranque del sistema)
sudo systemctl enable apache2
sudo systemctl disable apache2

# Estado
sudo systemctl status apache2

# Logs del servicio
sudo journalctl -u apache2

# Últimas líneas en tiempo real
sudo journalctl -u apache2 -f

# Recargar configuración sin reiniciar
sudo systemctl reload apache2
```

Diferencia:
● start/stop: afectan al servicio AHORA (sesión actual)
● enable/disable: afectan al ARRANQUE del sistema
● Se pueden combinar: enable + start = arrancar ahora y siempre

Otros comandos útiles:
```bash
# Listar todos los servicios
systemctl list-units --type=service

# Ver servicios activos
systemctl list-units --type=service --state=running
```""",
    "tags": ['si', 'eac2', 'systemd', 'servicios', 'linux']
})

# 9. Redes - TCP/IP basics
new_si.append({
    "front": """(SI — EAC1 / Redes) Explica los fundamentos de redes TCP/IP.

1. ¿Qué son las capas TCP/IP? Nombra las 4 capas y un protocolo de cada una.
2. ¿Qué es una IP? ¿Qué diferencia hay entre IPv4 e IPv6?
3. ¿Qué es una máscara de red? ¿Qué significa /24?
4. ¿Qué es la puerta de enlace (gateway)?
5. ¿Qué es DNS y para qué sirve?""",
    "back": """1. Capas TCP/IP:
   ● Aplicación: HTTP, FTP, SSH, DNS, SMTP (datos del usuario)
   ● Transporte: TCP (fiable), UDP (rápido) (segmentos)
   ● Red: IP, ICMP, ARP (paquetes)
   ● Enlace: Ethernet, WiFi (tramas)

2. IP (Internet Protocol):
   ● IPv4: 32 bits, 4 octetos (192.168.1.1), ~4.3 mil millones direcciones
   ● IPv6: 128 bits, 8 grupos hex (::1), casi ilimitado

3. Máscara de red: define qué parte de la IP es red y qué parte es host
   /24 = 255.255.255.0 = 24 bits de red, 8 bits de host = 254 hosts
   /16 = 255.255.0.0 = 65,534 hosts
   /8 = 255.0.0.0 = 16.7 millones hosts

4. Gateway (puerta de enlace): la IP del router que permite salir a otras redes/Internet

5. DNS (Domain Name System): traduce nombres de dominio (google.com) a direcciones IP (142.250.184.4)""",
    "tags": ['si', 'eac1', 'redes', 'tcpip', 'dns']
})

# 10. Networking commands
new_si.append({
    "front": """(SI — EAC2 / Redes) Comandos de red en Linux.

1. ¿Para qué sirven estos comandos?
   ip a, ip r, ping, traceroute, netstat, ss, dig, nslookup
2. Configura IP estática 192.168.1.100/24 con gateway 192.168.1.1 con ip command
3. ¿Cómo compruebas si un puerto está abierto en un servidor remoto?""",
    "back": """1. Comandos de red:
```bash
# Ver interfaces de red y sus IPs
ip a              # (ip addr) - remplaza a ifconfig

# Ver tabla de enrutamiento
ip r              # (ip route) - remplaza a route -n

# Probar conectividad
ping 8.8.8.8      # ICMP echo request (Ctrl+C para parar)

# Ver ruta hasta un destino
traceroute google.com

# Conexiones activas y puertos
ss -tln           # sockets TCP en escucha (remplaza netstat)
ss -tunap         # todas las conexiones TCP/UDP

# Consultas DNS
dig google.com    # consulta DNS detallada
nslookup google.com  # consulta DNS simple
```

2. Configurar IP estática con ip:
```bash
sudo ip addr add 192.168.1.100/24 dev eth0
sudo ip route add default via 192.168.1.1
```

3. Comprobar puerto abierto:
```bash
# Con nc (netcat)
nc -zv servidor.com 80

# Con telnet
telnet servidor.com 80

# Con nmap (más potente)
nmap -p 22,80,443 servidor.com
```""",
    "tags": ['si', 'eac2', 'redes', 'comandos', 'ip']
})

# 11. Swap y memoria
new_si.append({
    "front": """(SI — EAC2 / Memoria) Explica la gestión de memoria y swap en Linux.

1. ¿Qué es la memoria swap? ¿Para qué sirve?
2. ¿Cómo crear un archivo swap de 2GB?
3. ¿Cómo se comprueba el uso de memoria y swap?
4. ¿Qué es el caché de disco? ¿Por qué Linux usa RAM libre como caché?""",
    "back": """1. Swap: espacio en disco que Linux usa como "memoria virtual".
   Cuando la RAM se llena, las páginas inactivas se mueven a swap.
   No es un sustituto de la RAM (es mucho más lento).

2. Crear archivo swap de 2GB:
```bash
# Crear archivo de 2GB con ceros
sudo dd if=/dev/zero of=/swapfile bs=1M count=2048

# Establecer permisos (solo root puede leerlo)
sudo chmod 600 /swapfile

# Formatear como swap
sudo mkswap /swapfile

# Activar swap
sudo swapon /swapfile

# Hacerlo permanente (en /etc/fstab)
echo '/swapfile none swap sw 0 0' | sudo tee -a /etc/fstab
```

3. Ver uso de memoria:
```bash
free -h              # memoria en humano (MB/GB)
free -m              # en MB
cat /proc/meminfo    # información detallada
swapon --show        # ver swaps activos
```

4. Caché de disco:
● Linux usa RAM libre como caché de disco (buff/cache)
● Acelera el acceso a archivos leídos recientemente
● Si un programa necesita RAM, Linux libera caché automáticamente
● NO es memoria "ocupada" - se libera bajo demanda""",
    "tags": ['si', 'eac2', 'memoria', 'swap', 'linux']
})

# 12. Procesos en Linux
new_si.append({
    "front": """(SI — EAC2 / Procesos) Explica la gestión de procesos en Linux.

1. ¿Qué diferencia hay entre un proceso y un programa?
2. Comandos: ps, top, htop, kill, pkill, nice, renice
3. ¿Qué significa PID, PPID, TTY, STAT?
4. ¿Qué señal envía Ctrl+C? ¿Y kill -9?
5. ¿Cómo ejecutar un comando en segundo plano?""",
    "back": """1. Proceso: programa en ejecución con su propio PID, memoria y estado.
   Programa: archivo en disco (binario/script).

2. Comandos:
```bash
ps aux            # ver todos los procesos
ps -ef            # formato completo
top               # monitor interactivo en tiempo real
htop              # top mejorado (más vistoso)

kill 1234         # enviar SIGTERM (terminar amablemente)
kill -9 1234      # SIGKILL (matar forzosamente)
killall firefox   # matar por nombre

nice -n 10 comando   # ejecutar con prioridad baja
renice 5 -p 1234     # cambiar prioridad de un proceso
```

3. Campos de ps:
● PID: Process ID (identificador único)
● PPID: Parent PID (proceso padre que lo creó)
● TTY: terminal asociada (? = sin terminal, proceso del sistema)
● STAT: estado del proceso (R=running, S=sleeping, Z=zombie)

4. Señales:
● Ctrl+C = SIGINT (interrumpir)
● Ctrl+Z = SIGTSTP (suspender)
● kill = SIGTERM (terminar, el proceso puede limpiar)
● kill -9 = SIGKILL (matar inmediato, sin limpieza)
● kill -15 = SIGTERM (por defecto)
● kill -1 = SIGHUP (recargar configuración)

5. Segundo plano:
```bash
comando &          # ejecutar en segundo plano
nohup comando &    # ejecutar incluso si cierras la terminal
Ctrl+Z             # suspender proceso actual
bg                 # reanudar en segundo plano
fg                 # traer a primer plano
jobs               # ver procesos en segundo plano
```""",
    "tags": ['si', 'eac2', 'procesos', 'linux', 'comandos']
})

# 13. SSH keys vs password
new_si.append({
    "front": """(SI — EAC3 / SSH) Explica SSH y autenticación con claves.

1. ¿Qué es SSH y para qué sirve?
2. ¿Cómo conectarse por SSH a un servidor?
3. ¿Qué diferencia hay entre autenticación por contraseña y por clave pública?
4. Comandos para generar claves SSH y copiarlas al servidor.
5. ¿Qué es SFTP? ¿Cómo transferir archivos?""",
    "back": """1. SSH (Secure Shell): protocolo para acceso remoto seguro a servidores.
   Conexión cifrada, autenticación flexible.

2. Conectarse:
```bash
ssh usuario@servidor.com
ssh -p 2222 usuario@servidor.com  # puerto personalizado
```

3. Autenticación por contraseña vs clave pública:

Contraseña: escribes la contraseña cada vez.
   ● Simple pero menos seguro (fuerza bruta, phishing)
   
Clave pública: usando par de claves (pública + privada).
   ● La pública se copia al servidor (~/.ssh/authorized_keys)
   ● La privada nunca se comparte
   ● Más seguro, sin contraseña

4. Generar y copiar claves:
```bash
# Generar par de claves (RSA 4096)
ssh-keygen -t rsa -b 4096 -C "mi@email.com"

# Copiar clave pública al servidor
ssh-copy-id usuario@servidor.com

# O manualmente:
# cat ~/.ssh/id_rsa.pub | ssh usuario@servidor.com 'cat >> ~/.ssh/authorized_keys'
```

5. SFTP (SSH File Transfer Protocol):
```bash
# Conectarse
sftp usuario@servidor.com

# Comandos dentro de sftp:
ls                # listar archivos remotos
lls               # listar archivos locales
get archivo.txt   # descargar archivo
put archivo.txt   # subir archivo
get -r directorio # descargar directorio recursivo
bye               # salir
```""",
    "tags": ['si', 'eac3', 'ssh', 'sftp', 'seguridad']
})

# 14. Cron y automatización
new_si.append({
    "front": """(SI — EAC2 / Automatización) Explica cron y la planificación de tareas.

1. ¿Qué es cron y para qué sirve?
2. Explica el formato del crontab: minuto hora día-mes mes día-semana comando
3. Escribe crontab para:
   a) Ejecutar script.sh todos los días a las 2 AM
   b) Ejecutar backup.sh cada lunes a las 3:30 AM
   c) Ejecutar limpieza.sh cada hora
   d) Ejecutar cada 15 minutos
4. ¿Cómo se edita el crontab del usuario actual?""",
    "back": """cron: demonio que ejecuta tareas programadas en Linux.

Formato crontab (5 campos + comando):
```
min  hora  día-del-mes  mes  día-semana  comando
0    2     *            *    *           /ruta/script.sh
```

Campos:
● minuto: 0-59
● hora: 0-23
● día del mes: 1-31
● mes: 1-12 o ENE-DIC
● día de la semana: 0-7 (0=domingo) o DOM-SAB

Ejemplos:
```bash
# Diario a las 2 AM
0 2 * * * /ruta/script.sh

# Cada lunes a las 3:30 AM
30 3 * * 1 /ruta/backup.sh

# Cada hora (minuto 0)
0 * * * * /ruta/limpieza.sh

# Cada 15 minutos
*/15 * * * * /ruta/algo.sh

# Cada 1 de mes a las 5 AM
0 5 1 * * /ruta/mensual.sh
```

Comandos:
```bash
crontab -e        # editar crontab del usuario actual
crontab -l        # listar tareas programadas
crontab -r        # eliminar crontab
```

Atajos especiales:
@reboot: al arrancar el sistema
@daily: 0 0 * * *
@hourly: 0 * * *
@weekly: 0 0 * * 0""",
    "tags": ['si', 'eac2', 'cron', 'automatizacion', 'linux']
})

# Add all SI cards
for card_data in new_si:
    cid = add_card(card_data['front'], card_data['back'], card_data['tags'])
    print(f'  Added {cid}: {card_data["front"][:70]}...')

si_count = len([c for c in pd_all['cards'] if c['front'].startswith('(SI')])
print(f'\nAdded {len(new_si)} new SI preguntas directas')
print(f'Total SI now: {si_count}')
print(f'Total all: {len(pd_all["cards"])}')

save_json('public/data/preguntas-directas/pd-all.json', pd_all)
print('Saved.')
