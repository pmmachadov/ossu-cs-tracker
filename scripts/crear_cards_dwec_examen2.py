import json

with open('public/data/preguntas-directas/pd-all.json', 'r', encoding='utf-8') as f:
    data = json.load(f)

existing_ids = {c['id'] for c in data['cards']}

# ============================================
# Card 1: XMLHttpRequest a REST Countries
# ============================================
card1_front = (
    "(DWEC \u2014 Examen 2\u00aa eval / XMLHttpRequest) Crea una p\u00e1gina HTML con:\n\n"
    "1. Un formulario con un campo para el nombre de un pa\u00eds y un bot\u00f3n de b\u00fasqueda.\n\n"
    "2. Usa **XMLHttpRequest** para hacer GET a:\n"
    "   `https://restcountries.com/v3.1/name/{name}`\n\n"
    "3. Muestra en la p\u00e1gina: **capital**, **poblaci\u00f3n** y **moneda**.\n\n"
    "4. Manejo de errores: alerta si no hay resultados."
)

card1_back = (
    "```html\n"
    "<!DOCTYPE html>\n"
    "<html>\n"
    "<head><title>Buscar Pa\u00eds</title></head>\n"
    "<body>\n"
    "  <h1>Buscar informaci\u00f3n de un pa\u00eds</h1>\n"
    "  <input type=\"text\" id=\"paisInput\" placeholder=\"Nombre del pa\u00eds\">\n"
    "  <button id=\"btnBuscar\">Buscar</button>\n"
    "  <div id=\"resultado\"></div>\n\n"
    "  <script>\n"
    "  document.getElementById(\"btnBuscar\").addEventListener(\"click\", function() {\n"
    "    const nombre = document.getElementById(\"paisInput\").value.trim();\n"
    "    if (!nombre) return;\n\n"
    "    const xhr = new XMLHttpRequest();\n"
    "    xhr.open(\"GET\", \"https://restcountries.com/v3.1/name/\" + nombre);\n"
    "    xhr.onload = function() {\n"
    "      if (xhr.status === 200) {\n"
    "        const datos = JSON.parse(xhr.responseText);\n"
    "        const pais = datos[0];\n"
    "        const monedas = Object.values(pais.currencies)\n"
    "          .map(m => m.name + \" (\" + m.symbol + \")\").join(\", \");\n\n"
    "        document.getElementById(\"resultado\").innerHTML =\n"
    "          \"<p><strong>Capital:</strong> \" + (pais.capital ? pais.capital[0] : \"N/A\") + \"</p>\" +\n"
    "          \"<p><strong>Poblaci\u00f3n:</strong> \" + pais.population.toLocaleString() + \"</p>\" +\n"
    "          \"<p><strong>Moneda:</strong> \" + monedas + \"</p>\";\n"
    "      } else {\n"
    "        alert(\"Pa\u00eds no encontrado. Verifica el nombre.\");\n"
    "      }\n"
    "    };\n"
    "    xhr.onerror = function() {\n"
    "      alert(\"Error de conexi\u00f3n.\");\n"
    "    };\n"
    "    xhr.send();\n"
    "  });\n"
    "  </script>\n"
    "</body>\n"
    "</html>\n"
    "```"
)

# ============================================
# Card 2: jQuery AJAX a REST Countries por idioma
# ============================================
card2_front = (
    "(DWEC \u2014 Examen 2\u00aa eval / jQuery AJAX) Crea una p\u00e1gina HTML con:\n\n"
    "1. Un formulario con un campo para introducir un **idioma** y un bot\u00f3n de b\u00fasqueda.\n\n"
    "2. Usa **jQuery.ajax()** para GET a:\n"
    "   `https://restcountries.com/v3.1/lang/{idioma}`\n\n"
    "3. Muestra los **nombres de los pa\u00edses** que hablan ese idioma, en columna.\n\n"
    "4. Manejo de errores: notificar si el c\u00f3digo de idioma es inv\u00e1lido."
)

