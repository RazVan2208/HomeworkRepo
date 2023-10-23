package Oct17Homework;
// ---------- QUESTION 3 -----------
//Pick a popular song and make a Java program that prints out the lyrics in time with the song. Basically a karaoke machine.
import java.util.*;
import java.util.ArrayList;

public class Oct21HomeworkP3 {
    static void PrintOutLyrics(ArrayList<String> strList, double n){
        long startTime = System.currentTimeMillis();

            double convertedNTime = n * 1000;
            int b = 0;
            while(true){
                long currentTime = System.currentTimeMillis();
                long timePassed = currentTime - startTime;
                if(timePassed >= convertedNTime){
                    System.out.println(strList.get(b));
                    startTime = System.currentTimeMillis();
                    b += 1;
            }
            if(b > strList.size() - 1){
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        ArrayList<String> SongLyrics = new ArrayList<String>();
        SongLyrics.add("Life's like a road that you travel on");
        SongLyrics.add("When there's one day here and the next day gone");
        SongLyrics.add("Sometimes you bend and sometimes you stand");
        SongLyrics.add("Sometimes you turn your back to the wind");
        SongLyrics.add("There's a world outside every darkened door");
        SongLyrics.add("Where blues won't haunt you anymore");
        SongLyrics.add("Where brave are free and lovers soar");
        SongLyrics.add("Come ride with me to the distant shore");
        SongLyrics.add("We won't hesitate");
        SongLyrics.add("To break down the garden gate");
        SongLyrics.add("There's not much time left today");
        SongLyrics.add("Life is a highway");
        PrintOutLyrics(SongLyrics, 2.64);
        SongLyrics.clear();
        SongLyrics.add("I wanna ride it all night long");
        SongLyrics.add("If you're going my way");
        SongLyrics.add("I wanna drive it all night long");
        SongLyrics.add("Through all these cities and all these towns");
        PrintOutLyrics(SongLyrics, 4.65);
        SongLyrics.clear();
        SongLyrics.add("It's in my blood, and it's all around");
        SongLyrics.add("I love you now like I loved you then");
        SongLyrics.add("This is the road, and these are the hands");
        SongLyrics.add("From Mozambique to those Memphis nights");
        SongLyrics.add("The Khyber Pass to Vancouver's lights");
        SongLyrics.add("Knock me down and back up again");
        SongLyrics.add("You're in my blood; I'm not a lonely man");
        SongLyrics.add("There's no load I can't hold, A road so rough this I know");
        SongLyrics.add("I'll be there when the light comes in, Tell 'em we're survivors");
        PrintOutLyrics(SongLyrics, 2.44);
        SongLyrics.clear();
        SongLyrics.add("Life is a highway");
        SongLyrics.add("I wanna ride it all night long");
        SongLyrics.add("If you're going my way");
        SongLyrics.add("I wanna drive it all night long");
        SongLyrics.add("Life is a highway");
        PrintOutLyrics(SongLyrics, 4.65);
        SongLyrics.clear();
        SongLyrics.add("I wanna ride it all night long");
        SongLyrics.add("If you're going my way");
        SongLyrics.add("I wanna drive it all night long");
        PrintOutLyrics(SongLyrics, 4.25);
        SongLyrics.clear();
        SongLyrics.add("There was a distance between you and I");
        PrintOutLyrics(SongLyrics, 10.11);
        SongLyrics.clear();
        SongLyrics.add("A misunderstanding once But now we look in the eye");
        PrintOutLyrics(SongLyrics, 21);
        SongLyrics.clear();
        SongLyrics.add("There's no load I can't hold, A road so rough this I know");
        SongLyrics.add("I'll be there when the light comes in, Tell 'em we're survivors");
        PrintOutLyrics(SongLyrics, 3.64);
        SongLyrics.clear();
        SongLyrics.add("Life is a highway");
        SongLyrics.add("I wanna ride it all night long");
        SongLyrics.add("If you're going my way");
        SongLyrics.add("I wanna drive it all night long");
        SongLyrics.add("Life is a highway");
        PrintOutLyrics(SongLyrics, 4.65);
        SongLyrics.clear();
        SongLyrics.add("Life is a highway (Life is a highway)");
        SongLyrics.add("I wanna ride it all night long (wooh, yeah)");
        PrintOutLyrics(SongLyrics, 3.1);
        SongLyrics.clear();
        SongLyrics.add("If you're going my way (Going my way)");
        PrintOutLyrics(SongLyrics, 6.0);
        SongLyrics.clear();
        SongLyrics.add("If you're going my way");
        SongLyrics.add("I wanna drive it all night long");
        SongLyrics.add("Gimme, gimme, gimme, gimme, yeah");
        SongLyrics.add("Life is a highway");
        SongLyrics.add("I wanna ride it all night long");
        PrintOutLyrics(SongLyrics, 3.0);
        SongLyrics.clear();
        SongLyrics.add("If you're going my way");
        PrintOutLyrics(SongLyrics, 7.0);
        SongLyrics.clear();
        SongLyrics.add("I wanna drive it all night long....");
        PrintOutLyrics(SongLyrics, 3.0);

/* 

[04:00.44]If you're going my way
[04:03.19]I wanna drive it all night long*/

    }
}
