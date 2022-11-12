package models.order

import models.client.Client
import models.payment.PaymentType
import play.api.libs.json.{Json, OFormat}

case class CreateOrder(
  client: Client,
  items: Seq[OrderItem],
  notes: Option[String],
  paymentType: PaymentType
)

object CreateOrder {
  implicit val format: OFormat[CreateOrder] = Json.format[CreateOrder]
}
