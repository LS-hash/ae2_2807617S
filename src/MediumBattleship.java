public class MediumBattleship extends Battleship {
    // specify the total number of permissible ships of that class on the board
    private static int totalNumberOfMediumShips = 2;

    public static int getTotalNumberOfMediumShips() {
        return totalNumberOfMediumShips;
    }

    public static void setTotalNumberOfMediumShips(int totalNumberOfMediumShips) {
        MediumBattleship.setTotalNumberOfMediumShips(totalNumberOfMediumShips);
    }

    public MediumBattleship(boolean s) {
        super(s, 2, 2);
    }
}
