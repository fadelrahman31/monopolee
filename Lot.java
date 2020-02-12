
/* CLASS LOT */
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.Border;
import javax.swing.Timer;
import java.awt.Color;
import java.util.Scanner;

public class Lot extends Property {
    Scanner s = new Scanner(System.in);

    private final Color kompleks;

    private int countRumah;
    private final int hargaR;

    public Lot(Player owner, String name, int position, Color kompleks, int harga, int countRumah, int hargaR) {
        super(owner, name, position, harga);

        this.kompleks = kompleks;
        this.countRumah = countRumah;
        this.hargaR = hargaR;
    }

    public Color getKompleks() {
        return this.kompleks;
    }

    public int getCountRumah() {
        return this.countRumah;
    }

    public void setCountRumah(int countRumah) {
        this.countRumah = countRumah;
    }

    public int getHargaR() {
        return this.hargaR;
    }

    //@Override
    public double getSewa(Player owner) {
        if (owner.cekSekompleks(this.kompleks)) {
            switch (this.countRumah) {
            case 0:
                return (0.25 * getHarga());
            case 1:
                return (0.5 * getHarga());
            case 2:
                return (1 * getHarga());
            case 3:
                return (2 * getHarga());
            case 4:
                return (4 * getHarga());
            default:
                return 0;
            }
        } else {
            return (0.125 * getHarga());
        }
    }

    public double getJualL(Player p, String namaLot) {
        double hasiljual = 0;
        if (p.getLots(namaLot).getCountRumah() != 0) {
            hasiljual = hasiljual + p.getLots(namaLot).getCountRumah() * (p.getLots(namaLot).getHargaR());
        }
        hasiljual = hasiljual + p.getLots(namaLot).getHarga();
        p.getLots(namaLot).setOwner(null);
        p.removeLots(p.getLots(namaLot));

        return hasiljual;
    }

