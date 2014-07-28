package repository

import models.Resume

trait ResumeRepo {
  def findAll: List[Resume]
}

trait DummyRepo extends ResumeRepo{
  override  def findAll: List[Resume] = Resume("manu") :: Resume("toto") :: Nil
}