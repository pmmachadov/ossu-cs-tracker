import json
from collections import Counter

# Check sistemas-informaticos.json for command-related cards
with open(r'C:\Users\Pablo\Desktop\Pablo\anki-cards-completo\public\data\sistemas-informaticos.json', encoding='utf-8') as f:
    data = json.load(f)

# Find cards with 'comandos' tag
comandos = [c for c in data['cards'] if 'comandos' in c.get('tags', [])]
print(f'Cards tagged "comandos": {len(comandos)}')
for c in comandos:
    front_short = c['front'][:100].replace('\n', ' ')
    print(f'  [{c.get("id","?")}] {front_short}...')
print()

# Also find cards mentioning command names
cmd_names = ['ls', 'cd', 'pwd', 'cp', 'mv', 'rm', 'mkdir', 'rmdir', 'touch', 'cat', 'more', 'less', 'head', 'tail', 'wc', 'sort', 'uniq', 'cut', 'tr', 'tee', 'echo', 'printf', 'read', 'alias', 'unalias', 'history', 'type', 'which', 'whereis', 'locate', 'updatedb', 'find', 'grep', 'sed', 'awk', 'xargs', 'chmod', 'chown', 'chgrp', 'umask', 'passwd', 'useradd', 'usermod', 'userdel', 'groupadd', 'groupdel', 'groupmod', 'id', 'who', 'w', 'whoami', 'finger', 'su', 'sudo', 'ps', 'top', 'htop', 'kill', 'killall', 'pkill', 'pgrep', 'nice', 'renice', 'nohup', 'bg', 'fg', 'jobs', 'df', 'du', 'mount', 'umount', 'fdisk', 'parted', 'fsck', 'blkid', 'lsblk', 'findmnt', 'dd', 'tar', 'gzip', 'gunzip', 'zip', 'unzip', 'bzip2', 'rsync', 'scp', 'sftp', 'wget', 'curl', 'ping', 'traceroute', 'tracepath', 'mtr', 'nslookup', 'dig', 'host', 'netstat', 'ss', 'ip', 'ifconfig', 'route', 'arp', 'iptables', 'ufw', 'nmap', 'ssh', 'systemctl', 'journalctl', 'service', 'init', 'shutdown', 'reboot', 'halt', 'poweroff', 'crontab', 'at', 'man', 'info', 'whatis', 'apropos', 'apt', 'apt-get', 'aptitude', 'dpkg', 'snap', 'flatpak', 'make', 'gcc', 'git', 'samba', 'smbclient', 'smbpasswd', 'testparm', 'exportfs', 'showmount', 'ldapadd', 'ldapsearch', 'slappasswd', 'netplan', 'nmcli', 'nmtui', 'dhclient', 'hostnamectl', 'timedatectl', 'loginctl', 'usermod', 'groupmod']

found = []
for c in data['cards']:
    front = c['front'].lower()
    for cmd in cmd_names:
        if f' {cmd} ' in front or f'{cmd} ' in front[:20] or front.startswith(cmd):
            found.append((cmd, c['front'][:80]))
            break

print(f'Cards mentioning specific commands: {len(found)}')
cmd_count = Counter(cmd for cmd, _ in found)
for cmd, n in cmd_count.most_common(30):
    print(f'  {cmd}: {n}')
