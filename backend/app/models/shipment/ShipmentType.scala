package models.shipment

import play.api.libs.json._
import utils.CodecUtils

sealed trait ShipmentType

object ShipmentType {
  case object Delivery extends ShipmentType
  case object InStore extends ShipmentType

  def values: Seq[ShipmentType] = Seq(Delivery, InStore)

  implicit val shipmentTypeFormat: Format[ShipmentType] = CodecUtils.generateCodec(values)
}