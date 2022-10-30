package models.client

import models.contact.{Address, Email, PhoneNumber}
import play.api.libs.json.{Format, Json}

case class Client(
  //id: String,
  firstName: String,
  lastName: String,
  email: Email,
  phoneNumber: PhoneNumber,
  address: Address
)

object Client {
  implicit val clientFormat: Format[Client] = Json.format[Client]
}
