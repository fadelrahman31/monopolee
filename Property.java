/* CLASS PROPERTY */

public abstract class Property implements Tile {
    private Player owner;
    private String name;
    private int position;
    private final double harga;
    //private final double sewa;

    // constructor
    public Property(Player owner, String name, int position, int harga) {
        this.owner = owner;
        this.name = name;
        this.position = position;
        this.harga = harga;
        //this.sewa = 0.125 * harga;
    }

    // Cek apakah property dapat dibeli/rent
    public boolean isOwnable() {
        boolean own = false;
        if (this.owner == null) {
            own = true;
        }
        return own;
    }

    // return pemilik property
    public Player getOwner() {
        return this.owner;
    }

    // mengubah owner property
    public void setOwner(Player owner) {
        this.owner = owner;
    }

    // return nama property
    public String getName() {
        return this.name;
    }

    // posisi tile pada board
    public int getPosition() {
        return this.position;
    }

    public double getHarga() {
        return this.harga;
    }

    // handle kondisi player ketika berada di suatu tile
    public void handlePlayer(Player p) {
        // Do nothing, yg do something yg anak2 classnya
    }

    public abstract double getSewa(Player owner);

}
