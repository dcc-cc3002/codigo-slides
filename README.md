# CC3002 - Código Complementario
### Metodologías de Diseño y Programación

Universidad de Chile - Departamento de Ciencias de la Computación

[![License: CC BY 4.0](https://img.shields.io/badge/License-CC%20BY%204.0-555555.svg)](https://creativecommons.org/licenses/by/4.0/)
[![Scala](https://img.shields.io/badge/Scala-3.7.3-red?logo=scala)](https://www.scala-lang.org)
[![sbt](https://img.shields.io/badge/build-sbt-blue)](https://www.scala-sbt.org)
[![Tests](https://img.shields.io/badge/tests-MUnit%20%7C%20JUnit-green)](https://scalameta.org/munit/)
![Status](https://img.shields.io/badge/status-educational-7E57C2)

> [!NOTE]
> Este repositorio reúne ejemplos progresivos usados en el curso CC3002.
> Está pensado para estudiantes que vienen de Python y están aprendiendo
> OOP clásica en Scala por primera vez.

## Inicio rápido

### Opción A: con Git

```bash
git clone https://github.com/dcc-cc3002/codigo-slides.git
cd codigo-slides
git switch <year>/<semester>   # Ej: 2026/1 o 2025/2
sbt compile
```

### Opción B: con ZIP

1. Descarga el repositorio con **Code > Download ZIP**.
2. Descomprime la carpeta.
3. Abre una terminal dentro del proyecto.
4. Ejecuta `sbt compile`.

> [!TIP]
> Abre la carpeta raíz del proyecto en IntelliJ IDEA o VS Code con Metals y
> espera la importación SBT antes de ejecutar ejemplos o tests.

## Si solo quieres probar algo hoy

```bash
sbt "project testing" test
sbt "project forComprehensions" "show discoveredMainClasses"
```

> [!IMPORTANT]
> En `sbt "project forComprehensions" ...`, `forComprehensions` es el id del
> proyecto SBT, no el nombre de carpeta. La carpeta correspondiente es
> `18-for-comprehensions/`.

## Qué es este repo

Este repo contiene código de apoyo y ejercicios del curso, organizado por clase
y por tema. Cada carpeta numerada (`01-...`, `02-...`, etc.) es un subproyecto
independiente dentro de un build SBT multi-módulo.

El foco es pedagógico: los ejemplos son deliberadamente pequeños y priorizan
claridad sobre robustez o sofisticación. No es un repositorio de código de
producción ni incluye las cátedras o diapositivas oficiales.

## Cambiar o actualizar rama del semestre

Usa siempre la rama del semestre que te corresponda. En este repositorio
aparecen, por ejemplo, `2026/1` y `2025/2`.

```bash
git fetch origin
git switch <year>/<semester>
git pull --ff-only origin <year>/<semester>
```

Si no recuerdas el nombre exacto de la rama, puedes listar las remotas:

```bash
git branch -r --list "origin/*/*"
```

## Ejecutar ejemplos y tests

Compilar todo:

```bash
sbt compile
```

Compilar o probar un módulo específico:

```bash
sbt "project testing" compile
sbt "project testing" test
```

Listar entry points `@main` de un módulo:

```bash
sbt "project forComprehensions" "show discoveredMainClasses"
```

Ejecutar uno específico:

```bash
sbt "project forComprehensions" "runMain cl.uchile.dcc.forcomprehensions.basics.basicsRunner"
```

> Si no aparece ningún `@main`, compila primero con `sbt compile` y confirma
> que estás en la rama correcta del semestre.

## Índice de módulos

| Nº  | Carpeta                     | Tema principal                                        |
| --- | --------------------------- | ----------------------------------------------------- |
| 01  | static-typing               | Tipado estático básico, valores y tipos               |
| 02  | intro-oop                   | Primera mirada a clases, objetos y métodos            |
| 03  | testing                     | Pruebas con MUnit y JUnit                             |
| 04  | programming-to-abstractions | Programar contra abstracciones                        |
| 05  | inheritance                 | Herencia simple y clases abstractas                   |
| 05x | media-player-exercise       | Material extra/opcional: ejercicio aplicado de OOP    |
| 06  | overriding-overloading      | Overriding, sobrecarga y lookup                       |
| 07  | encapsulation-and-liskov    | Encapsulación y principio de Liskov                   |
| 08  | double-dispatch             | Doble despacho                                        |
| 09  | exceptions                  | Manejo de excepciones                                 |
| 10  | polymorphism                | Polimorfismo revisitado                               |
| 12  | design-patterns-1           | Patrones introductorios: Observer, State y más        |
| 13  | tamagotchi-exercise         | Ejercicio Tamagotchi                                  |
| 14  | design-patterns-2           | Factory, Singleton, Composite, Flyweight, Null Object |
| 15  | visitor                     | Patrón Visitor                                        |
| 16  | expression-problem          | Expression Problem, OOP vs FP                         |
| 17  | intro-functional            | Introducción gradual a programación funcional         |
| 18  | for-comprehensions          | `for` como azúcar sobre `map`/`flatMap`/`withFilter`  |

Las clases faltantes del semestre no siempre viven en este repo. Para material
complementario adicional, revisa:
[dcc-cc3002/clases-2025-2](https://github.com/dcc-cc3002/clases-2025-2/tree/main).

Para el módulo 04, revisa su documentación específica en
[04-programming-to-abstractions/README.md](04-programming-to-abstractions/README.md).

## Referencia rápida

- Scala: `3.7.3`
- SBT: `1.11.x`
- JDK: `17+`
- Tests: MUnit en todos los módulos, JUnit 5 en `03-testing`
- Alias útil: `sbt ci` ejecuta `;clean;compile;test`
- Documento histórico del curso:
  [docs/CC3002-programa-primavera-2021-transcripcion.md](docs/CC3002-programa-primavera-2021-transcripcion.md)

## Licencia

Este material se distribuye bajo **CC BY 4.0**.
Texto completo:
[creativecommons.org/licenses/by/4.0](https://creativecommons.org/licenses/by/4.0/).

> Uso estrictamente educativo: algunas implementaciones se simplifican para
> destacar conceptos por sobre rendimiento o robustez extrema.
