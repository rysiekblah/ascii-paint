package com.kozlowst.paint

import scala.collection.mutable.ArrayBuffer

object drawing {

  private[paint] val functions:ArrayBuffer[(Int, Int) => Boolean] = ArrayBuffer()
  private[paint] val history:ArrayBuffer[(Int, Int) => Boolean] = ArrayBuffer()
  private[paint] var width = 0
  private[paint] var height = 0

  def createCanvas(f:(Int, Int) => Boolean, w:Int, h:Int):Unit =
    if (functions.nonEmpty) println("Can't create canvas, already created.")
    else {
      width = w
      height = h
      draw(f, check = false)
    }

  def revert(): Unit = {
    if (functions.nonEmpty){
      functions.remove(0) +=: history
      draw()
    }
  }

  def redo(): Unit = {
    if (history.nonEmpty) {
      history.remove(0) +=: functions
      draw()
    }
  }

  def draw(f:(Int, Int) => Boolean): Unit = draw(f, check = true)

  private def draw(f: (Int, Int) => Boolean, check:Boolean):Unit = {
    if (check && functions.isEmpty) {
      println("Canvas not created yet, can't draw any shape.")
    } else {
      f +=: functions
      draw()
    }
  }

  private def draw():Unit =
    if (functions.nonEmpty) {
      for(y <- (0 to height).reverse) {
        for (x <- 0 to width) {
          if (functions.map(_(x,y)).reduce(_|_)) print('x')
          else print(' ')
        }
        println()
      }
    }

}
