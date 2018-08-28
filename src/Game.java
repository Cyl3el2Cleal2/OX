import java.util.*;
public class Game {
    private static OX game;
    public static void main(String arg[]){
    Scanner kb = new Scanner(System.in);
    game = new OX();
    game.start();
    int x,y;
    while (true){

        game.displayBoard();
        System.out.print(game.getCurrentPlayer()+" (col): ");
        y=kb.nextInt();
        System.out.print(game.getCurrentPlayer()+" (row): ");
        x=kb.nextInt();
        game.put(x,y);
        if(game.checkWin(x,y)==true){
            game.displayBoard();
            printScore();
            game.start();
            continue;
        }
        if(game.isDraw()){

            game.displayBoard();
            printScore();
            game.start();
            continue;
        }

        game.switchPlayer();



    }











    }
    private static void printScore() {
        System.out.println("X win: " + game.getScoreX());
        System.out.println("O win: " + game.getScoreO());
        System.out.println("Draw: " + game.getScoreDraw());
    }


}










