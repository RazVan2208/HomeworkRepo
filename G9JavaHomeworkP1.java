public class G9JavaHomeworkP1 {
    /*
     * Make a function where you find all even fibonnaci numbers from 1-1000 (EXCLUSIVE OF 1, EXCLUSIVE OF 1000), this can be done using a for loop.
     * public static int fibonnaciEvenSum(int limit(//limit being your 1000)){}
     * After, use the numbers obtained to find the sum of the even fibonnaci numbers
     */
    public static void main(String[] args) {
        System.out.println(fibonnaciAnswerKey(1000));
    }

    public static int fibonnaciAnswerKey(int limit){
        int FibonnaciVal = 0;
        int OLDERVal = 0;
        int oldVal = 1;
        int sum = 0;
        for(int i = 1; FibonnaciVal < limit; i+=1){
          FibonnaciVal = oldVal + OLDERVal;
       //System.out.println(FibonnaciVal);
          OLDERVal = oldVal;
          oldVal = FibonnaciVal;
          if(FibonnaciVal % 2 == 0 && FibonnaciVal < limit){
            sum += FibonnaciVal;
          }
          
       //  System.out.println(FibonnaciVal);
        }
        System.out.println(sum);
        return sum;
    }
}
