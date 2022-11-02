public class LargeBattleship extends Battleship {
    // specify the total number of permissible ships of that class on the board
    private static int totalNumberOfLargeShips = 1;

    public LargeBattleship(boolean s) {
        super(s, 3, 3);
    }

    public static int getTotalNumberOfLargeShips() {
        return totalNumberOfLargeShips;
    }

    public static void setTotalNumberOfLargeShips(int totalNumberOfLargeShips) {
        LargeBattleship.setTotalNumberOfLargeShips(totalNumberOfLargeShips);
    }
}