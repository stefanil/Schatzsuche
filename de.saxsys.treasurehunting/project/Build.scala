import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "treasurehunting"
  val appVersion      = "0.1-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean
  )
  
  val common = play.Project(
    appName + "-common", appVersion, appDependencies, path = file("modules/de.saxsys.treasurehunting.common")
  ).settings(
      // none
  )
  
  val game = play.Project(
    appName + "-game", appVersion, appDependencies, path = file("modules/de.saxsys.treasurehunting.game")
  ).settings( 
	  // none 
  ).dependsOn(
      common
  ).aggregate(
      common 
  )

  val admin = play.Project(
    appName + "-admin", appVersion, appDependencies, path = file("modules/de.saxsys.treasurehunting.admin")
  ).settings(   
      // none
  ).dependsOn(
      common
  ).aggregate(
      common 
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
      
    // prevent from forking tests (Debug Tests via IDE)
    sbt.Keys.fork in Test := false
      
  ).dependsOn(
      game, admin
  ).aggregate(
      game, admin
  )

}
