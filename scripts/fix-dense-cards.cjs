const fs = require('fs');
const data = JSON.parse(fs.readFileSync('public/data/preguntas-directas/pd-all.json', 'utf8'));

function fixDenseCard(id, oldFragment, newText) {
  const card = data.cards.find(c => c.id === id);
  if (!card) { console.log('NOT FOUND:', id); return; }
  if (card.back.includes(oldFragment)) {
    card.back = card.back.replace(oldFragment, newText);
    console.log('FIXED:', id);
  } else {
    console.log('NOT FOUND in', id, '- fragment too specific?');
  }
}

// Fix pd-ed-030 - duplicated content
fixDenseCard('pd-ed-030',
  'Técnica que asigna el listener al **elemento PADRE** (o contenedor)\nen vez de a cada hijo. Gracias al **burbujeo (bubbling)**,\nlos eventos de los hijos llegan al padre. (o contenedor) en vez de a cada hijo. Gracias al **burbujeo (bubbling)**, el evento sube por el DOM hasta el padre, donde se detecta con `event.target`.',
  'Técnica que asigna el listener al **elemento PADRE** (o contenedor)\nen vez de a cada hijo. Gracias al **burbujeo (bubbling)**,\nel evento sube por el DOM hasta el padre, donde se detecta\ncon `event.target`.'
);

// pd-ed-001 - fix agregacion description
fixDenseCard('pd-ed-001',
  '- **Agregación:** `Especialidad` (enum) existe aunque ningún\n  científico la use actualmente. BIOLOGIA, GEOLOGIA, OCEANOGRAFIA\n  siguen existiendo como tipo de dato independientemente de\n  los científicos o proyectos.\n- **Agregación (otro):** Un `Proyecto` tiene `Cientifico`s asignados, pero el científico puede existir sin estar asignado a ningún proyecto.',
  '- **Agregación:** `Especialidad` (enum) existe aunque ningún\n  científico la use actualmente. BIOLOGIA, GEOLOGIA, OCEANOGRAFIA\n  siguen existiendo como tipo de dato independientemente de\n  los científicos o proyectos.\n\n- **Agregación (otro):** Un `Proyecto` tiene `Cientifico`s\n  asignados, pero el científico puede existir sin estar\n  asignado a ningún proyecto.'
);

// pd-ed-037 - fix long ACL line
fixDenseCard('pd-ed-037',
  '$acl.AddAccessRule((New-Object\n    System.Security.AccessControl.FileSystemAccessRule(\n      "eac3\\bibliotecari", "FullControl",\n      "ContainerInherit,ObjectInherit", "None", "Allow"))\n$acl.AddAccessRule((New-Object System.Security.AccessControl.FileSystemAccessRule("eac3\\usuari","ReadAndExecute","ContainerInherit,ObjectInherit","None","Allow"))\n$acl.SetAccessRuleProtection($true, $false)',
  '$acl.AddAccessRule((New-Object\n    System.Security.AccessControl.FileSystemAccessRule(\n      "eac3\\bibliotecari", "FullControl",\n      "ContainerInherit,ObjectInherit", "None", "Allow")))\n\n$acl.AddAccessRule((New-Object\n    System.Security.AccessControl.FileSystemAccessRule(\n      "eac3\\usuari", "ReadAndExecute",\n      "ContainerInherit,ObjectInherit", "None", "Allow")))\n\n$acl.SetAccessRuleProtection($true, $false)'
);

// pd-ed-037 - user creation lines
fixDenseCard('pd-ed-037',
  'New-ADUser -Name "Martí" -GivenName "Martí" -Surname "Garcia"\n  -SamAccountName "marti" -UserPrincipalName "marti@eac3.usuarios.local"\n  -Path "OU=Usuaris,DC=eac3,DC=usuaris,DC=local"\nNew-ADUser -Name "Jana" -GivenName "Jana" -Surname "López"\n  -SamAccountName "jana" -UserPrincipalName "jana@eac3.usuarios.local"\n  -Path "OU=Usuaris,DC=eac3,DC=usuaris,DC=local"',
  'New-ADUser -Name "Martí" -GivenName "Martí" -Surname "Garcia"\n  -SamAccountName "marti"\n  -UserPrincipalName "marti@eac3.usuarios.local"\n  -Path "OU=Usuaris,DC=eac3,DC=usuaris,DC=local"\n\nNew-ADUser -Name "Jana" -GivenName "Jana" -Surname "López"\n  -SamAccountName "jana"\n  -UserPrincipalName "jana@eac3.usuarios.local"\n  -Path "OU=Usuaris,DC=eac3,DC=usuaris,DC=local"'
);

// pd-ed-049 - fix middleware description
fixDenseCard('pd-ed-049',
  'Middleware que **parsea el cuerpo** de las peticiones entrantes\ncomo JSON. Convierte el JSON crudo del body en un objeto\nJavaScript accesible desde `req.body`.\n\n**Diferencia con express.urlencoded():**\n- `express.json()` parsea JSON (`Content-Type: application/json`)\n- `express.urlencoded()` parsea formularios (`Content-Type: application/x-www-form-urlencoded`)\n\n**Ejemplo básico:**',
  'Middleware que **parsea el cuerpo** de las peticiones entrantes\ncomo JSON. Convierte el JSON crudo del body en un objeto\nJavaScript accesible desde `req.body`.\n\n**Diferencia con express.urlencoded():**\n- `express.json()` parsea JSON\n  (`Content-Type: application/json`)\n- `express.urlencoded()` parsea formularios\n  (`Content-Type: application/x-www-form-urlencoded`)\n\n**Ejemplo básico:**'
);

console.log('\nAll fixes applied');
fs.writeFileSync('public/data/preguntas-directas/pd-all.json', JSON.stringify(data, null, 2) + '\n');
