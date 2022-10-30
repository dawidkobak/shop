package models.order

import models.client.Client
import models.payment.PaymentType
import models.shipment.ShipmentType
import org.mongodb.scala.bson.ObjectId
import play.api.libs.json.{Format, Json}

case class Order(
  _id: ObjectId,
  client: Client,
  items: Seq[OrderItem],
  notes: Option[String] = None,
  paymentType: PaymentType,
  state: OrderState,
  shipmentType: ShipmentType
) {
}

object Order {
  import models.product.Product._
  implicit val orderFormat: Format[Order] = Json.format[Order]
}