/**
  * Created by oleg.iermilov on 6/1/2017.
  */
import java.sql.DriverManager
import java.sql.Connection
//Incorrect way to read data from sql, no functional programming using Java API
case class EmployeesCommission(first_name: String,
                              last_name: String,
                              salary: Double,
                              commission_pct: Float) {
  override def toString:String = {
    "first name: "+ first_name + ", last_name: " + last_name + ", salary: " + salary + ", commission_pct: " +
      commission_pct + "; commission amount: " + getCommissionAmount()
  }

  def getCommissionAmount(): Any = {
    if (commission_pct > 0) return salary * commission_pct
    "Not eligible"
  }
}

object ComissionAmount {

  def main(args: Array[String]): Unit = {
    val driver = "com.mysql.jdbc.Driver" // class path to the driver
    val url = "jdbc:mysql://nn01.itversity.com:3306/hr"
    val username = "hr_ro"
    val password = "itversity"

    Class.forName(driver)
    val connection = DriverManager.getConnection(url,username,password)
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery(s"SELECT first_name, last_name, salary, commission_pct " +
      s"FROM employees")

    while (resultSet.next()) {
      println(EmployeesCommission(resultSet.getString("first_name"),
        resultSet.getString("last_name"),
        resultSet.getDouble("salary"),
        resultSet.getFloat("commission_pct")))
    }
  }
}
