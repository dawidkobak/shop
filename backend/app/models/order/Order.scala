package models.order

import models.client.Client
import models.order.OrderState.OrderState
import models.payment.PaymentType.PaymentType
import models.shipment.ShipmentType.ShipmentType
import org.mongodb.scala.bson.ObjectId
import play.api.libs.json.{Format, Json}

case class Order(
  _id: ObjectId,
  client: Client,
  items: Iterable[OrderItem],
  state: OrderState,
  paymentType: PaymentType,
  shipmentType: ShipmentType
) {
}

object Order {
  import models.product.Product._
  implicit val orderFormat: Format[Order] = Json.format[Order]
}