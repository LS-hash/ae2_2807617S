import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(" ");
        System.out.println("INSTRUCTIONS:");
        System.out.println("There is only one board, you are both trying to get the most points by sinking as many ships as possible. There are 6 ships in the game.");
        int allShipNum = LargeBattleship.getTotalNumberOfLargeShips()
                + MediumBattleship.getTotalNumberOfMediumShips()
                + SmallBattleship.getTotalNumberOfSmallShips();
        Scanner scanner = new Scanner(System.in);
        Board board1 = new Board();
        Board board2 = new Board();

        Square[][] s = Board.generateBoard();
        board1.generateRandomBattleShips(s);
        Square[][] s2 = Board.generateBoard();
        board2.generateRandomBattleShips(s2);
        System.out.println("What is your name, PLAYER 1?");
        Player player1 = new Player(scanner.nextLine().trim(), board1 );
        System.out.println("What is your name, PLAYER 2?");
        Player player2 = new Player(scanner.nextLine().trim(), board2);

        boolean finish1Flag = false;
        boolean finish2Flag = false;
        int round = 1;
        while (!finish1Flag && !finish2Flag) {
            System.out.println("==================================================");
            System.out.printf("round:%d \n", round++);
            Board.printBoard(s);
            finish1Flag = player1.takeTurn(board1, s, player1);
            Board.printBoard(s);
            finish2Flag = player2.takeTurn(board2, s, player2);
            System.out.printf("%d ships have been sunk on " + player1.getName() + "'s board, %d left in the game \n", allShipNum - board1.getTotalNumberOfShips(), board1.getTotalNumberOfShips());
            System.out.printf("%d ships have been sunk on " + player2.getName() + "'s board, %d left in the game \n", allShipNum - board2.getTotalNumberOfShips(), board1.getTotalNumberOfShips());

            System.out.println(player1.getName() + ", your score is now: " + player1.getScore());
            System.out.println(player2.getName() + ", your score is now: " + player2.getScore());
        }
        System.out.printf("Game Over...  %s ", player1.getScore() >= player2.getScore() ?
                (player1.getScore() > player2.getScore() ? player1.getName() + "You win!" : " it is a draw.") : player2.getName() + " You win!");

    }
}