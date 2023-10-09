public class Rectangle implements Shape {
    private double mlength = 0;
    private double mwidth = 0;
    public Rectangle(double length, double width){
        mlength = length;
        mwidth = width;
    }
    @Override
    public double getArea() {
        return mlength * mwidth;
      }
    public double getPerimeter() {
        return 2*mlength + 2*mwidth;
      }
    public int getNumOfEdges() {
        return 4;
      }
    public int getNumOfCorners() {
        return 4;
      }
}
