package AveragePointsClass;
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
public class AvgPoints {
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
  
      public static List<List<String>> putTeamNumberandScore(){
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
                  if(j == 6){
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
          List<List<String>> pairs = putTeamNumberandScore();
          double average = 0;
          double scoreVal = 0;
          double teamAmount = 0;
  
          for(int i = 0; i < pairs.size(); i += 1){
              if(Integer.valueOf(pairs.get(i).get(0)).equals(teamNumber)){
                 // System.out.println(cycleVal);
                  scoreVal += Double.valueOf(pairs.get(i).get(1));
                  teamAmount += 1;
              }
          }
          average = scoreVal / teamAmount;
          
          return average;
  
      }
  
  
      public static List<List<String>> getAvgCyclesOfEachTeam() {
          LinkedHashMap<String, String> teamCycleMap = new LinkedHashMap<String, String>();
          double respectiveTeamAverage = 0;
          List<String> averages = new ArrayList<>();
          List<List<String>> linktest = putTeamNumberandScore();
          List<List<String>> teamAndAvgScore = new ArrayList<>();
          List<String> teamNums = getTeamNumber();
          List<List<String>> finalList = new ArrayList<>();
          
              for(int i = 0; i < teamNums.size(); i += 1){
                  respectiveTeamAverage = calculateAvg(Integer.valueOf(teamNums.get(i)));
                  averages.add(String.valueOf(respectiveTeamAverage));
                  teamAndAvgScore.add(Arrays.asList((teamNums.get(i)), averages.get(i)));    
              }
              for(int i = 0; i < teamAndAvgScore.size(); i += 1){
                  if(!(finalList.contains(teamAndAvgScore.get(i)))){
                      finalList.add(teamAndAvgScore.get(i));
                  }
              }
              //System.out.println(finalList);
            //  System.out.println(respectiveTeamAverage);
              // averages.add(String.valueOf(respectiveTeamAverage));
              // teamAndAvgCycle.add(Arrays.asList((teamNums.get(i)), averages.get(i)));
             
          
          return finalList;
        // System.out.println(respectiveTeamAverage);
      }  
  
      public static List<List<String>> sortTeams(List<List<String>> teamAndAvg, int avgscore){
          Comparator<List<String>> comparator = new Comparator<List<String>>() {
              @Override
              public int compare(List<String> c1, List<String> c2){
                  try {
                      Double num1 = Double.parseDouble(c1.get(avgscore));
                      Double num2 = Double.parseDouble(c2.get(avgscore));
                      return num1.compareTo(num2);
                      
                  } catch (Exception e) {
                      return c1.get(avgscore).compareTo(c2.get(avgscore));
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
