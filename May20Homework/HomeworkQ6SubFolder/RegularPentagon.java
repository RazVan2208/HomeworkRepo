package May20Homework.HomeworkQ6SubFolder;

public class RegularPentagon implements ShapeInterface{
    private int equalLengthA;
    RegularPentagon(int equalLengthA){
       this.equalLengthA = equalLengthA;
    }
    @Override
    public double getArea() {
        double area = 0.25*(Math.sqrt(5*(5+2*Math.sqrt(5)))) * (Math.pow(equalLengthA, 2)); 
        return area;
    }
    @Override
    public int getNumOfCorners() {
        return 4;
    }
    @Override
    public double getPerimeter() {
        return 5*equalLengthA;
    }
    @Override
    public int getNumOfEdges() {
        return 4;
    }
}
