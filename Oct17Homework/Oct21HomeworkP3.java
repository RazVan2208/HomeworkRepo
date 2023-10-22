package Oct17Homework;
// ---------- QUESTION 3 -----------
//Pick a popular song and make a Java program that prints out the lyrics in time with the song. Basically a karaoke machine.

public class Oct21HomeworkP3 {
    static void PrintOutLyrics(double msOfSong){
        long startTime = System.currentTimeMillis();
        long lastTimePrinted = startTime;
        int i = 0;
        while(true){
            long currentTime = System.currentTimeMillis();
            long timePassed = currentTime - startTime;
            if(timePassed > msOfSong){
                break;
            }
            long timeSinceLastPrint = currentTime - lastTimePrinted;
            if(timePassed >= 30640 && timePassed <= 32640){
                i = 1;
                System.out.println("Life's like a road that you travel on");
                timeSinceLastPrint = currentTime;
            }
            i = 0;
            if(timePassed >= 34890 && timePassed <= 37380 && i == 1){
                System.out.println("Sometimes you bend and sometimes you stand");
                timeSinceLastPrint = currentTime;
                i = 0;
            }

            
        }
    }
    public static void main(String[] args) {
        PrintOutLyrics(276740);
    }
}
