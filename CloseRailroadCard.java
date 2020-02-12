/* CLASS CLOSE RAILROAD CARD SUBCLASS CARD */

public class CloseRailroadCard extends Card {
    private String cardText;

    public CloseRailroadCard(String cardText) {
        this.cardText = cardText;
    }

    @Override
    public void executeCard(Player p) {
        int add = 0;
        if (p.getCursor() == 7) {
            add = 8;
        }
        else if (p.getCursor() == 22) {
            add = 3;
        }
        else if (p.getCursor() == 36) {
            add = 9;
            p.addmoney(200); // VARIABEL BLM FIX
        }

        p.setCursor(p.getCursor() + add);
        Board_Game.moveCard(p);
    }

    @Override
    public String printCardText() {
        return this.cardText;
    }
}
