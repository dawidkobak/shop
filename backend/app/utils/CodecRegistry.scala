package utils

import models.product.Product
import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}
import org.bson.codecs.configuration.CodecRegistry
import org.mongodb.scala.MongoClient.DEFAULT_CODEC_REGISTRY
import org.mongodb.scala.bson.codecs.Macros._

object CodecRegistry {
  val codecRegistry: CodecRegistry = fromRegistries(fromProviders(classOf[Product]), DEFAULT_CODEC_REGISTRY)
}
