public class LargeBattleship extends Battleship {
    // specify the total number of permissible ships of that class on the board
    private static int totalNum = 1;

    public LargeBattleship(boolean s) {
        super(s, 3, 3);
    }

    public static int getTotalNum() {
        return totalNum;
    }

    public static void setTotalNum(int totalNum) {
        LargeBattleship.setTotalNum(totalNum);
    }
}