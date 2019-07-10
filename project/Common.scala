object Common {
  def version = "1.3.1"
  def playVersion = System.getProperty("play.version", "2.6.13")
  def scalaVersion =  "2.12.8"
  def scalaVersions =  Seq("2.11.12", "2.13.0", scalaVersion)
}
