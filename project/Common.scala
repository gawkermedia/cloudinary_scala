object Common {
  def version = "1.3.0"
  def playVersion = System.getProperty("play.version", "2.6.13")
  def scalaVersion =  "2.12.6"
  def scalaVersions =  Seq("2.11.8", scalaVersion)
}
