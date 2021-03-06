import sbt._, Keys._
import com.typesafe.sbteclipse.core.EclipsePlugin._

object Build extends sbt.Build {
  object config {
    val scala = "2.11.6"
  }

  def common = Seq(
    scalaVersion := config.scala,
    scalacOptions ++=  Seq(
      "-deprecation",
      "-encoding", "UTF-8",
      "-feature",
      "-language:_",
      "-unchecked",
      "-Xlint",
      "-Xfuture",
      "-Yno-adapted-args",
      "-Ywarn-dead-code",
      "-Ywarn-numeric-widen",
      "-Ywarn-unused-import",
      "-Ywarn-unused"
    ),
    resolvers ++= Seq(
      "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/releases"
    ),
    libraryDependencies ++= Seq(
      "org.scala-stm" %% "scala-stm" % "0.7",
      "junit" % "junit" % "4.12" % "test",
      "com.storm-enroute" %% "scalameter" % "0.6" % "test"
    ),
    EclipseKeys.withSource := true,
    initialCommands in console := """
    """
  )

  lazy val `rf-core` = Project("rf-core", file("rf-core"))
    .settings(common: _*)
    .settings(name := "rf-core", version := "0.1-SNAPSHOT")

}
