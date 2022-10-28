package handlers

import models.product.Product
import play.api.libs.json._
import play.api.mvc.Result
import play.api.mvc.Results.Ok

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

  private def readProductsFromFile(): Seq[Product] = {
    val path = os.resource / "products.json"
    val arrayOfProducts = Json.parse(os.read(path)).as[JsArray]
    arrayOfProducts.value.collect {
      case product: JsObject =>
        Product(
          _id = product("id").as[JsNumber].value.toInt.toString,
          name = product("name").as[JsString].value,
          categories = product("categories").as[JsArray].value.map(_.as[JsString].value).toSeq,
          price = product("price").as[JsNumber].value.toDouble,
          image = product("image").as[JsString].value,
          description = product("description").as[JsString].value
        )
    }.toSeq
  }
}
