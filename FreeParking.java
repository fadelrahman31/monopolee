/* CLASS FREE PARKING SEBAGAI SUBCLASS DARI SPACE */

public class FreeParking extends Space {

    public FreeParking(String name, int position) {
        super(name, position);
    }

    @Override
    public void handlePlayer(Player p) {
        if (p.getCursor() == 20) {
            Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Kamu berada di Free Parking\n");
            Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Kamu mendapat 100!\n");
            p.addmoney(100);
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
