/* CLASS SPACE */

public class Space implements Tile {
    private String name;
    private int position;

    public Space (String name, int position) {
        this.name = name;
        this.position = position;
    }


    // Cek apakah tile dapat dibeli/rent
    public boolean isOwnable() {
        return false;
    }

    // return pemilik tile
    public Player getOwner() {
        return null;
    }

    // posisi tile pada board
    public int getPosition() {
        return this.position;
    }

    // handle kondisi player ketika berada di suatu tile
    public void handlePlayer (Player p) {
        // Do nothing, yg do something yg anak2 classnya
    }

    public void handleBuyPlayer(Player p){
        // Do nothing, yang do buy something hanya anak bawah
    }

    public String getName() {
        return this.name;
    }
}
