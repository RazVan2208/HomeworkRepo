import java.util.*;
public class EulerQ5 {
    public static void main(String[] args) {
      SmallestMultiple();  
    }

  public static void SmallestMultiple(){
    List<Integer> Divisors = new ArrayList<Integer>();
    int num = 0;
    int count = 0;
    while(count != 20){
    for(int i = 0; i < 20; i += 1){
      if(num % i == 0){
        count+=1;
      }
      if(count == 20){
        System.out.println("The num is " + num);
      }
    }
    
    num+=1;
    count = 0;
  }
  }
}

