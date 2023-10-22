package Oct17Homework;
// ---------- QUESTION 3 -----------
//Pick a popular song and make a Java program that prints out the lyrics in time with the song. Basically a karaoke machine.

public class Oct21HomeworkP3 {
    static void PrintOutLyrics(double msOfSong){
        long startTime = System.currentTimeMillis();
        long lastTimePrinted = startTime;
        boolean PrintedOnce = true;
        int i = 0;
        while(true){
            long currentTime = System.currentTimeMillis();
            long timePassed = currentTime - startTime;
            if(timePassed > msOfSong){
                break;
            }
            
            long timeSinceLastPrint = currentTime - lastTimePrinted;
            if(timePassed >= 30640 && timePassed <= 31640){
                System.out.println("Life's like a road that you travel on");
                timeSinceLastPrint = currentTime;

            }
        
            PrintedOnce = true;
            if(timePassed >= 32640 && timePassed <= 33890){
                System.out.println("When there's one day here and the next day gone");
                timeSinceLastPrint = currentTime;
            }

            if(timePassed >= 34890 && timePassed <= 36380){
                System.out.println("Sometimes you bend and sometimes you stand");
                timeSinceLastPrint = currentTime;
            }
            if(timePassed >= 37380 && timePassed <= 38640){
                System.out.println("Sometimes you turn your back to the wind");
                timeSinceLastPrint = currentTime;
            }
            if(timePassed >= 39640 && timePassed <= 40890){
                System.out.println("There's a world outside every darkened door");
                timeSinceLastPrint = currentTime;
            }
            if(timePassed >= 41890 && timePassed <= 43140){
                System.out.println("Where blues won't haunt you anymore");
                timeSinceLastPrint = currentTime;
            }
            if(timePassed >= 44140 && timePassed <= 45390){
                System.out.println("Where brave are free and lovers soar");
                timeSinceLastPrint = currentTime;
            }
            if(timePassed >= 46390 && timePassed <= 47890){
                System.out.println("Come ride with me to the distant shore");
                timeSinceLastPrint = currentTime;
            }
            if(timePassed >= 48890 && timePassed <= 50380){
                System.out.println("Come ride with me to the distant shore");
                timeSinceLastPrint = currentTime;
            }
            if(timePassed >= 51380 && timePassed <= 52640){
                System.out.println("Come ride with me to the distant shore");
                timeSinceLastPrint = currentTime;
            }
            if(timePassed >= 53640 && timePassed <= 57640){
                System.out.println("Come ride with me to the distant shore");
                timeSinceLastPrint = currentTime;
            }
            if(true){}
        }
    }
    public static void main(String[] args) {
        PrintOutLyrics(276740);
    }
}
