/**
  * Created by oleg.iermilov on 6/14/2017.
  */

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object wordcount {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Testing").setMaster("local")
    val sc = new SparkContext(conf)

    sc.textFile("wordcount.txt").flatMap(_ split(" ")).filter(_.length > 0).map((_,1)).reduceByKey(_+_).sortByKey().foreach(println)
  }
}
