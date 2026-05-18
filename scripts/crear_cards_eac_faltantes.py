import json

with open('public/data/preguntas-directas/pd-all.json', 'r', encoding='utf-8') as f:
    data = json.load(f)

existing_ids = {c['id'] for c in data['cards']}
max_si = max(int(c['id'].split('-')[-1]) for c in data['cards'] if c['id'].startswith('pd-si-'))
max_ed = max(int(c['id'].split('-')[-1]) for c in data['cards'] if c['id'].startswith('pd-ed-'))

new_cards = []

# ========== SI EAC1 — A2a: Protocolo an\u00e1lisis lentitud ==========
new_cards.append({
    "id": f"pd-si-{max_si+1:03d}",
    "front": "(SI \u2014 EAC1 / Diagn\u00f3stico) Un equipo va lento tras instalar varias aplicaciones.\n\n"
             "Describe un **protocolo de an\u00e1lisis** paso a paso para determinar\n"
             "si el problema es de software, falta de recursos o configuraci\u00f3n.\n\n"
             "Prop\u00f3n medidas preventivas.",
    "back": "**Protocolo de an\u00e1lisis:**\n\n"
            "1. Comparar estado actual con anterior: desde cu\u00e1ndo empez\u00f3 la lentitud,\n"
            "   qu\u00e9 programas se instalaron, si ocurre siempre o solo en ciertas tareas.\n\n"
            "2. Revisar consumo de CPU, RAM, disco y red con el administrador de tareas.\n"
            "   Si la RAM est\u00e1 casi llena o el disco al 100%, puede ser falta de recursos.\n\n"
            "3. Comprobar programas de inicio y servicios en segundo plano.\n"
            "   Utilidades residentes, antivirus duplicados o sincronizadores pueden ralentizar.\n\n"
            "4. Revisar espacio libre en disco, errores del sistema, actualizaciones pendientes\n"
            "   y posibles conflictos de controladores.\n\n"
            "5. Arrancar en modo seguro o hacer inicio limpio para separar\n"
            "   si el problema es de software instalado o de configuraci\u00f3n.\n\n"
            "**Medidas preventivas:**\n"
            "- Instalar solo software necesario\n"
            "- Mantener actualizado el sistema\n"
            "- Controlar arranque autom\u00e1tico\n"
            "- Dejar espacio libre en disco\n"
            "- Crear puntos de restauraci\u00f3n antes de cambios importantes",
    "tags": ["si", "eac1", "diagnostico", "rendimiento"],
    "difficulty": "medium"
})

# ========== SI EAC3 — A1: Configurar red con ip command ==========
new_cards.append({
    "id": f"pd-si-{max_si+2:03d}",
    "front": "(SI \u2014 EAC3 / Red) Configura la red de Ubuntu de forma **temporal**\n"
             "(se pierde al reiniciar) usando el comando `ip`:\n\n"
             "a) Asigna IP est\u00e1tica\n"
             "b) Configura m\u00e1scara de red\n"
             "c) Define puerta de enlace\n"
             "d) Configura DNS\n"
             "e) Comprueba conectividad con ping a IP y nombre",
    "back": "```bash\n"
            "# Configurar interfaz como bridge y asignar IP/m\u00e1scara\n"
            "sudo ip link set eth0 up\n"
            "sudo ip addr add 192.168.1.100/24 dev eth0\n\n"
            "# Definir puerta de enlace\n"
            "sudo ip route add default via 192.168.1.1\n\n"
            "# Configurar DNS (temporal, en /etc/resolv.conf)\n"
            "echo \"nameserver 8.8.8.8\" | sudo tee /etc/resolv.conf\n"
            "echo \"nameserver 1.1.1.1\" | sudo tee -a /etc/resolv.conf\n\n"
            "# Comprobar configuraci\u00f3n\n"
            "ip addr show eth0\n"
            "ip route show\n\n"
            "# Verificar conectividad\n"
            "ping -c 4 192.168.1.1     # Gateway\n"
            "ping -c 4 8.8.8.8          # DNS externo\n"
            "ping -c 4 google.com       # Resoluci\u00f3n DNS\n"
            "```\n\n"
            "**Nota:** La configuraci\u00f3n con `ip` es **temporal**.\n"
            "Para hacerla permanente usa **Netplan** (`/etc/netplan/01-netcfg.yaml`).",
    "tags": ["si", "eac3", "red", "ip", "temporal"],
    "difficulty": "medium"
})

