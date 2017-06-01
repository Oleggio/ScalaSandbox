/**
  * Created by oleg.iermilov on 5/31/2017.
  */
class Time(hours: Int, minutes: Int, seconds: Int) {

  require(hours >= 0 && hours <= 24, "Invalid time")
  require(minutes >= 0 && minutes <= 60, "Invalid time")
  require(seconds >= 0 && seconds <= 60, "Invalid time")

  def minutesOfDay(): Int = {
    hours * 60 + minutes
  }

  def apply(hours: Int, minutes: Int, seconds: Int): Unit = {
    print("In apply method")
  }

  println("Time: " + hours + ":" + minutes + ":" + seconds)
}

//Companion object
object Time {
  def main(args: Array[String]): Unit = {
    println("Companion object")
  }

  def apply(hours: Int, minutes: Int, seconds: Int): Unit = {
    new Time(hours, minutes, seconds)
  }
}
