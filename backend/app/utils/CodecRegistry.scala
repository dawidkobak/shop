package utils

import models.client.Client
import models.contact.{Address, Email, PhoneNumber}
import models.order.{Order, OrderItem, OrderState}
import models.payment.PaymentType
import models.product.Product
import models.shipment.ShipmentType
import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}
import org.bson.codecs.configuration.CodecRegistry
import org.mongodb.scala.MongoClient.DEFAULT_CODEC_REGISTRY
import org.mongodb.scala.bson.codecs.Macros._

object CodecRegistry {
  val codecRegistry: CodecRegistry = fromRegistries(
    fromProviders(
      classOf[Product],
      classOf[Email],
      classOf[PhoneNumber],
      classOf[Address],
      classOf[Client],
      classOf[OrderItem],
      classOf[Order],
      classOf[OrderState],
      classOf[PaymentType],
      classOf[ShipmentType]
    ),
    DEFAULT_CODEC_REGISTRY
  )
}
