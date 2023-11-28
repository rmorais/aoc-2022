package com.cabexas

import scala.io.Source
import scala.util.Using

val lines  = readFile("src/main/resources/day1.txt").linesIterator

  val splitByElves = {
    val builder = List.newBuilder[List[Int]]
    var items = List.newBuilder[Int]
    for (line <- lines)
      if line.isBlank() then
        builder.addOne(items.result())
        items = List.newBuilder[Int]
      else
        items += line.toInt

    builder.result()
  }

@main def part1: Unit =
  println(s"Maximum calories: [${splitByElves.map(_.sum).max}]")

@main def part2: Unit = {
  println(s"Top 3 calories: [${splitByElves.map(_.sum).sortBy(-_).take(3).sum}]")
}

//Using ensures file is closed
def readFile(path: String) = Using.resource(Source.fromFile(path))(_.mkString)