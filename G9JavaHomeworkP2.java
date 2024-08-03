public class G9JavaHomeworkP2 {
    /*
     * Given a limit for a max number, find all the squares of each number that also happen to be cubes. Example 64 = 8^2 but it is 4^3.
     * You can acheive checking for a square by checking if the decimal value of the square root of the value = 0. This means, that you must the square root of the number minus the absolute value of the square root. 
     * If this value returns 0, we know it is a square as square root of 36 = 0, while square root of 35 = 5.99
     * This code is very reliant on while and for loops, especially with embedding them one into another, so be careful on how you approach the embedding of each loop to not get a runtime error.
     * The easiest limit to start with is 4500 max. 
     */
    public static void main(String[] args) {
        String palindrome = "car";
        char[] palindromeArray = palindrome.toCharArray();
        boolean flag = true;
        
        for(int i = 0; i < palindrome.length(); i += 1){
            
            char currentletter = palindromeArray[i];
            System.out.println(currentletter);
            if(palindrome.charAt(i) != currentletter){
                flag = false;   
            }
            System.out.println(flag);
        }
    
        if(flag == true){
            System.out.println("Its a palindrome!");
        } else {
            System.out.println("Dumbass");
        }
    }


}
