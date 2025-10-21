package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case r: Rectangle => Location(0, 0, r)
    case e: Ellipse => Location(0, 0, Rectangle(e.width, e.height))
    case l: Location => Location(l.x, l.y, apply(l.shape))
    case g: Group => ???
    case _ => Location(0, 0, Rectangle(0, 0)) // not yet implemented

end boundingBox
