/* CLASS RAILROAD */

import javax.swing.*;
import java.util.Scanner;

public class Railroad extends Property {
    Scanner s = new Scanner(System.in);

    public Railroad(Player owner, String name, int position, int harga) {
        super(owner, name, position, harga);
    }

    @Override
    public double getSewa(Player owner) {
        switch (owner.numRailroads()) {
        case 1:
            return (0.125 * getHarga());
        case 2:
            return (0.25 * getHarga());
        case 3:
            return (0.5 * getHarga());
        case 4:
            return (1 * getHarga());
        default:
            return 0;
        }
    }

    public double getJualR(Player p, String namaRailroad) {
        double hasiljual = 0;
        hasiljual = hasiljual + p.getRailroads(namaRailroad).getHarga();
        p.getRailroads(namaRailroad).setOwner(null);
        p.removeRailroads(p.getRailroads(namaRailroad));

        return hasiljual;
    }

    // @Override
    public void handlePlayer(Player p) {
        Board_Game.gameLog.append("Anda berada di " + this.getName()+"\n");
        String pilihan;

        if (this.getOwner() == null) {
            /*System.out.println("Railroad ini belum ada pemiliknya, Mau beli? YES/NO");
            System.out.println("Harga Railroad " + this.getName() + " yaitu = " + this.getHarga());
            pilihan = s.next();

            if (pilihan.equalsIgnoreCase("YES")) {
                if (p.bisaBayar(getHarga())) {
                    p.takeMoney(getHarga());
                    p.addRailroads(this);
                    this.setOwner(p);

                    System.out.println("Pembelian railroad berhasil :)");
                } else {
                    System.out.println("Uang gak cukup untuk beli railroad ini :(");
                }
            }
            else if (pilihan.equalsIgnoreCase("NO")) {
                System.out.println("Uang gak cukup untuk beli railroad ini :(");
            }
            */
            Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda berada di Railroad Station tanpa pemilik !\n");
            Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda bisa menekan tombol BUY !\n");
        }
        else if (this.getOwner() == p) {
            Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda berada pada railroad milik anda sendiri :)\n");
        }
        else {
            Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda berada di Railroad Station milik Player " + this.getOwner().getName() + ".\n");
            Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda harus membayar denda sebesar " + this.getSewa(this.getOwner())+"\n");
            if (p.bisaBayar(this.getSewa(this.getOwner()))) {
                p.takeMoney(this.getSewa(this.getOwner()));
                p.giveMoney(this.getOwner(), this.getSewa(this.getOwner()));
                Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Denda berhasil terbayar, terima kasih ^^\n");
            } else {
                Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Uang gak cukup untuk bayar rent :(\n");
                Board_Game.gameLog.append("Player " + p.getName() + " harus menjual property!!!\n");
                // Jual property

                //while ((!(p.bisaBayar(this.getSewa(this.getOwner()))))
                  //      && (p.numLots() != 0 || p.numRailroads() != 0 || p.numUtilities() != 0)) {
                    /*
                    p.displayallLots();
                    p.displayallRailroads();
                    p.displayallUtilities();

                    System.out.println("Masukan nama property yang ingin dijual:");
                    String namaproperty = s.next();
                    if (!(p.cekLot(namaproperty)) && !(p.cekRailroads(namaproperty))
                            && !(p.cekUtilities(namaproperty))) {
                        System.out.println("Serius lah Mas >:(");
                    } else if (p.cekLot(namaproperty)) {
                        p.addmoney(p.getLots(namaproperty).getJualL(p, namaproperty));
                    } else if (p.cekRailroads(namaproperty)) {
                        p.addmoney(getJualR(p, namaproperty));
                    } else if (p.cekUtilities(namaproperty)) {
                        p.addmoney(p.getUtilities(namaproperty).getJualU(p, namaproperty));
                    }*/
                    if(p.numLots() == 0 && p.numRailroads() == 0 & p.numUtilities()==0){
                        Winning_Frame layarmenang = new Winning_Frame(p);
                    }else {
                        Jual_Properti formJual = new Jual_Properti(p, this);
                    }
                /*if(!p.bisaBayar(this.getSewa(this.getOwner()))){
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Uang MASIH gak cukup untuk bayar rent :(\n");
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda harus menjual LAGI property!!!\n");
                    Jual_Properti formJual2 = new Jual_Properti();
                }else{
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda berhasil mengumpulkan uang !\n");
                    p.takeMoney(this.getSewa(this.getOwner()));
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda lepas dari hutang !!!\n");

                }*/
                //}
                /*
                if (!(p.bisaBayar(this.getSewa(this.getOwner())))
                        && (p.numLots() != 0 && p.numRailroads() != 0 && p.numUtilities() != 0)) {
                    p.setBangkrut(true);
                    System.out.println("Kamu bangkrut Mas! Main yang bener dong!!");
                    System.out.println("Selamat! Player " + this.getOwner().getName() + " menang <(^u^)>");
                    // Penanganan kasus 2 orang pemain
                } else if (p.bisaBayar(this.getSewa(this.getOwner()))) {
                    p.takeMoney(this.getSewa(this.getOwner()));
                    System.out.println("Denda berhasil terbayar, terima kasih ^^");
                }
            */
            }
        }







        /*System.out.println("Beli? YES/NO");


        if (this.getOwner() == null && pilihan.equalsIgnoreCase("YES")) {
            if (p.bisaBayar(getHarga())) {
                p.takeMoney(getHarga());
                p.addRailroads(this);
                this.setOwner(p);

                System.out.println("Pembelian railroad berhasil :)");
            } else {
                System.out.println("Uang gak cukup untuk beli railroad ini :(");
            }
        } else if (this.getOwner() == null && pilihan.equals("NO")) {
            System.out.println("Ntar jangan nyesel ya gak beli railroad ini :p");
        } else {
            System.out.println("You have arrived at Player " + this.getOwner() + " railroad.");
            System.out.println("You have to pay the rent fee");
            if (p.bisaBayar(this.getSewa(this.getOwner()))) {
                p.takeMoney(this.getSewa(this.getOwner()));
            } else {
                System.out.println("Uang gak cukup untuk bayar rent :(");
                System.out.println("Player " + p.getName() + " harus menjual property!!!");
                // Jual property
            }
        }*/
    }

