package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case r: Rectangle => Location(0, 0, r)
    case e: Ellipse => Location(-e.width, -e.height, Rectangle(e.width*2, e.height*2))
    case l: Location =>
      val box = apply(l.shape)
      Location(l.x + box.x, l.y + box.y, box.shape)
    case g: Group =>
      val boxes = g.shapes.map(apply)
      // accounting for length of shapes in ascertaining bottom-right
      // not pretty but removes need for var; seek corner of object w/ max x, then resolve from x+w
      val max_x_corner = boxes.maxBy { box => box.x + box.shape.asInstanceOf[Rectangle].width } 
      val max_x = max_x_corner.x + max_x_corner.shape.asInstanceOf[Rectangle].width
      // seek corner of object w/ max y, then resolve from y+h
      val max_y_corner = boxes.maxBy { box => box.y + box.shape.asInstanceOf[Rectangle].height }
      val max_y = max_y_corner.y + max_y_corner.shape.asInstanceOf[Rectangle].height

      // top left corner
      val min_x = boxes.minBy(_.x).x
      val min_y = boxes.minBy(_.y).y

      val w = max_x - min_x
      val h = max_y - min_y
      Location(min_x, min_y, new Rectangle(w, h))
    case _ => Location(0, 0, Rectangle(0, 0)) // not yet implemented

end boundingBox
