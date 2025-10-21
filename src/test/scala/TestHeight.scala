package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import TestFixtures.*
import Shape.*

class TestHeight extends AnyFunSuite:
  def testHeight(description: String, s: Shape, target: Int): Unit =
    assert(height(s) == target) : Unit  // discard silently

  testHeight("simple ellipse", simpleEllipse, 1)
  testHeight("simple rectangle", simpleRectangle, 1)
  testHeight("simple location", simpleLocation, 1)
  testHeight("basic group", basicGroup, 2)
  testHeight("simple group", simpleGroup, 2)
  testHeight("complex group", complexGroup, 3)
end TestHeight
