package dojo.items

import scala.Some

trait TimedItem {

  val delay: Int

  def ready(now:Int) : Boolean = (now - startTime) >= delay

  def act(now:Int) : Option[Any]

  def startClock(now:Int) = {
    startTime = now
  }

  protected var startTime: Int = 0
  protected def ifReady(now:Int)(action: => Any) = if (ready(now)) Some(action) else None
}
