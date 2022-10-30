package models.order

import play.api.libs.json._

import scala.collection.Seq

sealed trait OrderState

object OrderState {

  case object Placed extends OrderState
  case object InDelivery extends OrderState

  def values: Seq[OrderState] = Seq(Placed, InDelivery)

  implicit val orderStateFormat: Format[OrderState] = Format(
    {
      case JsString(str) =>
        values.find(_.toString == str)
          .map(JsSuccess(_))
          .getOrElse(JsError(Seq(JsPath -> Seq(JsonValidationError("error.expected.validenumvalue")))))
      case _ => JsError(Seq(JsPath -> Seq(JsonValidationError("error.expected.enumstring"))))
    },
    (value: OrderState) => JsString(value.toString)
  )
}