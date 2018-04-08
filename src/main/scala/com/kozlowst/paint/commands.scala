package com.kozlowst.paint


object commands {
  def createCanvas(f:(Int, Int) => Boolean, w:Int, h:Int)() : Unit = drawing.createCanvas(f, w, h)
  def drawShape(f:(Int, Int) => Boolean)(): Unit = drawing.draw(f)
  def revert()(): Unit = drawing.revert()
  def redo()(): Unit = drawing.redo()
  def clear()(): Unit = {
    drawing.functions.clear()
    drawing.history.clear()
    drawing.width = 0
    drawing.height = 0
  }
}
