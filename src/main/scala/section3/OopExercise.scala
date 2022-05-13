package section3

object OopExercise extends App {

    trait MyPredicate[-T] {
        def test(e: T): Boolean = ???
    }

    trait MyTransformer[-A, B] {
        def transform(e: A): B = ???
    }

    class EventPredicate extends MyPredicate[Int] {}
    class StringToIntTransformer extends MyTransformer[String, Int] {}

    abstract class MyList[+A] {
        def head: A 
        def tail: MyList[A]
        def isEmpty: Boolean
        def add[B >: A](element: B): MyList[B]
        def printElements: String
        override def toString: String = "["+printElements+"]"
        def map[B](transformer: MyTransformer[A, B]): MyList[B]
        def filter(predicate: MyPredicate[A]): MyList[A]
        def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
        // concat
        def ++[B >: A](list: MyList[B]): MyList[B]
    }

    object Empty extends MyList[Nothing] {
        def head: Nothing = throw new NoSuchElementException
        def tail: MyList[Nothing] = throw new NoSuchElementException
        def isEmpty: Boolean = true
        def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
        def printElements: String = ""
        def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
        def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
        def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
        def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
    }

    class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
        def head: A = h
        def tail: MyList[A] = t
        def isEmpty: Boolean = false
        def add[B >: A](element: B): MyList[B] = new Cons(element, this)
        def printElements: String = {
            if (t.isEmpty) "" + h
            else h + " " + t.printElements
        }
        def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
            new Cons(transformer.transform(h), t.map(transformer))
        }
        def filter(predicate: MyPredicate[A]): MyList[A] = {
            if (predicate.test(h)) new Cons(h, t.filter(predicate))
            else t.filter(predicate)
        }
        def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
            transformer.transform(h) ++ t.flatMap(transformer)
        }
        def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
    }

    val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
    val listV2 = new Cons(4, new Cons(5, Empty))

    println(list.map(new MyTransformer[Int, Int]{
        override def transform(elem: Int): Int = elem * 2
    }).toString)
    println(list.filter(new MyPredicate[Int]{
        override def test(elem: Int): Boolean = elem % 2 == 0
    }).toString)
    println(list ++ listV2)
    println(list.flatMap(new MyTransformer[Int, MyList[Int]]{
        override def transform(e: Int): MyList[Int] = {
            new Cons(e, new Cons(e + 1, Empty))
        }
    }).toString)

}