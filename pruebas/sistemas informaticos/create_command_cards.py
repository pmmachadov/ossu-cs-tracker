import json

path = r'C:\Users\Pablo\Desktop\Pablo\anki-cards-completo\public\data\preguntas-directas\pd-all.json'
with open(path, encoding='utf-8') as f:
    data = json.load(f)

new_cards = [
    {
        "id": "pd-si-043",
        "front": "(SI — Linux / Comandos) ¿Que hace `ls` y cuales son sus opciones mas usadas?\n\nOpciones: -l, -a, -la, -lh, -R, -S, -t, -r.",
        "back": "`ls` lista el contenido de un directorio.\n\nOpciones:\n\n● -l : formato largo (permisos, propietario, tamano, fecha)\n\n● -a : muestra archivos ocultos (empiezan por .)\n\n● -la : combina formato largo + ocultos\n\n● -lh : tamaño en formato legible (K, M, G)\n\n● -R : listado recursivo (subdirectorios)\n\n● -S : ordena por tamaño\n\n● -t : ordena por fecha de modificacion\n\n● -r : orden inverso\n\nEjemplo:\n  ls -la /home/usuario\n  ls -lhS /var/log\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "easy"
    },
    {
        "id": "pd-si-044",
        "front": "(SI — Linux / Comandos) ¿Que hace `cd`, `pwd` y `which` en Linux?",
        "back": "● `cd [directorio]` : Change Directory.\n  Navega al directorio especificado.\n  cd ~  → va al home del usuario\n  cd .. → sube un nivel\n  cd /  → va a la raiz\n  cd -  → vuelve al directorio anterior\n\n● `pwd` : Print Working Directory.\n  Muestra la ruta absoluta del directorio actual.\n\n● `which [comando]` : muestra la ruta del ejecutable.\n  Ej: which ls → /usr/bin/ls\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "easy"
    },
    {
        "id": "pd-si-045",
        "front": "(SI — Linux / Comandos) ¿Que hacen `cp`, `mv`, `rm`, `mkdir` y `touch`? Da un ejemplo de cada uno.",
        "back": "Gestion basica de archivos:\n\n● `cp origen destino` : copia archivos/directorios.\n  cp -r dir1/ dir2/  → copia recursiva\n  cp archivo.txt backup/  → copia a directorio\n\n● `mv origen destino` : mueve o renombra.\n  mv archivo.txt nueva-ruta/  → mover\n  mv viejo.txt nuevo.txt  → renombrar\n\n● `rm archivo` : elimina archivos.\n  rm -rf directorio/  → elimina recursivamente sin preguntar\n  rm *.tmp  → elimina todos los .tmp\n\n● `mkdir directorio` : crea un directorio.\n  mkdir -p a/b/c  → crea toda la jerarquia\n\n● `touch archivo` : crea archivo vacio o actualiza timestamp.\n  touch nuevo.txt  → crea si no existe\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "easy"
    },
    {
        "id": "pd-si-046",
        "front": "(SI — Linux / Comandos) ¿Que hace `cat`, `less`, `head`, `tail` y `wc`?",
        "back": "Visualizacion de archivos:\n\n● `cat archivo` : muestra el contenido completo.\n  cat /etc/passwd\n\n● `less archivo` : paginacion interactiva.\n  Espacio → siguiente pagina\n  q → salir\n  /texto → buscar\n\n● `head -n archivo` : muestra las primeras n lineas.\n  head -20 /var/log/syslog\n\n● `tail -n archivo` : muestra las ultimas n lineas.\n  tail -f /var/log/syslog  → sigue en tiempo real\n\n● `wc archivo` : word count (lineas, palabras, caracteres).\n  wc -l archivo  → solo lineas\n  wc -w archivo  → solo palabras\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "easy"
    },
    {
        "id": "pd-si-047",
        "front": "(SI — Linux / Comandos) ¿Que hacen `grep` y `find`? Da un ejemplo de cada uno.",
        "back": "Busqueda en Linux:\n\n● `grep patron archivo` : busca texto DENTRO de archivos.\n  grep \"error\" /var/log/syslog\n  grep -i \"warning\" *.log  → sin distincion mayus/minus\n  grep -r \"funcion\" src/  → recursivo\n  grep -v \"#\" config.conf  → excluye lineas con #\n  grep -E \"error|fail\" log.txt  → regex extendida\n\n● `find [directorio] -name \"patron\"` : busca ARCHIVOS por nombre.\n  find /home -name \"*.txt\"\n  find / -type f -size +100M  → archivos mayores a 100MB\n  find . -mtime -7  → modificados en los ultimos 7 dias\n  find . -exec rm {} \\;  → ejecuta comando en cada resultado\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-048",
        "front": "(SI — Linux / Comandos) ¿Que hacen `chmod`, `chown` y `chgrp`? Explica los permisos en Linux (rwx).",
        "back": "Permisos en Linux:\n\nCada archivo tiene 3 grupos de permisos:\n  r w x  |  r w x  |  r w x\n usuario  |  grupo  |  otros\n\nr=4 (lectura), w=2 (escritura), x=1 (ejecucion)\n\n● `chmod 755 archivo` : cambia permisos en octal.\n  7=rwx (usuario), 5=r-x (grupo), 5=r-x (otros)\n  chmod u+x archivo  → añade ejecucion al usuario\n  chmod go-w archivo  → quita escritura a grupo y otros\n\n● `chown usuario:grupo archivo` : cambia propietario.\n  chown root:root archivo\n  chown -R usuario:grupo directorio/  → recursivo\n\n● `chgrp grupo archivo` : cambia solo el grupo.\n  chgrp biblioteca documento.txt\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-049",
        "front": "(SI — Linux / Comandos) ¿Que hacen `ps`, `top`, `kill` y `killall`? Explica las senales de kill.",
        "back": "Gestion de procesos:\n\n● `ps` : lista procesos en ejecucion.\n  ps aux  → todos los procesos (formato detallado)\n  ps -ef  → formato completo\n  ps aux | grep apache  → filtrar por nombre\n\n● `top` : monitor interactivo en tiempo real.\n  q → salir\n  k → matar proceso (pide PID)\n  u → filtrar por usuario\n\n● `kill [senal] PID` : envia senal a un proceso.\n  kill -15 PID  → SIGTERM (terminar graceful, por defecto)\n  kill -9 PID   → SIGKILL (matar forzoso)\n  kill -1 PID   → SIGHUP (recargar configuracion)\n\n● `killall nombre` : mata todos los procesos con ese nombre.\n  killall nginx  → mata todos los procesos nginx\n  killall -9 chrome  → fuerza cierre\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-050",
        "front": "(SI — Linux / Comandos) ¿Que hace `systemctl`? Explica los subcomandos principales.",
        "back": "`systemctl` gestiona servicios en sistemas systemd (Ubuntu moderno, CentOS 7+).\n\nSubcomandos principales:\n\n● `systemctl start servicio` : inicia el servicio\n● `systemctl stop servicio` : detiene el servicio\n● `systemctl restart servicio` : reinicia\n● `systemctl reload servicio` : recarga config sin reiniciar\n● `systemctl enable servicio` : auto-inicio al arrancar\n● `systemctl disable servicio` : desactiva auto-inicio\n● `systemctl status servicio` : muestra estado (activo, logs)\n● `systemctl mask servicio` : bloquea (no puede iniciarse ni manual)\n● `systemctl unmask servicio` : desbloquea\n● `systemctl list-units --type=service` : lista todos los servicios\n\nEjemplo:\n  sudo systemctl restart vsftpd\n  sudo systemctl status sshd\n  sudo systemctl enable --now nginx  → habilita e inicia\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-051",
        "front": "(SI — Linux / Comandos) ¿Que hacen `journalctl` y `systemctl` para ver logs?",
        "back": "`journalctl` accede a los logs del sistema (systemd-journald).\n\nComandos:\n\n● `journalctl` : muestra todos los logs (paginados)\n● `journalctl -u servicio` : logs de un servicio especifico\n  journalctl -u vsftpd\n● `journalctl -f` : sigue en tiempo real (como tail -f)\n● `journalctl --since \"hoy\"` : logs desde hoy\n● `journalctl -p err` : logs con nivel error\n● `journalctl -n 50` : ultimas 50 lineas\n● `journalctl --disk-usage` : espacio usado\n\nDiferencia:\n  `systemctl status servicio` → muestra logs de la sesion actual\n  `journalctl -u servicio` → muestra historico completo\n\nEj:\n  journalctl -u sshd -n 20 --no-pager\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-052",
        "front": "(SI — Linux / Comandos) ¿Que hacen `fdisk` y `gdisk`? Explica como crear particiones.",
        "back": "Particionado de discos:\n\n● `fdisk /dev/sdb` : herramienta MBR (max 2TB, 4 primarias).\n  Comandos internos:\n    m → ayuda\n    p → mostrar tabla de particiones\n    n → crear nueva particion\n    d → eliminar particion\n    t → cambiar tipo de particion\n    w → guardar cambios y salir\n    q → salir sin guardar\n\n  Crear 5 particiones MBR:\n    n → p (primaria) → 1 → +2G (x4)\n    5ª particion: n → e (extendida) → resto del disco\n    luego n → l (logica) dentro de la extendida\n\n● `gdisk /dev/sdb` : herramienta GPT (sin limite particiones).\n  Comandos identicos a fdisk (m, n, p, d, w, q).\n  Soporta discos > 2TB.\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-053",
        "front": "(SI — Linux / Comandos) ¿Que hacen `mkfs`, `mount`, `umount` y `lsblk`? Explica el montaje de particiones.",
        "back": "Formateo y montaje:\n\n● `mkfs -t ext4 /dev/sdb1` : formatea (crea sistema de archivos).\n  mkfs.ext4 /dev/sdb1\n  mkfs.ntfs /dev/sdb2\n  mkfs.vfat /dev/sdb3\n\n● `mount /dev/sdb1 /mnt/datos` : monta una particion.\n  mount -t ext4 /dev/sdb1 /mnt/datos\n  mount -o ro /dev/sdb2 /mnt/backup  → solo lectura\n  mount -o rw,uid=1000,gid=1000 /dev/sdb3 /mnt/usb\n\n● `umount /mnt/datos` : desmonta (o umount /dev/sdb1).\n  Si da \"target is busy\":\n    fuser -m /mnt/datos  → que procesos lo usan\n    lsof /mnt/datos\n\n● `lsblk` : lista discos/particiones en arbol.\n  lsblk -f  → con sistema de archivos y UUID\n  lsblk -o NAME,SIZE,TYPE,FSTYPE,MOUNTPOINT\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-054",
        "front": "(SI — Linux / Comandos) ¿Que hacen `blkid`, `df` y `du`?",
        "back": "Informacion de discos:\n\n● `blkid` : muestra UUID y tipo de sistema de archivos.\n  blkid /dev/sdb1  → UUID unico de particion\n  usado en /etc/fstab para montar por UUID\n\n● `df -h` : Disk Free, espacio disponible en discos montados.\n  df -h  → formato legible (GB, MB)\n  df -T  → con tipo de sistema de archivos\n  df -i  → inodos (cuando hay \"no space\" pero df muestra libre)\n\n● `du -sh directorio` : Disk Usage, tamano de directorios/archivos.\n  du -sh /home/usuario  → total del directorio\n  du -sh * | sort -h  → tamano de cada elemento, ordenado\n  du -shc /var/log/*  → suma total al final (-c)\n\nDiferencia: df mide espacio en disco montado,\ndu mide tamano de archivos/directorios.\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-055",
        "front": "(SI — Linux / Comandos) ¿Que hacen `tar`, `gzip`, `gunzip` y `rsync`?",
        "back": "Compresion y copias:\n\n● `tar` : empaqueta archivos.\n  tar -cvf backup.tar /home/usuario  → crear (c=crear, v=verbose, f=archivo)\n  tar -xvf backup.tar  → extraer (x=extraer)\n  tar -czvf backup.tar.gz /home  → comprimir con gzip (z)\n  tar -cjvf backup.tar.bz2 /home  → comprimir con bzip2 (j)\n  tar -tf backup.tar  → listar contenido (t=listar)\n\n● `gzip archivo` : comprime (reemplaza el original por .gz).\n  gzip archivo.txt  → crea archivo.txt.gz\n  gunzip archivo.txt.gz  → descomprime\n  gzip -k archivo.txt  → conserva el original\n  gzip -r directorio/  → comprime todo recursivamente\n\n● `rsync -av origen/ destino/` : sincroniza archivos.\n  rsync -av /home/user/docs/ /backup/docs/  → copia solo cambios\n  rsync -avz usuario@servidor:/remoto/ /local/  → por SSH (-z comprime)\n  rsync -av --delete origen/ destino/  → borra en destino lo que no hay en origen\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-056",
        "front": "(SI — Linux / Comandos) ¿Que hacen `apt`, `apt-get` y `dpkg`? Explica su uso.",
        "back": "Gestion de paquetes (Debian/Ubuntu):\n\n● `apt` : interfaz moderna.\n  sudo apt update  → actualiza lista de paquetes\n  sudo apt upgrade  → actualiza paquetes instalados\n  sudo apt install paquete  → instalar\n  sudo apt remove paquete  → desinstalar (deja config)\n  sudo apt purge paquete  → desinstalar completamente\n  sudo apt autoremove  → limpia dependencias huerfanas\n  apt search texto  → buscar paquete\n  apt show paquete  → informacion del paquete\n\n● `apt-get` : version clasica (mismos subcomandos).\n  apt-get update && apt-get upgrade -y\n\n● `dpkg` : gestion directa de paquetes .deb (bajo nivel).\n  dpkg -i paquete.deb  → instalar .deb\n  dpkg -r paquete  → eliminar\n  dpkg -l  → listar paquetes instalados\n  dpkg -L paquete  → que archivos instalo\n  dpkg -S /ruta/archivo  → que paquete contiene ese archivo\n\napt resuelve dependencias automaticamente; dpkg no.\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-057",
        "front": "(SI — Linux / Comandos) ¿Que hace `ip` (comando) y como configurar la red temporalmente en Linux?",
        "back": "Configuracion de red con `ip`:\n\n`ip` reemplazo moderno de ifconfig.\n\n● `ip addr` o `ip a` : muestra interfaces e IPs\n● `ip link` : interfaces de red\n● `ip route` o `ip r` : tabla de enrutamiento\n● `ip neigh` : tabla ARP (vecinos)\n\nConfigurar IP temporal (se pierde al reiniciar):\n\n  sudo ip addr add 192.168.1.100/24 dev eth0\n  sudo ip link set eth0 up\n  sudo ip route add default via 192.168.1.1\n\nVer configuracion:\n  ip a show eth0\n  ip route show\n\nEn Ubuntu moderno, config permanente se hace con:\n  /etc/netplan/*.yaml\n  sudo netplan apply\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-058",
        "front": "(SI — Linux / Comandos) ¿Que hacen `ping`, `netstat`, `ss` y `nmap`?",
        "back": "Diagnostico de red:\n\n● `ping IP` : prueba conectividad.\n  ping -c 5 8.8.8.8  → 5 paquetes\n  ping -c 5 google.com  → resuelve DNS\n\n● `netstat -tlnp` : muestra puertos en escucha TCP.\n  netstat -tlnp  → TCP en escucha con PID/programa\n  netstat -ulnp  → UDP\n  netstat -an  → todas las conexiones\n  netstat -rn  → tabla de enrutamiento\n\n● `ss` : reemplazo moderno de netstat (mas rapido).\n  ss -tlnp  → TCP escuchando\n  ss -tup  → conexiones activas\n  ss -s  → estadisticas resumidas\n\n● `nmap IP` : escanea puertos abiertos.\n  nmap localhost  → escaneo basico\n  nmap -p 1-1000 192.168.1.1  → rango de puertos\n  nmap -sV IP  → detecta versiones de servicios\n  nmap -O IP  → detecta SO\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-059",
        "front": "(SI — Linux / Comandos) ¿Que hacen `ssh`, `scp` y `sftp`?",
        "back": "Acceso remoto seguro:\n\n● `ssh usuario@IP` : conexion remota por SSH (puerto 22).\n  ssh usuario@192.168.1.100\n  ssh -p 2222 usuario@IP  → puerto personalizado\n  ssh -i ~/.ssh/clave usuario@IP  → autenticacion por clave\n\n● `scp origen usuario@IP:destino` : copia segura.\n  scp archivo.txt usuario@192.168.1.100:/home/usuario/\n  scp -r directorio/ usuario@IP:/destino/  → recursivo\n  scp usuario@IP:/remoto/archivo ./local/  → descargar\n\n● `sftp usuario@IP` : transferencia interactiva.\n  sftp usuario@192.168.1.100\n  Comandos dentro de sftp:\n    get archivo  → descargar\n    put archivo  → subir\n    ls  → listar remoto\n    lls  → listar local\n    cd  → cambiar dir remoto\n    lcd  → cambiar dir local\n    exit  → salir\n\nArchivos de config:\n  /etc/ssh/sshd_config  → servidor\n  PermitRootLogin no  → desactivar acceso root\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-060",
        "front": "(SI — Linux / Comandos) ¿Que hacen `useradd`, `usermod`, `groupadd` y `passwd`?",
        "back": "Gestion de usuarios y grupos:\n\n● `sudo useradd -m usuario` : crea usuario con home (-m).\n  sudo useradd -m -s /bin/bash -G grupo usuario\n  -m → crea /home/usuario\n  -s → shell por defecto\n  -G → grupos secundarios\n  -d /ruta → home personalizado\n\n● `sudo usermod -aG grupo usuario` : añade usuario a grupo.\n  usermod -L usuario  → bloquea cuenta\n  usermod -U usuario  → desbloquea\n  usermod -l nuevo_nom viejo_nom  → cambia nombre\n\n● `sudo groupadd grupo` : crea grupo.\n  sudo groupadd --system grupo  → grupo del sistema\n  sudo groupdel grupo  → elimina grupo\n  sudo groupmod -n nuevo_grupo viejo_grupo  → renombrar\n\n● `sudo passwd usuario` : cambia contrasena.\n  sudo passwd -l usuario  → bloquea cuenta\n  sudo passwd -u usuario  → desbloquea\n  sudo chage -l usuario  → info de vigencia contrasena\n  sudo chage -M 90 usuario  → maximo 90 dias contrasena\n\nVer informacion:\n  id usuario  → UID, GID, grupos\n  who  → usuarios conectados\n  last  → historial de logins\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-061",
        "front": "(SI — Linux / Comandos) ¿Que hacen `arp`, `route`, `wget`, `curl` y `hostnamectl`?",
        "back": "Comandos de red adicionales:\n\n● `arp -a` : muestra tabla ARP (IP ↔ MAC).\n  arp -d IP → borrar entrada ARP\n  arp -s IP MAC → añadir entrada estatica\n  (reemplazado por: ip neigh)\n\n● `route -n` : tabla de enrutamiento.\n  route add default gw 192.168.1.1  → gateway por defecto\n  (reemplazado por: ip route)\n\n● `wget URL` : descarga archivos desde HTTP/FTP.\n  wget https://ejemplo.com/archivo.zip\n  wget -O nombre.zip URL  → renombrar salida\n  wget -c URL  → continuar descarga interrumpida\n\n● `curl URL` : transfiere datos (mas versatil que wget).\n  curl https://api.ejemplo.com/datos\n  curl -o archivo.html URL  → guardar en archivo\n  curl -I URL  → solo cabeceras HTTP\n  curl -X POST -d \"data\" URL  → peticion POST\n\n● `hostnamectl set-hostname nombre` : cambia nombre del equipo.\n  hostnamectl status  → ver hostname actual\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-062",
        "front": "(SI — Linux / Comandos) ¿Que hacen `crontab`, `at`, `man`, `alias` y `history`?",
        "back": "Utilidades del sistema:\n\n● `crontab -e` : edita tareas programadas.\n  crontab -l  → lista tareas del usuario\n  crontab -r  → elimina todas las tareas\n  Formato: minuto hora dia mes dia_semana comando\n  0 2 * * * /script/backup.sh  → cada dia a las 2:00\n  30 1 * * 0 apt update && apt upgrade -y  → domingo 1:30\n  */15 * * * * comando  → cada 15 minutos\n\n● `at hora` : ejecuta comando una vez a una hora.\n  at 14:00\n  at> comando\n  at> Ctrl+D\n  atq  → cola de trabajos at\n  atrm NUM  → eliminar trabajo\n\n● `man comando` : manual del comando.\n  man ls  → manual detallado\n  man -k palabra  → busca en descripciones (equivalente a apropos)\n  Secciones: 1=usuario, 5=config, 8=admin\n\n● `alias nombre='comando'` : crea atajo.\n  alias ll='ls -la'\n  alias ..='cd ..'\n  unalias ll  → eliminar alias\n  (sin parametro: lista todos los alias)\n\n● `history` : historial de comandos.\n  !123  → ejecuta comando 123 del historial\n  !!  → ejecuta ultimo comando\n  history -c  → limpia historial\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-063",
        "front": "(SI — Linux / Comandos) ¿Que hacen `dd`, `ln`, `ln -s` y `locate`?",
        "back": "Comandos varios:\n\n● `dd if=origen of=destino` : copia byte a byte.\n  dd if=/dev/sda of=/dev/sdb  → clonar disco\n  dd if=/dev/sda of=backup.img bs=4M  → backup de disco\n  dd if=/dev/zero of=swapfile bs=1M count=1024  → crear archivo swap\n  dd if=disco.iso of=/dev/sdb bs=4M status=progress  → crear USB booteable\n\n● `ln archivo enlace` : crea enlace duro.\n  ln original.txt enlace.txt  → mismo inodo, mismo contenido\n  Si borras original, el enlace sigue teniendo los datos\n  Solo en el mismo sistema de archivos\n\n● `ln -s archivo enlace` : crea enlace simbolico (symlink).\n  ln -s /ruta/real/archivo acceso_directo\n  Similar a acceso directo en Windows\n  Si borras el original, el symlink queda roto\n  Puede cruzar sistemas de archivos\n\n● `locate patron` : busca archivos por nombre (base pre-indexada).\n  locate *.txt  → busca rapidamente\n  locate passwd  → encuentra /etc/passwd\n  sudo updatedb  → actualiza la base de datos de locate\n  (mas rapido que find pero no muestra archivos recien creados)\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-064",
        "front": "(SI — Linux / Comandos) ¿Que hacen `ufw`, `iptables`, `sort`, `uniq` y `echo`?",
        "back": "Firewall y utilidades de texto:\n\n● `sudo ufw enable` : activa firewall.\n  sudo ufw allow 22/tcp  → permite SSH\n  sudo ufw deny 21/tcp  → bloquea FTP\n  sudo ufw status verbose  → estado\n  sudo ufw default deny incoming  → denegar todo entrante\n\n● `sudo iptables -L` : lista reglas del firewall.\n  iptables -A INPUT -p tcp --dport 22 -j ACCEPT  → permitir SSH\n  iptables -A INPUT -j DROP  → denegar todo lo demas\n  iptables -P INPUT DROP  → politica por defecto\n  (ufw es frontend de iptables, mas facil)\n\n● `sort archivo` : ordena lineas alfabeticamente.\n  sort -n  → orden numerico\n  sort -r  → orden inverso\n  sort -u  → unico (elimina duplicados)\n\n● `uniq` : elimina lineas duplicadas CONSECUTIVAS.\n  uniq archivo  → solo duplicados adyacentes\n  sort archivo | uniq  → primero ordenar\n  uniq -c  → cuenta ocurrencias\n\n● `echo \"texto\"` : imprime texto en stdout.\n  echo $PATH  → valor de variable\n  echo \"texto\" > archivo.txt  → redirige a archivo\n  echo \"texto\" >> archivo.txt  → añade al final\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-065",
        "front": "(SI — Linux / Comandos) ¿Que hacen `gcc`, `make` y `git` en el contexto de SI?",
        "back": "Compilacion y control de versiones:\n\n● `gcc archivo.c -o programa` : compila codigo C.\n  gcc hola.c -o hola  → genera ejecutable \"hola\"\n  gcc -Wall -o prog prog.c  → con advertencias (-Wall)\n  gcc -c archivo.c  → solo compila sin enlazar (.o)\n  gcc -o salida archivo1.o archivo2.o  → enlaza objetos\n\n● `make` : automatiza compilacion (usa Makefile).\n  make  → compila segun reglas del Makefile\n  make clean  → limpia archivos generados\n  make install  → instala el programa\n\n● `git` : control de versiones.\n  git init  → iniciar repositorio\n  git add .  → añadir cambios al stage\n  git commit -m \"mensaje\"  → confirmar cambios\n  git clone URL  → clonar repositorio\n  git push  → subir cambios\n  git pull  → traer cambios\n  git status  → estado del repositorio\n  git log  → historial de commits\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-066",
        "front": "(SI — Linux / Comandos) ¿Que hacen `su`, `sudo`, `umask`, `id` y `whoami`?",
        "back": "Identidad y permisos de usuario:\n\n● `su usuario` : Switch User, cambia de usuario.\n  su  → a root (pide contrasena root)\n  su -  → login shell (carga entorno del destino)\n  su - usuario  → cambia a ese usuario con su entorno\n\n● `sudo comando` : ejecuta comando como superusuario.\n  sudo -i  → shell como root\n  sudo -u usuario comando  → ejecuta como otro usuario\n  sudo -l  → lista que comandos puede ejecutar el usuario\n  Config: /etc/sudoers (editar con visudo)\n  El usuario debe estar en grupo sudo (Ubuntu) o wheel (RHEL)\n\n● `umask 022` : establece permisos por defecto para nuevos archivos.\n  umask 022 → archivos: 644 (rw-r--r--), directorios: 755 (rwxr-xr-x)\n  umask 077 → archivos: 600, directorios: 700 (solo propietario)\n  Permiso final = 666 - umask (archivos), 777 - umask (directorios)\n\n● `id usuario` : muestra UID, GID y grupos del usuario.\n  id -u  → solo UID\n  id -g  → solo GID principal\n  id -G  → todos los GID\n\n● `whoami` : muestra el nombre del usuario actual.\n  (equivalente a: id -un)\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-067",
        "front": "(SI — Linux / Comandos) ¿Que hacen `dd` para crear swap, `swapon`, `free` y `lsblk -f`?",
        "back": "Swap y memoria:\n\n● Crear archivo swap:\n  sudo dd if=/dev/zero of=/swapfile bs=1M count=2048\n  sudo chmod 600 /swapfile\n  sudo mkswap /swapfile  → formatear como swap\n  sudo swapon /swapfile  → activar swap\n\n● `swapon -s` o `swapon --show` : muestra swaps activos.\n  sudo swapoff /swapfile  → desactivar swap\n\n● `free -h` : muestra memoria RAM y swap.\n  free -m  → en MB\n  free -g  → en GB\n  free -h  → formato legible\n  Muestra: total, used, free, shared, buff/cache, available\n\n● `lsblk -f` : lista discos con sistema de archivos, UUID y punto de montaje.\n  lsblk -o NAME,SIZE,TYPE,FSTYPE,UUID,MOUNTPOINT\n\nPara que swap sea permanente:\n  Añadir linea en /etc/fstab:\n  /swapfile none swap sw 0 0\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-068",
        "front": "(SI — Linux / Comandos) Explica los operadores de redireccion y tuberias en Linux: `>`, `>>`, `<`, `|`, `2>`.",
        "back": "Redireccion y pipes:\n\n● `>` : redirige stdout a archivo (sobrescribe).\n  ls > listado.txt  → guarda salida en archivo\n\n● `>>` : redirige stdout a archivo (añade al final).\n  echo \"nueva linea\" >> log.txt\n\n● `<` : redirige archivo a stdin del comando.\n  sort < desordenado.txt  → ordena leyendo del archivo\n  mail -s \"asunto\" usuario@ejemplo.com < mensaje.txt\n\n● `2>` : redirige stderr a archivo.\n  gcc programa.c 2> errores.txt  → solo errores\n  2>&1  → redirige stderr a stdout\n  comando > salida.txt 2>&1  → stdout y stderr al mismo archivo\n  &> archivo  → atajo bash: stdout+stderr\n\n● `|` (pipe) : pasa stdout de un comando al stdin del siguiente.\n  ls -la | grep \"txt\"\n  ps aux | grep apache\n  dmesg | tail -20\n  cat /var/log/syslog | grep error | head -10\n  sort archivo | uniq -c | sort -rn  → contar y ordenar\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-069",
        "front": "(SI — Linux / Comandos) ¿Que hacen `testparm`, `smbpasswd`, `exportfs`, `showmount` y `slappasswd`?",
        "back": "Comandos de servicios:\n\n● `testparm` : verifica la sintaxis de /etc/samba/smb.conf.\n  testparm -v  → muestra config completa\n  testparm -s  → solo errores, sin preguntar\n\n● `smbpasswd -a usuario` : añade/ Cambia contrasena Samba.\n  smbpasswd usuario@DOMINIO\n  smbpasswd -x usuario  → elimina usuario Samba\n  smbpasswd -d usuario  → desactiva cuenta Samba\n  smbpasswd -e usuario  → reactiva\n\n● `exportfs -v` : muestra recursos NFS exportados.\n  sudo exportfs -r  → recarga /etc/exports\n  sudo exportfs -a  → exporta todos\n\n● `showmount -e IP` : muestra recursos NFS disponibles en un servidor.\n  showmount -d IP  → directorios exportados\n  showmount -a IP  → clientes y directorios\n\n● `slappasswd` : genera hash de contrasena para LDAP.\n  slappasswd -s miPassword  → genera {SSHA}hash...\n  (solicita contrasena interactivamente si no se pasa -s)\n\n---",
        "tags": ["si", "comandos", "linux"],
        "difficulty": "medium"
    },
]

# Add all new cards
data['cards'].extend(new_cards)
print(f'Added {len(new_cards)} cards. Total: {len(data["cards"])}')

# Verify JSON validity
import json as j
j.dumps(data)

# Save
with open(path, 'w', encoding='utf-8') as f:
    j.dump(data, f, ensure_ascii=False, indent=2)

print('Saved successfully!')
