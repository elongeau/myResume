import controllers.FormController
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import play.api.libs.json.{JsObject, Json}
import play.api.mvc._
import play.api.test._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
object ApplicationSpec extends PlaySpecification with Results {

  class TestController() extends Controller with FormController

  "Application" should {

    "respond with 'Hi manu your age is 32'" in {
      implicit val app = FakeApplication()
      running(app) {
        val json: JsObject = Json.obj("name" -> "manu", "age" -> 32)
        val Some(result) = route(FakeRequest(POST, "/userPost", FakeHeaders(), json))
        status(result) must equalTo(OK)
        val bodyText = contentAsString(result)
        bodyText must be equalTo "Hi manu your age is 32"
      }
    }
  }
}
