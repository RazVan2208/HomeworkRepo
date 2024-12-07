
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

import AverageCycleClass.AvgCycles;
import AveragePointsClass.AvgPoints;


/*
 * Decide on several stats to collect for scouting for the 2024 FRC Game.

Write a program that takes input from the user for a particular team in a
particular match and stores the data in a file in a format of your choice.

Write another program that is able to open such a file and based on input in
the format of your choosing is able to display data for each team.
	Example of inputs: 
	DONE	view 5036 - maybe this displays the match data for 5036
		rankAllTeams - maybe this ranks all the teams by some metric
		rankAllTeams notesScored - maybe this ranks all the teams by the number of notes scored
		averages notesScored - maybe this shows the average notes scored for each team

 */
public class RoboDevilsDatabaseOutput {
    static Scanner userOverview = new Scanner(System.in);
    
    File leaderboardData = new File("FRC_AverageCycle_Leaderboard.txt");

    
    
    public static void main(String[] args) {

        int quitAmount = 0;
        String fileName = "FRC MATCH DATA.csv";
        System.out.println("What do you wish to do with the current program? Rank By Cycles or View a Team (rank/view)");
        String decision = userOverview.nextLine();
        if(decision.contains("view")){
        
        System.out.println("What team do you wish to view? Input team number. Once you are done, say quit to exit.");
        String teamNumber = userOverview.nextLine();
         while(quitAmount < 1){
         viewTeam(fileName, teamNumber);
         System.out.println("\n" + "Go again?");
        String viewTeamQuit = userOverview.nextLine();
         if(viewTeamQuit.contains("quit") || viewTeamQuit.contains("no")){
             quitAmount += 1;
         } else {
            System.out.println("Would you like to view another team?");
            String secondaryView = userOverview.nextLine();
            if(secondaryView.contains("no")){
                viewTeam(fileName, teamNumber);
            } else {
            System.out.println("What new team?");
            teamNumber = userOverview.nextLine();
            viewTeam(fileName,teamNumber);
        }
         }
     }
        } else if (decision.contains("rank")){
            AvgCycles averageCycles = new AvgCycles();
            AvgPoints averagePoints = new AvgPoints();
            System.out.println("Here are all the teams ranked by their average Cycles" + '\n' +  averageCycles.rankAllTeams());
            System.out.println("Here are all the teams ranked by their average Points Scored" +'\n'+ averagePoints.rankAllTeams());
        }
     }
    
        
      
    
        
    
        
        //rankAllTeamsByAvgCyclePerInputMatches(teamNumber, fileName);
        
        
        
        
        


    

    

    // views specifically team 5036, for now, and maps Headers and User inputs together so it can be read easily.
    public static void viewTeam(String fileName, String teamNumber){

        //Declaring Arraylists (headers comes from input file) and the map
       ArrayList<String> headers = new ArrayList<String>();
        LinkedHashMap<String, String> inputMap = new LinkedHashMap<String, String>();
        Scanner userMatchRequest = new Scanner(System.in);
        

       String teamHeader = "Team Number: ";
			String teamAlliance = "Team Alliance colour ";
			String matchNumber = "matchNumber";
			String teamPointsScored = "Team's Points scored";
			String opposingTeamScore = "Opposing team Score";
			String teamCycles = "Cycles in match";
            String teamNotes = "Notes Scored: ";
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
            headers.add(teamNotes);
			headers.add(autoLeave);
			headers.add(trapScored);
			headers.add(OnstageAcheived);
			headers.add(harmonyCondition);
			headers.add(parkedEndgame);

        

       
        try {
			File readFile = new File(fileName);
            Scanner dataReader = new Scanner(readFile).useDelimiter(",");

			if(readFile.exists()){
            System.out.println("Is there a certain match you are looking for? If so, input number, otherwise press space and the latest match data will be provided.");
            String match = userMatchRequest.nextLine();
           

            // while there are still lines, read the file and break up the team info into seperate strings to add into the ArrayList teamInfo
		 	 while (dataReader.hasNextLine()) {
                ArrayList<String> teamInfo = new ArrayList<String>();
                 String data = dataReader.nextLine();
                if(data.contains(teamNumber) && !(match.isEmpty())){
                    
                    String[] teamStuff = data.split(",");
                    for(String i : teamStuff){
                        teamInfo.add(i);
                     }
                    if(teamInfo.get(2).equals(match)){
                     //Map each header to each string, this works because each arraylist *should* be the same length
                     for(int i = 0; i < headers.size(); i += 1){
                        inputMap.put(headers.get(i), teamInfo.get(i));
                     }
                    }
                } else if(match.isEmpty()){
                    String[] teamStuff = data.split(",");
                    for(String i : teamStuff){
                        teamInfo.add(i);
                     }
                     
                     //Map each header to each string, this works because each arraylist *should* be the same length
                     for(int i = 0; i < headers.size(); i += 1){
                        inputMap.put(headers.get(i), teamInfo.get(i));
                     }
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

