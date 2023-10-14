package Oct13HomeworkPart1;
// ------ QUESTION 2 ------- //
// Create a class called OrderedPoints that stores a bunch of 2D points ordered by the x-values.
// The constructor should take in no parameters.
// The following public methods should be implemented:
// 	void addPoint(double x, double y) - Adds a point
//	List<Double> getXValues() - Returns a list of doubles, which are the x-values of all the added points, ordered from least to greatest
//	List<Double> getYValues() - Returns a list of doubles, which are the y-values of all the added points, ordered by the corresponding x-values
//	double getXValue(int i) - Returns the ith smallest x-value, where i is 0-indexed. (0 returns the smallest x-value)
//	double getYValue(int i) - Returns the corresponding y-value for the ith-smallest x-value, where i is 0-indexed. (0 returns the corresponding y-value for the smallest x-value)
//	void printPoints() - Prints each of the (x,y) point pairs, ordered by the x-values
// Hint: When you add a point, insert it into the correct spot to keep the list(s) ordered. This will make it easier.

public class Oct13HomeworkP2 {
    public static void main(String[] args) {
      OrderedPoints orderedPoints = new OrderedPoints();
      orderedPoints.addPoint(4, 3);
      orderedPoints.addPoint(45.3, 324.1);
      orderedPoints.addPoint(321, 2);
      orderedPoints.addPoint(45.8, 0);
      orderedPoints.addPoint(1.2, 0.3);
      orderedPoints.addPoint(1.23434, 3);
      orderedPoints.getXValues();
      }
}

