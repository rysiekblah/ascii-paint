package com.kozlowst.paint

import scala.io.StdIn
import scala.util.control.Breaks.{break, breakable}

object Main {

  def main(args: Array[String]): Unit = {
    if (args.nonEmpty) {
      args.head match {
        case "demo" => {
          demo()
          demo2()
        }
        case _ => println("support only for demo1 or demo2 params")
      }
    } else {
      init()
      run()
      println("Bye")
    }
  }

  def run(): Unit = {
    breakable {
      while (true) {
        println("Type command.")
        val cmd = getCodeAndArgs(StdIn.readLine())
        if (cmd.isDefined) {
          val c = cmd.get
          if (c._1.equals("Q")) break
          else process(getCommand(c._1, c._2))
        }
      }
    }
  }

  private def init(): Unit = {
    val cmd = getCodeAndArgs("C 30 10").get
    process(getCommand(cmd._1, cmd._2))
  }

  def process(c:Option[() => Unit]): Unit = c match {
    case Some(f) => f()
    case None => println(" Non executable command.")
  }

  def getCommand(code:String, params:Array[String]): Option[() => Unit] = code match {
    case "C" =>
      if (params.length >= 2) {
        val wh = getP(0, 1, params)
        Some(commands.createCanvas(algs.drawRectangle(_, _, (0, 0), wh), wh._1, wh._2))
      }
      else None
    case "R" =>
      if (params.length >= 4) Some(commands.drawShape(algs.drawRectangle(_, _, getP(0, 1, params), getP(2, 3, params))))
      else None
    case "L" =>
      if (params.length >= 4) Some(commands.drawShape(algs.drawLine(_, _, getP(0, 1, params), getP(2, 3, params))))
      else None
    case "T" =>
      if (params.length >= 6) Some(commands.drawShape(algs.drawTriangle(_, _, getP(0,1,params), getP(2,3,params), getP(4,5,params))))
      else None
    case "Z" => Some(commands.revert())
    case "W" => Some(commands.redo())
    case "N" => Some(commands.clear())
    case _ => None
  }

  def getCodeAndArgs(s:String):Option[(String, Array[String])] ={
    val tokens = s.trim.replaceAll("\\s+", " ").split(" ")
    if (tokens.isEmpty || tokens.size == 1 && (tokens.head.isEmpty || tokens.head.equals(" "))) None
    else command(tokens)
  }

  private def command(items:Array[String]):Option[(String, Array[String])] =
    if (items.length == 0) None
    else Some(items.head, items.tail)

  private def getInt(index:Int, arr:Array[String]):Int = arr.apply(index).toInt

  private def getP(p1:Int, p2:Int, a:Array[String]): (Int, Int) = (getInt(p1, a), getInt(p2, a))


  /**
    * Demo
    */
  private def demo(): Unit = {
    println("\nDEMO-1")
    executeDemo(List(
      "C 30 14",
      "L 0 7 15 0",
      "L 15 0 30 7",
      "L 15 14 30 7",
      "L 0 7 15 14",
      "R 10 5 20 9"
    ))
  }

  private def demo2(): Unit = {
    publishCommand("N")
    println("\nDEMO-2")
    executeDemo(List(
      "C 20 20",
      "T 0 10 20 10 10 0",
      "T 0 15 20 20 20 10"
    ))
  }

  private def executeDemo(commands:List[String]): Unit = {
    commands.foreach(x => {
      println(s" [*] Execute command: $x")
      publishCommand(x)
    })
  }

  private def publishCommand(s:String): Unit = {
    val cmd = getCodeAndArgs(s).get
    process(getCommand(cmd._1, cmd._2))
  }

}
