//import com.typesafe.sbt.SbtAspectj._

name := """kamon-play"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

dockerExposedPorts := Seq(9000)

val kamonVersion = "0.5.1"

libraryDependencies ++= Seq(
  "io.kamon" %% "kamon-core" % kamonVersion,
  //"io.kamon" %% "kamon-akka" % kamonVersion,
  "io.kamon" %% "kamon-play-24" % kamonVersion,
  "io.kamon" %% "kamon-statsd" % kamonVersion,
  "io.kamon" %% "kamon-log-reporter" % kamonVersion,
  "io.kamon" %% "kamon-system-metrics" % kamonVersion,
  "org.aspectj" % "aspectjweaver" % "1.8.7",
  jdbc,
  cache,
  ws,
  specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

//javaOptions in run += "-Xset:weaveJavaxPackages=true -Dapplication.config=config/application.config"
//aspectjSettings

//javaOptions in run <++= AspectjKeys.weaverOptions in Aspectj
//javaOptions in run += "-Xset:weaveJavaxPackages=true"
