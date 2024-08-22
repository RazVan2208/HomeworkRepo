package July4Homework.Output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import July4Homework.Input.RoboDevilsDatabaseInput;

/*
 * Decide on several stats to collect for scouting for the 2024 FRC Game.

Write a program that takes input from the user for a particular team in a
particular match and stores the data in a file in a format of your choice.

Write another program that is able to open such a file and based on input in
the format of your choosing is able to display data for each team.
	Example of inputs: 
		view 5036 - maybe this displays the match data for 5036
		rankAllTeams - maybe this ranks all the teams by some metric
		rankAllTeams notesScored - maybe this ranks all the teams by the number of notes scored
		averages notesScored - maybe this shows the average notes scored for each team

 */
public class RoboDevilsDatabaseOutput {
    static Scanner userOverview = new Scanner(System.in);
    static RoboDevilsDatabaseInput inputVals = new RoboDevilsDatabaseInput();
    File leaderboardData = new File("FRC_AverageCycle_Leaderboard.txt");

    
    
    public static void main(String[] args) {
        try {
        File leaderboardData = new File("FRCAverageCycleLeaderboard.txt");
        leaderboardData.createNewFile();
        FileWriter leaderboardWriter = new FileWriter(leaderboardData, false);
        String fileName = "FRC MATCH DATA.csv";
        while(true){
        System.out.println("What team do you wish to view? Input team number");
        String teamNumber = userOverview.nextLine();
        
        //viewTeam(fileName, teamNumber);
        rankAllTeamsByCycles(fileName);
        //rankAllTeamsByAvgCyclePerInputMatches(teamNumber, fileName);
        

        System.out.println("Do you wish to add another team to the leaderboard?");
        if(userOverview.nextLine().contains("no")){
            leaderboardWriter.close();
            break;
        }
        } } catch (IOException e) {
            // TODO: handle exception
        }
        
        


    }

    public static void rankAllTeamsByCycles(String fileName){
        int totalPointsScored = 0;
        int pointsScored = 0;
        List<List<String>> finalInfo = new ArrayList<>();
        ArrayList<Integer> cycleList = new ArrayList<>();
        List<List<String>> finalFINALInfo = new ArrayList<>(cycleList.size());
        int highestCycle = 0;
        int checkCount = 0;
        int x = 0;

       try {
        File readFile = new File(fileName);
            Scanner dataReader = new Scanner(readFile).useDelimiter(",");
			if(readFile.exists()){
                dataReader.nextLine();
        while (dataReader.hasNextLine()) {
            
            ArrayList<String> teamInfo = new ArrayList<String>();
            String data = dataReader.nextLine();
            
            String[] teamStuff = data.split(",");
                    for(String i : teamStuff){
                        teamInfo.add(i);
                    }
            // System.out.println(teamInfo);
            pointsScored = Integer.valueOf(teamInfo.get(5));

            // add each team input to make the list of lists
            finalInfo.add(teamInfo);
            
            
            

            //totalPointsScored += pointsScored;
            
            }

            // add the scores to a seperate list that will later be sorted
        for(List<String> i : finalInfo){
            pointsScored = Integer.valueOf(i.get(5));
            cycleList.add(pointsScored); 
    }
        // sort the CYCLES numerically so 58,32,444 becomes 444,58,32
        Collections.sort(cycleList, Collections.reverseOrder());
        
        //print-check
        System.out.println(cycleList);

        // create a new list to reset all elements (I really only did this so my new list wasnt empty)
        for(List<String> i : finalInfo){
            finalFINALInfo.add(i);
        }


        // iterate through the final info list, then get the cycles of each input (example input 1 has team 9999 with 8 cycles)
        // after that, iterate through the cycles in their list (Remember 444,58,32?)
        // if the cycle amount (lets say 444 is the first) equals the cycle from the current list we're in (in final Info), reset that element to the correct one
        // basically: 
        /*
         * original formation:
         * cycleList = 8,7,23,21
         * after order: cycleList = 23,21,8,7
         * 
         * original List of Lists formation:
         * team9999....cycles 7, team8888...cycles 23, team7777...cycles 21, team6666...cycles8
         * 
         * going into for loops here:
         * get the cycles from each team indivually: first up team 9999
         * pointsScored = 7
         * iterate through the cycle list; does 7 equal to 23? no, move on
         * does 7 equal to 21? no move on
         * does 7 equal to 8? no move on
         * does 7 equal to 7? yes, set the list of info from team 9999 at the index of cycle list (think of it this way: 4 team inputs, 4 different cycle amounts, creating an equal sized list)
         * therefore, putting team9999 at the end of the list.
         */
        for(List<String> i : finalInfo){
            pointsScored = Integer.valueOf(i.get(5));
            for(int j = 0; j < cycleList.size(); j += 1){
                if(cycleList.get(j) == pointsScored){
                    finalFINALInfo.set(j, i);
                }
            }
        }
        System.out.println(finalFINALInfo);
        
        //System.out.println("The team's total amount of cycles (notes successfuly Scored) over inputted matches is " + totalPointsScored);
        dataReader.close();
    }else{

    }
    } catch (IOException e) {
        // TODO: handle exception
    }
    
    } 

