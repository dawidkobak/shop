package handlers

import models.order.{CreateOrder, Order, OrderState}
import models.payment.PaymentType
import models.shipment.ShipmentType
import org.mongodb.scala.bson.ObjectId
import play.api.libs.json.Json
import play.api.mvc.Results.Created
import utils.MongoDb

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.language.postfixOps

object OrderApiHandler {
  def createOrder(createOrder: CreateOrder) = {
    val order = Order(
      _id = new ObjectId(),
      client = createOrder.client,
      items = createOrder.items,
      notes = createOrder.notes,
      paymentType = createOrder.paymentType,
      state = OrderState.Placed,
      shipmentType = ShipmentType.Delivery
    )
    val x = MongoDb.ordersCollection.insertOne(order).toFuture()
    val y = Await.result(x, 5 seconds)
    Created(Json.toJson(order))
  }
}
