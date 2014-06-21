package controllers

import play.api.mvc._
import forms.UserForms
import views.html.helper.form

object Application extends Controller {

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

  def form1 = Action {
    Ok(views.html.user(UserForms.userForm))
  }

  def userPost() = Action {
    implicit request =>
      val userData = UserForms.userForm.bindFromRequest().get
      Ok(s"Hi ${userData.name} your age is ${userData.age}")

  }


}