/* CLASS INCOME TAX SEBAGAI SUBCLASS SPACE */

import javax.swing.*;

public class IncomeTax extends Space {

    public IncomeTax(String name, int position) {
        super(name, position);
    }

    @Override
    public void handlePlayer(Player p) {
        Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Bayar pajak penghasilan bos, 200\n");
        String pesan = "[ "+p.getName()+" ]"+" Kamu harus membayar pajak istimewa/Luxury Tax, bayar 200\n";
        JOptionPane.showMessageDialog(null,pesan);
        if(!p.bisaBayar(200)){
            if(p.numLots()==0 && p.numRailroads() == 0 && p.numUtilities()==0){
                Winning_Frame layarMenang = new Winning_Frame(p);
            }else{
                Jual_Properti formjual = new Jual_Properti(p,this);
            }
        }else{
            p.takeMoney(200);
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
