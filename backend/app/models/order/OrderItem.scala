package models.order

import models.product.Product
import play.api.libs.json.{Format, Json}

case class OrderItem(
  product: Product,
  quantity: Int
)

object OrderItem {
  implicit val orderItemFormat: Format[OrderItem] = Json.format[OrderItem]
}
