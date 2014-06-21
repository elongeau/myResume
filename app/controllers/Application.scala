package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("hello Play !, no more OutOfMem"))
  }

  def home = Action {request =>
    Ok(s"got request : $request")
  }

  def id(id: Long) = Action {
    Ok(s"get {$id}")
  }

}