card2_back = (
    "```html\n"
    "<!DOCTYPE html>\n"
    "<html>\n"
    "<head>\n"
    "  <title>Buscar por Idioma</title>\n"
    "  <script src=\"https://code.jquery.com/jquery-3.7.1.min.js\"></script>\n"
    "</head>\n"
    "<body>\n"
    "  <h1>Pa\u00edses por idioma</h1>\n"
    "  <input type=\"text\" id=\"idiomaInput\" placeholder=\"C\u00f3digo de idioma (ej: es, en, fr)\">\n"
    "  <button id=\"btnBuscar\">Buscar</button>\n"
    "  <ul id=\"listaPaises\"></ul>\n\n"
    "  <script>\n"
    "  $(\"#btnBuscar\").on(\"click\", function() {\n"
    "    const idioma = $(\"#idiomaInput\").val().trim();\n"
    "    if (!idioma) return;\n\n"
    "    $.ajax({\n"
    "      url: \"https://restcountries.com/v3.1/lang/\" + idioma,\n"
    "      method: \"GET\",\n"
    "      success: function(datos) {\n"
    "        let html = \"\";\n"
    "        datos.forEach(function(pais) {\n"
    "          html += \"<li>\" + pais.name.common + \"</li>\";\n"
    "        });\n"
    "        $(\"#listaPaises\").html(html);\n"
    "      },\n"
    "      error: function() {\n"
    "        alert(\"C\u00f3digo de idioma no v\u00e1lido o sin resultados.\");\n"
    "      }\n"
    "    });\n"
    "  });\n"
    "  </script>\n"
    "</body>\n"
    "</html>\n"
    "```"
)

# ============================================
# Card 3: Formulario din\u00e1mico con validaci\u00f3n y POST
# ============================================
card3_front = (
    "(DWEC \u2014 Examen 2\u00aa eval / Formulario din\u00e1mico) Desarrolla una p\u00e1gina que:\n\n"
    "1. **Cree din\u00e1micamente** un formulario dentro de `#formContainer` con:\n"
    "   - Nombre (text)\n"
    "   - Email (email)\n"
    "   - Mensaje (textarea)\n"
    "   - Bot\u00f3n de env\u00edo\n\n"
    "2. **Valide** al enviar:\n"
    "   - Todos los campos obligatorios\n"
    "   - Email con formato v\u00e1lido\n"
    "   - Muestre mensajes de error espec\u00edficos\n\n"
    "3. **Simule POST** a `https://example.com/contacto`\n"
    "   y muestre \"Formulario enviado con \u00e9xito\".\n\n"
    "4. Aplique estilos CSS al formulario."
)

