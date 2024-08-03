package May20Homework.HomeworkQ6SubFolder;

public class EquilateralTriange implements ShapeInterface{
    private int sideLength;
    EquilateralTriange(int sideLength){
        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        double area = ((Math.sqrt(3)) / 4) *(sideLength * sideLength); 
        return area;
    }
    @Override
    public int getNumOfCorners() {
        return 3;
    }
    @Override
    public double getPerimeter() {
        return 3*sideLength;
    }
    @Override
    public int getNumOfEdges() {
        return 3;
    }
}
