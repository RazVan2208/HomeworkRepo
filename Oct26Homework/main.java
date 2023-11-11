package Oct26Homework;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
    FourInARow newGame = new FourInARow();
    Scanner scanner = new Scanner(System.in);
    while(true){
        newGame.displayPlayGrid();
    // Place Red in Col
    System.out.println("User 1, play first move, only column is needed, if column is taken, place on top, or move to next column");
    int Rcol = scanner.nextInt();
    newGame.placeRed(Rcol);
    newGame.DetermineGameWinner();
        if(newGame.DetermineGameWinner() == 1){
            System.out.println("RED WON WOOOOOOOO");
            newGame.displayPlayGrid();
            break;
        }
    // Place Yellow in Col
    newGame.DetermineGameWinner();
    if(newGame.DetermineGameWinner() == 1){
        System.out.println("RED WON WOOOOOOOO");
        newGame.displayPlayGrid();
        break;
        }
    if(newGame.DetermineGameWinner() == 2){
        System.out.println("YELLOW WON WOOOOOOOO");
        newGame.displayPlayGrid();
        break;
        }
    scanner.nextLine();
    System.out.println("User 2, play first move, only column is needed, if column is taken, place on top, or move to next column");
    int Ycol = scanner.nextInt();
    newGame.placeYellow(Ycol);
    newGame.DetermineGameWinner();
     if(newGame.DetermineGameWinner() == 2){
            System.out.println("YELLOW WON WOOOOOOOO");
            newGame.displayPlayGrid();
            break;
        }
    System.out.println();
    }
}
}
