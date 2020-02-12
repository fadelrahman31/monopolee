/* CLASS CHANCE SEBAGAI REPRESNTASI TILE CHANCE DI BOARD */

import javax.swing.*;

public class Chance extends Space {
    private Deck deck;

    public Chance(String name, Deck deck, int position) {
        super(name, position);
        this.deck = deck;
    }

    @Override
    public void handlePlayer(Player p) {
        Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda sampai di Chance, ambil 1 kartu.\n");
        String pesan = "[ "+p.getName()+" ]"+" Kartu yang kamu dapat adalah :\n";
        Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Kartu yang kamu dapat adalah :\n");
        pesan = pesan + deck.printCardText()+"\n";
        Board_Game.gameLog.append(deck.printCardText()+"\n");
        JOptionPane.showMessageDialog(null,pesan);
        deck.nextCard(p);
    }

    @Override
    public void handleBuyPlayer(Player p){
        if(p.getName().equals(Board_Game.daftarPemain[0].getName())){
            Board_Game.buy1.setEnabled(false);
        }else{
            Board_Game.buy2.setEnabled(false);
        }
    }

}
