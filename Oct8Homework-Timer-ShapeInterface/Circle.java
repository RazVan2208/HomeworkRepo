// --------- QUESTION 2 -------- //
// Create an interface called Shape. It has the two following methods:
// 	double getArea() - Returns the area of the shape.
//	double getPerimeter() - Returns the perimeter of the shape.
//	int getNumOfEdges() - Returns the number of edges of the shape.
//	int getNumOfCorners() - Returns the number of corners of the shape.
// Create the classes Square, Rectangle, Circle, EquilateralTriangle,
 //   RightAngledTriange and Parallelogram that implement the interface of Shape
// 	- Note: The constructor for each of these classes should take in the minimum number of parameters to be able to specify a shape of that class of any size.
public class Circle implements Shape{
  double pi = Math.PI;
  private double mradius = 0;
  public Circle(double radius){
      mradius = radius;
  }
  @Override
  public double getArea() {
      return pi * mradius * mradius;
    }
  public double getPerimeter() {
      return 2 * pi * mradius;
    }
  public int getNumOfEdges() {
      return 0;
    }
  public int getNumOfCorners() {
      return 0;
    }
}