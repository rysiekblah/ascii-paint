package com.kozlowst.paint

import com.kozlowst.paint.Main.{getCodeAndArgs, getCommand, process}
import org.scalatest.{BeforeAndAfter, FunSuite}

class DrawingTests extends FunSuite with BeforeAndAfter {

  before {
    publishCommand("N")
  }

  test("When canvas is not created other commands should be rejected") {
    publishCommand("L 1 1 10 10")
    assert(drawing.functions.isEmpty)
  }

  test("When command C is executed there be only one entry in drown item") {
    publishCommand("C 10 20")
    assert(drawing.functions.size === 1)
    assert(drawing.width === 10)
    assert(drawing.height === 20)
  }

  test("When there are more drown items, C command be rejected") {
    publishCommand("C 5 10")
    publishCommand("L 1 1 10 10")
    assert(drawing.functions.size === 2)

    publishCommand("C 20 20")
    assert(drawing.functions.size === 2)
    assert(drawing.width === 5)
    assert(drawing.height === 10)
  }

  test("Revert is performed an some commands hae been executed too") {
    publishCommand("C 10 10")
    publishCommand("L 1 1 10 10")
    publishCommand("L 10 1 1 10")
    assert(drawing.functions.size === 3)

    publishCommand("Z")
    assert(drawing.functions.size === 2)
    assert(drawing.history.size === 1)
  }

  private def publishCommand(s:String):Unit = {
    val cmd = getCodeAndArgs(s).get
    process(getCommand(cmd._1, cmd._2))
  }

}
