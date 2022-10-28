import java.util.Scanner;

public class Main {

//    Board board1 = new Board;
//    Board board2 = new Board;
//    Player player1 = new Player(board1, "Leo");
//    Player player2 = new Player(board2, "Andy");


    public static void main(String[] args) {
        System.out.println(" ");
        System.out.println("INSTRUCTIONS:");
        System.out.println("There is only one board, you are both trying to get the most points by sinking as many ships as possible. There are 6 ships in the game.");
        int allShipNum = LargeBattleship.getTotalNum()
                + MediumBattleship.getTotalNum()
                + SmallBattleship.getTotalNum();
        Scanner sc = new Scanner(System.in);
        Board board1 = new Board();
        Board board2 = new Board();

        Square[][] s = board1.generateBoard();
        board1.generateRandomBattleShips(s);
        System.out.println(" ");
        System.out.println("What is your name, PLAYER 1?");
        Player player1 = new Player(board1, sc.nextLine());
        System.out.println("What is your name, PLAYER 2? ");
        Player player2 = new Player(board2, sc.nextLine());

        boolean finish1Flag = false;
        boolean finish2Flag = false;
        int round = 1;
        while (!finish1Flag && !finish2Flag) {
            System.out.println("==================================================");
            System.out.printf("round:%d \n", round++);
            board1.printBoard(s);
            finish1Flag = player1.takeTurnMethod(board1, s, player1);
            board2.printBoard(s);
            finish2Flag = player2.takeTurnMethod(board2, s, player2);
            System.out.printf("%d ships have been sunk on " + player1.getName() + "'s board, %d left in the game \n", allShipNum - board1.getShipNums(), board1.getShipNums());
            System.out.printf("%d ships have been sunk on " + player2.getName() + "'s board, %d left in the game \n", allShipNum - board1.getShipNums(), board1.getShipNums());

            System.out.println(player1.getName() + ", your score is now: " + player1.getScore());
            System.out.println(player2.getName() + ", your score is now: " + player2.getScore());
        }
        System.out.printf("Game Over...  %s ", player1.getScore() >= player2.getScore() ?
                (player1.getScore() > player2.getScore() ? player1.getName() + "You win!" : " it is a draw.") : player2.getName() + " You win!");

    }
}