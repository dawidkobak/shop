package models.contact

import play.api.libs.json.{Format, Json}

case class Address(
  city: String,
  street: String,
  streetNumber: Int,
  flatNumber: Option[Int] = None
)

object Address {
  implicit val addressFormat: Format[Address] = Json.format[Address]
}