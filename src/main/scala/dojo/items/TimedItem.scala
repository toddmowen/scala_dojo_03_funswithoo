package dojo.items

import scala.Some

trait TimedItem {

  val delay: Int

  def ready(now:Int) : Boolean = (now - startTime) >= delay

  def act(now:Int) : Option[Any] = if (ready(now)) Some(action) else None

  def startClock(now:Int) = {
    startTime = now
  }

  private var startTime: Int = 0

  protected def action(): Any
}
