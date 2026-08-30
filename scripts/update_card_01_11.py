import json

NEW_BACK_01_11 = """RESPUESTA / SOLUCIÓN

### ❌ Error 1: Sintaxis al pasar el array como argumento (`notas[]`)
- **Lo que se hizo mal:**
```java
double media = calcular(notas[]);   // ❌ Sobran los corchetes al invocar
```
*Fallo:* Al pasar un array a un método no se ponen corchetes `[]`, solo el identificador de la variable.

- **Lo que está correcto (Debajo):**
```java
double media = calcular(notas);     // ✅ Se pasa la referencia del array
```
*Corrección:* Quitar los corchetes `[]` en la llamada.

---

### ❌ Error 2: Condición de bucle con desbordamiento (`<=`)
- **Lo que se hizo mal:**
```java
for (int i = 0; i <= n.length; i++) {   // ❌ i llega a 4 y n[4] no existe
    suma += n[i];
}
```
*Fallo:* Con un array de longitud 4, los índices válidos son `0..3`. La condición `<=` evalúa `n[4]`, lanzando `ArrayIndexOutOfBoundsException`.

- **Lo que está correcto (Debajo):**
```java
for (int i = 0; i < n.length; i++) {    // ✅ Recorre estrictamente índices 0..3
    suma += n[i];
}
```
*Corrección:* Cambiar `<=` por `<`.

---

### ❌ Error 3: El método devuelve la suma en lugar del promedio real
- **Lo que se hizo mal:**
```java
return suma;   // ❌ Devuelve la suma acumulada (23), no el promedio (5.75)
```
*Fallo:* El método promete devolver la `media`, pero solo devuelve `suma`.

- **Lo que está correcto (Debajo):**
```java
return suma / (double) n.length;   // ✅ Devuelve el promedio con división decimal (5.75)
```
*Corrección:* Dividir la suma entre `(double) n.length` para evitar división entera truncada.

---

### Código completo corregido:

```java
public class Promedio {
    public static void main(String[] args) {
        int[] notas = {4, 7, 3, 9};
        double media = calcular(notas);                // ✅ ERROR ① corregido: sin corchetes
        System.out.println("Media: " + media);
    }

    static double calcular(int[] n) {
        int suma = 0;
        for (int i = 0; i < n.length; i++) {          // ✅ ERROR ② corregido: i < n.length
            suma += n[i];
        }
        return suma / (double) n.length;              // ✅ ERROR ③ corregido: devuelve la media (5.75)
    }
}
```

### Salida esperada:
```text
Media: 5.75
```

---
### Pseudocódigo:

```pseudocode
Algoritmo CalcularPromedio
    Definir notas Como Entero
    Dimension notas[4]
    notas[0] <- 4; notas[1] <- 7; notas[2] <- 3; notas[3] <- 9
    
    Definir media Como Real
    media <- calcular(notas, 4)
    Escribir "Media: ", media
FinAlgoritmo

Funcion media <- calcular(n, longitud)
    Definir suma, i Como Entero
    suma <- 0
    Para i <- 0 Hasta longitud - 1 Con Paso 1 Hacer
        suma <- suma + n[i]
    FinPara
    media <- suma / longitud
FinFuncion
```"""

for path in [
    'public/data/examenes/examen-java-ejercicios.json',
    'public/data/examenes/examen-java.json',
    'dist/data/examenes/examen-java-ejercicios.json',
    'dist/data/examenes/examen-java.json',
]:
    try:
        with open(path, 'r', encoding='utf-8') as f:
            data = json.load(f)
        for c in data['cards']:
            if c['id'] == 'ex-java-01-11':
                c['back'] = NEW_BACK_01_11
        with open(path, 'w', encoding='utf-8') as f:
            json.dump(data, f, ensure_ascii=False, indent=2)
        print(f"Updated {path}")
    except Exception as e:
        print(f"Skipped {path}: {e}")
