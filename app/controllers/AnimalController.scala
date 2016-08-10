package controllers

import javax.inject._
import data.Tables._
import com.google.inject.Singleton
import play.api.mvc._
import slick.driver.MySQLDriver.api._
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps

/**
  * Created by richardpianka on 8/9/16.
  */
@Singleton
class AnimalController @Inject() extends Controller {

  def animalById(id: Int) = Action {

    val db = Database.forURL(
      url = "jdbc:mysql://animals-cluster.cluster-crw8ngxc2vao.us-east-1.rds.amazonaws.com:3306/animals",
      user = "admin",
      password = "password",
      driver = "com.mysql.jdbc.Driver"
    )

    val q = for {
      a <- Animals if a.animalid === id
      s <- Species if s.speciesid === a.speciesid
    } yield a.name

    Await.result(db.run(q.result).map { result =>
      Ok(result.head)
    }, 60 seconds)
  }
}
