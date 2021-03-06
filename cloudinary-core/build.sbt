import sbt._
import Keys._

organization := "com.kinja"

version := Common.version

scalaVersion := Common.scalaVersion

crossScalaVersions := Common.scalaVersions

name := "cloudinary-core-scala"

pomExtra := {
  <url>http://cloudinary.com</url>
  <licenses>
    <license>
      <name>MIT</name>
      <url>http://opensource.org/licenses/MIT</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <connection>scm:git:github.com/cloudinary/cloudinary_scala.git</connection>
    <developerConnection>scm:git:github.com/cloudinary/cloudinary_scala.git</developerConnection>
    <url>github.com/cloudinary/cloudinary_scala.git</url>
  </scm>
  <developers>
     <developer>
        <id>cloudinary</id>
        <name>Cloudinary</name>
        <email>info@cloudinary.com</email>
    </developer>
  </developers>
}  
  
libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "1.2.0",
  "com.ning" % "async-http-client" % "1.9.40",
  "org.json4s" %% "json4s-native" % "3.6.7",
  "org.json4s" %% "json4s-ext" % "3.6.7",
  "org.scalatest" %% "scalatest" % "3.0.8" % "test",
  "org.nanohttpd" % "nanohttpd" % "2.3.1" % "test")

// http://mvnrepository.com/artifact/org.slf4j/slf4j-simple
libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.25" % "test"
libraryDependencies += "org.scalamock" %% "scalamock" % "4.3.0" % "test"
resolvers ++= Seq("sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots", "sonatype releases" at "https://oss.sonatype.org/content/repositories/releases")

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

credentials ++= Seq(Credentials(Path.userHome / ".ivy2" / ".kinja-artifactory.credentials"))

publishTo := (
  if (version.value endsWith "SNAPSHOT") Some("Kinja Snapshots" at sys.env.get("KINJA_SNAPSHOTS_REPO").getOrElse("https://kinjajfrog.jfrog.io/kinjajfrog/kinja-local-snapshots/"))
  else Some("Kinja Releases" at sys.env.get("KINJA_RELEASES_REPO").getOrElse("https://kinjajfrog.jfrog.io/kinjajfrog/kinja-local-releases/"))
)
