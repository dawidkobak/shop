package handlers

import models.order.create.CreateOrder
import models.order.{Order, OrderState}
import models.shipment.ShipmentType
import org.mongodb.scala.bson.ObjectId
import org.mongodb.scala.model.Filters._
import play.api.libs.json.Json
import play.api.mvc.Results.{Created, NotFound, Ok}
import utils.MongoDb

import scala.collection.mutable.ArrayBuffer
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.language.postfixOps

object OrderApiHandler {

  val orders: ArrayBuffer[Order] = new ArrayBuffer[Order]()

  def createOrder(createOrder: CreateOrder) = {
    val order = Order(
      _id = new ObjectId(),
      client = createOrder.client,
      items = createOrder.items,
      notes = createOrder.notes,
      paymentType = createOrder.paymentType,
      state = OrderState.Accepted,
      shipmentType = ShipmentType.Delivery
    )
    //val x = MongoDb.ordersCollection.insertOne(order).toFuture()
    //val y = Await.result(x, 5 seconds)
    orders += order
    Created(Json.toJson(order))
  }

  def getOrder(orderId: String) = {
    try {
//      val orderFut = MongoDb.ordersCollection.find(equal("_id", new ObjectId(orderId))).first().toFuture()
//      val order = Await.result(orderFut, 5 seconds)
      val order = orders.find(_._id == new ObjectId(orderId)).get
      Ok(Json.toJson(order))
    } catch {
      case _: Exception => NotFound
    }
  }

  def getOrders() = {
    Ok(Json.toJson(orders))
  }
}
