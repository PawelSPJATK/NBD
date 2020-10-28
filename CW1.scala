import scala.annotation.tailrec
import scala.math.abs

object test {
  val days = List("Poniedzialek", "Wtorek", "Sroda", "Czwartek", "Piatek", "Sobota", "Niedziela")
  val products: Map[String, Double] = Map("product1" -> 20.0, "product2" -> 340.0, "product3" -> 2000.0)
  val numbers: List[Int] = List(1,4,0,6,3,0,2,10,4,0,-5,-7,-3,0,1)
  val numbers2:List[Double] = List(1.0,3.0,-12.0,-1.0,40.0,-20.0,12.0)
  var tempList = List[String]()

  def Zad1a(daysArray: List[String]) = {
    for (i <- daysArray) {
    tempList = tempList:::List(i)
  }
    print(tempList.mkString(", "))
  }

  def Zad1b(daysArray: List[String]) = {
    for (i <- daysArray if i(0)=='P') {
      tempList = tempList:::List(i)
    }
    print(tempList.mkString(", "))
    }


  def Zad1c(daysArray: List[String]) = {
    while(false)
      {
        //nie wiem jak sensownie użyć while. Utworzyć iterator i liczyć do długości listy? Trochę się z celem mija.
      }
    print(daysArray.mkString(", "))
  }

  def Zad2a(daysArray: List[String])={
    def Recc(list:List[String], joined:String, delimiter:String=", ") : String = {
      if (list.isEmpty) joined
      else Recc(list.tail, joined + delimiter + list.head)
    }
    print(Recc(daysArray.tail, daysArray.head))
  }

  def Zad2b(daysArray: List[String])={
    def Recc(list:List[String], joined:String, delimiter:String=", ") : String = {
      if (list.isEmpty) joined
      else Recc(list.tail, joined + delimiter + list.head)
    }
    print(Recc(daysArray.reverse.tail, daysArray.reverse.head))
  }

  def Zad3(daysArray: List[String])={
    @tailrec
    def Recc(list:List[String], joined:String, delimiter:String=", ") : String = {
      if (list.isEmpty) joined
      else Recc(list.tail, joined + delimiter + list.head)
    }
    print(Recc(daysArray.tail, daysArray.head))
  }

  def Zad4a(daysArray:List[String], delimiter:String = ", ")  = print(daysArray.tail.foldLeft(daysArray.head) (_+delimiter +_))

  def Zad4b(daysArray:List[String], delimiter:String = ", ")  = print(daysArray.dropRight(1).foldRight(daysArray.last) (_+delimiter +_))

  def Zad5(map: Map[String, Double], percentage: Double=0.1) = print(map.view.mapValues(value => value - value * percentage).toMap)

  def Zad6(tuple: (String, Int, Boolean))= print("String: " + tuple._1 + ", Int: " + tuple._2 + ", Boolean: " + tuple._3)

  def Zad7(map: Map[String, Double], productName: String) = print(map.get(productName))

  def Zad8(list: List[Int]): List[Int] = {
    @tailrec
    def iter(numbersList: List[Int], result: List[Int]): List[Int] = {
      if (numbersList.isEmpty) result
      else if (numbersList.head != 0) {
        iter(numbersList.tail, result.appended(numbersList.head))
      } else {
        iter(numbersList.tail, result)
      }
    }

    iter(list, List())
  }

  def Zad9(list: List[Int]): List[Int] = {
    list.map(element => element + 1)
  }

  def Zad10(list: List[Double]): List[Double] = {
    list.filter(element => element < 12)
      .filter(element => element > -5)
      .map(element => abs(element))
  }

  def main(args:Array[String]) : Unit = {
    Zad1a(days)
    Zad1b(days)
    Zad1c(days)
    Zad2a(days)
    Zad2b(days)
    Zad3(days)
    Zad4a(days)
    Zad4b(days)
    Zad5(products)
    Zad6(("abc", 1,true))
    Zad7(products, "product1")
    print(Zad8(numbers))
    print(Zad9(numbers))
    print(Zad10(numbers2))
  }
}
