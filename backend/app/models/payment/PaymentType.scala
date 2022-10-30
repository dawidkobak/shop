package models.payment

import play.api.libs.json._

import scala.collection.Seq

sealed trait PaymentType

object PaymentType {

  case object Cash extends PaymentType
  case object CreditCard extends PaymentType
  case object PayU extends PaymentType

  def values: Seq[PaymentType] = Seq(Cash, CreditCard, PayU)

  implicit val paymentTypeFormat: Format[PaymentType] = Format(
    {
      case JsString(str) =>
        values.find(_.toString == str)
          .map(JsSuccess(_))
          .getOrElse(JsError(Seq(JsPath -> Seq(JsonValidationError("error.expected.validenumvalue")))))
      case _ => JsError(Seq(JsPath -> Seq(JsonValidationError("error.expected.enumstring"))))
    },
    (value: PaymentType) => JsString(value.toString)
  )
}
