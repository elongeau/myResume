package controllers

import play.api.mvc._
import forms.UserData
import play.api.libs.json._

import play.api.libs.functional.syntax._

trait FormController {
  this: Controller =>

  implicit val userWrites: Writes[UserData] = (
    (JsPath \ "name").write[String] and
      (JsPath \ "age").write[Int]
    )(unlift(UserData.unapply))

  implicit val userReads: Reads[UserData] = (
    (JsPath \ "name").read[String] and
      (JsPath \ "age").read[Int])(UserData.apply _)

  def index = Action {
    Ok(views.html.index("hello Play !, no more OutOfMem"))
  }

  def home = Action {
    request =>
      Ok(s"got request : $request")
  }

  def id(id: Long) = Action {
    Ok(s"get $id")
  }

  def userPost() = Action(BodyParsers.parse.json) {
    implicit request =>
      val user = request.body.validate[UserData]
      user.fold(
        errors => {
          BadRequest(Json.obj("status" -> "KO", "message" -> JsError.toFlatJson(errors)))
        },
        userData => {
          Ok(s"Hi ${userData.name} your age is ${userData.age}")
        }
      )

  }
}

object Application extends Controller with FormController {

}