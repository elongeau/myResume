package forms

import play.api.data.Form
import play.api.data.Forms._

/**
 * Created by ELONGEAU on 21/06/2014.
 */
object UserForms {
  case class UserData(name: String, age: Int)


  val userForm = Form(
    mapping(
      "name" -> text,
      "age" -> number
    )(UserData.apply)(UserData.unapply)
  )
}
