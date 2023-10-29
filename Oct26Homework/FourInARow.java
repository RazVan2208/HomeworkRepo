package Oct26Homework;

import java.util.ArrayList;

public class FourInARow {
    public char[][] playingGrid = new char[6][7];
    public int mRow;
    public int mCol;

    public FourInARow(){
         
    }
    public void placeRed(int row, int col){
    boolean spaceIsTakenRed = false;
    mRow = row;
    mCol = col;
        if(playingGrid[row][col] != 'R' && mRow < 6 && mCol < 7){
            playingGrid[row][col] = 'R';
        }

    }
    public void placeYellow(int row, int col){
    mRow = row;
    mCol = col;
        if(playingGrid[row][col] != 'Y' && mRow < 6 && mCol < 7){
            playingGrid[row][col] = 'Y';
        }
        if(playingGrid[row][col] == 'Y' || playingGrid[row][col] == 'R'){
            
        }
    }
    public char[][] displayPlayGrid(){
        int d = 0;
        for(int i = 0; i < playingGrid[0].length; i += 1){
            for(int j = 0; j < playingGrid.length; j += 1){
                d += 1;
                System.out.print("[" + playingGrid[i][j] + "]");
                if(d % 6 == 0){
                    System.out.println();
                }
            }
        }
        return playingGrid;
    }
}
