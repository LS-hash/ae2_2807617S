import java.util.Random;

public class Board {
    private static int rows = 10;
    private static int columns = 10;
    private static int totalNumberOfShips = LargeBattleship.getTotalNumberOfLargeShips()
            + MediumBattleship.getTotalNumberOfMediumShips()
            + SmallBattleship.getTotalNumberOfSmallShips(); // the number of ships


    public int getTotalNumberOfShips() {
        return totalNumberOfShips;
    }

    public void setTotalNumberOfShips(int shipNums) {
        this.totalNumberOfShips = shipNums;
    }

    public static Square[][] generateBoard() {
        Square[][] board = new Square[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = new Square(i, j, false, null, false);
            }
        }
        return board;
    }
    public static void generateRandomBattleShips(Square[][] board) {
        // generate ship randomly
        try {
            generateBigShip(board);
            generateMidShip(board);
            generateSmallShip(board);
        } catch (RuntimeException e) {
            System.out.println("====restart please====");
        }
    }

    private static void generateBigShip(Square[][] board) {
        for (int n = 0; n < LargeBattleship.getTotalNumberOfLargeShips(); n++) {
            Battleship ship;
            while (true) {
                // random generate location of ship
                int i = (int) (Math.random() * board.length);
                int j = (int) (Math.random() * board.length);
                if (board[i][j].occupied(true)) continue; // ships do not overlap when they are placed on the board
                board[i][j].occupied(true);
                ship = new LargeBattleship(false); // create a ship
                board[i][j].setShipRef(ship);
                // the first location is ok ,find the suitable second loc
                // ‘coin flip’ some ships placed vertically on the board, whilst others are horizontal.
                if (new Random().nextBoolean()) { //  horizontal
                    if (i - 1 > 0 && i + 1 < 10
                            && board[i - 1][j] != null && !board[i - 1][j].occupied(true)
                            && board[i + 1][j] != null && !board[i + 1][j].occupied(true)) {
                        board[i - 1][j].occupied(true);
                        board[i - 1][j].setShipRef(ship);
                        board[i + 1][j].occupied(true);
                        board[i + 1][j].setShipRef(ship);
//                        System.out.println("  LargeBattleship: " + board[i - 1][j].toString()
//                                + "|||" + board[i][j].toString()
//                                + "|||" + board[i + 1][j].toString()
//                                + "  ship: " + ship.toString());
                        break; //jump out of loop
                    }
                } else { // vertically
                    if (j - 1 > 0 && j + 1 < 10
                            && board[i][j - 1] != null && !board[i][j - 1].occupied(true)
                            && board[i][j + 1] != null && !board[i][j + 1].occupied(true)) {
                        board[i][j - 1].setOccupied(true);
                        board[i][j - 1].setShipRef(ship);
                        board[i][j + 1].setOccupied(true);
                        board[i][j + 1].setShipRef(ship);
//                        System.out.println("  LargeBattleship: " + board[i][j - 1].toString()
//                                + "|||" + board[i][j].toString()
//                                + "|||" + board[i][j + 1].toString()
//                                + "  ship: " + ship.toString());
                        break;
                    }
                }
                board[i][j].setOccupied(false); // This means no second position has been found
                board[i][j].setShipRef(null);
            }
        }
    }

    private static void generateMidShip(Square[][] board) {
        for (int n = 0; n < MediumBattleship.getTotalNumberOfMediumShips(); n++) {
            Battleship ship;
            while (true) {
                // random generate location of ship
                int i = (int) (Math.random() * board.length);
                int j = (int) (Math.random() * board.length);
                if (board[i][j].occupied(true)) continue; // ships do not overlap when they are placed on the board
                board[i][j].occupied(true);
                ship = new MediumBattleship(false); // create a ship
                board[i][j].setShipRef(ship);
                // the first location is ok ,find the suitable second loc
                // ‘coin flip’ some ships placed vertically on the board, whilst others are horizontal.
                if (new Random().nextBoolean()) { //  horizontal
                    if (i - 1 > 0 && board[i - 1][j] != null && !board[i - 1][j].occupied(true)) {
                        board[i - 1][j].occupied(true);
                        board[i - 1][j].setShipRef(ship);
//                        System.out.println("  MediumBattleship: " + board[i - 1][j].toString() + board[i][j].toString() + "  ship: " + ship.toString());
                        break; //jump out of loop
                    }
                    if (i + 1 < 10 && board[i + 1][j] != null && !board[i + 1][j].occupied(true)) {
                        board[i + 1][j].occupied(true);
                        board[i + 1][j].setShipRef(ship);
//                        System.out.println("  MediumBattleship: " + board[i + 1][j].toString() + board[i][j].toString() + "  ship: " + ship.toString());
                        break;
                    }
                } else { // vertically
                    if (j - 1 > 0 && board[i][j - 1] != null && !board[i][j - 1].occupied(true)) {
                        board[i][j - 1].occupied(true);
                        board[i][j - 1].setShipRef(ship);
//                        System.out.println("  MediumBattleship: " + board[i][j - 1].toString() + board[i][j].toString() + "  ship: " + ship.toString());
                        break;
                    }
                    if (j + 1 < 10 && board[i][j + 1] != null && !board[i][j + 1].occupied(true)) {
                        board[i][j + 1].occupied(true);
                        board[i][j + 1].setShipRef(ship);
//                        System.out.println("  MediumBattleship: " + board[i][j + 1].toString() + board[i][j].toString() + "  ship: " + ship.toString());
                        break;
                    }
                }
                board[i][j].occupied(false); // This means no second position has been found
                board[i][j].setShipRef(null);
            }
        }
    }

    private static void generateSmallShip(Square[][] board) {
        for (int n = 0; n < SmallBattleship.getTotalNumberOfSmallShips(); n++) {
            Battleship ship;
            while (true) {
                // random generate location of ship
                int i = (int) (Math.random() * board.length);
                int j = (int) (Math.random() * board.length);
                if (board[i][j].occupied(true)) continue; // ships do not overlap when they are placed on the board
                board[i][j].setOccupied(true);
                ship = new SmallBattleship(false); // create a ship
                board[i][j].setShipRef(ship);
//                System.out.println("  SmallBattleship: " + board[i][j].toString() + "  ship: " + ship.toString());
                break;
            }
        }
    }

    // print the board
//        If the player has not interacted with a square then the representation should be ‘-‘,
//        if the player has fired and missed, then the square representation should be ‘o’
//        and finally ‘x’ if they have hit a ship.
    public static void printBoard(Square[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // is not fired
                if (!board[i][j].shot()) {
                    System.out.print(String.format("%3s", "-"));
                } else if (board[i][j].shot() &&
                        board[i][j].getShipRef()!= null && board[i][j].getShipRef().getRemainingHealth()== 0) {  //  is fired and the ship sink
                    System.out.print(String.format("%3s", "x"));
                } else if (board[i][j].shot()) {  //  is fired but the ship doesnt sink
                    System.out.print(String.format("%3s", "o"));
                }
            }
            System.out.println();
        }
    }
}