    // @Override
    public void handlePlayer(Player p) {
        String pilihan;
        Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda berada di " + this.getName()+"\n");
        //System.out.println("Anda berada di " + this.getName());

        if (this.getOwner() == null) {
           /* System.out.println("Lot ini belum ada pemiliknya, Mau beli? YES/NO");
            System.out.println("Harga Lot " + this.getName() + " yaitu = " + this.getHarga());
            pilihan = s.next();

            boolean cek = false;

            while(!cek) {
                if (pilihan.equalsIgnoreCase("YES")) {
                    if (p.bisaBayar(getHarga())) {
                        p.takeMoney(getHarga());
                        p.addLots(this);
                        this.setOwner(p);
                        p.incrementCountKompleks(this.getKompleks());

                        System.out.println("Pembelian lot berhasil :)");
                    } else {
                        System.out.println("Uang gak cukup untuk beli lot ini :(");
                    }
                    cek = true;

                } else if (pilihan.equalsIgnoreCase("NO")) {
                    System.out.println("Ntar jangan nyesel ya gak beli lot ini :p");
                    cek = true;
                } else {
                    System.out.println("Pilihan anda salah");
                    System.out.println("Lot ini belum ada pemiliknya, Mau beli? YES/NO");
                    System.out.println("Harga Lot " + this.getName() + " yaitu = " + this.getHarga());

                    pilihan = s.next();

                }
            }
            */
            Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda berada di lot tanpa pemilik !\n");
            Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda bisa menekan tombol BUY !\n");
        }
        else if (this.getOwner() == p) {
            Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda berada di lot milik anda sendiri\n");
            //System.out.println("Mau beli rumah? YES/NO");
            int response = JOptionPane.showConfirmDialog(null,"Mau beli rumah ? ","Konfirmasi Beli Rumah ",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            //pilihan = s.next();
            if(response == JOptionPane.NO_OPTION){
                Board_Game.gameLog.append("[ "+p.getName()+" ]"+"Ntar jangan nyesel ya gak beli rumah :p\n");
            }else if(response == JOptionPane.YES_OPTION){
                if (p.cekSekompleks(this.getKompleks())) {
                    // beli rumah
                    if (p.bisaBayar(this.getHargaR())) {
                        p.takeMoney(this.getHargaR());
                        setCountRumah(getCountRumah() + 1);
                        Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Pembelian rumah berhasil :)\n");
                    } else {
                        Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Uang gak cukup untuk beli rumah :(\n");
                    }
                } else {
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Kamu belum memiliki 1 kompleks\n");
                }
            }else if(response == JOptionPane.CLOSED_OPTION){
                System.out.println("JOptionPane closed");
            }

            /*
            if (pilihan.equalsIgnoreCase("YES")) {
                if (p.cekSekompleks(this.getKompleks())) {
                    // beli rumah
                    if (p.bisaBayar(this.getHargaR())) {
                        p.takeMoney(this.getHargaR());
                        setCountRumah(getCountRumah() + 1);
                        System.out.println("Pembelian rumah berhasil :)");
                    } else {
                        System.out.println("Uang gak cukup untuk beli rumah :(");
                    }
                } else {
                    System.out.println("Kamu belum memiliki 1 kompleks");
                }
            } else if (pilihan.equalsIgnoreCase("NO")) {
                System.out.println("Ntar jangan nyesel ya gak beli rumah :p");
            }*/
        }
        else {
            Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda berada di lot milik Player " + this.getOwner().getName() + ".\n");
            Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda harus membayar denda sebesar " + this.getSewa(this.getOwner())+"\n");
            if (p.bisaBayar(this.getSewa(this.getOwner()))) {
                p.takeMoney(this.getSewa(this.getOwner()));
                p.giveMoney(this.getOwner(), this.getSewa(this.getOwner()));
                Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Denda berhasil terbayar, terima kasih ^^\n");
            } else {
                Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Uang gak cukup untuk bayar rent :(\n");
                Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda harus menjual property!!!\n");

                // Jual property
           //   while ((!(p.bisaBayar(this.getSewa(this.getOwner()))))
             //          && (p.numLots() != 0 || p.numRailroads() != 0 || p.numUtilities() != 0)) {

              //      p.displayallLots();
              //      p.displayallRailroads();
              //      p.displayallUtilities();

              //      System.out.println("Masukan nama property yang ingin dijual:");
              //     String namaproperty = s.next();
               //     if (!(p.cekLot(namaproperty)) && !(p.cekRailroads(namaproperty))
                 //           && !(p.cekUtilities(namaproperty))) {
                  //      System.out.println("Serius lah Mas >:(");
                 // } else if (p.cekLot(namaproperty)) {
                   //     p.addmoney(getJualL(p, namaproperty));
                 //   } else if (p.cekRailroads(namaproperty)) {
                  //      p.addmoney(p.getRailroads(namaproperty).getJualR(p, namaproperty));
                  //  } else if (p.cekUtilities(namaproperty)) {
                  //      p.addmoney(p.getUtilities(namaproperty).getJualU(p, namaproperty));
                  //  }
                if(p.numLots() == 0 && p.numRailroads() == 0 && p.numUtilities()==0){
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

               // if (!(p.bisaBayar(this.getSewa(this.getOwner())))
               //         && (p.numLots() != 0 && p.numRailroads() != 0 && p.numUtilities() != 0)) {
               //     p.setBangkrut(true);
                //    System.out.println("Kamu bangkrut Mas! Main yang bener dong!!");
               //     System.out.println("Selamat! Player " + this.getOwner().getName() + " menang <(^u^)>");
               //     // Penanganan kasus 2 orang pemain
              //  } else if (p.bisaBayar(this.getSewa(this.getOwner()))) {
               //     p.takeMoney(this.getSewa(this.getOwner()));
                //    System.out.println("Denda berhasil terbayar, terima kasih ^^");
               // }



            }
        }












        /*System.out.println("Beli? YES/NO");
        String pilihan = s.next();

        if (this.getOwner() == null && pilihan.equalsIgnoreCase("YES")) {
            if (p.bisaBayar(getHarga())) {
                p.takeMoney(getHarga());
                p.addLots(this);
                this.setOwner(p);
                p.incrementCountKompleks(this.getKompleks());

                System.out.println("Pembelian lot berhasil :)");
            } else {
                System.out.println("Uang gak cukup untuk beli lot ini :(");
            }
        } else if (this.getOwner() == null && pilihan.equals("NO")) {
            System.out.println("Ntar jangan nyesel ya gak beli lot ini :p");
        } else if ((p.cekSekompleks(this.getKompleks())) && pilihan.equals("YES")) {
            // beli rumah
            if (p.bisaBayar(this.getHargaR())) {
                p.takeMoney(this.getHargaR());
                setCountRumah(getCountRumah() + 1);
                System.out.println("Pembelian rumah berhasil :)");
            } else {
                System.out.println("Uang gak cukup untuk beli rumah :(");
            }
        } else if ((p.cekSekompleks(this.getKompleks())) && pilihan.equals("NO")) {
            System.out.println("Ntar jangan nyesel ya gak beli rumah :p");
        } else {
            System.out.println("You have arrived at Player " + this.getOwner().getName() + " lot.");
            System.out.println("You have to pay the rent fee");
            if (p.bisaBayar(this.getSewa(this.getOwner()))) {
                p.takeMoney(this.getSewa(this.getOwner()));
            } else {
                System.out.println("Uang gak cukup untuk bayar rent :(");
                System.out.println("Player " + p.getName() + " harus menjual property!!!");
                
                // Jual property
                while ((!(p.bisaBayar(this.getSewa(this.getOwner())))) && (p.numLots()!=0 || p.numRailroads() !=0 || p.numUtilities() !=0)){
                    p.displayallLots();
                    p.displayallRailroads();
                    p.displayallUtilities();

                    System.out.println("Masukan nama property yang ingin dijual:");
                    String namaproperty = s.next();
                    //if (p.cekRailroads(namaproperty))
                }

            }
        } */
    }

    @Override
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
            int response = JOptionPane.showConfirmDialog(null, "Mau Beli Lot "+lokasi+" seharga "+harga+" ?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION) {
                System.out.println("No button clicked");
                Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Nanti jangan menyesal tidak beli lot ini ya ! \n");
            } else if (response == JOptionPane.YES_OPTION) {
                if(p.bisaBayar(getHarga())){
                    String namaAyeuna = this.getName();
                    p.addLots(this);
                    this.setOwner(p);
                    p.incrementCountKompleks(this.getKompleks());
                    double minus = p.getLots(namaAyeuna).getHarga();
                    double present = p.getBalance();
                    double next = present-minus;
                    p.setBalance(next);
                    if(p.getName().equals(Board_Game.daftarPemain[0].getName())){
                        Board_Game.buy1.setEnabled(false);
                    }else{
                        Board_Game.buy2.setEnabled(false);
                    }
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" >> Yes Lot Terbeli!!\n");
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" >> Anda Membeli Lot "+lokasi+"\n");
                }else{
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Maaf Anda tidak punya cukup uang !.\n");
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" >> Anda Gagal Membeli Lot !\n");
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
            Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda berada pada properti sendiri \n");
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
