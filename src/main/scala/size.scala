package edu.luc.cs.laufer.cs371.shapes
import Shape.*

object size:
  def apply(s: Shape): Int = s match
    case r: Rectangle => 1
    case e: Ellipse => 1
    case l: Location => apply(l.shape)
    case g: Group => g.shapes.foldLeft(0)((x, y) => x + apply(y))
    case _ => 0

end size