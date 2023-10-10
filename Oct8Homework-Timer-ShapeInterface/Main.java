import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    List<Shape> shapes = new ArrayList<Shape>();
    shapes.add(new Parallelogram(8, 12, 80));
    shapes.add(new RightAngleTriange(3, 4));
    shapes.add(new Circle((3)));
    shapes.add(new Square(3,3));
    shapes.add(new Rectangle(3, 2));
    shapes.add(new EquilateralTriangle(2, 2));
     for(Shape shapesI : shapes){
         System.out.println(shapesI.getArea());
         System.out.println(shapesI.getPerimeter());
         System.out.println(shapesI.getNumOfEdges());
         System.out.println(shapesI.getNumOfCorners());
     }
      }
}
