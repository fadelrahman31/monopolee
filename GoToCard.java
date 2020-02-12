/* CLASS GO TO CARD SUBCLASS DARI CARD */

public class GoToCard extends Card {
    private String cardText;
    private int position;
    Board board;


    public GoToCard(String cardText, int position) {
        this.cardText = cardText;
        this.position = position;
    }

    @Override
    public void executeCard(Player p) {
        p.setCursor(position);
        Board_Game.moveCard(p);


    }

    @Override
    public String printCardText() {
        return this.cardText;
    }
}
