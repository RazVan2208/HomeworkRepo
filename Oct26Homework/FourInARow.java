package Oct26Homework;

import java.util.ArrayList;

public class FourInARow {
    public char[][] playingGrid = new char[6][7];
    public int mRow;
    public int mCol;

    public FourInARow(){
    }
    public void placeRed(int row, int col){
    mRow = row;
    mCol = col;
        if(mRow < 6 && mCol < 7){
            playingGrid[row][col] = 'R';
        }
    }
    public void placeYellow(int row, int col){
    mRow = row;
    mCol = col;
        if(mRow < 6 && mCol < 7){
            playingGrid[row][col] = 'Y';
        }
    }
    public char[][] displayPlayGrid(){
        int d = 0;
        for(int i = 0; i < playingGrid[0].length; i += 1){
            for(int j = 0; j < playingGrid.length; j += 1){
                d += 1;
                System.out.println(playingGrid[i][j]);
                if(d % 3 == 0){
                    System.out.println();
                }
            }
        }
        return playingGrid;
    }
}
