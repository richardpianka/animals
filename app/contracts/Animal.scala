package contracts

import play.api.libs.json.Json

/**
  * Created by richardpianka on 8/9/16.
  */
case class Animal(
  animalId: Option[Int],
  name: String,
  speciesId: Int
)

object Animal {
  implicit val writes = Json.writes[Animal]
  implicit val reads = Json.reads[Animal]
}