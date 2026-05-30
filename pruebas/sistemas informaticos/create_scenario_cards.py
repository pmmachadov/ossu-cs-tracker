import json

path = r'C:\Users\Pablo\Desktop\Pablo\anki-cards-completo\public\data\preguntas-directas\pd-all.json'
with open(path, encoding='utf-8') as f:
    data = json.load(f)

new_cards = [
    {
        "id": "pd-si-082",
        "front": "(SI — Linux / Practico) Tienes que crear un directorio compartido para el grupo `profesores` en `/srv/compartido/profes`.\n\n1. Crea el directorio\n2. Asigna grupo propietario `profesores`\n3. Permisos 770\n4. SGID para que nuevos archivos hereden el grupo",
        "back": "Paso a paso:\n\n1. Crear directorio:\n   sudo mkdir -p /srv/compartido/profes\n\n2. Asignar grupo propietario:\n   sudo chown :profesores /srv/compartido/profes\n   (dejar usuario root, cambiar solo grupo)\n\n3. Permisos 770 (rwx para usuario y grupo, nada para otros):\n   sudo chmod 770 /srv/compartido/profes\n\n4. SGID (nuevos archivos heredan grupo):\n   sudo chmod g+s /srv/compartido/profes\n   Resultado: drwxrws---\n\nVerificar:\n   ls -la /srv/compartido/\n   drwxrws--- 2 root profesores 4096 ... profes\n\nAlternativa en un solo comando:\n   sudo install -d -o root -g profesores -m 2770 /srv/compartido/profes\n   2770 = setGID(2) + rwx(7) + rwx(7) + ---(0)\n\n---",
        "tags": ["si", "permisos", "practico", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-083",
        "front": "(SI — Linux / Practico) Disco /dev/sdb de 5GB. Crea una particion primaria de 5GB, formateala como ext4, montala en /mnt/datos, y asigna permisos 755 al punto de montaje.",
        "back": "Paso a paso:\n\n1. Crear particion unica con fdisk:\n   sudo fdisk /dev/sdb\n   n → new partition\n   p → primary\n   1 → numero de particion\n   Enter (inicio default)\n   Enter (fin default, todo el disco)\n   w → write & exit\n\n2. Formatear como ext4:\n   sudo mkfs.ext4 /dev/sdb1\n\n3. Crear punto de montaje:\n   sudo mkdir /mnt/datos\n\n4. Montar:\n   sudo mount /dev/sdb1 /mnt/datos\n\n5. Asignar permisos 755:\n   sudo chmod 755 /mnt/datos\n\n6. Verificar:\n   lsblk -f  → UUID y punto de montaje\n   df -h | grep /mnt/datos\n   ls -la /mnt/  → permisos del mount point\n\n7. Montaje permanente en /etc/fstab:\n   echo \"UUID=$(sudo blkid -s UUID -o value /dev/sdb1) /mnt/datos ext4 defaults 0 2\" | sudo tee -a /etc/fstab\n   sudo mount -a  → prueba fstab\n\n---",
        "tags": ["si", "particiones", "practico", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-084",
        "front": "(SI — Linux / Practico) Crea un usuario `invitado` con:\n\n1. Home en /home/invitado\n2. Grupo primario `invitados`\n3. Sin shell interactivo\n4. Home con permisos 700\n5. Cuota soft 100MB, hard 150MB",
        "back": "Paso a paso:\n\n1. Crear grupo:\n   sudo groupadd invitados\n\n2. Crear usuario:\n   sudo useradd -m -d /home/invitado -g invitados -s /usr/sbin/nologin invitado\n   (-m crear home, -d home path, -g grupo primario, -s shell)\n\n3. Asignar contrasena:\n   sudo passwd invitado\n\n4. Permisos 700 en home:\n   sudo chmod 700 /home/invitado\n\n5. Verificar permisos:\n   ls -la /home/ | grep invitado\n   drwx------ 2 invitado invitados 4096 ... invitado\n\n6. Cuotas (si estan activadas en /home):\n   sudo setquota -u invitado 100M 150M 0 0 /home\n\n7. Ver cuota:\n   sudo quota -u invitado\n   Disk quotas for user invitado (uid X):\n     Filesystem  blocks  quota  limit  grace\n     /dev/sdb1      20   102400 153600\n\nComprobar que no puede hacer login:\n   sudo -u invitado bash  → This account is currently not available.\n\n---",
        "tags": ["si", "usuarios", "practico", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-085",
        "front": "(SI — Linux / Practico) Tienes 3 usuarios: ana, bob, carla. Necesitas:\n\n1. Crear un grupo `proyecto`\n2. A los 3 al grupo `proyecto`\n3. Crear /srv/proyecto/ con permisos 2770\n4. Sticky bit en /srv/proyecto/temp\n5. Verificar todo",
        "back": "Paso a paso:\n\n1. Crear usuarios:\n   sudo useradd -m ana\n   sudo useradd -m bob\n   sudo useradd -m carla\n   sudo passwd ana (lo mismo para bob, carla)\n\n2. Crear grupo:\n   sudo groupadd proyecto\n\n3. Anadir usuarios al grupo:\n   sudo usermod -aG proyecto ana\n   sudo usermod -aG proyecto bob\n   sudo usermod -aG proyecto carla\n\n4. Crear directorio compartido:\n   sudo mkdir -p /srv/proyecto\n\n5. Asignar grupo y permisos:\n   sudo chown :proyecto /srv/proyecto\n   sudo chmod 2770 /srv/proyecto\n   (2=SGID, 770=rwx para user y grupo, nada para otros)\n\n6. Crear subdirectorio temp con sticky bit:\n   sudo mkdir /srv/proyecto/temp\n   sudo chmod 1770 /srv/proyecto/temp\n   (1=Sticky, 770=rwx grupo)\n\n7. Verificar:\n   ls -la /srv/\n   drwxrws--- 2 root proyecto 4096 ... proyecto\n   ls -la /srv/proyecto/\n   drwxrwxr-t 2 root proyecto 4096 ... temp\n\nProbar:\n   sudo -u ana touch /srv/proyecto/temp/ana.txt  → ok\n   sudo -u bob rm /srv/proyecto/temp/ana.txt  → ERROR (sticky bit)\n   Solo ana puede borrar su archivo\n\n---",
        "tags": ["si", "usuarios", "permisos", "practico", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-086",
        "front": "(SI — Linux / Practico) Disco /dev/sdc de 2GB. Crear:\n\n1. Particion swap de 512MB\n2. Particion ext4 con el resto\n3. Activar swap (permanente)\n4. Montar ext4 en /mnt/backups con permisos 700\n5. fstab para ambos",
        "back": "Paso a paso:\n\n1. Particionar con fdisk:\n   sudo fdisk /dev/sdc\n   n → p → 1 → Enter → +512M  (particion swap)\n   n → p → 2 → Enter → Enter  (resto del disco, ext4)\n   t → 1 → 82  (cambiar tipo a Linux swap)\n   w\n\n2. Formatear:\n   sudo mkfs.ext4 /dev/sdc2\n   sudo mkswap /dev/sdc1\n\n3. Activar swap:\n   sudo swapon /dev/sdc1\n   sudo swapon --show  → verificar\n\n4. Montar ext4:\n   sudo mkdir -p /mnt/backups\n   sudo mount /dev/sdc2 /mnt/backups\n   sudo chmod 700 /mnt/backups\n\n5. /etc/fstab (montaje permanente):\n   Obtener UUIDs:\n     sudo blkid /dev/sdc1 /dev/sdc2\n   Anadir:\n     UUID=xxx none swap sw 0 0\n     UUID=yyy /mnt/backups ext4 defaults 0 2\n\n6. Probar fstab:\n   sudo umount /mnt/backups\n   sudo swapoff /dev/sdc1\n   sudo mount -a\n   sudo swapon -a\n   sudo swapon --show\n\n---",
        "tags": ["si", "particiones", "swap", "practico", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-087",
        "front": "(SI — Linux / Practico) Crear un usuario `admin` que pueda ejecutar sudo SIN contrasena solo para:\n\n1. systemctl restart vsftpd\n2. systemctl status vsftpd\n3. systemctl restart sshd\n\nConfigura el sudoers correctamente.",
        "back": "Paso a paso:\n\n1. Crear usuario:\n   sudo useradd -m -s /bin/bash admin\n   sudo passwd admin\n\n2. Editar sudoers con visudo:\n   sudo visudo -f /etc/sudoers.d/admin\n   (usar archivo separado en /etc/sudoers.d/ para no tocar el principal)\n\n3. Anadir la linea:\n   admin ALL=(ALL) NOPASSWD: /usr/bin/systemctl restart vsftpd, /usr/bin/systemctl status vsftpd, /usr/bin/systemctl restart sshd\n\n   O usar alias mas limpio:\n   Cmnd_Alias VSFTPD = /usr/bin/systemctl restart vsftpd, /usr/bin/systemctl status vsftpd\n   Cmnd_Alias SSHD = /usr/bin/systemctl restart sshd\n   admin ALL=(ALL) NOPASSWD: VSFTPD, SSHD\n\n4. Verificar config:\n   sudo -l -U admin  → lista comandos permitidos\n   User admin may run the following commands on this host:\n     (ALL) NOPASSWD: /usr/bin/systemctl restart vsftpd\n     (ALL) NOPASSWD: /usr/bin/systemctl status vsftpd\n     (ALL) NOPASSWD: /usr/bin/systemctl restart sshd\n\n5. Probar:\n   sudo -u admin sudo systemctl status vsftpd  → no pide clave\n   sudo -u admin sudo systemctl restart vsftpd  → ok\n   sudo -u admin sudo apt update  → DENIED (no autorizado)\n\n---",
        "tags": ["si", "usuarios", "sudo", "practico", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-088",
        "front": "(SI — Linux / Practico) Samba: comparte la carpeta /srv/compartida para el grupo `empleados` con:\n\n1. Crear grupo y usuarios\n2. Anadir a Samba (smbpasswd)\n3. Configurar smb.conf (permisos de lectura/escritura solo para el grupo)\n4. Asignar permisos Linux correctos",
        "back": "Paso a paso:\n\n1. Crear grupo y usuarios:\n   sudo groupadd empleados\n   sudo useradd -m -G empleados ana\n   sudo useradd -m -G empleados bob\n   sudo passwd ana\n   sudo passwd bob\n\n2. Anadir usuarios a Samba:\n   sudo smbpasswd -a ana  (pide contrasena Samba)\n   sudo smbpasswd -a bob\n\n3. Crear y configurar directorio:\n   sudo mkdir -p /srv/compartida\n   sudo chown :empleados /srv/compartida\n   sudo chmod 2770 /srv/compartida\n   (SGID + grupo con rwx, otros sin acceso)\n\n4. Configurar /etc/samba/smb.conf:\n   [compartida]\n      comment = Carpeta compartida empleados\n      path = /srv/compartida\n      browseable = yes\n      read only = no\n      valid users = @empleados\n      create mask = 0770\n      directory mask = 0770\n      force group = empleados\n\n5. Verificar config:\n   testparm\n\n6. Reiniciar Samba:\n   sudo systemctl restart smbd\n   sudo systemctl restart nmbd\n\n7. Verificar desde Windows:\n   \\\\IP-DEL-SERVIDOR\\compartida\n\n---",
        "tags": ["si", "samba", "usuarios", "permisos", "practico"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-089",
        "front": "(SI — Linux / Practico) Tienes /dev/sdb con 3 particiones. Configura /etc/fstab para:\n\n1. /dev/sdb1 ext4 → /mnt/datos  RW\n2. /dev/sdb2 ntfs → /mnt/windatos  RO\n3. /dev/sdb3 swap → swap\n\nUsa UUID en lugar de /dev/sdbX.",
        "back": "Paso a paso:\n\n1. Obtener UUIDs:\n   sudo blkid\n   /dev/sdb1: UUID=\"aaa...\" TYPE=\"ext4\"\n   /dev/sdb2: UUID=\"bbb...\" TYPE=\"ntfs\"\n   /dev/sdb3: UUID=\"ccc...\" TYPE=\"swap\"\n\n2. Crear puntos de montaje:\n   sudo mkdir -p /mnt/datos /mnt/windatos\n\n3. Anadir a /etc/fstab (sudo nano /etc/fstab):\n   # Particiones /dev/sdb\n   UUID=aaa /mnt/datos ext4 defaults 0 2\n   UUID=bbb /mnt/windatos ntfs ro,uid=1000,gid=1000,umask=022 0 0\n   UUID=ccc none swap sw 0 0\n\nExplicacion de opciones:\n  ● defaults = rw, suid, dev, exec, auto, nouser, async\n  ● ro = solo lectura\n  ● uid/gid = forzar propietario (ntfs no tiene permisos Linux)\n  ● umask = mascara de permisos en ntfs (022=644)\n  ● 0 2 -> dump(0=no backup) pass(2=check despues de raiz)\n  ● swap no necesita punto de montaje (none)\n\n4. Probar fstab:\n   sudo mount -a  (monta todo)\n   sudo swapon -a  (activa swaps)\n\n5. Verificar:\n   df -h | grep /mnt\n   mount | grep sdb\n   swapon --show\n\n---",
        "tags": ["si", "particiones", "fstab", "practico", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-090",
        "front": "(SI — Linux / Practico) Crea un script de backup que:\n\n1. Comprima /home en /backups/home_YYYYMMDD.tar.gz\n2. Solo conserve backups de los ultimos 7 dias\n3. Se ejecute cada dia a las 2am con cron\n4. Permisos 600 en los backups\n5. Registre en log cada ejecucion",
        "back": "1. Crear script /usr/local/bin/backup.sh:\n   #!/bin/bash\n   BACKUP_DIR=\"/backups\"\n   DATE=$(date +%Y%m%d)\n   FILENAME=\"home_$DATE.tar.gz\"\n   LOG=\"/var/log/backup.log\"\n\n   mkdir -p \"$BACKUP_DIR\"\n\n   # Comprimir /home\n   tar -czf \"$BACKUP_DIR/$FILENAME\" /home\n\n   # Permisos 600 en el backup\n   chmod 600 \"$BACKUP_DIR/$FILENAME\"\n\n   # Eliminar backups mas antiguos de 7 dias\n   find \"$BACKUP_DIR\" -name \"home_*.tar.gz\" -mtime +7 -delete\n\n   # Log\n   echo \"$(date): Backup $FILENAME creado\" >> \"$LOG\"\n\n2. Dar permisos de ejecucion:\n   sudo chmod 700 /usr/local/bin/backup.sh\n\n3. Probar:\n   sudo /usr/local/bin/backup.sh\n\n4. Programar en cron (sudo crontab -e):\n   0 2 * * * /usr/local/bin/backup.sh\n   (minuto 0, hora 2, cada dia, cada mes, cada dia de semana)\n\n5. Verificar:\n   sudo crontab -l\n   ls -la /backups/\n   cat /var/log/backup.log\n\nNota: /backups debe tener espacio suficiente.\nUsar df -h /backups para verificar.\n\n---",
        "tags": ["si", "backup", "cron", "practico", "linux"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-091",
        "front": "(SI — Linux / Practico) LVM: Tienes /dev/sdb (2GB) y /dev/sdc (2GB).\n\n1. Crear Volumen Fisico (PV) en ambos\n2. Crear Grupo de Volumenes (VG) \"vg_datos\"\n3. Crear Volumen Logico (LV) \"lv_proyecto\" de 3GB\n4. Formatear como ext4\n5. Montar en /mnt/proyecto\n6. Extender el LV a 3.5GB",
        "back": "Paso a paso:\n\n1. Crear Particiones (si no existen):\n   sudo fdisk /dev/sdb  → n → p → 1 → Enter → Enter → t → 8e → w\n   (tipo 8e = Linux LVM)\n   Lo mismo para /dev/sdc\n\n2. Crear Volumenes Fisicos:\n   sudo pvcreate /dev/sdb1 /dev/sdc1\n   sudo pvs  → ver PVs\n\n3. Crear Grupo de Volumenes:\n   sudo vgcreate vg_datos /dev/sdb1 /dev/sdc1\n   sudo vgs  → ver VGs\n   sudo vgdisplay vg_datos\n\n4. Crear Volumen Logico:\n   sudo lvcreate -n lv_proyecto -L 3G vg_datos\n   sudo lvs  → ver LVs\n\n5. Formatear y montar:\n   sudo mkfs.ext4 /dev/vg_datos/lv_proyecto\n   sudo mkdir /mnt/proyecto\n   sudo mount /dev/vg_datos/lv_proyecto /mnt/proyecto\n\n6. Extender LV:\n   sudo lvextend -L +500M /dev/vg_datos/lv_proyecto\n   (o -L 3.5G para tamaño absoluto)\n   sudo resize2fs /dev/vg_datos/lv_proyecto\n   (redimensiona el sistema de archivos)\n\n7. Verificar:\n   df -h | grep proyecto\n   lvs\n   lsblk\n\n8. /etc/fstab para montaje automatico:\n   /dev/vg_datos/lv_proyecto /mnt/proyecto ext4 defaults 0 2\n\n---",
        "tags": ["si", "lvm", "particiones", "practico", "linux"],
        "difficulty": "medium"
    },
]

data['cards'].extend(new_cards)
print(f'Added {len(new_cards)} cards. Total: {len(data["cards"])}')

import json as j
j.dumps(data)

with open(path, 'w', encoding='utf-8') as f:
    j.dump(data, f, ensure_ascii=False, indent=2)

print('Saved successfully!')