    public void handleBuyPlayer(Player p){
        if(this.getOwner() == null){
            //int lokasiLast = p.getCursor();
            if(p.getName().equals(Board_Game.daftarPemain[0].getName())){
                Board_Game.buy1.setEnabled(true);
            }else{
                Board_Game.buy2.setEnabled(true);
            }
            JDialog.setDefaultLookAndFeelDecorated(true);
            String lokasi = this.getName();
            double harga = this.getHarga();
            int response = JOptionPane.showConfirmDialog(null, "Mau Beli "+lokasi+" seharga "+harga+" ?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION) {
                System.out.println("No button clicked");
                Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Nanti jangan menyesal tidak beli stasiun ini ya ! \n");
            } else if (response == JOptionPane.YES_OPTION) {
                if(p.bisaBayar(getHarga())){
                    String namaAyeuna = this.getName();
                    p.addRailroads(this);
                    this.setOwner(p);
                    double minus = this.getHarga();
                    double present = p.getBalance();
                    double next = present-minus;
                    p.setBalance(next);
                    if(p.getName().equals(Board_Game.daftarPemain[0].getName())){
                        Board_Game.buy1.setEnabled(false);
                    }else{
                        Board_Game.buy2.setEnabled(false);
                    }
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" >> Yes Stasiun Terbeli!!\n");
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" >> Anda Membeli "+lokasi+"\n");
                }else{
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Maaf Anda tidak punya cukup uang !.\n");
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" >> Anda Gagal Membeli Stasiun ini !\n");
                }

            } else if (response == JOptionPane.CLOSED_OPTION) {
                System.out.println("JOptionPane closed");
            }
        }else if(this.getOwner() == p){
            if(p.getName().equals(Board_Game.daftarPemain[0].getName())){
                Board_Game.buy1.setEnabled(false);
            }else{
                Board_Game.buy2.setEnabled(false);
            }
            //JOptionPane.showMessageDialog(null,"[ "+p.getName()+" ]"+" Properti Anda Sendiri !!.");
            Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda berada pada stasiun sendiri \n");
        }else{
            if(p.getName().equals(Board_Game.daftarPemain[0].getName())){
                Board_Game.buy1.setEnabled(false);
            }else{
                Board_Game.buy2.setEnabled(false);
            }
            //JOptionPane.showMessageDialog(null,"[ "+p.getName()+" ]"+" Properti Milik Pemain Lain !!.");
            //Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda berada pada properti milik orang lain \n");
        }
    }
}
