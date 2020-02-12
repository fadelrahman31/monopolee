/* CLASS COMMUNITY CHEST SEBAGAI REPRESNTASI TILE COMMUNITY CHEST DI BOARD */

import javax.swing.*;

public class CommunityChest extends Space {
    private Deck deck;

    public CommunityChest(String name, Deck deck, int position) {
        super(name, position);
        this.deck = deck;
    }

    @Override
    public void handlePlayer(Player p) {
        Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda sampai di Community Chest, ambil 1 kartu.\n");
        Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Kartu yang kamu dapat adalah :\n");
        String pesan = "[ "+p.getName()+" ]"+" Kartu yang kamu dapat adalah :\n";
        Board_Game.gameLog.append(deck.printCardText()+"\n");
        pesan = pesan + deck.printCardText()+"\n";
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
