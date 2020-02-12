/* CLASS START SEBAGAI SUBCLASS SPACE */

public class Start extends Space {

    public Start(String name, int position) {
        super(name, position);
    }

    public void handlePlayer(Player p, Dice dice) {
        Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Kamu melewati START, dapat 200\n");
    }

    public void handleBuyPlayer(Player p){
        if(p.getName().equals(Board_Game.daftarPemain[0].getName())){
            Board_Game.buy1.setEnabled(false);
        }else{
            Board_Game.buy2.setEnabled(false);
        }
    }

}
