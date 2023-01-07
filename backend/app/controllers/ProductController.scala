package controllers

import handlers.ProductApiHandler
import play.api.mvc.{AnyContent, BaseController, ControllerComponents, Request}

import javax.inject.{Inject, Singleton}

@Singleton
class ProductController @Inject()(
  val controllerComponents: ControllerComponents
) extends BaseController {

  def getProducts() = Action {
    implicit request: Request[AnyContent] =>
      ProductApiHandler.getProducts
  }
}
