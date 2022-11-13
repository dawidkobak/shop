package controllers

import handlers.OrderApiHandler
import models.client.Client
import models.contact.{Address, Email, PhoneNumber}
import models.order.create.CreateOrder
import models.order.{Order, OrderItem, OrderState}
import models.payment.PaymentType
import models.shipment.ShipmentType
import org.mongodb.scala.bson.ObjectId
import play.api.libs.json.Json
import play.api.mvc.{BaseController, ControllerComponents}

import javax.inject.{Inject, Singleton}

@Singleton
class OrderController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  val handler = OrderApiHandler

  def createOrder() = Action {
    implicit request =>
      val createOrder = request.body.asJson.map(_.as[CreateOrder])
      createOrder match {
        case Some(cOrder) =>
          handler.createOrder(cOrder)
        case _ =>
          BadRequest("Incorrect request body")
      }
  }

  def getOrder(orderId: String) = Action {
    handler.getOrder(orderId)
  }

  def getOrders() = Action {
    handler.getOrders()
  }
}
