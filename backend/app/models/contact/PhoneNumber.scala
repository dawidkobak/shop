package models.contact

import play.api.libs.json.{Format, Json}

case class PhoneNumber(
  number: String
)

object PhoneNumber {
  implicit val phoneNumberFormat: Format[PhoneNumber] = Json.format[PhoneNumber]
}