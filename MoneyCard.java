/* CLASS MONEY CARD SUBCLASS DARI CARD */

import java.util.Scanner;

public class MoneyCard extends Card {
    private String cardText;
    public int amount;
    Scanner s = new Scanner(System.in);


    public MoneyCard(String cardText, int amount) {
        this.cardText = cardText;
        this.amount = amount;
    }

    @Override
    public void executeCard(Player p) {
        if ((p.getBalance() + amount) < 0) {
           // System.out.println("Uang kamu kurang, harus jual property!!!");
            Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Uang gak cukup untuk bayar rent :(\n");
            Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda harus menjual property!!!\n");


            //while ((!(p.bisaBayar(-amount)) && (p.numLots() != 0 || p.numRailroads() != 0 || p.numUtilities() != 0))) {

                /*
                p.displayallLots();
                p.displayallRailroads();
                p.displayallUtilities();

                System.out.println("Masukan nama property yang ingin dijual:");
                String namaproperty = s.next();
                if (!(p.cekLot(namaproperty)) && !(p.cekRailroads(namaproperty)) && !(p.cekUtilities(namaproperty))) {
                    System.out.println("Serius lah Mas >:(");
                } else if (p.cekLot(namaproperty)) {
                    p.addmoney(p.getLots(namaproperty).getJualL(p, namaproperty));
                } else if (p.cekRailroads(namaproperty)) {
                    p.addmoney(p.getRailroads(namaproperty).getJualR(p, namaproperty));
                } else if (p.cekUtilities(namaproperty)) {
                    p.addmoney(p.getUtilities(namaproperty).getJualU(p, namaproperty));
                }*/
                if(p.numLots() == 0 && p.numRailroads() == 0 && p.numUtilities() == 0){
                    Winning_Frame layarmenang = new Winning_Frame(p);
                }else {
                    Jual_Properti formJual = new Jual_Properti(p, this);
                }
               /* if(!p.bisaBayar(-this.amount)){
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Uang MASIH gak cukup untuk bayar rent :(\n");
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda harus menjual LAGI property!!!\n");
                    Jual_Properti formJual2 = new Jual_Properti();
                }else{
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda berhasil mengumpulkan uang !\n");
                    p.addmoney(amount);
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda lepas dari hutang !!!\n");

                }*/
            //}

            /*
            if (!(p.bisaBayar(-amount)) && (p.numLots() != 0 && p.numRailroads() != 0 && p.numUtilities() != 0)) {
                p.setBangkrut(true);
                System.out.println("Kamu bangkrut Mas! Main yang bener dong!!");
                System.out.println("HAHA! Player " + p.getPlayer().getName() + " kalah :(");
                // Penanganan kasus 2 orang pemain
            } else if (p.bisaBayar(-amount)) {
                p.addmoney(amount);
                System.out.println("Denda berhasil terbayar, terima kasih ^^");
                System.out.println("Total uang kamu sekarang = " + p.getBalance());

            }*/

        }
        else {
            p.addmoney(amount);
            System.out.println("Total uang kamu sekarang = " + p.getBalance());
        }


        /*if (p.getBalance() < 0) {

            while (p.getBalance() < 0 && (p.numLots() != 0 || p.numRailroads() != 0 || p.numUtilities() != 0))


            while ((!(p.bisaBayar(this.getSewa(this.getOwner())))) && (p.numLots() != 0 || p.numRailroads() != 0 || p.numUtilities() != 0)) {

                p.displayallLots();
                p.displayallRailroads();
                p.displayallUtilities();

                System.out.println("Masukan nama property yang ingin dijual:");
                String namaproperty = s.next();
                if (!(p.cekLot(namaproperty)) && !(p.cekRailroads(namaproperty)) && !(p.cekUtilities(namaproperty))) {
                    System.out.println("Serius lah Mas >:(");
                } else if (p.cekLot(namaproperty)) {
                    p.addmoney(p.getLots(namaproperty).getJualL(p, namaproperty));
                } else if (p.cekRailroads(namaproperty)) {
                    p.addmoney(p.getRailroads(namaproperty).getJualR(p, namaproperty));
                } else if (p.cekUtilities(namaproperty)) {
                    p.addmoney(p.getUtilities(namaproperty).getJualU(p, namaproperty));
                }

            }

            if (!(p.bisaBayar(this.getSewa(this.getOwner()))) && (p.numLots() != 0 && p.numRailroads() != 0 && p.numUtilities() != 0)) {
                p.setBangkrut(true);
                System.out.println("Kamu bangkrut Mas! Main yang bener dong!!");
                System.out.println("Selamat! Player " + this.getOwner().getName() + " menang <(^u^)>");
                // Penanganan kasus 2 orang pemain
            } else if (p.bisaBayar(this.getSewa(this.getOwner()))) {
                p.takeMoney(this.getSewa(this.getOwner()));
                System.out.println("Denda berhasil terbayar, terima kasih ^^");
            }

        } */
    }

    @Override
    public String printCardText() {
        return this.cardText;
    }
}
