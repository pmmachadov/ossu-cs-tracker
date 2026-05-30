import re

for eac in ['EAC1', 'EAC2', 'EAC3']:
    if eac == 'EAC1':
        path = r'C:\Users\Pablo\Desktop\Pablo\anki-cards-completo\pruebas\sistemas informaticos\DA2_0483_EAC1_Pablo_M.txt'
    else:
        path = rf'C:\Users\Pablo\Desktop\Pablo\anki-cards-completo\pruebas\sistemas informaticos\DA2_0483_{eac}_Machado_V.txt'
    
    try:
        with open(path, encoding='utf-8') as f:
            text = f.read()
    except:
        continue
    
    lines = text.split('\n')
    commands = []
    keywords = ['sudo', 'fdisk', 'mksf', 'mount', 'umount', 'lsblk', 'chmod', 'chown', 'apt', 'systemctl', 'service', 'netstat', 'ip ', 'ifconfig', 'ping', 'nmap', 'ssh', 'scp', 'sftp', 'useradd', 'userdel', 'groupadd', 'usermod', 'passwd', 'tar', 'gzip', 'grep', 'find', 'ps ', 'kill', 'cron', 'crontab', 'rsync', 'nfs', 'samba', 'vsftpd', 'ufw', 'iptables', 'df ', 'du ', 'dd ', 'gdisk', 'parted', 'vgcreate', 'lvcreate', 'pvcreate', 'lvextend', 'resize2fs', 'mdadm', 'blkid', 'fsck', 'swapon', 'exportfs', 'smbpasswd', 'testparm', 'slappasswd', 'ldapadd', 'ldapsearch', 'wget', 'curl', 'git', 'gcc', 'man']
    
    for line in lines:
        stripped = line.strip()
        if 'Codi:' in stripped or 'Pàgina' in stripped or 'Exercici' in stripped or 'Formació' in stripped:
            continue
        if len(stripped) < 5:
            continue
        lower = stripped.lower()
        if any(kw in lower for kw in keywords):
            commands.append(stripped)
    
    print(f'=== {eac} ({len(commands)} lines) ===')
    for c in commands:
        print(f'  {c}')
    print()
