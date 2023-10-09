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
    private double mlength = 0;
    private double mwidth = 0;
    public Square(double length, double width){
        mlength = length;
        mwidth = width;
    }
    @Override
    public double getArea() {
        return mlength * mwidth;
      }
    public double getPerimeter() {
        return 2*mlength + 2*mwidth;
      }
    public int getNumOfEdges() {
        return 4;
      }
    public int getNumOfCorners() {
        return 4;
      }
}