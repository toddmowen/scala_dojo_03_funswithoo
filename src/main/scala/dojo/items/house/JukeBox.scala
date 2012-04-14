package dojo.items.house

import dojo.items.TimedItem

class JukeBox extends HouseItem with TimedItem {
  val id = 6
  val delay = 30
  protected def action = "Blah-Blah"
}
