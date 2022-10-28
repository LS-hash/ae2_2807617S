import java.util.Scanner;

public class Player {
    private String name;

    private Board board;

    private int score;

    public Player(Board board, String name) {
        this.board = board;
        this.name = name;

    }

    public boolean takeTurnMethod(Board b, Square[][] sq, Player p) {
        // ‘xy’ where x represents the row and y represents the column that is to be targeted
        System.out.printf("%s  ,which square do you want to hit? Please input location x and y as two numbers next to each other, ex. 28: x = 2, y = 8 \n", p.getName());
        Scanner sc = new Scanner(System.in);
        // get what num player input
        char[] c = sc.nextLine().trim().toCharArray();
        if (c.length != 2 || !Character.isDigit(c[0]) || !Character.isDigit(c[1])) {
            System.out.println("enter irregularly,you lose your turn");
            return false;
        }
        Square s = sq[(c[0]) - '0'][c[1] - '0']; // char -> int
        //  ship exist and is fired
        if (s.occupied(true) && s.shot()) {
            System.out.println("the ship on this square has already been hit");
        } else if (s.occupied(true)) {  // ship exist and is not fired
            System.out.println("hit!");
            s.setShot(true);
            Battleship ship = s.getShipRef();
            int health = ship.getRemainingHealth() - 1;
            // If a player sinks a ship
            if (health == 0) {
                ship.setIfSunk(true);
                b.setShipNums(b.getShipNums() - 1);
                p.setScore(p.getScore() + 1);
                System.out.printf("%s sinks a ship,get 1 point ,now %s's scores is: %d \n", p.getName(), p.getName(), p.getScore());
            }
            ship.setRemainingHealth(health);
        } else if (s.shot()) {
            System.out.println("there is nothing there...");
        } else {
            s.setShot(true);
            System.out.println("you missed :<");
        }
        if (b.getShipNums() == 0) {
            return true;
        }
        return false;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
