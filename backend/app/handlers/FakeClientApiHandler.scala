package handlers

import com.free2move.geoscala.polyline
import play.api.libs.json.{JsArray, JsNumber, JsObject}
import play.api.mvc.Result
import play.api.mvc.Results.Ok

object FakeClientApiHandler extends ClientApiHandler {
  override def get(clientId: String): Result = Ok("")

  override def create(): Result = Ok("")

  override def checkLocation(city: String, street: String, streetNumber: String): Result = {
    val coordinates = JsObject(Seq(
      "lat" -> JsNumber(50.068521667536636),
      "lng" -> JsNumber(19.95388576690215)
    ))
    Ok(coordinates)
  }

  override def checkRoute(shopLat: Double, shopLng: Double, clientLat: Double, clientLng: Double): Result = {
    val polylines = os.read.lines(os.resource / "route.txt")
    val decodedCoordinates = polylines.map(polyline.decode).flatMap(_.toOption).flatMap(_.coordinates)
    val coordinates = decodedCoordinates.map(c => JsObject(Seq("lat" -> JsNumber(c.latitude), "lng" -> JsNumber(c.longitude))))
    Ok(
      JsObject(Seq(
          "time" -> JsNumber(922),
          "distance" -> JsNumber(5182),
          "steps" -> JsArray(coordinates))
      )
    )
  }
}
