/* CLASS LUXURY TAX SEBAGAI SUBCLASS SPACE */

import javax.swing.*;

public class LuxuryTax extends Space {

    public LuxuryTax(String name, int position) {
        super(name, position);
    }

    @Override
    public void handlePlayer(Player p) {
        Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Kamu harus membayar pajak istimewa/Luxury Tax, bayar 75\n");
        String pesan = "[ "+p.getName()+" ]"+" Kamu harus membayar pajak istimewa/Luxury Tax, bayar 75\n";
        JOptionPane.showMessageDialog(null,pesan);
        if(!p.bisaBayar(75)){
            if(p.numLots()==0 && p.numRailroads() == 0 && p.numUtilities() == 0){
                Winning_Frame layarmenang = new Winning_Frame(p);
            }else {
                Jual_Properti formjual = new Jual_Properti(p, this);
            }
        }else{
            p.takeMoney(75);
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
