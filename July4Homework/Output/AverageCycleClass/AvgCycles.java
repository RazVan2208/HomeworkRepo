package AverageCycleClass;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class AvgCycles {
    
    public static void main(String[] args) {
      //  System.out.println(retrieveInfo());
     //   System.out.println(putTeamNumberandCycle());
     //   System.out.println(getTeamNumber());

      //  getAvgCyclesOfEachTeam();
      
        System.out.println(rankAllTeams());

    }

    public static List<List<String>> retrieveInfo(){
        List<List<String>> returnedInfo = new ArrayList();
        List<String> individualLines = new ArrayList<>();

        String info; 
        try {
            File readFile = new File("FRC MATCH DATA.csv"); 
            Scanner reader = new Scanner(readFile).useDelimiter(","); 


            while (reader.hasNextLine()) {
                info = reader.nextLine();
                individualLines = Arrays.asList(info.split(",")); 
                returnedInfo.add(individualLines);
            } 
            return returnedInfo;
        } 
        catch (IOException e) {
        } 
        return returnedInfo;
    } 

    public static List<String> getTeamNumber(){
        List<List<String>> info = retrieveInfo();
        List<String> teamNumbers = new ArrayList<>();
        for(int i = 1; i < info.size(); i += 1){
            teamNumbers.add(info.get(i).get(0));
        }
        return teamNumbers;
    }

    public static List<List<String>> putTeamNumberandCycle(){
        List<String> teamNums = new ArrayList<>();
        List<String> teamCycles = new ArrayList<>();

        LinkedHashMap<String, String> teamCycleMap = new LinkedHashMap<String, String>();
        List<List<String>> teamNumCyclePair = new ArrayList<>();

        List<List<String>> linebyline = retrieveInfo();
        for (int i = 1; i < linebyline.size(); i += 1) { 
            for(int j = 0; j < linebyline.get(i).size(); j += 1){
                if(j == 0){
                    teamNums.add(linebyline.get(i).get(j));
                }
                if(j == 5){
                    teamCycles.add(linebyline.get(i).get(j));
                }
            }
            }
        
        for(int i = 0; i < teamNums.size(); i += 1){
           teamNumCyclePair.add(Arrays.asList((teamNums.get(i)), teamCycles.get(i)));
        }
        
        return teamNumCyclePair;
    }

    public static double calculateAvg(int teamNumber){
        List<List<String>> pairs = putTeamNumberandCycle();
        double average = 0;
        double cycleVal = 0;
        double teamAmount = 0;

        for(int i = 0; i < pairs.size(); i += 1){
            if(Integer.valueOf(pairs.get(i).get(0)).equals(teamNumber)){
               // System.out.println(cycleVal);
                cycleVal += Double.valueOf(pairs.get(i).get(1));
                teamAmount += 1;
            }
        }
        average = cycleVal / teamAmount;
        
        return average;

    }


    public static List<List<String>> getAvgCyclesOfEachTeam() {
        LinkedHashMap<String, String> teamCycleMap = new LinkedHashMap<String, String>();
        double respectiveTeamAverage = 0;
        List<String> averages = new ArrayList<>();
        List<List<String>> linktest = putTeamNumberandCycle();
        List<List<String>> teamAndAvgCycle = new ArrayList<>();
        List<String> teamNums = getTeamNumber();
        List<List<String>> finalList = new ArrayList<>();
        
            for(int i = 0; i < teamNums.size(); i += 1){
                respectiveTeamAverage = calculateAvg(Integer.valueOf(teamNums.get(i)));
                averages.add(String.valueOf(respectiveTeamAverage));
                teamAndAvgCycle.add(Arrays.asList((teamNums.get(i)), averages.get(i)));    
            }
            for(int i = 0; i < teamAndAvgCycle.size(); i += 1){
                if(!(finalList.contains(teamAndAvgCycle.get(i)))){
                    finalList.add(teamAndAvgCycle.get(i));
                }
            }
            //System.out.println(finalList);
          //  System.out.println(respectiveTeamAverage);
            // averages.add(String.valueOf(respectiveTeamAverage));
            // teamAndAvgCycle.add(Arrays.asList((teamNums.get(i)), averages.get(i)));
           
        
        return finalList;
      // System.out.println(respectiveTeamAverage);
    }  

    public static List<List<String>> sortTeams(List<List<String>> teamAndAvg, int avgcycle){
        Comparator<List<String>> comparator = new Comparator<List<String>>() {
            @Override
            public int compare(List<String> c1, List<String> c2){
                try {
                    Double num1 = Double.parseDouble(c1.get(avgcycle));
                    Double num2 = Double.parseDouble(c2.get(avgcycle));
                    return num1.compareTo(num2);
                    
                } catch (Exception e) {
                    return c1.get(avgcycle).compareTo(c2.get(avgcycle));
                }
            }
            
        };

        Collections.sort(teamAndAvg, comparator);

        return teamAndAvg;
    }
    public static List<List<String>> rankAllTeams(){
        List<List<String>> unrankedTeams = getAvgCyclesOfEachTeam();
        List<List<String>> rankedTeams = new ArrayList<>();
        
        sortTeams(unrankedTeams, 1);
        return unrankedTeams;
    }

}   
   // public static List<String> retrieveTeamCycle()
   

    
    // public static void rankAllTeamsByCycles(String fileName){
    //     int totalPointsScored = 0;
    //     int pointsScored = 0;
    //     List<List<String>> finalInfo = new ArrayList<>();
    //     ArrayList<Integer> cycleList = new ArrayList<>();
    //     List<List<String>> finalFINALInfo = new ArrayList<>(cycleList.size());
    //     int highestCycle = 0;
    //     int checkCount = 0;
    //     int x = 0;

    //    try {
    //     File readFile = new File(fileName);
    //         Scanner dataReader = new Scanner(readFile).useDelimiter(",");
	// 		if(readFile.exists()){
    //             dataReader.nextLine();
    //     while (dataReader.hasNextLine()) {
            
    //         ArrayList<String> teamInfo = new ArrayList<String>();
    //         String data = dataReader.nextLine();
            
    //         String[] teamStuff = data.split(",");
    //                 for(String i : teamStuff){
    //                     teamInfo.add(i);
    //                 }
    //         // System.out.println(teamInfo);
    //         pointsScored = Integer.valueOf(teamInfo.get(5));

    //         // add each team input to make the list of lists
    //         finalInfo.add(teamInfo);
            
            
            

    //         //totalPointsScored += pointsScored;
            
    //         }

    //         // add the scores to a seperate list that will later be sorted
    //     for(List<String> i : finalInfo){
    //         pointsScored = Integer.valueOf(i.get(5));
    //         cycleList.add(pointsScored); 
    // }
    //     // sort the CYCLES numerically so 58,32,444 becomes 444,58,32
    //     Collections.sort(cycleList, Collections.reverseOrder());
        
    //     //print-check
    //     //System.out.println(cycleList);

    //     // create a new list to reset all elements (I really only did this so my new list wasnt empty)
    //     for(List<String> i : finalInfo){
    //         finalFINALInfo.add(i);
    //     }


    //     // iterate through the final info list, then get the cycles of each input (example input 1 has team 9999 with 8 cycles)
    //     // after that, iterate through the cycles in their list (Remember 444,58,32?)
    //     // if the cycle amount (lets say 444 is the first) equals the cycle from the current list we're in (in final Info), reset that element to the correct one
    //     // basically: 
    //     /*
    //      * original formation:
    //      * cycleList = 8,7,23,21
    //      * after order: cycleList = 23,21,8,7
    //      * 
    //      * original List of Lists formation:
    //      * team9999....cycles 7, team8888...cycles 23, team7777...cycles 21, team6666...cycles8
    //      * 
    //      * going into for loops here:
    //      * get the cycles from each team indivually: first up team 9999
    //      * pointsScored = 7
    //      * iterate through the cycle list; does 7 equal to 23? no, move on
    //      * does 7 equal to 21? no move on
    //      * does 7 equal to 8? no move on
    //      * does 7 equal to 7? yes, set the list of info from team 9999 at the index of cycle list (think of it this way: 4 team inputs, 4 different cycle amounts, creating an equal sized list)
    //      * therefore, putting team9999 at the end of the list.
    //      */
    //     for(List<String> i : finalInfo){
    //         pointsScored = Integer.valueOf(i.get(5));
    //         for(int j = 0; j < cycleList.size(); j += 1){
    //             if(cycleList.get(j) == pointsScored){
    //                 finalFINALInfo.set(j, i);
    //             }
    //         }
    //     }
    //     System.out.println(finalFINALInfo);
        
    //     //System.out.println("The team's total amount of cycles (notes successfuly Scored) over inputted matches is " + totalPointsScored);
    //     dataReader.close();
    // }else{

    // }
    // } catch (IOException e) {
    //     // TODO: handle exception
    // }
    
    // } 

