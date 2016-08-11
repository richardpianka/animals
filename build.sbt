name := "animals"

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "com.typesafe.slick" %% "slick" % "3.1.1",
  "com.typesafe.slick" %% "slick-codegen" % "3.1.1",
  "mysql" % "mysql-connector-java" % "5.1.39",
  //"com.wordnik" %% "swagger-play2" % "1.3.12",
  "io.swagger" %% "swagger-play2" % "1.5.2",
  "org.webjars" % "swagger-ui" % "2.1.8-M1"
  /*"org.reflections" % "reflections" % "0.9.8" notTransitive ()*/
)

//dependencyOverrides += "com.typesafe.play" %% "play-netty-server" % "2.4.6"

//dependencyOverrides +=  "com.typesafe.play" %% "play-server" % "2.4.6"


resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

routesGenerator := InjectedRoutesGenerator