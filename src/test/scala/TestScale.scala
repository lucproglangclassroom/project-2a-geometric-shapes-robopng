package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import TestFixtures.*
import Shape.*

class TestScale extends AnyFunSuite:
  def testScale(description: String, s: Shape, size: Int, target: Location): Unit =
    test(description):
      val scaled = boundingBox(scale(s, size))
      // no alteration to coordinates
      assert(scaled.x == target.x)
      assert(scaled.y == target.y)
      assert(scaled.shape.asInstanceOf[Rectangle].width == target.shape.asInstanceOf[Rectangle].width)
      assert(scaled.shape.asInstanceOf[Rectangle].height == target.shape.asInstanceOf[Rectangle].height)

  testScale("simple ellipse", simpleEllipse, 2, boundingBox(Ellipse(100, 60)))
  testScale("simple rectangle", simpleRectangle, 3, boundingBox(Rectangle(240, 360)))
  testScale("simple location", simpleLocation, 5, boundingBox(Location(70, 30, Rectangle(400, 600))))
  testScale("basic group", basicGroup, 2, boundingBox(Group(Ellipse(100, 60), Rectangle(40, 80))))
  testScale("simple group", simpleGroup, 2, boundingBox(Group(
    Location(200, 100, Ellipse(100, 60)),
    Location(400, 300, Rectangle(200, 100))
  )))
  testScale("complex group", complexGroup, 2, boundingBox(Location(50, 100,
    Group(
      Ellipse(40, 80),
      Location(150, 50,
        Group(
          Rectangle(100, 60),
          Rectangle(600, 120),
          Location(100, 200,
            Ellipse(100, 60)
          )
        )),
      Rectangle(200, 400)
    ))))
end TestScale
