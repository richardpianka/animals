package contracts

import play.api.libs.json.Json

/**
  * Created by richardpianka on 8/9/16.
  */
case class AnimalList(
  animals: List[Animal]
)

object AnimalList {
  implicit val writes = Json.writes[AnimalList]
  implicit val reads = Json.reads[AnimalList]
}