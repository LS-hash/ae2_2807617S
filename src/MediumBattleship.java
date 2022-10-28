public class MediumBattleship extends Battleship {
    // specify the total number of permissible ships of that class on the board
    private static int totalNum = 2;

    public static int getTotalNum() {
        return totalNum;
    }

    public static void setTotalNum(int totalNum) {
        MediumBattleship.setTotalNum(totalNum);
    }

    public MediumBattleship(boolean s) {
        super(s, 2, 2);
    }
}
