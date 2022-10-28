public class SmallBattleship extends Battleship {
    // specify the total number of permissible ships of that class on the board
    private static int totalNum = 3;

    public static int getTotalNum() {
        return totalNum;
    }

    public static void setTotalNum(int totalNum) {
        SmallBattleship.setTotalNum(totalNum);
    }

    public SmallBattleship(boolean s) {
        super(s, 1, 1);
    }
}
