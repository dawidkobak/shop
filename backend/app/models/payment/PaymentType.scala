package models.payment

import play.api.libs.json._
import utils.CodecUtils

sealed trait PaymentType

object PaymentType {

  case object Cash extends PaymentType
  case object CreditCard extends PaymentType
  case object PayU extends PaymentType

  def values: Seq[PaymentType] = Seq(Cash, CreditCard, PayU)

  implicit val paymentTypeFormat: Format[PaymentType] = CodecUtils.generateCodec(values)
}
