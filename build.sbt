name := "MyFWJGLGame"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= {
  val version = "3.1.6"
  val os = "linux" // TODO: Change to "linux" or "mac" if necessary

  Seq(
    "lwjgl",
    "lwjgl-glfw",
    "lwjgl-opengl"
    // TODO: Add more modules here
  ).flatMap {
    module => {
      Seq(
        "org.lwjgl" % module % version,
        "org.lwjgl" % module % version classifier s"natives-$os"
      )
    }
  }
}

libraryDependencies += "com.typesafe.slick" %% "slick" % "3.2.3"

libraryDependencies += "org.scalamock" %% "scalamock" % "4.1.0" % Test
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"

libraryDependencies += "org.seleniumhq.selenium" % "selenium-java" % "2.35.0" % "test"
