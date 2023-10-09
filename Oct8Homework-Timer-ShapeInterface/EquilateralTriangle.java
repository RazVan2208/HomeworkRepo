public class EquilateralTriangle implements Shape {
    private double mbase = 0;
    private double mheight = 0;
    public EquilateralTriangle(double base, double height){
        mbase = base;
        mheight = height;
    }
    @Override
    public double getArea() {
        return (mbase * mheight) / 2;
      }
    public double getPerimeter() {
        return 3 * mbase;
      }
    public int getNumOfEdges() {
        return 3;
      }
    public int getNumOfCorners() {
        return 3;
      }
}