package com.kozlowst.paint

object algs {

  def drawLine(x:Int, y:Int, p1:(Int, Int), p2:(Int, Int)): Boolean = {
    if (p1._2 == p2._2) x >= p1._1 && x <= p2._1 && y == p1._2 // horizontal
    else if (p1._1 == p2._1) y >= p1._2 && y <= p2._2 && x == p1._1 // vertical
    else drawDiagonalLine(x, y, p1, p2) // diagonal

  }

  private def drawDiagonalLine(x:Int, y:Int, p1:(Int, Int), p2:(Int, Int)): Boolean = {

    val nX = p1._2 + (p2._2 - p1._2)*(x - p1._1)/(p2._1 - p1._1)

    val x1 = Math.min(p1._1, p2._1)
    val x2 = Math.max(p1._1, p2._1)
    val y1 = Math.min(p1._2, p2._2)
    val y2 = Math.max(p1._2, p2._2)

    (y >= y1 && y <= y2) && (x >= x1 && x <= x2) && (y == nX)

  }

  def drawRectangle(x:Int, y:Int, p1:(Int, Int), p2:(Int, Int)): Boolean = {
    val p1_p = (p2._1, p1._2)
    val p2_p = (p1._1, p2._2)
    drawLine(x, y, p1, p1_p) ||
      drawLine(x, y, p1_p, p2) ||
      drawLine(x, y, p1, p2_p) ||
      drawLine(x, y, p2_p, p2)
  }

  def drawTriangle(x:Int, y:Int, p1:(Int, Int), p2:(Int, Int), p3:(Int, Int)): Boolean =
    drawLine(x, y, p1, p2) || drawLine(x, y, p1, p3) || drawLine(x, y, p2, p3)

}
