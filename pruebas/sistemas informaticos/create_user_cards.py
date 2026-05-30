import json

path = r'C:\Users\Pablo\Desktop\Pablo\anki-cards-completo\public\data\preguntas-directas\pd-all.json'
with open(path, encoding='utf-8') as f:
    data = json.load(f)

new_cards = [
    {
        "id": "pd-si-070",
        "front": "(SI — Linux / Usuarios) ¿Cual es la diferencia entre `adduser` y `useradd`? ¿Cual se recomienda y por que?",
        "back": "● `adduser` : script interactivo (Debian/Ubuntu).\n  Crea usuario + grupo + home + copia /etc/skel.\n  Pide contrasena interactivamente.\n  Mas amigable, recomendado para uso manual.\n  Ej: sudo adduser juan\n\n● `useradd` : comando de bajo nivel (estandar UNIX).\n  No crea home a menos que se use -m.\n  No asigna contrasena.\n  Mas adecuado para scripts.\n  Ej: sudo useradd -m -s /bin/bash -G sudo juan\n  sudo passwd juan  → necesario para asignar contrasena\n\nDiferencia clave:\n  adduser = automatiza todo (recomendado para interactivo)\n  useradd = manual, control total (recomendado para scripts)\n\nArchivos de configuracion:\n  /etc/default/useradd  → valores por defecto\n  /etc/login.defs  → rangos UID/GID, max dias contrasena\n  /etc/skel/  → archivos copiados al home al crear usuario\n\n---",
        "tags": ["si", "usuarios", "linux", "comandos"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-071",
        "front": "(SI — Linux / Usuarios) ¿Que es un usuario del sistema (system user)? ¿Como se crea y para que sirve?",
        "back": "Usuario del sistema: cuenta no humana, usada por servicios/demonios.\n\nCaracteristicas:\n  ● UID < 1000 (tipicamente 1-999)\n  ● No tiene contrasena (/etc/shadow muestra !! o *)\n  ● No tiene shell interactivo (/sbin/nologin o /usr/sbin/nologin)\n  ● No tiene home, o tiene home en /var/lib/servicio\n\nEjemplos de system users:\n  ● www-data → servicio Apache/Nginx\n  ● mysql → MySQL/MariaDB\n  ● postfix → servidor de correo\n  ● nobody → usuario minimo para servicios anonimos\n  ● sshd → OpenSSH server\n  ● systemd-resolve → resolucion DNS\n\nCrear usuario del sistema:\n  sudo useradd --system --no-create-home --shell /usr/sbin/nologin mi-servicio\n  sudo adduser --system --no-create-home --group mi-servicio\n\nVer system users:\n  cat /etc/passwd | awk -F: '$3 < 1000 {print $1\":\"$3}'\n  getent passwd | awk -F: '$3 < 1000'\n\n---",
        "tags": ["si", "usuarios", "linux", "comandos"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-072",
        "front": "(SI — Linux / Usuarios) ¿Que permisos debe tener el directorio home de un usuario? Explica la configuracion de /etc/skel.",
        "back": "Permisos del directorio home:\n  Por defecto: 755 (rwxr-xr-x) o 700 (rwx------)\n  Recomendado: 750 (rwxr-x---) si hay grupo compartido\n  ● 700 → solo el usuario puede entrar (privacidad total)\n  ● 750 → usuario y grupo pueden entrar\n  ● 755 → todos pueden entrar (no recomendado)\n\nPor que 700 es seguro:\n  Otros usuarios no pueden listar ni acceder a tus archivos.\n  Los servicios como Apache necesitan permisos 755 en ~/public_html\n\n/etc/skel/ (skeleton):\n  Directorio plantilla para nuevos usuarios.\n  Todo su contenido se copia al home al crear el usuario.\n  Contenido tipico:\n    .bashrc  → alias y configuracion de shell\n    .profile → variables de entorno\n    .bash_logout\n    .config/\n    Documentos/\n    plantillas/\n\nPersonalizar esqueleto:\n  sudo mkdir -p /etc/skel/Documentos\n  sudo chmod 755 /etc/skel/Documentos\n  echo \"alias ll='ls -la'\" | sudo tee -a /etc/skel/.bashrc\n\n---",
        "tags": ["si", "usuarios", "linux", "comandos"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-073",
        "front": "(SI — Linux / Permisos) Explica los permisos especiales: SUID, SGID y Sticky Bit. ¿Que hace cada uno y como se asignan?",
        "back": "Permisos especiales en Linux:\n\n1) SUID (Set User ID) - 4xxx en octal, s en lugar de x del usuario\n   ● El programa se ejecuta con los permisos del propietario, no del usuario.\n   ● Util para que usuarios normales ejecuten como root.\n   ● Ejemplo: /usr/bin/passwd (rwsr-xr-x, chmod 4755)\n   ● chmod u+s programa  o  chmod 4xxx programa\n   ● Seguridad: riesgo si se asigna a programas incorrectos.\n\n2) SGID (Set Group ID) - 2xxx en octal, s en lugar de x del grupo\n   ● En archivos: se ejecuta con permisos del grupo propietario.\n   ● En directorios: los nuevos archivos heredan el grupo del directorio.\n   ● Util para carpetas compartidas por equipos.\n   ● chmod g+s directorio  o  chmod 2xxx directorio\n\n3) Sticky Bit - 1xxx en octal, t en lugar de x de otros\n   ● Solo el propietario puede borrar/renombrar sus archivos.\n   ● Tipico en /tmp (drwxrwxrwt, chmod 1777)\n   ● chmod +t directorio  o  chmod 1xxx directorio\n\nRepresentacion:\n  rwsr-xr-x = SUID (4755)\n  rwxr-sr-x = SGID (2755)\n  rwxrwxrwt = Sticky (1777)\n  rwsr-sr-t = SUID+SGID+Sticky (7755)\n\n---",
        "tags": ["si", "permisos", "linux", "comandos"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-074",
        "front": "(SI — Linux / Usuarios) ¿Que es umask y como afecta a los permisos de archivos y directorios creados por un usuario? Ejemplos.",
        "back": "umask = mascara de permisos. Resta permisos del maximo posible.\n\nFormula:\n  Archivos: 666 - umask\n  Directorios: 777 - umask\n\nEjemplos:\n  umask 022 → archivos 644 (rw-r--r--), directorios 755 (rwxr-xr-x)\n  umask 077 → archivos 600 (rw-------), directorios 700 (rwx------)\n  umask 027 → archivos 640 (rw-r-----), directorios 750 (rwxr-x---)\n  umask 002 → archivos 664 (rw-rw-r--), directorios 775 (rwxrwxr-x)\n  umask 007 → archivos 660 (rw-rw----), directorios 770 (rwxrwx---)\n\nComo se usa:\n  umask 027  → cambia para la sesion actual\n  En /etc/profile o ~/.bashrc → persistente\n  En /etc/login.defs → UMASK 027 (global para todos)\n\nDiferencia con chmod:\n  ● umask = permisos por defecto (pre-creacion)\n  ● chmod = cambiar permisos (post-creacion)\n\nEjemplo practico:\n  umask 027\n  touch archivo.txt  → permisos 640\n  mkdir directorio  → permisos 750\n\n---",
        "tags": ["si", "permisos", "linux", "comandos"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-075",
        "front": "(SI — Linux / Usuarios) ¿Que son las cuotas de disco en Linux? Explica como configurarlas: soft limit, hard limit y grace period.",
        "back": "Cuotas de disco: limitan el espacio que un usuario/grupo puede usar.\n\nComponentes:\n  ● Soft limit: limite que avisa. Si se supera, empieza grace period.\n  ● Hard limit: maximo absoluto. No se puede superar.\n  ● Grace period: tiempo para bajar del soft limit antes de bloquear.\n\nPasos de configuracion:\n\n1. Instalar paquetes:\n   sudo apt install quota quotatool\n\n2. Activar cuotas en /etc/fstab:\n   /dev/sdb1 /home ext4 defaults,usrquota,grpquota 0 0\n\n3. Remontar particion:\n   sudo mount -o remount /home\n\n4. Crear archivos de cuotas:\n   sudo quotacheck -cum /home  → aquota.user y aquota.group\n   sudo quotaon /home  → activar cuotas\n\n5. Asignar cuotas a usuario:\n   sudo edquota -u usuario\n   sudo setquota -u usuario 500M 600M 0 0 /home\n   # Soft=500MB, Hard=600MB, inodos sin limite\n\n6. Ver cuotas:\n   quota -u usuario\n   repquota -a  → resumen de todos\n\n---",
        "tags": ["si", "usuarios", "linux", "discos"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-076",
        "front": "(SI — Linux / Usuarios) Explica los archivos del sistema de usuarios en Linux: /etc/passwd, /etc/shadow, /etc/group, /etc/gshadow. ¿Que contiene cada campo?",
        "back": "Archivos de gestion de usuarios:\n\n1) /etc/passwd : cuentas de usuario (lectura publica)\n  usuario:x:UID:GID:descripcion:/home/usuario:/bin/bash\n  Campos: nombre, contrasena (x=en shadow), UID, GID, info, home, shell\n  Shell /bin/false o /usr/sbin/nologin → sin login interactivo\n\n2) /etc/shadow : contrasenas cifradas (solo root)\n  usuario:$6$salt$hash:18988:0:99999:7:::\n  Campos: login, hash, ultimo cambio, min dias, max dias,\n          aviso, inactividad, expiracion, reservado\n  !! = cuenta bloqueada, * = sin login\n\n3) /etc/group : grupos del sistema\n  grupo:x:GID:usuario1,usuario2\n  Campos: nombre, contrasena, GID, miembros\n\n4) /etc/gshadow : contrasenas de grupo\n  grupo:!::usuario1,usuario2\n\nComandos relacionados:\n  vipw  → editar /etc/passwd (bloquea archivo)\n  vigr  → editar /etc/group\n  pwck  → verificar integridad /etc/passwd\n  grpck → verificar /etc/group\n  pwconv → sincroniza passwd con shadow\n\n---",
        "tags": ["si", "usuarios", "linux", "comandos"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-077",
        "front": "(SI — Linux / Usuarios) ¿Como se gestionan las politicas de contrasenas en Linux? Explica `passwd`, `chage` y los parametros en /etc/login.defs.",
        "back": "Gestion de contrasenas:\n\n● `passwd usuario` : cambia contrasena.\n  sudo passwd -l usuario  → bloquea cuenta\n  sudo passwd -u usuario  → desbloquea\n  sudo passwd -d usuario  → elimina contrasena\n  sudo passwd -S usuario  → estado de la cuenta\n  sudo passwd -e usuario  → fuerza cambio en proximo login\n\n● `chage` : (change age) vigencia de contrasena.\n  sudo chage -l usuario  → lista configuracion actual\n  sudo chage -M 90 usuario  → maximo 90 dias\n  sudo chage -m 7 usuario  → minimo 7 dias entre cambios\n  sudo chage -W 7 usuario  → aviso 7 dias antes de expirar\n  sudo chage -I 30 usuario  → inactividad 30 dias tras expirar\n  sudo chage -E 2026-12-31 usuario  → fecha de expiracion\n  sudo chage -d 0 usuario  → obliga cambio en proximo login\n\n● /etc/login.defs : valores globales.\n  PASS_MAX_DAYS  99999  → maximo dias\n  PASS_MIN_DAYS  0      → minimo dias\n  PASS_WARN_AGE  7      → aviso antes de expirar\n  UID_MIN 1000          → minimo UID para usuarios normales\n  UID_MAX 60000         → maximo UID\n  CREATE_HOME yes       → crear home automaticamente\n  USERGROUPS_ENAB yes   → crear grupo con mismo nombre\n\n---",
        "tags": ["si", "usuarios", "linux", "comandos"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-078",
        "front": "(SI — Linux / Usuarios) ¿Que son los grupos secundarios (supplementary groups) en Linux? ¿Como se asigna un usuario a varios grupos?",
        "back": "Cada usuario tiene:\n  ● 1 grupo primario (GID en /etc/passwd)\n  ● N grupos secundarios (supplementary groups)\n\nGrupo primario:\n  Archivos creados por el usuario heredan este grupo.\n  Se define al crear el usuario (-g grupo).\n  Por defecto: grupo con el mismo nombre que el usuario.\n\nGrupos secundarios:\n  Permiten acceder a recursos compartidos.\n  No afectan a archivos nuevos (heredan del primario).\n\nAsignar grupos:\n  ● Al crear usuario:\n    sudo useradd -m -G sudo,www-data,biblioteca juan\n    (-G = grupos secundarios)\n\n  ● Anadir a grupo existente:\n    sudo usermod -aG biblioteca juan\n    (-a = append, -G = grupos. Sin -a reemplaza todos!)\n\n  ● Quitar de grupo:\n    sudo gpasswd -d juan biblioteca\n    O editar /etc/group manualmente con vigr\n\n  ● Cambiar grupo primario:\n    sudo usermod -g grupo_primario juan\n\nVer grupos del usuario:\n  groups juan\n  id juan\n\nEjemplo practico:\n  sudo useradd -m profesor    # grupo primario = profesor\n  sudo usermod -aG sudo profesor\n  groups profesor  → profesor sudo\n\n---",
        "tags": ["si", "usuarios", "linux", "comandos"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-079",
        "front": "(SI — Linux / AD) ¿Como se crean usuarios y grupos en Active Directory de Windows Server? Explica los pasos para asignar permisos NTFS.",
        "back": "Usuarios y grupos en AD:\n\nCrear Unidad Organizativa (OU):\n  Active Directory Users and Computers (ADUC)\n  Boton derecho en dominio → New → Organizational Unit\n  Ej: OU=Profesores, OU=Alumnos\n\nCrear grupo:\n  Boton derecho en OU → New → Group\n  Nombre: Profesores\n  Ambito: Global (recomendado) / Universal / Domain Local\n  Tipo: Security (permisos) / Distribution (solo correo)\n\nCrear usuario:\n  Boton derecho en OU → New → User\n  Nombre, login, contrasena\n  Opciones: \"User must change password at next logon\"\n  Se crea con propiedades por defecto\n\nPermisos NTFS:\n  1. Boton derecho en carpeta → Properties → Security\n  2. Add → escribir grupo/usuario → Check Names\n  3. Asignar permisos:\n     Full Control, Modify, Read & Execute,\n     List Folder Contents, Read, Write\n  4. Avanzado → Change Permissions → Add\n     Apply onto: This folder, subfolders and files\n\nEquivalencias NTFS:\n  ● Full Control = chmod 777\n  ● Modify = chmod 666\n  ● Read & Execute = chmod 555\n  ● Read = chmod 444\n  ● Write = chmod 222\n\n---",
        "tags": ["si", "usuarios", "windows", "ad"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-080",
        "front": "(SI — Linux / Usuarios) Explica el comando `sudo` en detalle: como configurar /etc/sudoers, grupos sudo vs wheel, y alias.",
        "back": "sudo: ejecuta comandos como otro usuario (normalmente root).\n\nConfiguracion: /etc/sudoers (EDITAR SIEMPRE CON visudo)\n\nEstructura:\n  usuario HOST=(USUARIO:GRUPO) TAG: COMANDOS\n\nEjemplos:\n  # Usuario puede ejecutar cualquier comando\n  juan ALL=(ALL:ALL) ALL\n\n  # Grupo sudo puede todo (Ubuntu)\n  %sudo ALL=(ALL:ALL) ALL\n\n  # Grupo wheel puede todo (RHEL)\n  %wheel ALL=(ALL:ALL) NOPASSWD: ALL\n\n  # Usuario solo puede gestionar servicios\n  juan ALL=(ALL) /usr/bin/systemctl restart *, /usr/bin/systemctl status *\n\n  # Sin contrasena para comandos especificos\n  juan ALL=(ALL) NOPASSWD: /usr/bin/apt update\n\nGrupos especiales:\n  ● sudo (Ubuntu/Debian) → acceso root via sudo\n  ● wheel (RHEL/CentOS) → acceso root via sudo\n\nDirectivas:\n  Defaults env_reset  → limpia entorno por seguridad\n  Defaults mail_badpass  → avisa si contrasena incorrecta\n  Defaults passwd_tries=3  → intentos de contrasena\n\nAlias en sudoers:\n  Cmnd_Alias SERVICES = /usr/bin/systemctl *, /usr/bin/journalctl *\n  User_Alias ADMINS = juan, maria, pedro\n  ADMINS ALL=(ALL) SERVICES\n\n---",
        "tags": ["si", "usuarios", "linux", "comandos"],
        "difficulty": "medium"
    },
    {
        "id": "pd-si-081",
        "front": "(SI — Linux / Usuarios) ¿Que son los perfiles moviles (roaming profiles) y las carpetas personales (home folders) en un entorno de red con Samba/AD?",
        "back": "En un dominio, los usuarios pueden tener su perfil y datos en el servidor.\n\nPerfil movil (Roaming Profile):\n  ● Configuracion del escritorio viaja con el usuario.\n  ● Al iniciar sesion en cualquier PC, se descarga su perfil.\n  ● Al cerrar sesion, se guarda en el servidor.\n  ● Config en AD: perfil de usuario → Profile path\n  Ej: \\\\servidor\\perfiles$\\%USERNAME%\n  La $ oculta el recurso compartido.\n  Desventaja: mayor tiempo de inicio si el perfil pesa mucho.\n\nCarpeta personal (Home Folder / Home Directory):\n  ● Disco personal del usuario en el servidor.\n  ● Se asigna como unidad de red (Z:).\n  ● Config en AD: perfil de usuario → Home folder\n  Ej: \\\\servidor\\hogar$\\%USERNAME% como unidad Z:\n\nEn Samba (Linux como DC):\n  [profiles]\n    path = /var/lib/samba/profiles\n    read only = No\n    profile acls = Yes\n\n  [homes]\n    comment = Home Directories\n    browseable = No\n    read only = No\n    valid users = %S\n\n---",
        "tags": ["si", "usuarios", "samba", "ad"],
        "difficulty": "medium"
    },
]

# Add all new cards
data['cards'].extend(new_cards)
print(f'Added {len(new_cards)} cards. Total: {len(data["cards"])}')

import json as j
j.dumps(data)  # verify

with open(path, 'w', encoding='utf-8') as f:
    j.dump(data, f, ensure_ascii=False, indent=2)

print('Saved successfully!')
