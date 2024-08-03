package May20Homework.HomeworkQ6SubFolder;

public class Trapezoid implements ShapeInterface{
    private double sideA;
    private double sideB;
    private double sideC;
    private double sideD;
    private double height;

    Trapezoid(double sideA, double sideB, double sideC, double sideD , double height){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.sideD = sideD;
        this.height = height;
    }

    @Override
    public double getArea() {
        double area = ((sideA + sideB) / 2)*height ; 
        return area;
    }
    @Override
    public int getNumOfCorners() {
        return 4;
    }
    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC + sideD;
    }
    @Override
    public int getNumOfEdges() {
        return 4;
    }
}
