package Oct13HomeworkPart1;
// ------ QUESTION 1 ------- //
// Given two points, figure out what line goes between those two points. 
// Given a value x, return the corresponding y-value on the line you just found.
// Example: x1=0, y1=0, x2=1, y2=1, x=2 -> Should return 2.
public class Oct13HomeworkP1 {
    static double lineInterpolate(double x1, double y1, double x2, double y2, double x){
        double slopeOfLine;
        double yIntercept;
        double missingY;
        slopeOfLine = (y2 - y1) / (x2 - x1);
        yIntercept = -(slopeOfLine * x1) + y1;
        System.out.println(yIntercept);
        String EquationOfTheLine = "The equation of the line is y = " + slopeOfLine + "x + " + yIntercept;
        System.out.println(EquationOfTheLine);
        missingY = slopeOfLine * x + yIntercept;
        return missingY;
    }
    public static void main(String[] args) {
        System.out.println(lineInterpolate(1, 3, 5, 7, 8));
      }
}
