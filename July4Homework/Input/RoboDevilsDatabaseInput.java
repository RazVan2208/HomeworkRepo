package July4Homework.Input;
import java.io.File;
import java.util.*;



import java.io.FileWriter;   // Import the FileWriter class
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

 //**IMPORTANT INFO BEFORE USING: DELETE THE CURRENT MATCH DATA, TEAM DATA, AND CYCLE LEADERBOARD. It will just make your experience easier as you do not have to work with old values */
import java.io.IOException;

// This part of the code is to take user input 
public class RoboDevilsDatabaseInput{
    static Scanner userInput = new Scanner(System.in);
	public static ArrayList<String> headers = new ArrayList<String>();

	
	// Declaring the basic text files, and .csv files. Creates files and the headers.
	public static void main(String[] args) throws IOException {
		int notesScored = 0;

		
		String matchFileName = "FRC MATCH DATA.csv";
		
		File matchData = new File(matchFileName);
	
		matchData.createNewFile();
	
		FileWriter matchWriter = new FileWriter(matchData, true);

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

			System.out.println("Is this a continuing file from a previous input? Yes or No");
			String reWrite = userInput.nextLine();
			
			if(reWrite.contains("yes")){

			} else {
				matchWriter.write(headers.toString() + "\n");
			}
			
	// This allows the user to input basic team data and team match data until they choose not to. You can input multiple matches one after another due to the while loop	
	for(int i = 0; ; i += 1){
	

		System.out.println("Lets Input match data");



		// Adds match data to the .csv file alongside headers
		while(true){
		ArrayList <String> matchInfo = inputMatches();
		
		matchWriter.write(String.join(",", matchInfo) + "\n");
		
		System.out.println("Input another matches stats?");
		String redo = userInput.nextLine();
		if(redo.contains("no")){
		//	System.out.println("The Team's notes scored over these two rounds was:" + tempStorage);
			break;
		} else {

		
		}
	}

		userInput.nextLine();

		boolean askUserForNextInput = askUser();

		


	//	boolean askUserForNextInput = askUser();



		
		
	// Try - Catch block which allows the writer to append both the basic data and the match data	
		try {	
			
			if(askUserForNextInput == false){
				matchWriter.close();
				return;
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	}


	

	// Ask the user if they would like to input another team once they are done with matches for the previous team
	public static boolean askUser(){
		
        System.out.println("Do you wish to input another team?");
		if(userInput.nextLine().toLowerCase().equals("yes")){
			return true;
		} else {
			return false;
		}
    }

	// Input all useful match data. This will be a new arraylist for each new input
	public static ArrayList<String> inputMatches(){
		ArrayList<String> returnList = new ArrayList<String>();
		
		for(int i = 0; ; i += 1){
		
		System.out.println("Team number for logging purposes:");
		String teamNumber = userInput.nextLine();
		returnList.add(teamNumber);

		System.out.println("Input which Alliance the team belonged to (red/blue) type it out");
		String alliance = userInput.nextLine();

		System.out.println("Input the match number");
		String matchNumber = userInput.nextLine();

		System.out.println("Input whether the team left in auto (true/false) type it out");
		boolean autoLeave = userInput.nextBoolean();


		userInput.nextLine();
		System.out.println("Input Overall respective team score");
		String respectiveScore = userInput.nextLine();
		System.out.println("Input Overall opposing team score");
		String opposingScore = userInput.nextLine();	
        System.out.println("Input the Number of average cycles (1 note from pickup to score) per game. Ex: 7 cycles (if all count)");
        String teamCycles = userInput.nextLine();
		System.out.println("Input the Number of notes scored per game");
		String teamNotes = userInput.nextLine();

		userInput.nextLine();
		
		System.out.println("Input whether the team scored in trap (true/false) type it out");
		boolean trap = userInput.nextBoolean();
		
		System.out.println("Input whether the team is onstage (true/false) type it out");
		boolean isOnstage = userInput.nextBoolean();

		System.out.println("Input whether there was a Harmony (true/false) type it out");
		boolean harmonyAcheived = userInput.nextBoolean();

		System.out.println("Input whether the team parked or not (true/false) type it out");
		boolean parkAcheived = userInput.nextBoolean();
		
		userInput.nextLine();

		returnList.add(alliance);
		returnList.add(matchNumber);
		returnList.add(respectiveScore);
		returnList.add(opposingScore);
		returnList.add(teamCycles);
		returnList.add(teamNotes);
		returnList.add(String.valueOf(autoLeave));
		returnList.add(String.valueOf(trap));
		returnList.add(String.valueOf(isOnstage));
		returnList.add(String.valueOf(harmonyAcheived));
		returnList.add(String.valueOf(parkAcheived));

		

		return returnList;
		}
		
	}

	//Simple get function to return headers for Output file


	// In-Progress: Adds up notes per team input
	public static int notesScored(String notesScored){
		int intNotes = Integer.valueOf(notesScored);
		return intNotes;
	}
	
	


}
