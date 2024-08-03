package May20Homework.HomeworkQ6SubFolder;

public class RightAngledTriange implements ShapeInterface {
    
    private int height;
    private int sideLengthA;

    RightAngledTriange(int height, int sideLengthA){
        this.height = height;
        this.sideLengthA = sideLengthA;
    }

    
    @Override
    public double getArea() {
        double area = sideLengthA*height;
        return area;
    }
    @Override
    public int getNumOfCorners() {
        return 3;
    }
    @Override
    public double getPerimeter() {
        double sideLengthB = Math.sqrt((height*height) + (sideLengthA * sideLengthA));
        return sideLengthB + sideLengthA + height;
    }
    @Override
    public int getNumOfEdges() {
        return 3;
    }
}
