package models.contact

import play.api.libs.json.{Format, Json}

case class Email(
  address: String
)

object Email {
  implicit val emailFormat: Format[Email] = Json.format[Email]
}