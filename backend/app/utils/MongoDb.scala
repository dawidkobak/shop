package utils

import config.Config
import models.order.Order
import models.product.Product
import org.mongodb.scala.{MongoClient, MongoCollection, MongoDatabase}

object MongoDb {
  val client: MongoClient = MongoClient(Config.mongodbUri)
  val shopDb: MongoDatabase = client.getDatabase("shop").withCodecRegistry(CodecRegistry.codecRegistry)
  val productsCollection: MongoCollection[Product] = shopDb.getCollection("products")
  val ordersCollection: MongoCollection[Order] = shopDb.getCollection("orders")
}
