public class RightAngleTriange implements Shape {
    private double mbase = 0;
    private double mheight = 0;
    private double mside = 0;
    public RightAngleTriange(double base, double height, double side){
        mbase = base;
        mheight = height;
    }
    @Override
    public double getArea() {
        return (mbase * mheight) / 2;
      }
    public double getPerimeter() {
        return mbase + mheight + mside;
      }
    public int getNumOfEdges() {
        return 3;
      }
    public int getNumOfCorners() {
        return 3;
      }
}

