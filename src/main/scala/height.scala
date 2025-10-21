package edu.luc.cs.laufer.cs371.shapes
import Shape.*

object height:
  def apply(s: Shape): Int = s match
    case r: Rectangle => 1
    case e: Ellipse => 1
    case l: Location => apply(l.shape)
    // ascertain the deepest branch and then bring it back to re-figure depth
    // redundant, but it's okay...
    case g: Group => 1 + apply( g.shapes.maxBy(shape => 1 + apply(shape)) )
    case _ => 0

end height