# ========== SI EAC3 — A2: Configurar red Windows ==========
new_cards.append({
    "id": f"pd-si-{max_si+3:03d}",
    "front": "(SI \u2014 EAC3 / Red Windows) Configura la red en Windows 11\n"
             "de forma est\u00e1tica:\n\n"
             "a) Asigna IP est\u00e1tica, m\u00e1scara y puerta de enlace\n"
             "b) Configura servidor DNS\n"
             "c) Comprueba conectividad\n"
             "d) Comando para consultar configuraci\u00f3n desde l\u00ednea de comandos",
    "back": "**Configurar IP est\u00e1tica en Windows 11:**\n\n"
            "1. Panel de Control > Centro de redes y recursos compartidos\n"
            "   > Cambiar configuraci\u00f3n del adaptador\n\n"
            "2. Click derecho en el adaptador > Propiedades\n"
            "   > Seleccionar \"Protocolo de Internet versi\u00f3n 4 (TCP/IPv4)\" > Propiedades\n\n"
            "3. Marcar \"Usar la siguiente direcci\u00f3n IP\":\n"
            "   - IP: 192.168.1.100\n"
            "   - M\u00e1scara: 255.255.255.0\n"
            "   - Puerta de enlace: 192.168.1.1\n\n"
            "4. DNS: 8.8.8.8 y 1.1.1.1\n\n"
            "**Comandos de verificaci\u00f3n:**\n\n"
            "```powershell\n"
            "# Ver configuraci\u00f3n actual\n"
            "ipconfig /all\n\n"
            "# Probar conectividad\n"
            "ping 192.168.1.1\n"
            "ping 8.8.8.8\n"
            "ping google.com\n"
            "```",
    "tags": ["si", "eac3", "red", "windows", "ip-estatica"],
    "difficulty": "easy"
})

# ========== SI EAC3 — A4: netstat y vsftpd ==========
new_cards.append({
    "id": f"pd-si-{max_si+4:03d}",
    "front": "(SI \u2014 EAC3 / Puertos) Analiza puertos en escucha con **netstat**\n"
             "y configura vsftpd:\n\n"
             "a) Muestra todos los puertos TCP en escucha con netstat\n"
             "b) Muestra todos los puertos UDP en escucha\n"
             "c) Identifica procesos asociados a cada puerto\n"
             "d) Instala e inicia vsftpd\n"
             "e) Verifica que FTP escucha en puerto 21\n"
             "f) Con\u00e9ctate por FTP a localhost\n"
             "g) Identifica conexiones ESTABLISHED\n"
             "h) Diferencia LISTEN vs ESTABLISHED",
    "back": "```bash\n"
            "# Puertos TCP en escucha\n"
            "sudo netstat -tlnp\n\n"
            "# Puertos UDP en escucha\n"
            "sudo netstat -ulnp\n\n"
            "# Ver procesos asociados a cada puerto\n"
            "sudo netstat -tlnp | grep -E \"22|21|80\"\n\n"
            "# Instalar vsftpd\n"
            "sudo apt install vsftpd -y\n"
            "sudo systemctl start vsftpd\n"
            "sudo systemctl enable vsftpd\n\n"
            "# Verificar que FTP escucha en puerto 21\n"
            "sudo netstat -tlnp | grep :21\n"
            "# Salida: tcp 0 0 0.0.0.0:21 0.0.0.0:* LISTEN .../vsftpd\n\n"
            "# Conectarse por FTP a localhost\n"
            "ftp localhost\n"
            "# Usuario: tu_usuario, Contrase\u00f1a: tu_password\n\n"
            "# En otra terminal, ver conexi\u00f3n establecida\n"
            "sudo netstat -tnp | grep :21\n"
            "# Salida: tcp 0 0 192.168.1.100:21 192.168.1.100:54321 ESTABLISHED\n"
            "```\n\n"
            "**Diferencia:**\n"
            "- **LISTEN**: el servicio espera conexiones entrantes\n"
            "- **ESTABLISHED**: hay una conexi\u00f3n activa en curso",
    "tags": ["si", "eac3", "netstat", "ftp", "vsftpd", "puertos"],
    "difficulty": "medium"
})

