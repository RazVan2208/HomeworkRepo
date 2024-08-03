package May20Homework.HomeworkQ6SubFolder;

public class RegularHexagon implements ShapeInterface {
    private int lengthA;
    RegularHexagon(int lengthA){
        this.lengthA = lengthA;
    }

    @Override
    public double getArea() {
        double area = ((Math.sqrt(3) * 3) / 2) * (lengthA * lengthA); 
        return area;
    }
    @Override
    public int getNumOfCorners() {
        return 6;
    }
    @Override
    public double getPerimeter() {
        return 6*lengthA;
    }
    @Override
    public int getNumOfEdges() {
        return 6;
    }
}
