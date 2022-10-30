package models.payment

import play.api.libs.json._

object PaymentType extends Enumeration {
  type PaymentType = Value

  val cash = Value("Cash")
  val creditCard = Value("CreditCard")
  val payU = Value("PayU")

  implicit val paymentTypeFormat: Format[PaymentType] = Json.formatEnum(this)
}
