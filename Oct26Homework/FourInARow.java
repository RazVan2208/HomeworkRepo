import java.util.ArrayList;

public class FourInARow {
    public char[][] playingGrid = new char[][]{{' ', ' ', ' ', ' ', ' ', ' ', ' '},{' ', ' ', ' ', ' ', ' ', ' ', ' '},{' ', ' ', ' ', ' ', ' ', ' ', ' '},{' ', ' ', ' ', ' ', ' ', ' ', ' '},{' ', ' ', ' ', ' ', ' ', ' ', ' '},{' ', ' ', ' ', ' ', ' ', ' ', ' '}};
    public int mRow;
    public int mCol;

    public FourInARow(){
         
    }
    public void placeRed(int col){
        for(int j = 5; j >= 0; j -= 1){
            if(playingGrid[j][col] == ' '){
                playingGrid[j][col] = 'R';
                break;
            }
        }
    }
    public void placeYellow(int col){
        for(int j = 5; j >= 0; j -= 1){
            if(playingGrid[j][col] == ' '){
                playingGrid[j][col] = 'Y';
                break;
            }
        }
    }
    public char[][] displayPlayGrid(){
        int d = 0;
        for(int i = 0; i < 6; i += 1){
            for(int j = 0; j < 7; j += 1){
                System.out.print("[" + playingGrid[i][j] + "]");
                if(j == 6){
                    System.out.println();
                }
            }
        }
        return playingGrid;
    }
    public int DetermineGameWinner(){
        int gameState = 0;
         for(int i = 0; i < 6; i += 1){
            for(int n = 0; n <= 7 - 4; n += 1){
               // playingGrid[i][0] = 'B';
                if(playingGrid[i][n] == 'R' && playingGrid[i][n + 1] == 'R' && playingGrid[i][n + 2] == 'R' && playingGrid[i][n + 3] == 'R'){
                    System.out.println("You did it, Four reds in a row!!!");
                    return 1;
                }
                if(playingGrid[i][n] == 'Y' && playingGrid[i][n + 1] == 'Y' && playingGrid[i][n + 2] == 'Y' && playingGrid[i][n + 3] == 'Y'){
                    System.out.println("You did it, Four yellows in a row!!!");
                    return 2;
                }
            }
        } 
         for(int i = 0; i < 6 - 4; i += 1){
            for(int n = 0; n < 7; n += 1){
               // playingGrid[i][0] = 'B';
                if(playingGrid[i][n] == 'R' && playingGrid[i + 1][n] == 'R' && playingGrid[i + 2][n] == 'R' && playingGrid[i + 3][n] == 'R'){
                    System.out.println("You did it, Four reds in a col!!!");
                    return 1;
                }
                if(playingGrid[i][n] == 'Y' && playingGrid[i + 1][n] == 'Y' && playingGrid[i + 2][n] == 'Y' && playingGrid[i + 3][n] == 'Y'){
                    System.out.println("You did it, Four yellows in a col!!!");
                    return 2;
                }
            }
        }
        for(int i = 0; i <= 6 - 4; i += 1){
            for(int n = 0; n <= 7 - 4; n += 1){
               // playingGrid[i][0] = 'B';
                if(playingGrid[i][n] == 'R' && playingGrid[i + 1][n + 1] == 'R' && playingGrid[i + 2][n + 2] == 'R' && playingGrid[i + 3][n + 3] == 'R'){
                    System.out.println("You did it, Four reds in a diagonal!!!");
                    return 1;
                }
                if(playingGrid[i][n] == 'Y' && playingGrid[i + 1][n + 1] == 'Y' && playingGrid[i + 2][n + 2] == 'Y' && playingGrid[i + 3][n + 3] == 'Y'){
                    System.out.println("You did it, Four yellows in a diagonal!!!");
                    return 2;

                }
            }
        } 
        for(int i = 0; i <= 2; i += 1){
            for(int n = 6; n >= 7 - 4; n -= 1){
               // playingGrid[i][0] = 'B';
                if(playingGrid[i][n] == 'R' && playingGrid[i + 1][n - 1] == 'R' && playingGrid[i + 2][n - 2] == 'R' && playingGrid[i + 3][n - 3] == 'R'){
                    System.out.println("You did it, Four reds in a diagonal!!!");
                    return 1;
                }
                if(playingGrid[i][n] == 'Y' && playingGrid[i + 1][n - 1] == 'Y' && playingGrid[i + 2][n - 2] == 'Y' && playingGrid[i + 3][n - 3] == 'Y'){
                    System.out.println("You did it, Four yellows in a diagonal!!!");
                    return 2;

                }
            }
        }
    return 0; 
    }
}
