package services

import models.Resume
import repository._


/**
 * Created by ELONGEAU on 28/07/2014.
 */
trait ResumeService {
  repository: ResumeRepo =>
  def findAll: List[Resume] = repository.findAll
}

object Service extends ResumeService with DummyRepo