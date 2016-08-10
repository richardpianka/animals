package controllers

import javax.inject._
import com.wordnik.swagger.annotations.{Api, ApiOperation}
import contracts.{Animal, AnimalList}
import data.Tables._
import com.google.inject.Singleton
import play.api.libs.json.Json
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
@Api(value = "/api/todos", description = "Operations with Todos")
class AnimalController @Inject() extends Controller {

  @ApiOperation(value = "Get all animals",
    notes = "Returns list of all animals",
    response = classOf[AnimalList],
    httpMethod = "GET"
  )
  def animals = Action {

    val db = Database.forURL(
      url = "jdbc:mysql://animals-cluster.cluster-crw8ngxc2vao.us-east-1.rds.amazonaws.com:3306/animals",
      user = "admin",
      password = "password",
      driver = "com.mysql.jdbc.Driver"
    )

    val q = for {
      a <- Animals
    } yield {
      a
    }

    Await.result(db.run(q.result).map { result =>
      val animals = result.map { animal =>
        Animal(
          animalId = Some(animal.animalid),
          name = animal.name,
          speciesId = animal.speciesid
        )
      }

      val animalList =
        AnimalList(
          animals = animals.toList
        )

      Ok(
        Json.toJson(animalList)
      )
    }, 60 seconds)
  }

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
