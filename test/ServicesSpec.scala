import models.Resume
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import play.api.test.PlaySpecification
import services.Service

/**
 * Created by ELONGEAU on 18/07/2014.
 */

@RunWith(classOf[JUnitRunner])
object ServicesSpec extends PlaySpecification {
  "Service" should {
    "return a dummy list of Resume" in {
      val resumes = Service.findAll
      resumes must be equalTo List(Resume("manu"), Resume("toto"))

    }
  }

}
