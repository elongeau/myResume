package controllers

import play.api.mvc._
import forms.UserForms


trait FormController {
  this: Controller =>

  def index = Action {
    Ok(views.html.index("hello Play !, no more OutOfMem"))
  }

  def home = Action {
    request =>
      Ok(s"got request : $request")
  }

  def id(id: Long) = Action {
    Ok(s"get {$id}")
  }

  def userPost() = Action {
    implicit request =>
      val userData = UserForms.userForm.bindFromRequest().get
      Ok(s"Hi ${userData.name} your age is ${userData.age}")
  }
}

object Application extends Controller with FormController