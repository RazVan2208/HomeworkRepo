public class Parallelogram implements Shape {
    private double mbase = 0;
    private double mheight = 0;
    private double mside = 0;
    public Parallelogram(double base, double height, double side){
        mbase = base;
        mheight = height;
        mside = side;
    }
    @Override
    public double getArea() {
        return (mbase * mheight);
      }
    public double getPerimeter() {
        return 2 * mbase + 2 * mside;
      }
    public int getNumOfEdges() {
        return 4;
      }
    public int getNumOfCorners() {
        return 4;
      }
}
