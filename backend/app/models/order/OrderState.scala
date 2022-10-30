package models.order

import play.api.libs.json.{Format, Json}

object OrderState extends Enumeration {
  type OrderState = Value

  val placed = Value("Placed")
  val inDelivery = Value("InDelivery")

  implicit val orderStateFormat: Format[OrderState] = Json.formatEnum(this)
}