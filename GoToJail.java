/* CLASS GO TO JAIL SEBAGAI SUBCLASS SPACE */

import javax.swing.*;
import java.awt.*;

public class GoToJail extends Space {
    private String name;
    private int position;

    public GoToJail(String name, int position) {
        super(name, position);
    }

    @Override
    public void handlePlayer(Player p) {
        Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Masuk penjara loe, HALO POLISI!!!!\n");

        if (p.getCursor() == 30) {
            p.setCursor(10);
            if(p.getName().equals(Board_Game.daftarPemain[0].getName())){
                Board_Game.daftarPemain[0].setDiJail(true);
                p.setDiJail(true);
            }else{
                Board_Game.daftarPemain[1].setDiJail(true);
                p.setDiJail(true);
            }
            JOptionPane.showMessageDialog(null, "[ "+Board_Game.currPlayer.getName() + " ]"+", you're locked In!", "You're  in jail!", JOptionPane.INFORMATION_MESSAGE);
            Board_Game.moveJail(p);
        }
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
