package controllers

import handlers.OrderApiHandler
import models.client.Client
import models.contact.{Address, Email, PhoneNumber}
import models.order.{CreateOrder, Order, OrderItem, OrderState}
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

  def getOrder() = Action {
    val order = Order(
      _id = new ObjectId(),
      client = Client(
        name = "Dawid",
        lastName = "Lastname",
        email = Email("dawid@gmail.com"),
        phoneNumber = PhoneNumber("123 456 789"),
        address = Address(
          city = "Kraków",
          street = "Biała",
          streetNumber = 1324,
          flatNumber = Some(5)
        )
      ),
      items = Seq(
        OrderItem(
          productId = "635e71151ce7966d7df0ed83",
          quantity = 5
        ),
        OrderItem(
          productId = "635e71151ce7966d7df0ed85",
          quantity = 2
        ),
        OrderItem(
          productId = "635e71151ce7966d7df0ed87",
          quantity = 1
        )
      ),
      state = OrderState.placed,
      paymentType = PaymentType.payU,
      shipmentType = ShipmentType.delivery
    )
    Ok(Json.toJson(order))
  }
}
