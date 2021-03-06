name := """eigenroute-publish-subscribe-rabbitmq"""

version := "0.0.8"
organization := "com.eigenroute"

scalaVersion := "2.11.7"
val opRabbitVersion = "1.6.0"

resolvers ++= Seq(
  // "Eigenroute maven repo" at "http://mavenrepo.eigenroute.com/",
  "SpinGo OSS" at "http://spingo-oss.s3.amazonaws.com/repositories/releases"
)

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  "com.eigenroute" % "eigenroute-messagebroker-message_2.11" % "0.0.4",
  "com.eigenroute" % "eigenroute-publish-subscribe-trait_2.11" % "0.0.1",
  "ch.qos.logback" % "logback-classic" % "1.1.7",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
  "com.spingo" %% "op-rabbit-core"        % opRabbitVersion,
  "com.spingo" %% "op-rabbit-play-json"   % opRabbitVersion,
  "com.spingo" %% "op-rabbit-akka-stream" % opRabbitVersion,
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

publishMavenStyle := true
val resolver = Resolver.ssh("Eigenroute maven repo", "mavenrepo.eigenroute.com", 7835, "/home/mavenrepo/repo") withPermissions "0644"
publishTo := Some(resolver as ("mavenrepo", Path.userHome / ".ssh" / "id_rsa"))

publishArtifact in packageSrc := false

publishArtifact in packageDoc := false


