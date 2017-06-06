/**
  * Created by oleg.iermilov on 6/1/2017.
  */
import java.sql.DriverManager
import java.sql.Connection
import com.typesafe.config._

case class EmployeesCommission(first_name: String,
                              last_name: String,
                              salary: Double,
                              commission_pct: Float) {
  override def toString:String = {
    "first name: "+ first_name + ", last_name: " + last_name + ", salary: " + salary + ", commission_pct: " +
      commission_pct + "; commission amount: " + getCommissionAmount
  }

  def getCommissionAmount: Any = {
    if (commission_pct > 0) return salary * commission_pct
    "Not eligible"
  }
}

//pass dev for dev config
object ComissionAmount {

  def main(args: Array[String]): Unit = {

    val props = ConfigFactory.load()
    val driver = "com.mysql.jdbc.Driver" // class path to the driver
    var host = props.getConfig(args(0)).getString("host")
    var port = props.getConfig(args(0)).getString("port")
    var db = props.getConfig(args(0)).getString("db")
    val url = "jdbc:mysql://" + host + ":" + port + "/" + db
    val username = props.getConfig(args(0)).getString("user")
    val password = props.getConfig(args(0)).getString("pw")

    Class.forName(driver) //Initialize class by name
    val connection = DriverManager.getConnection(url,username,password)
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery(s"SELECT first_name, last_name, salary, commission_pct " +
      s"FROM employees")

    Iterator.continually((resultSet, resultSet.next)).
      takeWhile(rec => rec._2). //takeWhile (_._2) - also eligible
      map(_._1).map(rec => {
      EmployeesCommission(rec.getString("first_name"),
        rec.getString("last_name"),
        rec.getDouble("salary"),
        rec.getFloat("commission_pct"))
    }).foreach(rec => {
      println(rec)
    })

//Incorrect way to read data from sql, no functional programming using Java API
//    while (resultSet.next()) {
//      println(EmployeesCommission(resultSet.getString("first_name"),
//        resultSet.getString("last_name"),
//        resultSet.getDouble("salary"),
//        resultSet.getFloat("commission_pct")))
//    }
  }
}
