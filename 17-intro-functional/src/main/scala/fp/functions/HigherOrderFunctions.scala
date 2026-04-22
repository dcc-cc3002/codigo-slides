package cl.uchile.dcc
package fp.functions

object HigherOrderFunctions:

  /** Recibe funciones como argumentos y devuelve una nueva función. */
  private def compose[A, B, C](f: B => C, g: A => B): A => C =
    (x: A) => f(g(x)) // Retornamos una lambda que aplica primero g y luego f

  @main def hofExample(): Unit =
    // Funciones simples que usaremos para construir un pipeline
    val parse: String => Int = s => s.toInt
    val double: Int => Double = x => x * 2.0
    val stringify: Double => String = d => s"Result: $d"
  
    // compose aplica primero g, luego f
    val pipeline: String => String = compose(stringify, compose(double, parse))
  
    // Ejemplo de uso del pipeline completo
    val result: String = pipeline("21") // "Result: 42.0"
    
    println(result)
