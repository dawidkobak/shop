package models.product

import play.api.libs.json.Json

case class Product(
  _id: String,
  name: String,
  categories: Seq[String],
  price: Double,
  image: String,
  description: String
)

object Product {
  implicit val newTodoListJson = Json.format[Product]
}