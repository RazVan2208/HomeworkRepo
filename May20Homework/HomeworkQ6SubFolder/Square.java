package May20Homework.HomeworkQ6SubFolder;

public class Square implements ShapeInterface {
    
    private double sidelength;

    Square(double sidelength){
        this.sidelength = sidelength;
    }

    @Override
    public double getArea() {
        double area = sidelength * sidelength; 
        return area;
    }
    @Override
    public int getNumOfCorners() {
        return 4;
    }
    @Override
    public double getPerimeter() {
        return 4*sidelength;
    }
    @Override
    public int getNumOfEdges() {
        return 4;
    }
}
