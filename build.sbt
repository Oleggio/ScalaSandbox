name := "ScalaSandbox"

version := "1.0"

scalaVersion := "2.10.6"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.36"
// Documentation is on GigtHub
libraryDependencies += "com.typesafe" % "config" % "1.3.1"

libraryDependencies += "org.apache.spark" % "spark-core_2.10" % "1.6.0"