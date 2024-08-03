package May20Homework.HomeworkQ6SubFolder;

public class Rectangle implements ShapeInterface{
    
    private double sidelength;
    private double width;
    private double length;

    Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    @Override
    public double getArea() {
        double area = width * length; 
        return area;
    }
    @Override
    public int getNumOfCorners() {
        return 4;
    }
    @Override
    public double getPerimeter() {
        return 2*width + 2*length;
    }
    @Override
    public int getNumOfEdges() {
        return 4;
    } 
}
