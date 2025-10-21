package edu.luc.cs.laufer.cs371.shapes
import Shape.*

object scale:
  def apply(s: Shape, scale: Double): Shape = s match
    case r: Rectangle =>
      val w = math.floor(r.width * scale).toInt
      val h = math.floor(r.height * scale).toInt
      Rectangle(w, h)
    case e: Ellipse =>
      val w = math.floor(e.width * scale).toInt
      val h = math.floor(e.height * scale).toInt
      Ellipse(w, h)
    case l: Location =>
      // wording of assignment implies that x and y do not need to be scaled (my interpretation)
      Location(l.x, l.y, apply(l.shape, scale))
    case g: Group =>
      Group(g.shapes.map(shape => apply(shape, scale))*)
    case _ => Rectangle(0, 0)

end scale