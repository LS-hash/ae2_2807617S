public class Square {
    private int row;
    private int column;
    private boolean occupied;
    private Battleship shipRef;  // what is this?
    private boolean shot;

    public Square(int x, int y, boolean occupied, Battleship shipRef, boolean shot) {
        row = x;
        column = y;
        this.occupied = occupied;
        this.shipRef = shipRef;
        this.shot = shot;

    }

    public boolean occupied(boolean b) {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Battleship getShipRef() {
        return shipRef;
    }

    public void setShipRef(Battleship shipRef) {
        this.shipRef = shipRef;
    }

    public boolean shot() {
        return shot;
    }

    public void setShot(boolean shot) {
        this.shot = shot;
    }

//    public String toString() {
//        return " row = ? " +
//                ", column = ? ";}
////                ", is there a ship there? " + occupied +
////                ", was it shot? " + shot +
////                '}';
////    }

}

