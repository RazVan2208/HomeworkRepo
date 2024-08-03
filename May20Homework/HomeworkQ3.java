package May20Homework;

import java.util.*;

/* 
 * Here are two function signatures:

static List<Double> filterAllInRange(List<Double> nums, min, max) {
	// Fill in the rest
}Let 

static void printAllInRange(List<Double> nums, min, max) {
	// Fill in the rest
}

filterAllInRange returns a new list containing all x in nums such that min <= x <= max.
printAllInRange every value x in nums such that min <= x <= max.
Write printAllInRange such that it makes use of filterAllInRange. You are not allowed to 
use any if statements in printAllInRange.
*/
public class HomeworkQ3 {
    public static void main(String[] args) {
        List<Double> Input = new ArrayList<Double>();
        Input.add(1.0);
        Input.add(2.0);
        Input.add(3.0);
        Input.add(4.0);
        Input.add(5.0);
        Input.add(6.0);
        Input.add(7.0);

        printAllInRange(Input, 2, 8);
    }
    static List<Double> filterAllInRange(List<Double> nums, double min, double max) {
        List<Double> ReturnList = new ArrayList<Double>();
        for(double i : nums){
            if(i >= min && i <= max){
                ReturnList.add(i);
            }
        }
        return ReturnList;
    }

     static void printAllInRange(List<Double> nums, double min, double max) {
        List<Double> ReturnList = new ArrayList<Double>(filterAllInRange(nums, min, max));
        for(double i = 0; i < ReturnList.size(); i += 1){
            System.out.println(ReturnList.get((int)i));
        }

     }
}
