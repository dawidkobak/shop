package models.shipment

import play.api.libs.json._
import scala.collection.Seq

sealed trait ShipmentType

object ShipmentType {
  case object Delivery extends ShipmentType

  case object InStore extends ShipmentType

  def values: Seq[ShipmentType] = Seq(Delivery, InStore)

  implicit val shipmentTypeFormat: Format[ShipmentType] = Format(
    {
      case JsString(str) =>
        values.find(_.toString == str)
          .map(JsSuccess(_))
          .getOrElse(JsError(Seq(JsPath -> Seq(JsonValidationError("error.expected.validenumvalue")))))
      case _ => JsError(Seq(JsPath -> Seq(JsonValidationError("error.expected.enumstring"))))
    },
    (value: ShipmentType) => JsString(value.toString)
  )
}