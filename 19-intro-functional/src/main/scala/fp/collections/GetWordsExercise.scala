package cl.uchile.dcc
package fp.collections

import scala.util.chaining.scalaUtilChainingOps

object GetWordsExercise:
  private def getWords(sentences: List[String]): List[String] =
    sentences
      .flatMap(_.split(" ")) // Dividimos cada oración en palabras
      .filter(_.nonEmpty) // Filtramos las cadenas vacías resultantes

  @main def runGetWords(): Unit =
    getWords(
        List(
            "Time is an ocean",
            "in a storm.",
            ""
        )
    ) // ["Time", "is", "an", "ocean", "in", "a", "storm."]
      .tap(println): Unit
