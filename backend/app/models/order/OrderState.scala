package models.order

import play.api.libs.json._
import utils.CodecUtils

sealed trait OrderState

object OrderState {

  case object Accepted extends OrderState
  case object InProgress extends OrderState
  case object InDelivery extends OrderState

  def values: Seq[OrderState] = Seq(Accepted, InProgress, InDelivery)

  implicit val orderStateFormat: Format[OrderState] = CodecUtils.generateCodec(values)
}