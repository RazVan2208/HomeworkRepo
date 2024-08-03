public class EulerQ10 {
    public static void main(String[] args) {
       sumOfPrimes(2000000);
      }
    
      public static void sumOfPrimes(int limit){
        long sum = 0; // Creates sum
    for (long i = 2000000; i > 1; i -= 1) {
      if (i % 100000 == 0) {
        System.out.println("At " + i);
      }
      if (isPrime(i)) {
        sum += i; // Adds to sum
      } // if
    } // for 
    System.out.println(sum); // Prints sum. Makes sense
      }
    
      public static boolean isPrime(long num){
        if(num == 0 || num == 1){
          return false;
        }
    
        for(long i = 2; i < num; i += 1){
          if(num % i == 0){
            return false;
          }
        }
    
        return true;
      }
}
