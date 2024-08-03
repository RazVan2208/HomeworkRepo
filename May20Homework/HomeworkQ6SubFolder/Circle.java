package May20Homework.HomeworkQ6SubFolder;

public class Circle implements ShapeInterface{
    private double radius;

    Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double getArea() {
        double area = Math.PI * (radius * radius); 
        return area;
    }
    @Override
    public int getNumOfCorners() {
        return 0;
    }
    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }
    @Override
    public int getNumOfEdges() {
        return 0;
    }
}
