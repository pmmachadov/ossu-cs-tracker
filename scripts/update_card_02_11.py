import json

NEW_BACK_02_11 = """RESPUESTA / SOLUCIÓN

### ❌ Error 1: Condición del bucle fuera de rango (`<=`)
- **Lo que se hizo mal:**
```java
for (int i = 0; i <= n.length; i++) {
    t += n[i];   // ❌ En la última vuelta i=5 y accede a n[5] que no existe
}
```
*Fallo:* El operador `<=` hace que `i` llegue a `5`. Para un array de 5 elementos los índices son `0..4`. Al intentar leer `n[5]` lanza `ArrayIndexOutOfBoundsException`.

- **Lo que está correcto (Debajo):**
```java
for (int i = 0; i < n.length; i++) {
    t += n[i];   // ✅ Recorre estrictamente los índices válidos 0, 1, 2, 3, 4
}
```
*Corrección:* Usar `< n.length` para no sobrepasar el límite del array.

---

### ❌ Error 2: Imprimir el array directamente
- **Lo que se hizo mal:**
```java
System.out.println(nums);   // ❌ Imprime la referencia [I@15db9742
```
*Fallo:* En Java, imprimir un array directamente muestra su identificador de memoria y tipo (`[I@...`), no los números que contiene.

- **Lo que está correcto (Debajo):**
```java
System.out.println(Arrays.toString(nums));   // ✅ Imprime [3, 1, 4, 1, 5]
```
*Corrección:* Usar `Arrays.toString(nums)` para formatear el contenido como texto legible.

---

### ❌ Error 3: Falta importar la clase `Arrays`
- **Lo que se hizo mal:**
```java
// ❌ No hay import arriba del archivo
public class ArraysBug { ... }
```
*Fallo:* Si usas `Arrays.toString()` sin importar `java.util.Arrays`, el código no compila (*cannot find symbol*).

- **Lo que está correcto (Debajo):**
```java
import java.util.Arrays;   // ✅ Import añadido al inicio

public class ArraysBug { ... }
```

---

### Código completo corregido:

```java
import java.util.Arrays;                           // ✅ ERROR ③ corregido: import añadido

public class ArraysBug {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5};
        System.out.println(suma(nums));            // ✅ Imprime 14
        System.out.println(Arrays.toString(nums)); // ✅ ERROR ② corregido: imprime [3, 1, 4, 1, 5]
    }

    static int suma(int[] n) {
        int t = 0;
        for (int i = 0; i < n.length; i++) {       // ✅ ERROR ① corregido: i < n.length
            t += n[i];
        }
        return t;
    }
}
```

### Salida esperada:
```text
14
[3, 1, 4, 1, 5]
```

---
### Pseudocódigo:

```pseudocode
Algoritmo ArraysSuma
    Definir nums, i, total Como Entero
    Dimension nums[5]
    nums[0] <- 3; nums[1] <- 1; nums[2] <- 4; nums[3] <- 1; nums[4] <- 5
    
    total <- suma(nums, 5)
    Escribir total
    Escribir "[", nums[0], ", ", nums[1], ", ", nums[2], ", ", nums[3], ", ", nums[4], "]"
FinAlgoritmo

Funcion t <- suma(n, longitud)
    Definir t, i Como Entero
    t <- 0
    Para i <- 0 Hasta longitud - 1 Con Paso 1 Hacer
        t <- t + n[i]
    FinPara
FinFuncion
```"""

# Actualizar en los archivos JSON
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
            if c['id'] == 'ex-java-02-11':
                c['back'] = NEW_BACK_02_11
        with open(path, 'w', encoding='utf-8') as f:
            json.dump(data, f, ensure_ascii=False, indent=2)
        print(f"Updated {path}")
    except Exception as e:
        print(f"Skipped {path}: {e}")
