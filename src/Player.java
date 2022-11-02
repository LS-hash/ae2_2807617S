import java.util.Scanner;

public class Player {
    private final Square[][] board;
    private String name;
    private int score;

    public Player(String name, Board board) {
        this.name = name;
        this.board = Board.generateBoard();
    }

    public boolean takeTurn(Board board, Square[][] square, Player player) {

        System.out.println("%point1  ,which point1 do you want to hit? Please input location x and y as two numbers next to each other, ex. 28: y = 2, x = 8 \n" + player.getName());
        Scanner scanner = new Scanner(System.in);

        char[] c = scanner.nextLine().trim().toCharArray();
        if (c.length != 2 || !Character.isDigit(c[0]) || !Character.isDigit(c[1])) {
            System.out.println("enter irregularly,you lose your turn");
            return false;
        }
        Square square1 = square[(c[0]) - '0'][c[1] - '0']; // char -> int

        if (square1.occupied(true) && square1.shot()) {       //if there is a ship that has been hit, we will get the notification that it's been hit
            System.out.println("the ship on this point1 has already been hit");
        } else if (square1.occupied(true)) {                 //if there is a ship, but it's not been hit, we will get notification "hit!"
            System.out.println("hit!");
            square1.setShot(true);
            Battleship ship = square1.getShipRef();
            int health = ship.getRemainingHealth() - 1;
            // If a player sinks a ship
            if (health == 0) {
                ship.setIfSunk(true);
                board.setTotalNumberOfShips(board.getTotalNumberOfShips() - 1);
                player.setScore(player.getScore() + 1);
                System.out.printf("%point1 sinks a ship,get 1 point ,now %point1'point1 scores is: %d \n", player.getName(), player.getName(), player.getScore());
            }
            ship.setRemainingHealth(health);
        } else if (square1.shot()) {
            System.out.println("there is nothing there...");
        } else {
            square1.setShot(true);
            System.out.println("you missed :<");
        }
        return board.getTotalNumberOfShips() == 0;
    }

    public void setBoard() {
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
