"""
Equivalente en Python del ejemplo de `SubtypePolymorphism.scala`.

La idea pedagogica es contrastar ambos lenguajes:
- En Scala, `foo(d: Duck)` exige un subtipo explicito de `Duck`.
- En Python, `foo(o: Duck)` es solo una anotacion de tipo.
  El interprete no obliga a que el argumento sea instancia de `Duck`.

Si el objeto tiene los metodos correctos, el programa puede funcionar
igual en tiempo de ejecucion, aunque no exista una relacion de herencia.
"""


class Duck:
    def m1(self) -> None:
        print("Duck.m1")

    def m2(self) -> int:
        return 7

    def m3(self) -> str:
        return "quack"


class Witch:
    def m1(self) -> None:
        print("Witch.m1")

    def m2(self) -> int:
        return 13

    def m3(self) -> str:
        return "spell"


def foo(obj: Duck) -> str:
    """La anotacion dice 'Duck', pero Python no la hace cumplir."""
    obj.m1()
    return f"{obj.m2()} - {obj.m3()}"


def main() -> None:
    duck = Duck()
    witch = Witch()

    print(f"foo(duck) = {foo(duck)}")
    print(f"isinstance(witch, Duck) = {isinstance(witch, Duck)}")
    print(f"foo(witch) = {foo(witch)}")
    print("La llamada anterior funciona aunque Witch no herede de Duck.")
    print("Las anotaciones ayudan a documentar o a herramientas externas,")
    print("pero no introducen polimorfismo explicito por si solas.")


if __name__ == "__main__":
    main()