# ========== SI EAC3 — B7: Impresoras en Windows Server ==========
new_cards.append({
    "id": f"pd-si-{max_si+5:03d}",
    "front": "(SI \u2014 EAC3 / Impresoras) Comparte una **impresora** en Windows Server 2019:\n\n"
             "1. Instala un servidor de impresi\u00f3n\n"
             "2. A\u00f1ade una impresora (real o virtual como Bullzip PDF)\n"
             "3. Comp\u00e1rtela en red\n"
             "4. Imprime un documento desde un cliente Windows 11\n\n"
             "Explica los pasos y permisos necesarios.",
    "back": "**Pasos para compartir impresora en Windows Server 2019:**\n\n"
            "**1. Instalar rol de impresi\u00f3n:**\n"
            "- Administrador del servidor > Agregar roles y caracter\u00edsticas\n"
            "- Seleccionar \"Servicios de impresi\u00f3n y documentos\"\n"
            "- Incluir \"Servidor de impresi\u00f3n\"\n\n"
            "**2. A\u00f1adir impresora virtual (Bullzip):**\n"
            "- Descargar e instalar Bullzip PDF Printer desde bullzip.com\n"
            "- La impresora aparece como dispositivo instalado\n\n"
            "**3. Compartir la impresora:**\n"
            "- Configuraci\u00f3n de impresoras > Click derecho > Propiedades\n"
            "- Pesta\u00f1a \"Compartir\" > Marcar \"Compartir esta impresora\"\n"
            "- Nombre de recurso compartido: \"ImpresoraPDF\"\n\n"
            "**4. Permisos:**\n"
            "- Pesta\u00f1a \"Seguridad\": asignar \"Imprimir\" a grupo Usuarios del dominio\n"
            "- Asignar \"Administrar impresoras\" a Administradores\n\n"
            "**5. Desde cliente Windows 11:**\n"
            "- Conectarse a \\\\servidor\\ImpresoraPDF\n"
            "- Abrir un documento > Imprimir > Seleccionar la impresora compartida",
    "tags": ["si", "eac3", "impresoras", "windows-server", "compartir"],
    "difficulty": "medium"
})

