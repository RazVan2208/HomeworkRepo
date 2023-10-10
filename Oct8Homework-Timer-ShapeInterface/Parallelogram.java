public class Parallelogram implements Shape {
    private double mbase = 0;
    private double mheight = 0;
    private double mangleA = 0;
    public Parallelogram(double base, double height, double angleA){
        mbase = base;
        mheight = height;
        mangleA = angleA;
    }
    @Override
    public double getArea() {
        return (mbase * mheight);
      }
    public double getPerimeter() {
        return (2*(getArea() / (mbase * Math.sin(mangleA)))*-1) + 2*mbase;
      }
    public int getNumOfEdges() {
        return 4;
      }
    public int getNumOfCorners() {
        return 4;
      }
}
