import java.util.*;

public class HomeworkQ3 {
    /*====================================== QUESTION 3 =====================================
Implement the following function:

static List<Double> getCappedVals(List<Double> initialNums, double min, double max) {
	// Implement the following logic:
	// Go through each number in initialNums.
	// 	If the number is in the range between min and max, add it to the list we return.
	// 	If the number is less than min, then add min to the list we return.
	// 	If the number is greater than max, then add max to the list we return.
} */

public static void main(String[] args) {

    
}
static List<Double> getCappedVals(List<Double> initialNums, double min, double max){
    List<Double> ReturnList = new ArrayList<Double>();
    for(int i = 0; i < initialNums.size(); i += 1){
        if(min < initialNums.get(i) && initialNums.get(i) < max){
            ReturnList.add((double)i);
        }
        if(initialNums.get(i) < min){
            ReturnList.add(min);
        }
        if (initialNums.get(i) > max){
            ReturnList.add(max);
        }
    }
    return ReturnList;
}

}
