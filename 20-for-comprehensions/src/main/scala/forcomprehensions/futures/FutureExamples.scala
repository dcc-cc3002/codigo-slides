package cl.uchile.dcc
package forcomprehensions.futures

/** Future muy simplificado con operaciones para for. */
trait Future[+T]:
  self =>
  def get: T

  def map[U](f: T => U): Future[U] =
    new ImmediateFuture(f(get))

  def flatMap[U](f: T => Future[U]): Future[U] =
    f(get)

  def foreach[U](f: T => U): Unit = {
    f(get)
    ()
  }

  def withFilter(p: T => Boolean): Future[T] =
    if p(get) then this
    else
      new ImmediateFuture(
          throw new NoSuchElementException("Future predicate failed")
      )

  def onSuccess[U](callback: T => U): U =
    callback(get)

/** Future que ya tiene el valor disponible. */
class ImmediateFuture[T](val value: T) extends Future[T]:
  def get: T = value

case class User(id: Int, email: String)
case class Order(id: Int, productIds: List[Int])
case class Product(id: Int, name: String)
case class Stock(productId: Int, quantity: Int)

/** Funciones dummy que devuelven futures inmediatamente llenos. */
def getUserById(id: Int): Future[User] =
  new ImmediateFuture(User(id, s"user$id@example.com"))

def getOrdersForUser(email: String): Future[List[Order]] =
  new ImmediateFuture(List(Order(1, List(10, 11)), Order(2, List(12))))

def getProductsForOrders(orders: List[Order]): Future[List[Product]] =
  val pids = for
    order <- orders
    pid <- order.productIds
  yield pid
  new ImmediateFuture(
      for pid <- pids.distinct
      yield Product(pid, s"Product-$pid")
  )

def getStockForProducts(products: List[Product]): Future[List[Stock]] =
  new ImmediateFuture(products.map(p => Stock(p.id, 42)))

/** Versión con callbacks anidados (callback hell). */
def nestedCallbacksExample(id: Int): Unit =
  getUserById(id).onSuccess(user =>
    getOrdersForUser(user.email).onSuccess(orders =>
      getProductsForOrders(orders).onSuccess(products =>
        getStockForProducts(products).onSuccess(stock =>
          println(s"Stock for products: $stock")
        )
      )
    )
  )

/** Misma lógica pero usando for-comprehension. */
def composedFutureStock(id: Int): Future[List[Stock]] =
  for
    user <- getUserById(id)
    orders <- getOrdersForUser(user.email)
    products <- getProductsForOrders(orders)
    stock <- getStockForProducts(products)
  yield stock

@main def futuresRunner(): Unit =
  println("--- nested callbacks ---")
  nestedCallbacksExample(1)

  println("--- for-comprehension over Future ---")
  val result = composedFutureStock(1).get
  println(s"Composed stock: $result")
