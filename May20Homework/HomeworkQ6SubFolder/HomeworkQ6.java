package May20Homework.HomeworkQ6SubFolder;
/*
 * Create an interface called TwoDimensionalShape. It has the two following methods:
	double getArea() - Returns the area of the shape.
	double getPerimeter() - Returns the perimeter of the shape.
	int getNumOfEdges() - Returns the number of edges of the shape.
	int getNumOfCorners() - Returns the number of corners of the shape.

Create the classes Square, Rectangle, Circle, EquilateralTriangle, RightAngledTriange, 
  Parallelogram, RegularHexagon, RegularPentagon, Trapezoid that implement the interface 
  of TwoDimensionalShape.

- Note: The constructor for each of these classes should take in the minimum number of 
  parameters to be able to specify a shape of that class of any size.
 */
public class HomeworkQ6 {

    public static void main(String[] args) {
    Circle circle = new Circle(4);
    EquilateralTriange EqTriangle = new EquilateralTriange(4);
    Parallelogram parallelogram = new Parallelogram(2, 3, 2);
    Rectangle rectangle = new Rectangle(3, 6);
    RegularHexagon hexagon = new RegularHexagon(4);
    RegularPentagon pentagon = new RegularPentagon(6);
    RightAngledTriange rightTriangle = new RightAngledTriange(6, 8);
    Square square = new Square(5);
    Trapezoid trapezoid = new Trapezoid(2, 3, 4, 5, 6);

    System.out.println(circle.getArea());
    }
}
