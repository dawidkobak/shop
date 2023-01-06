package handlers

import models.product.Product
import org.mongodb.scala.bson.ObjectId
import play.api.libs.json._
import play.api.mvc.Result
import play.api.mvc.Results.Ok
import utils.MongoDb

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object ProductApiHandler {

  val products: Seq[Product] = readProductsFromFile()

  def get(
    limit: Int,
    page: Int,
    categories: String,
    query: String
  ): Result = {

    val filtered = products
      .filter(p => if (categories.nonEmpty) p.categories.contains(categories) else true)
      .filter(p => if (query.nonEmpty) p.name.toLowerCase.contains(query.toLowerCase) else true)

    val toReturn = filtered.slice(limit * (page - 1), limit * page)

    Ok(Json.toJson(toReturn)).withHeaders("all-products-count" -> filtered.size.toString)
  }

  def getAll: Result = {
    Ok(Json.toJson(products)).withHeaders("X-Results-Count" -> products.size.toString)
  }

  private def readProductsFromFile(): Seq[Product] = {
    val path = os.resource / "products.json"
    val arrayOfProducts = Json.parse(os.read(path)).as[JsArray]
    arrayOfProducts.value.collect {
      case product: JsObject =>
        Product(
          _id = new ObjectId(product("_id").as[JsString].value),
          name = product("name").as[JsString].value,
          categories = product("categories").as[JsArray].value.map(_.as[JsString].value).toSeq,
          price = product("price").as[JsNumber].value.toDouble,
          image = product("image").as[JsString].value,
          description = product("description").as[JsString].value
        )
    }.toSeq
  }

  private def readProductsFromMongo(): Seq[Product] = {
    val mongoProducts = MongoDb.productsCollection.find().toFuture()
    Await.result(mongoProducts, Duration.Inf)
  }
}
