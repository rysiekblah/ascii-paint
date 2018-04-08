package com.kozlowst.paint

import org.scalatest.FlatSpec

class CliTests extends FlatSpec {

  "A command C 2 2" should "be parsed" in {
    val cmd = Main.getCodeAndArgs("C 2 5")
    val code = cmd.get._1
    val params = cmd.get._2
    assert(cmd.isDefined)
    assert(code.equals("C"))
    assert(params.length === 2)
    assert(params.apply(0).toInt === 2)
    assert(params.apply(1).toInt === 5)
  }

  "A command C is missing one param" should " NOT be parsed" in {
    assert(Main.getCodeAndArgs("C 3").isEmpty)
  }

}
