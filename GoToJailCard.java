/* CLASS GO TO JAIL CARD SUBCLASS DARI CARD */

public class GoToJailCard extends Card {
    private String cardText;

    public GoToJailCard(String cardText) {
        this.cardText = cardText;
    }

    @Override
    public void executeCard(Player p) {
        p.setCursor(10);
        if(p.getName().equals(Board_Game.daftarPemain[0].getName())){
            Board_Game.daftarPemain[0].setDiJail(true);
            p.setDiJail(true);
        }else{
            Board_Game.daftarPemain[1].setDiJail(true);
            p.setDiJail(true);
        }
        Board_Game.moveJail(p);
    }

    @Override
    public String printCardText() {
        return this.cardText;
    }
}
