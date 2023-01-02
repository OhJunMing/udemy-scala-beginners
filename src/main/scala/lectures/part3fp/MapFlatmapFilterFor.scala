package lectures.part3fp

object MapFlatmapFilterFor extends App {

  import java.util
  import java.util.stream.Collectors

  val number = util.Arrays.asList(2, 3, 4, 5)
  val square = number.stream.map((x) => x * x).collect(Collectors.toList)
  val square2 = number.stream.map((x) => x * x)

  /*
  https://www.javatpoint.com/flatmap-method-in-java-8
  Map Function
  Collections are list, arrays in java
  We always convert Collections to streams, e.g list1.stream()
  Can "ignore" stream, as stream do not change data structure
  Stream provide the lazy evaluation ability to lists
   We call .collect(Collectors.toList) to trigger the lazy evaluation of chained functions
  */

  /*
  Map Method
  <R> Stream<R> map(Function<? super T,? extends R> mapper)
  R: It is a type parameter that represents the element type of the new stream.
  The <R> in the method signature implies that the method will be dealing with generic type R.
  This is needed even if the method is returning void.

  List list1 = List list1.map(lambda function)
  Maps return value is Stream<R> = List<R>, no change
  Not required to know the inner workings of maps.
  It creates a resulting stream using the map().
  In each iteration, map() creates a separate stream with the result by executing the mapper function.
  At last, map() transforms all streams into a single stream.
  */

  /*
  The <T> in the method signature implies that the method will be dealing with generic type T.
  This is needed even if the method is returning void.
  As mentioned, the method can deal with more than one generic type. We must add all generic types to the method signature.
  Here is how we would modify the above method to deal with type T and type G:
  public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
      return Arrays.stream(a)
        .map(mapperFunction)
        .collect(Collectors.toList());
  }
  We're passing a function that converts an array with the elements of type T to list with elements of type G.
  Function<T, G> mapperFunction
  */


  println(number)
  println(square)
  println(square2)
  val list = List(1,2,3)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))
  println(list.filter(x => x % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  // print all combinations between two lists
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colors = List("black", "white")

  // List("a1", "a2"... "d4")

  // "iterating"
  val combinations = numbers.filter(_ % 2 == 0).flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations)


  // foreach
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color
  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  // syntax overload
  list.map { x =>
    x * 2
  }

  /*
    1.  MyList supports for comprehensions?
        map(f: A => B) => MyList[B]
        filter(p: A => Boolean) => MyList[A]
        flatMap(f: A => MyList[B]) => MyList[B]
    2.  A small collection of at most ONE element - Maybe[+T]
        - map, flatMap, filter
   */
}
