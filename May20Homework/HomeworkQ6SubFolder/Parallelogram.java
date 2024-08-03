package May20Homework.HomeworkQ6SubFolder;

public class Parallelogram implements ShapeInterface {
    
    private int sideA;
    private int sideB;
    private int height;
    Parallelogram(int sideA, int sideB, int height){
        this.sideA = sideA;
        this.sideB = sideB;
        this.height = height;
    }

    @Override
    public double getArea() {
        double area = sideB*sideA;
        return area;
    }
    @Override
    public int getNumOfCorners() {
        return 4;
    }
    @Override
    public double getPerimeter() {
        return 2*(sideA + sideB);
    }
    @Override
    public int getNumOfEdges() {
        return 4;
    }
}
