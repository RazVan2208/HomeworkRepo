package Oct26Homework;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
    FourInARow newGame = new FourInARow();
    Scanner scanner = new Scanner(System.in);
    while(true){
        newGame.displayPlayGrid();
        newGame.DetermineGameWinner();
        if(newGame.DetermineGameWinner() == 1){
            System.out.println("RED WON WOOOOOOOO");
            break;
        }
        if(newGame.DetermineGameWinner() == 2){
            System.out.println("YELLOW WON WOOOOOOOO");
            break;
        }
    newGame.DetermineGameWinner();
    System.out.println("User 1, play first move, only column is needed, if column is taken, place on top, or move to next column");
    int Rcol = scanner.nextInt();
    newGame.placeRed(Rcol);
    newGame.displayPlayGrid();
    scanner.nextLine();
    System.out.println("User 2, play first move, only column is needed, if column is taken, place on top, or move to next column");
    int Ycol = scanner.nextInt();
    newGame.placeYellow(Ycol);
    newGame.DetermineGameWinner();
    newGame.displayPlayGrid();
    }
    }
}
