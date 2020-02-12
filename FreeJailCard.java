/* CLASS FREE JAIL CARD SUBCLASS CARD */

public class FreeJailCard extends Card {
    private String cardText;

    public FreeJailCard(String cardText) {
        this.cardText = cardText;
    }

    @Override
    public void executeCard(Player p) {
        p.addfreejailcard();
    }

    @Override
    public String printCardText() {
        return this.cardText;
    }
}
