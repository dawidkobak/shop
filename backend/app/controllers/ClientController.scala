package controllers

import config.Config
import handlers.{ClientApiHandler, ClientApiHandlerImpl, FakeClientApiHandler}
import play.api.mvc.{BaseController, ControllerComponents}

import javax.inject.{Inject, Singleton}

@Singleton
class ClientController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  val handler: ClientApiHandler =
    if (Config.googleApiKey.nonEmpty)
      ClientApiHandlerImpl
    else
      FakeClientApiHandler


  def checkLocation(city: String, street: String, streetNumber: String) = Action {
    handler.checkLocation(city, street, streetNumber)
  }

  def checkRoute(shopLat: Double, shopLng: Double, clientLat: Double, clientLng: Double) = Action {
    handler.checkRoute(shopLat, shopLng, clientLat, clientLng)
  }
}
