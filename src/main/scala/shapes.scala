package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Location(x, y, Shape) */
enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int)
  case Location(x: Int, y: Int, shape: Shape)
  // TODO add missing cases (see test fixtures)
  case Ellipse(width: Int, height: Int)
  case Group(shapes: Shape*)
  
