package Oct17Homework;
import java.util.List;
import java.util.*;
import java.lang.Math;
// ---------- QUESTION 1 -----------
// Make a function that given three double values - start, stop and stepSize,
//  return a list of double values where the first element is the start value, the
//  last element is less than or equal to the stop value and all the elements are
//  the values in between, increased or decreased by the specified step size.
// Example: start=4, stop=5, stepSize=0.1 -> Return {4, 4.1, 4.2, 4.3, 4.4, 5}.
// Example: start=8, stop=-1.2, stepSize=-0.5 -> Return {8, 7.5, 7, 6.5, 6, 6.5, 5, 4.5, 4, 3.5, 3, 2.5, 2, 1.5, 1, 0.5, 0, -0.5, -1}
public class Oct17HomeworkP1 {

    static void rangeList(double start, double stop, double stepSize){
        ArrayList<Double> returnList = new ArrayList<Double>();
        for(double i = start; i >= start && i <= stop; i += stepSize){
            returnList.add(i);
        } 
           System.out.println(returnList); 

    }
    public static void main(String[] args) {
        rangeList(4, 5, 0.1);
    }
}
