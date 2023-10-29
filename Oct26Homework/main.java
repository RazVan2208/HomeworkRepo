package Oct26Homework;

public class main {
    public static void main(String[] args) {
    FourInARow newGame = new FourInARow();
    newGame.placeRed(3, 5);
    newGame.placeYellow(2, 4);
    newGame.placeRed(2, 4);
    newGame.placeRed(2, 1);
    newGame.displayPlayGrid();
    }
}