    // views specifically team 5036, for now, and maps Headers and User inputs together so it can be read easily.
    public static void viewTeam(String fileName, String teamNumber){

        //Declaring Arraylists (headers comes from input file) and the map
       ArrayList<String> headers = new ArrayList<String>();
        LinkedHashMap<String, String> inputMap = new LinkedHashMap<String, String>();
        LinkedHashMap<String, Integer> sortedLeaderBoard = new LinkedHashMap<String, Integer>();
        

       String teamHeader = "Team Number: ";
			String teamAlliance = "Team Alliance colour ";
			String matchNumber = "matchNumber";
			String teamPointsScored = "Team's Points scored";
			String opposingTeamScore = "Opposing team Score";
			String teamCycles = "Cycles in match";
			String autoLeave = "Left in auto period?";
			String trapScored = "Trap Score Acheived?";
			String OnstageAcheived = "Onstage climb Acheived?";
			String harmonyCondition = "Harmony condition Acheived?";
			String parkedEndgame = "Parked in endgame?";
            headers.add(teamHeader);
			headers.add(teamAlliance);
			headers.add(matchNumber);
			headers.add(teamPointsScored);
			headers.add(opposingTeamScore);
			headers.add(teamCycles);
			headers.add(autoLeave);
			headers.add(trapScored);
			headers.add(OnstageAcheived);
			headers.add(harmonyCondition);
			headers.add(parkedEndgame);

       
       
        try {
			File readFile = new File(fileName);
            Scanner dataReader = new Scanner(readFile).useDelimiter(",");

			if(readFile.exists()){
            
			System.out.println("This team Number's data file exists! Lets read it shall we?");

            // while there are still lines, read the file and break up the team info into seperate strings to add into the ArrayList teamInfo
		 	 while (dataReader.hasNextLine()) {
                ArrayList<String> teamInfo = new ArrayList<String>();
                 String data = dataReader.nextLine();
                if(data.contains(teamNumber)){
                    String[] teamStuff = data.split(",");
                    for(String i : teamStuff){
                        teamInfo.add(i);
                     }
                     
                     //Map each header to each string, this works because each arraylist *should* be the same length
                     for(int i = 0; i < headers.size(); i += 1){
                        inputMap.put(headers.get(i), teamInfo.get(i));
                     }
                     
                } else {

             }
             
         // System.out.println(headersToTeamMap);
        //     System.out.println(dataReader.nextLine());
             
                  
            }
            LinkedHashMap<String, String> headersToTeamMap = new LinkedHashMap<String, String>(inputMap);
                      for (Map.Entry<String, String> formattedInputMap : headersToTeamMap.entrySet()){
                        System.out.println(formattedInputMap.getKey() + " " + formattedInputMap.getValue());
                        }
                        
          //  System.out.println(inputMap);
             dataReader.close();
            } else {
                System.out.println("Make sure you imported the Data for this file prior to asking for its output");

            }
            
	
			
		
		} catch (IOException e) {
			// TODO: handle exception
		}
    }

    public static int rankAllTeamsByAvgCyclePerInputMatches(String teamNumber, String fileName){
        int totalPointsScored = 0;
        int pointsScored = 0;
        int timesParsed = 0;
        int cycleAverageOverMatches = 0;
        ArrayList<Integer> scoreTracks = new ArrayList<Integer>();
        
       try {
        File readFile = new File(fileName);
            Scanner dataReader = new Scanner(readFile).useDelimiter(",");
			if(readFile.exists()){
        while (dataReader.hasNextLine()) {
            ArrayList<String> teamInfo = new ArrayList<String>();
            String data = dataReader.nextLine();
           if(data.contains(teamNumber)){
            timesParsed += 1;
            String[] teamStuff = data.split(",");
                    for(String i : teamStuff){
                        teamInfo.add(i);
                     }
            pointsScored = Integer.valueOf(teamInfo.get(5));
            
            totalPointsScored += pointsScored;
            cycleAverageOverMatches = totalPointsScored / timesParsed;
            
            }else {
              //  dataReader.nextLine();
            }
        }
        scoreTracks.add(cycleAverageOverMatches);
        
        
        System.out.println("The team's average amount of cycles over " + timesParsed + " matches is " + cycleAverageOverMatches +"(truncated value)");
        
        dataReader.close();
    }else{

    }
    } catch (IOException e) {
        // TODO: handle exception
    }
       // createLeaderBoard(teamNumber, cycleAverageOverMatches);
        return cycleAverageOverMatches;
    } 

    // public static LinkedHashMap<String, Integer> createLeaderBoard(String teamNumber, int averageNotesScored){
    //     Map<String, Integer> leaderBoard = new HashMap<String, Integer>();
    //     leaderBoard.put(teamNumber, averageNotesScored);
    //     LinkedHashMap<String, Integer> sortedLeaderBoard = new LinkedHashMap<String, Integer>();
    //     List<Integer> leaderBoardByNumericalValues = new ArrayList<Integer>(leaderBoard.values());
    //     Collections.sort(leaderBoardByNumericalValues);

    //     for(int i : leaderBoardByNumericalValues){
    //         for (Map.Entry<String, Integer> entry : leaderBoard.entrySet()) {
    //             if (entry.getValue().equals(i)) {
    //                 sortedLeaderBoard.put(entry.getKey(), i);
    //             }
    //         }
    //     }
        
    //     System.out.println(sortedLeaderBoard);
    //     return sortedLeaderBoard;
    // }
    
}
