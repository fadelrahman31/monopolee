/* INTERFACE TILE PADA BOARD MONOPOLY */

public interface Tile {
    public boolean isOwnable(); // Cek apakah tile dapat dibeli/rent

    public Player getOwner(); // return pemilik tile

    public int getPosition(); // posisi tile pada board

    public void handlePlayer(Player p); // handle kondisi player ketika berada di suatu tile

    public void handleBuyPlayer(Player p);

    public String getName();
}
