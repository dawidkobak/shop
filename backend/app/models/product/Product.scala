package models.product

import org.bson.types.ObjectId
import play.api.libs.json._

case class Product(
  _id: ObjectId,
  name: String,
  categories: Seq[String],
  price: Double,
  image: String,
  description: String
)

object Product {
  implicit val objectIdWriters: Writes[ObjectId] = Writes.StringWrites.contramap[ObjectId](_.toString)
  implicit val objectIdReads: Reads[ObjectId] = Reads.StringReads.map(new ObjectId(_))
  implicit val objectIdFormat: Format[ObjectId] = Format(objectIdReads, objectIdWriters)
  implicit val productFormat: Format[Product] = Json.format[Product]
}