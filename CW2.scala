object cw2 {

  def Zad1(day: String): String = day.toLowerCase match  {
    case "poniedziałek" => "praca"
    case "wtorek" => "praca"
    case "środa" => "praca"
    case "czwartek" => "praca"
    case "piątek" => "praca"
    case "sobota" => "Weekend"
    case "niedziela" => "Weekend"
    case _ => "nie ma takiego dnia"
  }

  class KontoBankowe(stanP:Double) {
    def this() {
      this(0.0)
    }
    private var stanKonta = stanP
    def stan = stanKonta
    def wplata(wartosc:Double)= this.stanKonta+=wartosc
    def wyplata(wartosc:Double)= this.stanKonta-=wartosc
  }

  class Osoba(val imie:String, val nazwisko:String)
  val osoba1 = new Osoba("Jan","Nowak")
  val osoba2 = new  Osoba("Robert", "Lewandowski")
  val osoba3 = new Osoba("Filip", "Palak")
  def Hello(osoba: Osoba): String = osoba.nazwisko match {
    case "Nowak" => "Witaj, Janie Nowaku."
    case "Lewandowski" => "Siema Robert!"
    case "Palak" => "Dzień dobry Filipie."
    case _ => "Nie znam cię"
  }

  def cal(liczba:Int): Int = liczba*2
  def Zad4(liczba:Int, fun: Int => Int)= fun(fun(fun(liczba)))

  class Osoba2(val imie:String, val nazwisko:String, val podatek:Double)
  


  def main(args:Array[String]) : Unit = {
    println("Zad1")
    println(Zad1("poniedziałek"), Zad1("wtorek"), Zad1("niedziela"), Zad1("abc"))
    println("Zad2")
    var k1 = new KontoBankowe()
    println(k1.stan)
    k1.wplata(10.0)
    println(k1.stan)
    k1.wyplata(5.0)
    println(k1.stan)
    var k2 = new KontoBankowe(20.0)
    println(k2.stan)
    println("Zad3")
    println(Hello(osoba1))
    println(Hello(osoba2))
    println(Hello(osoba3))
    val osoba4= new Osoba("Krzysztof", "Koda")
    println(Hello(osoba4))
    println("Zad4")
    println(Zad4(2,cal))

  }
}
