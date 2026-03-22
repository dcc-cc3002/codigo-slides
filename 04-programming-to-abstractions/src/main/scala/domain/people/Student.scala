package cl.uchile.dcc
package domain.people

import java.time.LocalDate

// Este ejemplo muestra constructores auxiliares:
// delegan al constructor primario y la llamada a this(...)
// debe ser la primera instruccion.
class Student(val name: String,
              val id: String,
              val enrollmentDate: LocalDate
):
  // Usa la fecha actual cuando no se entrega una explicitamente.
  def this(name: String, id: String) =
    this(name, id, LocalDate.now())
    println("[INFO] Enrollment date defaulted to today.")

  // Genera un identificador basico a partir del nombre.
  def this(name: String) =
    this(name, name.take(3).toUpperCase + "-000")
    println(s"[INFO] Generated ID from name.")

@main def duelAcademy(): Unit =
  val students = List(
      // Full constructor with custom ID and date
      new Student("Johan Andersen",
                  "CRY-777",
                  LocalDate.parse("2005-04-01")
      ),
      // Constructor with ID, uses current date
      new Student("Yuki Judai", "HRO-001"),
      // Generates ID from name, uses current date
      new Student("Tenjoin Asuka")
  )
  for student <- students do
    println(
        s"Student: ${student.name}, " +
          s"ID: ${student.id}, " +
          s"Enrollment Date: ${student.enrollmentDate}"
    )
