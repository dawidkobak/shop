package models.order

import play.api.libs.json._
import utils.CodecUtils

sealed trait OrderState

object OrderState {

  case object Placed extends OrderState
  case object InDelivery extends OrderState

  def values: Seq[OrderState] = Seq(Placed, InDelivery)

  implicit val orderStateFormat: Format[OrderState] = CodecUtils.generateCodec(values)
}