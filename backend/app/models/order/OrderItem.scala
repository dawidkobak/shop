package models.order

import play.api.libs.json.{Format, Json}

case class OrderItem(
  productId: String,
  quantity: Int
)

object OrderItem {
  implicit val orderItemFormat: Format[OrderItem] = Json.format[OrderItem]
}
