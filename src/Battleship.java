public class Battleship {
    private boolean ifSunk;
    private int remainingHealth;
    private int shipLocation;


    // this is the class that holds the object "Battleship" which takes two parameters (x and y)
    public Battleship(boolean s, int h, int l) {
        this.ifSunk = s;
        this.remainingHealth = h;
        this.shipLocation = l;

    }

    public boolean ifSunk() {
        return ifSunk;
    }
    public void setIfSunk(boolean ifSunk) {
        this.ifSunk = ifSunk;
    }
    public int getRemainingHealth() {
        return remainingHealth;
    }

    public void setRemainingHealth(int remainHealth) {
        this.remainingHealth = remainHealth;
    }
}


