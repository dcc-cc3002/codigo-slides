# CC3002 – Código Complementario
### Metodologías de Diseño y Programación

Universidad de Chile – Departamento de Ciencias de la Computación

[![License: CC BY 4.0](https://img.shields.io/badge/License-CC%20BY%204.0-555555.svg)](https://creativecommons.org/licenses/by/4.0/)
[![Scala](https://img.shields.io/badge/Scala-3.7.3-red?logo=scala)](https://www.scala-lang.org)
[![sbt](https://img.shields.io/badge/build-sbt-blue)](https://www.scala-sbt.org)
[![Tests](https://img.shields.io/badge/tests-MUnit%20%7C%20JUnit-green)](https://scalameta.org/munit/)
![Status](https://img.shields.io/badge/status-educational-7E57C2)

> [!NOTE]
> Este repositorio reúne **ejemplos progresivos** usados en el curso **CC3002**. No necesitas experiencia previa en Scala ni Git: aquí aprenderás paso a paso conceptos de Programación Orientada a Objetos (OOP), buenas prácticas de diseño, pruebas automatizadas, genéricos e introducción a Programación Funcional (FP).

---

## 📚 Contenido
- [CC3002 – Código Complementario](#cc3002--código-complementario)
    - [Metodologías de Diseño y Programación](#metodologías-de-diseño-y-programación)
  - [📚 Contenido](#-contenido)
  - [🧩 Descripción general](#-descripción-general)
    - [Objetivo del curso](#objetivo-del-curso)
    - [Progresión (resumen)](#progresión-resumen)
    - [Stack técnico (implementado aquí)](#stack-técnico-implementado-aquí)
    - [Estructura del repositorio](#estructura-del-repositorio)
  - [⚙️ Requisitos](#️-requisitos)
    - [¿Sin Git? Método ZIP](#sin-git-método-zip)
    - [Con Git (recomendado)](#con-git-recomendado)
  - [🔄 Actualizar tu copia](#-actualizar-tu-copia)
  - [▶️ Ejecutar ejemplos (@main)](#️-ejecutar-ejemplos-main)
  - [🧪 Testing rápido](#-testing-rápido)
  - [🗂️ Índice de módulos](#️-índice-de-módulos)
  - [📌 Notas pedagógicas importantes](#-notas-pedagógicas-importantes)
  - [❓ FAQ rápida](#-faq-rápida)
  - [🪪 Licencia](#-licencia)
    - [GitHub (Descripción y Topics sugeridos)](#github-descripción-y-topics-sugeridos)

---

## 🧩 Descripción general

### Objetivo del curso

Aprender a diseñar y programar usando OOP clásica en Scala 3, construyendo desde tipos y clases simples hasta patrones de diseño y técnicas básicas de FP.

### Progresión (resumen)

1. Tipado estático y primeras clases.
2. Encapsulación, herencia y polimorfismo.
3. Pruebas automatizadas (MUnit/JUnit).
4. Abstracciones (traits / clases abstractas).
5. Patrones de diseño fundamentales (Observer, State, Factory, Singleton, Visitor, etc.).
6. Manejo de errores con excepciones.
7. Genéricos (parametrización de tipos) y reutilización.
8. Introducción a FP: inmutabilidad gradual, composición, `for-comprehensions`, Option/Future simplificados.

### Stack técnico (implementado aquí)

- Scala 3.7.3 sobre SBT 1.11.x (build multi-módulo).
- JDK 17+ (probado con Azul JDK 25).
- Pruebas: MUnit (todos los módulos) y JUnit 5 (módulo `03-testing`).
- Formateo: Scalafmt, indentación significativa (sin llaves extensivas).

### Estructura del repositorio

- Cada carpeta numerada (`01-...`, `02-...`, etc.) es un subproyecto independiente.
- El proyecto raíz compila y prueba todos simultáneamente.
- No incluye las diapositivas oficiales; sólo código de apoyo y ejercicios.
- Clases faltantes (12, 16) viven en: [dcc-cc3002/clases-2025-2](https://github.com/dcc-cc3002/clases-2025-2/tree/main).

> [!TIP]
> Puedes ejecutar cada módulo sin conocer toda Scala: sigue las instrucciones de este README.

---

## ⚙️ Requisitos

No necesitas instalar todo antes de leer el código. Para ejecutar ejemplos locales:

- **Java (JDK)**: versión 17 o superior.
- **SBT**: 1.11.x.
- **IDE recomendado**: IntelliJ IDEA + plugin Scala (o VS Code con Metals).

Verifica tus versiones (Terminal):
```bash
java -version
sbt --version
```
Si alguno falla, instala:
- JDK: https://adoptium.net o Azul.
- SBT: https://www.scala-sbt.org/download.html

> [!NOTE]
> No usamos configuraciones especiales de variables de entorno. Solo necesitas JDK y SBT visibles en tu PATH.

### ¿Sin Git? Método ZIP

1. Haz clic en el botón verde **Code** en GitHub.
2. Selecciona **Download ZIP**.
3. Descomprime y abre la carpeta en IntelliJ / VS Code.
4. Abre una terminal dentro de la carpeta y ejecuta: `sbt compile`.

### Con Git (recomendado)

```bash
git clone https://github.com/r8vnhill/clases-memes.git
cd clases-memes
git switch <year>/<semester>   # Ej: 2025/2 (Primavera 2025)
```
> Usa la rama correspondiente al semestre (por ej., `2025/2` = Primavera 2025). Si estás en otra rama podrías ver contenido desactualizado.

---

## 🔄 Actualizar tu copia

Para traer cambios nuevos del semestre:
```bash
git fetch origin
git switch <year>/<semester>        # Ej: git switch 2025/2
git pull --ff-only origin <year>/<semester>
```
`--ff-only` evita merges accidentales y mantiene el historial limpio.

Si hiciste cambios locales y aparece un mensaje de conflicto:
1. Guarda tus archivos aparte.
2. Restablece: `git reset --hard origin/<year>/<semester>` (⚠️ borra cambios no guardados).
3. Vuelve a copiar tus modificaciones si las necesitas.

Para confirmar el nombre de la rama del semestre, lista ramas remotas:
```bash
git branch -r --list "origin/*/*"
```

---

## ▶️ Ejecutar ejemplos (@main)

Pasos generales:
```bash
sbt compile                       # Compila todo
sbt "project forComprehensions" run   # Ejecuta el runner por defecto del módulo
```

Listar todos los entry points detectados:
```bash
sbt "project forComprehensions" "show discoveredMainClasses"
```

Ejecutar uno específico:
```bash
sbt "project forComprehensions" "runMain cl.uchile.dcc.forcomprehensions.basics.basicsRunner"
```

> Si no aparece ningún `@main`, revisa que hayas compilado (`sbt compile`) y estés en la **rama correcta**.

---

## 🧪 Testing rápido

```bash
sbt test                      # Todos los módulos
sbt "project testing" test    # Solo módulo de pruebas
sbt "project testing" "testOnly *Calculator*"  # Patrón
```

MUnit se usa para la mayoría de ejemplos; JUnit 5 solo aparece en `03-testing` para comparar estilos.

---

## 🗂️ Índice de módulos

| Nº | Carpeta                     | Tema principal                                                       |
|----|-----------------------------|----------------------------------------------------------------------|
| 01 | static-typing               | Tipado estático básico, valores y tipos                              |
| 02 | intro-oop                   | Primera mirada a clases, objetos y métodos                           |
| 03 | testing                     | Pruebas con MUnit/JUnit, aserciones y fixtures                       |
| 04 | programming-to-abstractions | Programar contra abstracciones (traits / interfaces)                 |
| 05 | inheritance                 | Herencia simple y clases abstractas                                  |
| 06 | media-player-exercise       | Ejercicio aplicado OOP (modelo reproductor)                          |
| 07 | overriding-overloading      | Diferencias entre overriding y sobrecarga                            |
| 08 | encapsulation-and-liskov    | Encapsulación y principio de sustitución (LSP)                       |
| 09 | double-dispatch             | Doble despacho y resolución dinámica                                 |
| 10 | exceptions                  | Manejo de excepciones, propagación controlada                        |
| 11 | polymorphism                | Polimorfismo revisitado y refinado                                   |
| 13 | design-patterns-1           | Observer, State y otros patrones introductorios                      |
| 14 | tamagotchi-exercise         | Integración State + Observer en ejercicio Tamagotchi                 |
| 15 | design-patterns-2           | Factory, Singleton, Composite, Flyweight, Null Object                |
| 17 | visitor                     | Patrón Visitor y doble despacho avanzado                             |
| 18 | expression-problem          | Discusión OOP vs FP, extensibilidad y genéricos                      |
| 19 | intro-functional            | Primeros pasos en FP: colecciones, funciones como valores            |
| 20 | for-comprehensions          | Traducción for ↔ map/flatMap/withFilter, Option/Future simplificados |

> Clases 12 y 16: ver repositorio externo ya enlazado.

**Genéricos:** aparecen de forma gradual (parámetros de tipo) a partir de módulos medios para mostrar reutilización segura sin duplicar código.

**Intro FP:** módulos 18–20 introducen patrones funcionales básicos sin abandonar el enfoque OOP (composición, manejo de efectos simples, for-comprehensions).

---

## 📌 Notas pedagógicas importantes

1. **OOP clásica primero:** evitamos al inicio características avanzadas de Scala (pattern matching extensivo, `enum`, implicits/given, for-comprehensions complejos) para no saturar.
2. **Código en inglés, comentarios en español:** esto simula entornos reales manteniendo claridad didáctica.
3. **Genéricos:** se introducen para mostrar cómo parametrizar tipos sin sacrificar legibilidad.
4. **FP progresiva:** partimos de colecciones y funciones simples; luego `for-comprehensions` como azúcar sobre `map/flatMap/withFilter`.
5. **Patrones de diseño:** se implementan versiones simplificadas con foco en entender el rol de cada patrón antes de optimizar.
6. **Ejemplos intencionalmente pequeños:** favorecen lectura rápida sobre eficiencia.

> [!WARNING]
> El `build.sbt` incluye configuraciones avanzadas (scalacOptions, formato, IDE). **No lo tomes como plantilla de producción.**

Programa histórico: [transcripción 2021](docs/CC3002-programa-primavera-2021-transcripcion.md) (puede estar desactualizado en algunos nombres de clases).

---

## ❓ FAQ rápida

**No se reconoce `sbt`:** Asegura que instalaste SBT y reinicia la terminal. En Windows verifica que el ejecutable esté en PATH.

**No veo mains al ejecutar `show discoveredMainClasses`:** Compila primero (`sbt compile`) y confirma rama `2025/2`.

**Error de versión Java:** Usa JDK 17+. Si tienes JDK 8 aparecerán errores de sintaxis Scala 3.

**IntelliJ no indexa:** Abre el proyecto raíz, espera la importación SBT y sincroniza. Si falla, borra `.idea` y reimporta.

**Conflictos al actualizar la rama:** Usa `git pull --ff-only`. Si ya hiciste commits locales no deseados, guarda tus archivos y resetea (`git reset --hard origin/2025/2`).

## 🪪 Licencia

Este material se distribuye bajo **CC BY 4.0**. Texto completo: [creativecommons.org/licenses/by/4.0](https://creativecommons.org/licenses/by/4.0/).

> Uso estrictamente educativo: algunas implementaciones se simplifican para destacar conceptos sobre rendimiento o robustez extrema.

---

¿Comentarios o mejoras? Abre un issue o discútelo en clase.
