package utils

import config.Config
import models.product.Product
import org.mongodb.scala.{MongoClient, MongoCollection}

object MongoDb {
  val client = MongoClient(Config.mongodbUri)
  val shopDb = client.getDatabase("shop").withCodecRegistry(CodecRegistry.codecRegistry)
  val productsCollection: MongoCollection[Product] = shopDb.getCollection("products")
}
