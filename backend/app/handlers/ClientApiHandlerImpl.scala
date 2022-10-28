package handlers
import play.api.mvc.Result

object ClientApiHandlerImpl extends ClientApiHandler {
  override def get(clientId: String): Result = ???

  override def create(): Result = ???

  override def checkLocation(city: String, street: String, streetNumber: String): Result = ???

  override def checkRoute(shopLat: Double, shopLng: Double, clientLat: Double, clientLng: Double): Result = ???
}