# ========== SI EAC3 — B8: Samba AD DC en Ubuntu ==========
new_cards.append({
    "id": f"pd-si-{max_si+6:03d}",
    "front": "(SI \u2014 EAC3 / Samba AD DC) Configura Ubuntu como **Controlador de Dominio**\n"
             "usando Samba en modo Active Directory:\n\n"
             "a) Instala paquetes Samba y dependencias\n"
             "b) Configura IP est\u00e1tica\n"
             "c) Provisiona el dominio con samba-tool\n"
             "d) Configura DNS integrado de Samba\n"
             "e) Inicia el servicio y verifica con samba-tool domain level show\n"
             "f) Une un cliente Windows al dominio\n"
             "g) Inicia sesi\u00f3n con usuario del dominio",
    "back": "```bash\n"
            "# 1. Instalar paquetes\n"
            "sudo apt install samba smbclient winbind -y\n\n"
            "# 2. Configurar IP est\u00e1tica (Netplan o ip)\n"
            "# 3. Provisionar el dominio\n"
            "sudo samba-tool domain provision \\\n"
            "  --use-rfc2307 \\\n"
            "  --domain=EAC3 \\\n"
            "  --realm=eac3.tudominio.home \\\n"
            "  --adminpass=Contrase\u00f1aSegura1\n\n"
            "# 4. Configurar resolv.conf para que apunte a s\u00ed mismo\n"
            "echo \"nameserver 127.0.0.1\" | sudo tee /etc/resolv.conf\n"
            "echo \"search eac3.tudominio.home\" | sudo tee -a /etc/resolv.conf\n\n"
            "# 5. Deshabilitar servicios conflictivos\n"
            "sudo systemctl disable --now systemd-resolved\n"
            "sudo systemctl disable --now bind9 2>/dev/null\n\n"
            "# 6. Iniciar Samba AD DC\n"
            "sudo systemctl unmask samba-ad-dc\n"
            "sudo systemctl enable samba-ad-dc\n"
            "sudo systemctl start samba-ad-dc\n\n"
            "# 7. Verificar nivel de dominio\n"
            "sudo samba-tool domain level show\n\n"
            "# 8. Verificar DNS\n"
            "nslookup eac3.tudominio.home localhost\n"
            "```\n\n"
            "**Unir cliente Windows 11 al dominio:**\n"
            "- Configurar DNS del cliente apuntando al servidor Ubuntu\n"
            "- Configuraci\u00f3n > Sistema > Acerca de > Unir al dominio\n"
            "- Introducir: eac3.tudominio.home\n"
            "- Usar credenciales del administrador del dominio",
    "tags": ["si", "eac3", "samba", "ad", "domain-controller", "ubuntu"],
    "difficulty": "hard"
})

# ========== SI EAC3 — C3a: Compilaci\u00f3n C + Makefile ==========
new_cards.append({
    "id": f"pd-si-{max_si+7:03d}",
    "front": "(SI \u2014 EAC3 / Compilaci\u00f3n C) Compila un programa en C en Ubuntu:\n\n"
             "a) Compila con gcc manualmente generando un binario ejecutable\n"
             "b) Crea un Makefile para automatizar la compilaci\u00f3n\n"
             "c) Ejecuta el programa con un par\u00e1metro de prueba\n"
             "d) Crea una p\u00e1gina de manual en formato roff\n"
             "   (secciones: NAME, SYNOPSIS, DESCRIPTION, OPTIONS, FILES, AUTHOR)\n"
             "e) Visualiza con groff antes de instalar\n"
             "f) Instala en /usr/share/man/man3/\n"
             "g) Verifica con man",
    "back": "**Programa ejemplo (saludo.c):**\n\n"
            "```c\n"
            "#include <stdio.h>\n"
            "#include <string.h>\n\n"
            "int main(int argc, char *argv[]) {\n"
            "  if (argc < 2) {\n"
            "    printf(\"Uso: %s <nombre>\\n\", argv[0]);\n"
            "    return 1;\n"
            "  }\n"
            "  printf(\"Hola, %s!\\n\", argv[1]);\n"
            "  return 0;\n"
            "}\n"
            "```\n\n"
            "**Compilar y ejecutar:**\n\n"
            "```bash\n"
            "# Compilaci\u00f3n manual\n"
            "gcc -o saludo saludo.c\n\n"
            "# Ejecutar con par\u00e1metro\n"
            "./saludo Mundo\n"
            "# Salida: Hola, Mundo!\n"
            "```\n\n"
            "**Makefile:**\n\n"
            "```makefile\n"
            "all: saludo\n\n"
            "saludo: saludo.c\n"
            "\tgcc -o saludo saludo.c\n\n"
            "clean:\n"
            "\trm -f saludo\n"
            "```\n\n"
            "**P\u00e1gina de manual (saludo.3):**\n\n"
            "```roff\n"
            ".TH SALUDO 3 \"2024\" \"Ejemplo\"\n"
            ".SH NAME\n"
            "saludo \\- imprime un saludo personalizado\n"
            ".SH SYNOPSIS\n"
            ".B saludo\n"
            ".I nombre\n"
            ".SH DESCRIPTION\n"
            "Imprime \\\"Hola, nombre!\\\" en la salida est\u00e1ndar.\n"
            ".SH OPTIONS\n"
            "No tiene opciones. Solo recibe un argumento obligatorio.\n"
            ".SH FILES\n"
            "/usr/local/bin/saludo\n"
            ".SH AUTHOR\n"
            "Tu Nombre\n"
            "```\n\n"
            "**Instalar p\u00e1gina de manual:**\n\n"
            "```bash\n"
            "# Visualizar con groff\n"
            "groff -man -Tascii saludo.3\n\n"
            "# Copiar al directorio de manuales\n"
            "sudo cp saludo.3 /usr/share/man/man3/\n\n"
            "# Actualizar base de datos\n"
            "sudo mandb\n\n"
            "# Verificar\n"
            "man 3 saludo\n"
            "```",
    "tags": ["si", "eac3", "compilacion", "c", "makefile", "man-page", "roff"],
    "difficulty": "hard"
})

