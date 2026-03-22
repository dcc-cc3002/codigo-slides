/*
 * Ejemplo standalone en C para comparar reserva de memoria e
 * inicializacion con `new Musician(...)` en Scala.
 *
 * Como compilar y ejecutar desde la raiz del repo:
 *
 * ## Con CMake:
 * 
 * ```
 * cmake -S 04-programming-to-abstractions  -B 04-programming-to-abstractions/cmake-build
 * cmake --build 04-programming-to-abstractions/cmake-build
 * ```
 * 
 * ### Linux/macOS:
 * 
 * ```
 * ./04-programming-to-abstractions/cmake-build/musician
 * ```
 *
 * ### Windows:
 * 
 * ```
 * .\04-programming-to-abstractions\cmake-build\Debug\musician.exe
 * ```
 *
 * El flujo con CMake es opt-in y no interfiere con SBT.
 *
 * ## Con clang:
 * 
 * ### Linux/macOS:
 * 
 * ```
 * clang -Wall -Wextra -pedantic \
 *     04-programming-to-abstractions/src/main/c/musician.c \
 *     -o 04-programming-to-abstractions/src/main/c/musician
 * ./04-programming-to-abstractions/src/main/c/musician
 * ```
 * 
 * ### Windows con clang:
 * ```
 * clang -Wall -Wextra -pedantic ^
 *     04-programming-to-abstractions/src/main/c/musician.c ^
 *     -o 04-programming-to-abstractions/src/main/c/musician.exe
 * .\04-programming-to-abstractions\src\main\c\musician.exe
 * ```
 *
 * ## Con gcc:
 * 
 * ### Linux/macOS:
 * 
 * ```
 * gcc -Wall -Wextra -pedantic \
 *   04-programming-to-abstractions/src/main/c/musician.c \
 *   -o 04-programming-to-abstractions/src/main/c/musician
 * ./04-programming-to-abstractions/src/main/c/musician
 * ```
 * 
 * ### Windows:
 * 
 * ```
 * gcc -Wall -Wextra -pedantic ^
 *   04-programming-to-abstractions/src/main/c/musician.c ^
 *   -o 04-programming-to-abstractions/src/main/c/musician.exe
 * .\04-programming-to-abstractions\src\main\c\musician.exe
 * ```
 */

#include <stdio.h>
#include <stdlib.h>

#define MAX_TEXT 64
// Simplificación: usamos buffers de tamaño fijo para evitar un malloc por cada
// string.

typedef struct Musician {
  char name[MAX_TEXT];
  char role[MAX_TEXT];
} Musician;

/*
 * En la slide se separa el flujo en dos pasos:
 * reservar memoria y luego inicializar el estado.
 */
Musician *malloc_musician(void) {
  Musician *musician = malloc(sizeof(Musician));
  if (musician == NULL) { return NULL; }
  return musician;
}

void initialize_musician(Musician *musician, const char *name, const char *role) {
  if (musician == NULL) { return; }
  // Simplificación: copiamos con snprintf en vez de reservar memoria exacta.
  // Si el texto excede MAX_TEXT - 1, se truncará.
  snprintf(musician->name, MAX_TEXT, "%s", name);
  snprintf(musician->role, MAX_TEXT, "%s", role);
}

void print_musician(const Musician *musician) {
  if (musician == NULL) {
    printf("No musician was created.\n");
    return;
  }

  printf("%s is a %s.\n", musician->name, musician->role);
}

void destroy_musician(Musician *musician) {
  // Simplificación: solo liberamos la struct,
  // porque name y role no fueron reservados por separado.
  free(musician);
}

int main(void) {
  // En C, quien programa coordina ambos pasos explicitamente.
  Musician *musician = malloc_musician();
  if (musician == NULL) {
    fprintf(stderr, "Failed to allocate memory for musician.\n");
    return 1;
  }
  initialize_musician(musician, "Masashi Hamauzu", "Composer");

  printf("\nComplete path:\n");
  print_musician(musician);

  printf(
      "\nIn Scala, `new Musician(...)` performs creation and initialization\n");
  printf("in one language-level operation.\n");

  destroy_musician(musician);
  return 0;
}
