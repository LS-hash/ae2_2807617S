public class SmallBattleship extends Battleship {
    // specify the total number of permissible ships of that class on the board
    private static int totalNumberOfSmallShips = 3;

    public static int getTotalNumberOfSmallShips() {
        return totalNumberOfSmallShips;
    }

    public static void setTotalNumberOfSmallShips(int totalNumberOfSmallShips) {
        SmallBattleship.setTotalNumberOfSmallShips(totalNumberOfSmallShips);
    }

    public SmallBattleship(boolean s) {
        super(s, 1, 1);
    }
}