# ========== SI EAC1 — A5: Prevenci\u00f3n riesgos laborales ==========
new_cards.append({
    "id": f"pd-si-{max_si+8:03d}",
    "front": "(SI \u2014 EAC1 / PRL) Identifica los principales **riesgos ergon\u00f3micos**\n"
             "en un puesto inform\u00e1tico y las **correcciones** para cada uno:\n\n"
             "a) Postura y silla\n"
             "b) Pantalla e iluminaci\u00f3n\n"
             "c) Teclado y rat\u00f3n\n"
             "d) Pausas y ejercicios",
    "back": "**Riesgos y correcciones:**\n\n"
            "**a) Postura y silla:**\n"
            "- Riesgo: dolor de espalda, cervicales\n"
            "- Correcci\u00f3n: silla ajustable con soporte lumbar,\n"
            "  pies apoyados en el suelo, muslos paralelos al suelo\n\n"
            "**b) Pantalla e iluminaci\u00f3n:**\n"
            "- Riesgo: fatiga visual, dolor de cabeza\n"
            "- Correcci\u00f3n: pantalla a la altura de los ojos,\n"
            "  distancia de 50-70 cm, evitar reflejos,\n"
            "  iluminaci\u00f3n ambiental adecuada, parpadeo frecuente\n\n"
            "**c) Teclado y rat\u00f3n:**\n"
            "- Riesgo: s\u00edndrome del t\u00fanel carpiano, tendinitis\n"
            "- Correcci\u00f3n: mu\u00f1ecas rectas al escribir,\n"
            "  reposamu\u00f1ecas, rat\u00f3n cerca del teclado,\n"
            "  usar atajos de teclado para reducir uso del rat\u00f3n\n\n"
            "**d) Pausas y ejercicios:**\n"
            "- Riesgo: fatiga muscular, circulaci\u00f3n\n"
            "- Correcci\u00f3n: pausas de 5 min cada hora,\n"
            "  regla 20-20-20 (cada 20 min, mirar a 20 pies durante 20 seg),\n"
            "  estiramientos de cuello, hombros y mu\u00f1ecas",
    "tags": ["si", "eac1", "prl", "ergonomia", "prevencion"],
    "difficulty": "easy"
})

