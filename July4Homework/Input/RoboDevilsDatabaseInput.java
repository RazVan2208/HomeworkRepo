package July4Homework.Input;
import java.io.File;
import java.util.*;
import July4Homework.Input.RoboDevilsDatabaseInterface;
import July4Homework.Output.RoboDevilsDatabaseOutput;

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
import java.io.IOException;

// This part of the code is to take user input 
public class RoboDevilsDatabaseInput{
    static Scanner userInput = new Scanner(System.in);
	public static ArrayList<String> headers = new ArrayList<String>();
	static RoboDevilsDatabaseOutput outputSteal = new RoboDevilsDatabaseOutput();
	public static ArrayList<String> returnList = new ArrayList<String>();
	// Declaring the basic text files, and .csv files. Creates files and the headers.
	public static void main(String[] args) throws IOException {
		int notesScored = 0;

		String fileName = "FRC TEAM DATA.txt";
		String matchFileName = "FRC MATCH DATA.csv";
		File teamData = new File(fileName);
		File matchData = new File(matchFileName);
		teamData.createNewFile();
		matchData.createNewFile();
		FileWriter myWriter = new FileWriter(teamData, true);
		FileWriter matchWriter = new FileWriter(matchData, true);

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
			matchWriter.write(headers.toString() + "\n");
	// This allows the user to input basic team data and team match data until they choose not to. You can input multiple matches one after another due to the while loop	
	for(int i = 0; ; i += 1){
		
		String teamNumberData = inputNumberOfTeam();

		String overAllRanking = inputOverallRanking();

		String districtPoints = inputDistrictPoints();

		String WinLossTieRatio = inputWinLossTieRatio().toString();

		userInput.nextLine();
		ArrayList <String> eventsAttended = inputNameOfEventsAttended();

		userInput.nextLine();

		String speakerOrAmp = inputSpeakerOrAmp();

		String teamDrivebaseData = inputDriveBase();

		System.out.println("Now we will move to match data");

		userInput.nextLine();


		// Adds match data to the .csv file alongside headers
		while(true){
		ArrayList <String> matchInfo = inputMatches();
		
		matchWriter.write(String.join(",", matchInfo) + "\n");
		
		System.out.println("Input another matches stats?");
		String redo = userInput.nextLine();
		if(redo.contains("no")){
		//	System.out.println("The Team's notes scored over these two rounds was:" + tempStorage);
			break;
		} else if (redo.contains("yes")) {

		
		}
	}

		userInput.nextLine();

		boolean askUserForNextInput = askUser();

		


	//	boolean askUserForNextInput = askUser();



		
		
	// Try - Catch block which allows the writer to append both the basic data and the match data	
		try {
			
		
			
			myWriter.write(teamNumberData);
			myWriter.append(',');
			myWriter.append("District Points Earned: " + districtPoints);
			myWriter.append(',');
			myWriter.append("Team Name: " + overAllRanking);
			myWriter.append(',');
			myWriter.append("WinLossTieRatio: " + WinLossTieRatio);
			myWriter.append(',');
			myWriter.append("Events attended: " + eventsAttended.toString());
			myWriter.append(',');
			myWriter.append("Speaker or Amp Primary Choice: " + speakerOrAmp);
			myWriter.append("team drvetrain type: " + teamDrivebaseData + "\n");
			
			
			
			
			myWriter.flush();
			
			
			
			if(askUserForNextInput == false){
				myWriter.close();
				matchWriter.close();
				return;
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	}

	//Input overall year-based ranking for the inputted team
	public static String inputOverallRanking(){
		
        System.out.println("Input This season's overall ranking in the Ontario District");
        String teamName = userInput.nextLine();
        return teamName;
    }

	// Input the number of the team
    public static String inputNumberOfTeam(){
        System.out.println("Input Team Number");
        String teamNumber = userInput.nextLine();
        return teamNumber;
    }

	// Input the type of drivetrain
	public static String inputDriveBase(){
        System.out.println("Input DriveBase type");
        String teamDrivetrain = userInput.nextLine();
        return teamDrivetrain;
    }

	// Input the Win Loss Tie Ratio (Ex: 65:32:0)
    public static ArrayList<Integer> inputWinLossTieRatio(){
        ArrayList<Integer> WinLossTieArr = new ArrayList<Integer>();
        System.out.println("Input Team W:L:T Ratio");
        int winRatio = userInput.nextInt();
        WinLossTieArr.add(winRatio);
        int lossRatio = userInput.nextInt();
        WinLossTieArr.add(lossRatio);
        int tieRatio = userInput.nextInt();
        WinLossTieArr.add(tieRatio);

        return WinLossTieArr;
    }

	// Input accumulated District points
    public static String inputDistrictPoints(){
        System.out.println("Input Amount of District Points this year");
        String year = userInput.nextLine();
        return year;
    }

	// Useless will delete
    public static ArrayList<String> inputSponsors(){
        System.out.println("Input Sponsor Names, once done type end, exactly lowercase");
        ArrayList<String> sponsors = new ArrayList<String>();
		while(true){
			String Sponsor = userInput.nextLine();
			if(Sponsor.equals("end")){
				break;
			}
			sponsors.add(Sponsor);
			
		}
        
        return sponsors;
        
    } 

	// Input the events attended (Can be short form such as Dur for Durham)
    public static ArrayList<String> inputNameOfEventsAttended(){
        System.out.println("Input Event names, this goes by the Canadian basis of 2 District and 1 Provincial");
        ArrayList<String> events = new ArrayList<String>();
        String event1 = userInput.nextLine();
        events.add(event1);
        String event2 = userInput.nextLine();
        events.add(event2);
        String event3 = userInput.nextLine();
        events.add(event3);

        return events;
    }

	// Input whether the team mostly focuses on Speaker or Amp
	public static String inputSpeakerOrAmp(){
		
        System.out.println("Does the team mainly do Speaker or mainly do Amp? Answer 1 of two");
        String teamChoice = userInput.nextLine();
        return teamChoice;
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
		
		
		for(int i = 0; ; i += 1){
		
		System.out.println("Team number Again for logging purposes:");
		String teamNumber = userInput.nextLine();
		returnList.add(teamNumber);

		System.out.println("Input which Alliance the team belonged to (r/b)");
		String alliance = userInput.nextLine();

		System.out.println("Input the match number");
		String matchNumber = userInput.nextLine();

		System.out.println("Input whether the team left in auto(t/f)");
		boolean autoLeave = userInput.nextBoolean();


		userInput.nextLine();
		System.out.println("Input Overall respective team score");
		String respectiveScore = userInput.nextLine();
		System.out.println("Input Overall opposing team score");
		String opposingScore = userInput.nextLine();	
        System.out.println("Input the Number of average cycles (1 note from pickup to score) per game. Ex: 7 cycles = 7 notes scored. (if all count)");
        String teamCycles = userInput.nextLine();
		

		userInput.nextLine();
		
		System.out.println("Input whether the team scored in trap(t/f)");
		boolean trap = userInput.nextBoolean();
		
		System.out.println("Input whether the team is onstage(t/f)");
		boolean isOnstage = userInput.nextBoolean();

		System.out.println("Input whether there was a Harmony(t/f)");
		boolean harmonyAcheived = userInput.nextBoolean();

		System.out.println("Input whether the team parked or not (t/f)");
		boolean parkAcheived = userInput.nextBoolean();
		
		userInput.nextLine();

		returnList.add(alliance);
		returnList.add(matchNumber);
		returnList.add(respectiveScore);
		returnList.add(opposingScore);
		returnList.add(teamCycles);
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
