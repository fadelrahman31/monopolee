/* CLASS JUST VISITING JAIL SEBAGAI SUBCLASS SPACE */

public class Jail extends Space {

    public Jail(String name, int position) {
        super(name, position);
    }

    @Override
    public void handlePlayer(Player p) {
        if (p.isDiJail()) {
            //Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Apakah punya jail card?\n");
            /*if (p.getJailcard() > 0) {
                p.usefreejail();
                if(p.getName().equals(Board_Game.daftarPemain[0].getName())){
                    Board_Game.daftarPemain[0].setDiJail(false);
                    p.setDiJail(false);
                }else{
                    Board_Game.daftarPemain[1].setDiJail(false);
                    p.setDiJail(false);
                }
            }*/
        }
        else {
            Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Kamu berkunjung ke penjara\n");
            Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Mungkin kamu bisa melihat temanmu disana...\n");
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