# ========== ED EAC2 — Testing particiones equivalentes ==========
new_cards.append({
    "id": f"pd-ed-{max_ed+1:03d}",
    "front": "(ED \u2014 EAC2 / Testing) Explica las **t\u00e9cnicas de caja negra**\n"
             "para diseñar casos de prueba:\n\n"
             "1. **Particiones equivalentes**: en qu\u00e9 consiste, ejemplo\n"
             "2. **Valores l\u00edmite**: en qu\u00e9 consiste, ejemplo\n"
             "3. **Tabla de decisiones**: cu\u00e1ndo usarla",
    "back": "**1. Particiones equivalentes (Equivalence Partitioning):**\n\n"
            "Consiste en dividir los valores de entrada en grupos (particiones)\n"
            "donde se espera el mismo comportamiento. Se prueba un valor\n"
            "representativo de cada partici\u00f3n.\n\n"
            "Ejemplo: campo edad acepta 18-65 a\u00f1os\n"
            "- V\u00e1lida: 18 a 65 (ej: 30)\n"
            "- Inv\u00e1lida baja: < 18 (ej: 15)\n"
            "- Inv\u00e1lida alta: > 65 (ej: 70)\n\n"
            "**2. Valores l\u00edmite (Boundary Value Analysis):**\n\n"
            "Se prueban los valores en los bordes de las particiones,\n"
            "donde es m\u00e1s probable encontrar errores.\n\n"
            "Ejemplo: campo edad 18-65\n"
            "- L\u00edmite inferior: 17 (inv\u00e1lido), 18 (v\u00e1lido), 19 (v\u00e1lido)\n"
            "- L\u00edmite superior: 64 (v\u00e1lido), 65 (v\u00e1lido), 66 (inv\u00e1lido)\n\n"
            "**3. Tabla de decisiones (Decision Table):**\n\n"
            "Se usa cuando hay m\u00faltiples condiciones que afectan el resultado.\n"
            "Ejemplo: validar pedido (cliente registrado AND stock disponible AND pago OK).\n"
            "Se listan todas las combinaciones de condiciones y su resultado esperado.",
    "tags": ["ed", "eac2", "testing", "caja-negra", "particiones-equivalentes"],
    "difficulty": "medium"
})

# ========== ED EAC2 — Integraci\u00f3n continua ==========
new_cards.append({
    "id": f"pd-ed-{max_ed+2:03d}",
    "front": "(ED \u2014 EAC2 / Integraci\u00f3n continua) Explica los conceptos de:\n\n"
             "1. **Integraci\u00f3n continua (CI)**: definici\u00f3n y beneficios\n"
             "2. **Entrega continua (CD)**: diferencia con CI\n"
             "3. Herramientas comunes: Jenkins, GitHub Actions, GitLab CI\n"
             "4. Pipeline t\u00edpico: compilar, testear, desplegar",
    "back": "**1. Integraci\u00f3n Continua (CI):**\n\n"
            "Pr\u00e1ctica de desarrollo donde los cambios de c\u00f3digo se integran\n"
            "en el repositorio principal varias veces al d\u00eda. Cada integraci\u00f3n\n"
            "se verifica autom\u00e1ticamente con compilaci\u00f3n y pruebas.\n\n"
            "Beneficios:\n"
            "- Detectar errores r\u00e1pidamente\n"
            "- Reducir problemas de integraci\u00f3n\n"
            "- Feedback inmediato al desarrollador\n"
            "- C\u00f3digo siempre en estado funcional\n\n"
            "**2. Entrega Continua (CD):**\n\n"
            "Extensi\u00f3n de CI donde el c\u00f3digo compilado y probado\n"
            "se despliega autom\u00e1ticamente en producci\u00f3n.\n"
            "CI = integrar + testear | CD = CI + desplegar\n\n"
            "**3. Herramientas:**\n"
            "- **Jenkins**: servidor CI/CD extensible con pipelines\n"
            "- **GitHub Actions**: CI/CD integrado en GitHub\n"
            "- **GitLab CI**: pipeline definido en .gitlab-ci.yml\n\n"
            "**4. Pipeline t\u00edpico:**\n\n"
            "```\n"
            "Commit \u2192 Compilar \u2192 Tests unitarios \u2192 Tests integraci\u00f3n \u2192 Desplegar\n"
            "```",
    "tags": ["ed", "eac2", "ci", "cd", "integracion-continua", "devops"],
    "difficulty": "medium"
})

# Add all new cards
for nc in new_cards:
    if nc['id'] not in existing_ids:
        data['cards'].append(nc)
        print(f"Added: {nc['id']}")
    else:
        print(f"Already exists: {nc['id']}")

with open('public/data/preguntas-directas/pd-all.json', 'w', encoding='utf-8') as f:
    json.dump(data, f, ensure_ascii=False, indent=2)

print(f"\nTotal cards: {len(data['cards'])}")