card3_back = (
    "```html\n"
    "<!DOCTYPE html>\n"
    "<html>\n"
    "<head>\n"
    "  <title>Formulario de Contacto</title>\n"
    "  <style>\n"
    "    body { font-family: Arial; padding: 20px; background: #f5f5f5; }\n"
    "    #formContainer {\n"
    "      max-width: 400px; margin: 0 auto;\n"
    "      background: white; padding: 20px;\n"
    "      border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1);\n"
    "    }\n"
    "    input, textarea {\n"
    "      width: 100%; padding: 8px; margin: 5px 0 10px 0;\n"
    "      border: 1px solid #ccc; border-radius: 4px;\n"
    "    }\n"
    "    button {\n"
    "      background: #007bff; color: white; padding: 10px 20px;\n"
    "      border: none; border-radius: 4px; cursor: pointer;\n"
    "    }\n"
    "    .error { color: red; font-size: 0.9em; margin-bottom: 10px; }\n"
    "  </style>\n"
    "</head>\n"
    "<body>\n"
    "  <div id=\"formContainer\"></div>\n\n"
    "  <script>\n"
    "  const container = document.getElementById(\"formContainer\");\n\n"
    "  // Crear formulario din\u00e1micamente\n"
    "  const form = document.createElement(\"form\");\n"
    "  form.id = \"contactForm\";\n\n"
    "  const campos = [\n"
    "    { label: \"Nombre\", type: \"text\", id: \"nombre\", required: true },\n"
    "    { label: \"Email\", type: \"email\", id: \"email\", required: true },\n"
    "    { label: \"Mensaje\", type: \"textarea\", id: \"mensaje\", required: true }\n"
    "  ];\n\n"
    "  campos.forEach(function(campo) {\n"
    "    const label = document.createElement(\"label\");\n"
    "    label.textContent = campo.label + \":\";\n"
    "    form.appendChild(label);\n\n"
    "    if (campo.type === \"textarea\") {\n"
    "      const ta = document.createElement(\"textarea\");\n"
    "      ta.id = campo.id; ta.rows = 4;\n"
    "      form.appendChild(ta);\n"
    "    } else {\n"
    "      const input = document.createElement(\"input\");\n"
    "      input.type = campo.type; input.id = campo.id;\n"
    "      form.appendChild(input);\n"
    "    }\n\n"
    "    const error = document.createElement(\"div\");\n"
    "    error.className = \"error\"; error.id = campo.id + \"Error\";\n"
    "    form.appendChild(error);\n"
    "  });\n\n"
    "  const btn = document.createElement(\"button\");\n"
    "  btn.type = \"submit\"; btn.textContent = \"Enviar\";\n"
    "  form.appendChild(btn);\n\n"
    "  container.appendChild(form);\n\n"
    "  // Validaci\u00f3n y env\u00edo\n"
    "  form.addEventListener(\"submit\", function(e) {\n"
    "    e.preventDefault();\n"
    "    let valido = true;\n\n"
    "    // Limpiar errores\n"
    "    document.querySelectorAll(\".error\").forEach(function(el) {\n"
    "      el.textContent = \"\";\n"
    "    });\n\n"
    "    const nombre = document.getElementById(\"nombre\").value.trim();\n"
    "    const email = document.getElementById(\"email\").value.trim();\n"
    "    const mensaje = document.getElementById(\"mensaje\").value.trim();\n\n"
    "    if (!nombre) {\n"
    "      document.getElementById(\"nombreError\").textContent = \"El nombre es obligatorio.\";\n"
    "      valido = false;\n"
    "    }\n"
    "    if (!email) {\n"
    "      document.getElementById(\"emailError\").textContent = \"El email es obligatorio.\";\n"
    "      valido = false;\n"
    "    } else if (!/^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$/.test(email)) {\n"
    "      document.getElementById(\"emailError\").textContent = \"Email no v\u00e1lido.\";\n"
    "      valido = false;\n"
    "    }\n"
    "    if (!mensaje) {\n"
    "      document.getElementById(\"mensajeError\").textContent = \"El mensaje es obligatorio.\";\n"
    "      valido = false;\n"
    "    }\n\n"
    "    if (valido) {\n"
    "      fetch(\"https://example.com/contacto\", {\n"
    "        method: \"POST\",\n"
    "        headers: { \"Content-Type\": \"application/json\" },\n"
    "        body: JSON.stringify({ nombre: nombre, email: email, mensaje: mensaje })\n"
    "      })\n"
    "      .then(function() {\n"
    "        console.log(\"Formulario enviado con \u00e9xito\");\n"
    "        alert(\"Formulario enviado con \u00e9xito\");\n"
    "      })\n"
    "      .catch(function() {\n"
    "        alert(\"Error al enviar el formulario.\");\n"
    "      });\n"
    "    }\n"
    "  });\n"
    "  </script>\n"
    "</body>\n"
    "</html>\n"
    "```"
)

new_cards = [
    {"id": "pd-dwec-016", "front": card1_front, "back": card1_back, "tags": ["dwec", "examen", "ajax", "xmlhttprequest", "api", "2eval"], "difficulty": "hard"},
    {"id": "pd-dwec-017", "front": card2_front, "back": card2_back, "tags": ["dwec", "examen", "jquery", "ajax", "api", "2eval"], "difficulty": "hard"},
    {"id": "pd-dwec-018", "front": card3_front, "back": card3_back, "tags": ["dwec", "examen", "formulario", "dom", "validacion", "fetch", "2eval"], "difficulty": "hard"},
]

for nc in new_cards:
    if nc['id'] not in existing_ids:
        data['cards'].append(nc)
        print(f"Added: {nc['id']}")
    else:
        print(f"Already exists: {nc['id']}")

with open('public/data/preguntas-directas/pd-all.json', 'w', encoding='utf-8') as f:
    json.dump(data, f, ensure_ascii=False, indent=2)

print(f"\nTotal cards now: {len(data['cards'])}")
