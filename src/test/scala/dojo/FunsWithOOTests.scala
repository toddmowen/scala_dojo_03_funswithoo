package dojo

import items.artifacts.Unicorn
import items.fashion.Hat
import items.house.Chair
import items.{Item, Purchasable, TimedItem, User}
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

@RunWith(classOf[JUnitRunner])
class FunsWithOOTests extends FunSuite with ShouldMatchers{

  // all items should have an id
  test("Unicorn should have id of 1"){
    (new Unicorn).id should equal (1)
  }

  test("anonymous items should have an id"){
    // By design, this won't compile:
    //   val item = new Item {}
    // hence anonymous items *must* have an id:

    val item = new Item { val id = 42 }
  }

  // all fashion and house items should be able to be bought for cash deducted from user

  test("should buy hat and deduct 5 cash from user"){
    val hat = new Hat
    assertPurchasableItemCashDeduction(hat, 5)
  }

  test("should buy chair and deduct 3 cash from user"){
    val chair = new Chair
    assertPurchasableItemCashDeduction(chair, 3)
  }

  def assertPurchasableItemCashDeduction(item:Purchasable, deduction:Int){
    val balance = 10

    val user = new User(balance)
    user.cash should equal (balance)

    user.buy(item)
    user.cash should equal (balance - deduction)
  }

  // MachineGunUnicorn and JukeBox have special actions that are available a set time after creation
  // * MachineGunUnicorn prints Bam-Bam
  // * JukeBox prints Blah-Blah

  test("MachineGunUnicorn goes Bam-Bam"){
    assert(false)
    //assertTimedItem(Some("Bam-Bam"), machineGunUnicorn, delay)
  }

  test("JukeBox goes Blah-Blah"){
    assert(false)
    //assertTimedItem(Some("Blah-Blah"), jukeBox, delay)
  }

  def assertTimedItem(expected: Some[Any], timedItem: TimedItem, delay: Int){
    val now = 10
    timedItem.startClock(now)

    timedItem.ready(now)          should  equal (false)
    timedItem.act(now + delay -1) should  equal (None)

    timedItem.ready(now + delay)  should  equal (true)
    timedItem.act(now + delay)    should  equal (expected)
  }

}
