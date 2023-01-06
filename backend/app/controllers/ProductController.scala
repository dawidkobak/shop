package controllers

import handlers.ProductApiHandler
import play.api.mvc.{AnyContent, BaseController, ControllerComponents, Request}

import javax.inject.{Inject, Singleton}

@Singleton
class ProductController @Inject()(
  val controllerComponents: ControllerComponents
) extends BaseController {

  def getProducts(limit: Int, page: Int, categories: String, query: String) = Action {
    implicit request: Request[AnyContent] =>
      ProductApiHandler.get(limit, page, categories, query)
  }

  def getAllProducts() = Action {
    implicit request: Request[AnyContent] =>
      ProductApiHandler.getAll
  }
}
