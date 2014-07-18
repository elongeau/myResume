import org.junit.runner.RunWith
import org.specs2.execute.Results
import org.specs2.runner.JUnitRunner
import play.api.libs.json.Json
import play.api.test.{FakeApplication, FakeRequest, FakeHeaders, PlaySpecification}
import play.api.mvc._
import controllers.ResumeController
/**
 * Created by ELONGEAU on 18/07/2014.
 */

@RunWith(classOf[JUnitRunner])
object ResumeAppSpec extends PlaySpecification with Results {

  class ResumeTest() extends Controller with ResumeController

  "ResumeApp" should {
    "responds with JSON {name : manu}" in {
      implicit val app = FakeApplication()
      running(app) {
        val Some(result) = route(FakeRequest(GET, "/resume/manu", FakeHeaders(), ""))
        status(result) must equalTo(OK)
        val bodyText = contentAsJson(result)
        bodyText must be equalTo Json.obj("name" -> "manu")
      }
    }
  }

}
