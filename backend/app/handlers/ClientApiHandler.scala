package handlers

import play.api.mvc.Result

trait ClientApiHandler {
  def get(clientId: String): Result

  def create(): Result

  def checkLocation(city: String, street: String, streetNumber: String): Result

  def checkRoute(shopLat: Double, shopLng: Double, clientLat: Double, clientLng: Double): Result
}
