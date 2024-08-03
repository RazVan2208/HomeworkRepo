package May20Homework;

import java.util.ArrayList;
import java.util.List;

/*
 * Here is a function signature:


Assume that each list is of the same length/size. Return a new list where the
0th element is the 0th element from list0, the 1st element is the 0th element
in list1, the 2nd element is the 0th element in list2, the 3rd element is the
1st element from list0 and so on.
 */
public class HomeworkQ5 {
    public static void main(String[] args) {
        List<String> list0 = new ArrayList<>();
        list0.add("1");
        list0.add("4");
        list0.add("7");
        List<String> list1 = new ArrayList<>();
        list1.add("2");
        list1.add("5");
        list1.add("8");
        List<String> list2 = new ArrayList<>();
        list2.add("3");
        list2.add("6");
        list2.add("9");
        System.out.println(zipperMergeThreeLists(list0, list1, list2));
    }
    static List<String> zipperMergeThreeLists(List<String> list0, List<String> list1, List<String> list2) {
        List<String> ReturnList = new ArrayList<>();
        for(int i = 0; i < list0.size(); i += 1){
            ReturnList.add(list0.get(i));
            ReturnList.add(list1.get(i));
            ReturnList.add(list2.get(i));
        }
        return ReturnList;
    }
}
