package handlers

import models.order.{CreateOrder, Order, OrderState}
import models.payment.PaymentType
import models.shipment.ShipmentType
import org.mongodb.scala.bson.ObjectId
import play.api.libs.json.Json
import play.api.mvc.Results.Created

object OrderApiHandler {
  def createOrder(createOrder: CreateOrder) = {
    val order = Order(
      _id = new ObjectId(),
      client = createOrder.client,
      items = createOrder.items,
      state = OrderState.placed,
      paymentType = PaymentType.payU,
      shipmentType = ShipmentType.delivery
    )
    Created(Json.toJson(order))
  }
}
