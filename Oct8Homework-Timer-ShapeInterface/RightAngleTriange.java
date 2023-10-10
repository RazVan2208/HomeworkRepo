public class RightAngleTriange implements Shape {
    private double mbase = 0;
    private double mheight = 0;
    public RightAngleTriange(double base, double height){
        mbase = base;
        mheight = height;
    }
    @Override
    public double getArea() {
        return (mbase * mheight) / 2;
      }
    public double getPerimeter() {
        double hypotenuse;
        hypotenuse = Math.pow(mbase, 2) + Math.pow(mheight, 2);
        hypotenuse = Math.sqrt(hypotenuse);
        return hypotenuse + mbase + mheight;
      }
    public int getNumOfEdges() {
        return 3;
      }
    public int getNumOfCorners() {
        return 3;
      }
}

