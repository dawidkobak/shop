name := """shop"""
organization := "com.dawid"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.10"

libraryDependencies += guice
libraryDependencies += "com.lihaoyi" %% "os-lib" % "0.8.1"
libraryDependencies += "com.free2move" %% "geo-scala-polyline" % "0.2.0"
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "4.7.1"

