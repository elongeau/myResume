import controllers.FormController
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import play.api.mvc._
import play.api.test._
import scala.concurrent.Future

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
object ApplicationSpec extends PlaySpecification with Results {

  class TestController() extends Controller with FormController

  "Application" should {

    "respond with 'get 1'" in {
      val controller = new TestController()
      val result: Future[Result] = controller.id(1).apply(FakeRequest())
      val bodyText = contentAsString(result)
      bodyText must be equalTo "get 1"

    }
  }
}
