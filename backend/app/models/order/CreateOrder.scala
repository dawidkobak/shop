package models.order

import models.client.Client
import models.payment.PaymentType.PaymentType
import play.api.libs.json.{Json, OFormat}

case class CreateOrder(
  client: Client,
  items: Iterable[OrderItem],
  paymentType: PaymentType
)

object CreateOrder {
  implicit val format: OFormat[CreateOrder] = Json.format[CreateOrder]
}
