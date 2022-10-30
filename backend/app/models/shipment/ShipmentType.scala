package models.shipment

import play.api.libs.json._

object ShipmentType extends Enumeration {

  type ShipmentType = Value

  val delivery = Value("Delivery")
  val inStore = Value("InStore")

  implicit val shipmentTypeFormat: Format[ShipmentType] = Json.formatEnum(this)
}