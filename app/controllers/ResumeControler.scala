package controllers


import play.api.mvc._
import play.api.libs.json._
import models.Resume

/**
 * Created by ELONGEAU on 18/07/2014.
 */
trait ResumeController {
  this: Controller =>

  implicit val resumeWrites = Json.writes[Resume]

  def getResume(name: String) = Action {
    implicit request =>
      Ok(Json.toJson(Resume(name)))
  }
}

object ResumeApp extends Controller with ResumeController