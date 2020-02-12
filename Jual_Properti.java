

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.lang.*;


public class Jual_Properti extends JFrame{

    JTextField isiNamaProp = new JTextField();
    String namaProp;
    //JTextField isi2 = new JTextField();
    JButton acceptSell = new JButton("Jual Sekarang !");
/*
    public static void main(String[] args) {
        Jual_Properti layerJualProp = new Jual_Properti(p);
    }*/

    public Jual_Properti(Player p){
        super("Form Jual Properti");
        setSize(500,750);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        Border kotak = BorderFactory.createLineBorder(Color.gray, 1);

        JPanel atas = new JPanel();
        atas.setBorder(null);
        atas.setLayout(new GridLayout(1,1));

        JPanel tengah = new JPanel();
        tengah.setBorder(null);
        tengah.setLayout(new GridLayout(1,1));

        JPanel bawah = new JPanel();
        bawah.setBorder(null);
        //bawah.setLayout(new GridLayout(1,1));




        JTextArea listProps = new JTextArea();
        JScrollPane scroll = new JScrollPane(listProps);
        listProps.setEditable(false);
        listProps.setBorder(BorderFactory.createTitledBorder("Berikut List Properti Dimiliki !"));
        listProps.setFont(listProps.getFont().deriveFont(15f));

        String[] listLots = new String[100];
        String[] listRailroads = new String[100];
        String[] listUtility = new String[100];
        int[] listHouse = new int[100];

        listProps.append("Daftar Kekayaan : \n");
        for(int i=0;i<p.numLots();i++){
            listLots[i] = p.lots.get(i).getName();
            listHouse[i] = p.lots.get(i).getCountRumah();
            listProps.append(listLots[i] + ", rumah = "+listHouse[i]+"\n");
        }
        //kumpulan = kumpulan + "\n\n";
        listProps.append("\n\n");
        for(int i=0;i<p.numRailroads();i++){
            listRailroads[i] = p.railroads.get(i).getName();
            listProps.append(listRailroads[i]+"\n");
        }
        //kumpulan = kumpulan + "\n\n";
        listProps.append("\n\n");
        for(int i=0;i<p.numUtilities();i++){
            listUtility[i] = p.utilities.get(i).getName();
            listProps.append(listUtility[i]+"\n");
        }

        //listProps.setText(kumpulan);
        atas.add(scroll);

        isiNamaProp.setBorder(BorderFactory.createTitledBorder("Isi Nama Properti akan Dijual !"));
        isiNamaProp.setFont(isiNamaProp.getFont().deriveFont(14f));
        isiNamaProp.setBounds(50,50,150,20);

        tengah.add(isiNamaProp);

        acceptSell.setFont(acceptSell.getFont().deriveFont(15f));
        acceptSell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                namaProp = isiNamaProp.getText();
                boolean cek = false;
                if (!(p.cekLot(namaProp)) && !(p.cekRailroads(namaProp))
                        && !(p.cekUtilities(namaProp))) {
                    Board_Game.gameLog.append("Serius lah Mas >:(\n");
                } else if (p.cekLot(namaProp)) {
                    double incomeSell = p.getLots(namaProp).getJualL(Board_Game.currPlayer,namaProp);
                    p.addmoney(incomeSell);
                    cek = true;
                } else if (p.cekRailroads(namaProp)) {
                    p.addmoney(Board_Game.currPlayer.getRailroads(namaProp).getJualR(Board_Game.currPlayer, namaProp));
                    cek = true;
                } else if (p.cekUtilities(namaProp)) {
                    p.addmoney(Board_Game.currPlayer.getUtilities(namaProp).getJualU(Board_Game.currPlayer, namaProp));
                    cek = true;
                }

                if(cek){
                    Board_Game.gameLog.append("Berhasil jual cui\n");
                }else{
                    Board_Game.gameLog.append("gagal jual cui\n");
                }
                setVisible(false);
                dispose();
/*
                if(!p.bisaBayar(m.amount)){
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Uang MASIH gak cukup untuk bayar rent :(\n");
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda harus menjual LAGI property!!!\n");
                    Jual_Properti formJual2 = new Jual_Properti(pbaru,mbaru);
                }else{
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda berhasil mengumpulkan uang !\n");
                    p.takeMoney(m.amount);
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda lepas dari hutang !!!\n");

                }*/

            }
        });
        bawah.add(acceptSell);
        add(atas); add(tengah); add(bawah);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public Jual_Properti(Player p, MoneyCard m){
        super("Form Jual Properti");
        Player pbaru = p;
        MoneyCard mbaru = m;
        setSize(500,750);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        Border kotak = BorderFactory.createLineBorder(Color.gray, 1);

        JPanel atas = new JPanel();
        atas.setBorder(null);
        atas.setLayout(new GridLayout(1,1));

        JPanel tengah = new JPanel();
        tengah.setBorder(null);
        tengah.setLayout(new GridLayout(1,1));

        JPanel bawah = new JPanel();
        bawah.setBorder(null);
        //bawah.setLayout(new GridLayout(1,1));




        JTextArea listProps = new JTextArea();
        JScrollPane scroll = new JScrollPane(listProps);
        listProps.setEditable(false);
        listProps.setBorder(BorderFactory.createTitledBorder("Berikut List Properti Dimiliki !"));
        listProps.setFont(listProps.getFont().deriveFont(15f));

        String[] listLots = new String[100];
        String[] listRailroads = new String[100];
        String[] listUtility = new String[100];
        int[] listHouse = new int[100];

        listProps.append("Daftar Kekayaan : \n");
        for(int i=0;i<p.numLots();i++){
            listLots[i] = p.lots.get(i).getName();
            listHouse[i] = p.lots.get(i).getCountRumah();
            listProps.append(listLots[i] + ", rumah = "+listHouse[i]+"\n");
        }
        //kumpulan = kumpulan + "\n\n";
        listProps.append("\n\n");
        for(int i=0;i<p.numRailroads();i++){
            listRailroads[i] = p.railroads.get(i).getName();
            listProps.append(listRailroads[i]+"\n");
        }
        //kumpulan = kumpulan + "\n\n";
        listProps.append("\n\n");
        for(int i=0;i<p.numUtilities();i++){
            listUtility[i] = p.utilities.get(i).getName();
            listProps.append(listUtility[i]+"\n");
        }

        //listProps.setText(kumpulan);
        atas.add(scroll);

        isiNamaProp.setBorder(BorderFactory.createTitledBorder("Isi Nama Properti akan Dijual !"));
        isiNamaProp.setFont(isiNamaProp.getFont().deriveFont(14f));
        isiNamaProp.setBounds(50,50,150,20);

        tengah.add(isiNamaProp);

        acceptSell.setFont(acceptSell.getFont().deriveFont(15f));
        acceptSell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                namaProp = isiNamaProp.getText();
                boolean cek = false;
                if (!(p.cekLot(namaProp)) && !(p.cekRailroads(namaProp))
                        && !(p.cekUtilities(namaProp))) {
                    Board_Game.gameLog.append("Serius lah Mas >:(\n");
                } else if (p.cekLot(namaProp)) {
                    double incomeSell = p.getLots(namaProp).getJualL(Board_Game.currPlayer,namaProp);
                    p.addmoney(incomeSell);
                    cek = true;
                } else if (p.cekRailroads(namaProp)) {
                    p.addmoney(Board_Game.currPlayer.getRailroads(namaProp).getJualR(Board_Game.currPlayer, namaProp));
                    cek = true;
                } else if (p.cekUtilities(namaProp)) {
                    p.addmoney(Board_Game.currPlayer.getUtilities(namaProp).getJualU(Board_Game.currPlayer, namaProp));
                    cek = true;
                }

                if(cek){
                    Board_Game.gameLog.append("Berhasil jual cui\n");
                }else{
                    Board_Game.gameLog.append("gagal jual cui\n");
                }
                setVisible(false);
                dispose();

                if(p.getBalance() + m.amount < 0) {
                    if (!p.bisaBayar(Math.abs(m.amount)) && (p.numLots() != 0 || p.numRailroads() != 0 || p.numUtilities() != 0)) {
                        Board_Game.gameLog.append("[ " + p.getName() + " ]" + " Uang MASIH gak cukup untuk bayar rent :(\n");
                        Board_Game.gameLog.append("[ " + p.getName() + " ]" + " Anda harus menjual LAGI property!!!\n");
                        if(p.numLots()==0 && p.numRailroads()==0 || p.numUtilities()==0){
                            dispose();
                            Winning_Frame layarMenang = new Winning_Frame(p);
                        }else{
                            Jual_Properti formJual2 = new Jual_Properti(pbaru, mbaru);
                        }
                    }
                }else{
                    p.addmoney(m.amount);
                    //Board_Game.gameLog.append("[ " + p.getName() + " ]" + " Anda ")
                    Board_Game.gameLog.append("[ " + p.getName() + " ]" + " Anda berhasil mengumpulkan uang !\n");
                    Board_Game.gameLog.append("[ " + p.getName() + " ]" + " Anda lepas dari hutang !!!\n");

                }

            }
        });
        bawah.add(acceptSell);
        add(atas); add(tengah); add(bawah);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public Jual_Properti(Player p, Lot l){
        super("Form Jual Properti");
        Player pbaru = p;
        Lot lbaru = l;
        setSize(500,750);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        Border kotak = BorderFactory.createLineBorder(Color.gray, 1);

        JPanel atas = new JPanel();
        atas.setBorder(null);
        atas.setLayout(new GridLayout(1,1));

        JPanel tengah = new JPanel();
        tengah.setBorder(null);
        tengah.setLayout(new GridLayout(1,1));

        JPanel bawah = new JPanel();
        bawah.setBorder(null);
        //bawah.setLayout(new GridLayout(1,1));




        JTextArea listProps = new JTextArea();
        JScrollPane scroll = new JScrollPane(listProps);
        listProps.setEditable(false);
        listProps.setBorder(BorderFactory.createTitledBorder("Berikut List Properti Dimiliki !"));
        listProps.setFont(listProps.getFont().deriveFont(15f));

            String[] listLots = new String[100];
            String[] listRailroads = new String[100];
            String[] listUtility = new String[100];
            int[] listHouse = new int[100];

            listProps.append("Daftar Kekayaan : \n");
            for(int i=0;i<p.numLots();i++){
                listLots[i] = p.lots.get(i).getName();
                listHouse[i] = p.lots.get(i).getCountRumah();
                listProps.append(listLots[i] + ", rumah = "+listHouse[i]+"\n");
            }
            //kumpulan = kumpulan + "\n\n";
            listProps.append("\n\n");
            for(int i=0;i<p.numRailroads();i++){
                listRailroads[i] = p.railroads.get(i).getName();
                listProps.append(listRailroads[i]+"\n");
            }
            //kumpulan = kumpulan + "\n\n";
            listProps.append("\n\n");
            for(int i=0;i<p.numUtilities();i++){
                listUtility[i] = p.utilities.get(i).getName();
               listProps.append(listUtility[i]+"\n");
            }

        //listProps.setText(kumpulan);
            atas.add(scroll);

        isiNamaProp.setBorder(BorderFactory.createTitledBorder("Isi Nama Properti akan Dijual !"));
        isiNamaProp.setFont(isiNamaProp.getFont().deriveFont(14f));
        isiNamaProp.setBounds(50,50,150,20);

        tengah.add(isiNamaProp);

        acceptSell.setFont(acceptSell.getFont().deriveFont(15f));
        acceptSell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                namaProp = isiNamaProp.getText();
                boolean cek = false;
                if (!(p.cekLot(namaProp)) && !(p.cekRailroads(namaProp))
                        && !(p.cekUtilities(namaProp))) {
                    Board_Game.gameLog.append("Serius lah Mas >:(\n");
                } else if (p.cekLot(namaProp)) {
                    double incomeSell = p.getLots(namaProp).getJualL(Board_Game.currPlayer,namaProp);
                    p.addmoney(incomeSell);
                    cek = true;
                } else if (p.cekRailroads(namaProp)) {
                    p.addmoney(Board_Game.currPlayer.getRailroads(namaProp).getJualR(Board_Game.currPlayer, namaProp));
                    cek = true;
                } else if (p.cekUtilities(namaProp)) {
                    p.addmoney(Board_Game.currPlayer.getUtilities(namaProp).getJualU(Board_Game.currPlayer, namaProp));
                    cek = true;
                }

                if(cek){
                    Board_Game.gameLog.append("Berhasil jual cui\n");
                }else{
                    Board_Game.gameLog.append("gagal jual cui\n");
                }
                setVisible(false);
                dispose();

                if(!p.bisaBayar(l.getSewa(l.getOwner()))){
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Uang MASIH gak cukup untuk bayar rent :(\n");
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda harus menjual LAGI property!!!\n");
                    if(p.numLots()==0 && p.numRailroads() == 0 && p.numUtilities() == 0){
                        dispose();
                        Winning_Frame layarMenang = new Winning_Frame(p);
                    }else{
                        Jual_Properti formJual2 = new Jual_Properti(pbaru,lbaru);
                    }
                }else{
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda berhasil mengumpulkan uang !\n");
                    p.takeMoney(l.getSewa(l.getOwner()));
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda lepas dari hutang !!!\n");

                }



            }
        });
        bawah.add(acceptSell);
        add(atas); add(tengah); add(bawah);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public Jual_Properti(Player p, Railroad r){
        super("Form Jual Properti");
        Player pbaru = p;
        Railroad rbaru = r;
        setSize(500,750);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        Border kotak = BorderFactory.createLineBorder(Color.gray, 1);

        JPanel atas = new JPanel();
        atas.setBorder(null);
        atas.setLayout(new GridLayout(1,1));

        JPanel tengah = new JPanel();
        tengah.setBorder(null);
        tengah.setLayout(new GridLayout(1,1));

        JPanel bawah = new JPanel();
        bawah.setBorder(null);
        //bawah.setLayout(new GridLayout(1,1));




        JTextArea listProps = new JTextArea();
        JScrollPane scroll = new JScrollPane(listProps);
        listProps.setEditable(false);
        listProps.setBorder(BorderFactory.createTitledBorder("Berikut List Properti Dimiliki !"));
        listProps.setFont(listProps.getFont().deriveFont(15f));

        String[] listLots = new String[100];
        String[] listRailroads = new String[100];
        String[] listUtility = new String[100];
        int[] listHouse = new int[100];

        listProps.append("Daftar Kekayaan : \n");
        for(int i=0;i<p.numLots();i++){
            listLots[i] = p.lots.get(i).getName();
            listHouse[i] = p.lots.get(i).getCountRumah();
            listProps.append(listLots[i] + ", rumah = "+listHouse[i]+"\n");
        }
        //kumpulan = kumpulan + "\n\n";
        listProps.append("\n\n");
        for(int i=0;i<p.numRailroads();i++){
            listRailroads[i] = p.railroads.get(i).getName();
            listProps.append(listRailroads[i]+"\n");
        }
        //kumpulan = kumpulan + "\n\n";
        listProps.append("\n\n");
        for(int i=0;i<p.numUtilities();i++){
            listUtility[i] = p.utilities.get(i).getName();
            listProps.append(listUtility[i]+"\n");
        }

        //listProps.setText(kumpulan);
        atas.add(scroll);

        isiNamaProp.setBorder(BorderFactory.createTitledBorder("Isi Nama Properti akan Dijual !"));
        isiNamaProp.setFont(isiNamaProp.getFont().deriveFont(14f));
        isiNamaProp.setBounds(50,50,150,20);

        tengah.add(isiNamaProp);

        acceptSell.setFont(acceptSell.getFont().deriveFont(15f));
        acceptSell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                namaProp = isiNamaProp.getText();
                boolean cek = false;
                if (!(p.cekLot(namaProp)) && !(p.cekRailroads(namaProp))
                        && !(p.cekUtilities(namaProp))) {
                    Board_Game.gameLog.append("Serius lah Mas >:(\n");
                } else if (p.cekLot(namaProp)) {
                    double incomeSell = p.getLots(namaProp).getJualL(Board_Game.currPlayer,namaProp);
                    p.addmoney(incomeSell);
                    cek = true;
                } else if (p.cekRailroads(namaProp)) {
                    p.addmoney(Board_Game.currPlayer.getRailroads(namaProp).getJualR(Board_Game.currPlayer, namaProp));
                    cek = true;
                } else if (p.cekUtilities(namaProp)) {
                    p.addmoney(Board_Game.currPlayer.getUtilities(namaProp).getJualU(Board_Game.currPlayer, namaProp));
                    cek = true;
                }

                if(cek){
                    Board_Game.gameLog.append("Berhasil jual cui\n");
                }else{
                    Board_Game.gameLog.append("gagal jual cui\n");
                }
                setVisible(false);
                dispose();

                if(!p.bisaBayar(r.getSewa(r.getOwner()))){
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Uang MASIH gak cukup untuk bayar rent :(\n");
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda harus menjual LAGI property!!!\n");
                    if(p.numLots()==0 && p.numRailroads()==0 && p.numUtilities()==0){
                        dispose();
                        Winning_Frame layarMenang = new Winning_Frame(p);
                    }else{
                        Jual_Properti formJual2 = new Jual_Properti(pbaru,rbaru);
                    }
                }else{
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda berhasil mengumpulkan uang !\n");
                    p.takeMoney(r.getSewa(r.getOwner()));
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda lepas dari hutang !!!\n");

                }

            }
        });
        bawah.add(acceptSell);
        add(atas); add(tengah); add(bawah);
        setLocationRelativeTo(null);
        setVisible(true);

    }



    public Jual_Properti(Player p, Utility u){
        super("Form Jual Properti");
        Player pbaru = p;
        Utility ubaru = u;
        setSize(500,750);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        Border kotak = BorderFactory.createLineBorder(Color.gray, 1);

        JPanel atas = new JPanel();
        atas.setBorder(null);
        atas.setLayout(new GridLayout(1,1));

        JPanel tengah = new JPanel();
        tengah.setBorder(null);
        tengah.setLayout(new GridLayout(1,1));

        JPanel bawah = new JPanel();
        bawah.setBorder(null);
        //bawah.setLayout(new GridLayout(1,1));




        JTextArea listProps = new JTextArea();
        JScrollPane scroll = new JScrollPane(listProps);
        listProps.setEditable(false);
        listProps.setBorder(BorderFactory.createTitledBorder("Berikut List Properti Dimiliki !"));
        listProps.setFont(listProps.getFont().deriveFont(15f));

        String[] listLots = new String[100];
        String[] listRailroads = new String[100];
        String[] listUtility = new String[100];
        int[] listHouse = new int[100];

        listProps.append("Daftar Kekayaan : \n");
        for(int i=0;i<p.numLots();i++){
            listLots[i] = p.lots.get(i).getName();
            listHouse[i] = p.lots.get(i).getCountRumah();
            listProps.append(listLots[i] + ", rumah = "+listHouse[i]+"\n");
        }
        //kumpulan = kumpulan + "\n\n";
        listProps.append("\n\n");
        for(int i=0;i<p.numRailroads();i++){
            listRailroads[i] = p.railroads.get(i).getName();
            listProps.append(listRailroads[i]+"\n");
        }
        //kumpulan = kumpulan + "\n\n";
        listProps.append("\n\n");
        for(int i=0;i<p.numUtilities();i++){
            listUtility[i] = p.utilities.get(i).getName();
            listProps.append(listUtility[i]+"\n");
        }

        //listProps.setText(kumpulan);
        atas.add(scroll);

        isiNamaProp.setBorder(BorderFactory.createTitledBorder("Isi Nama Properti akan Dijual !"));
        isiNamaProp.setFont(isiNamaProp.getFont().deriveFont(14f));
        isiNamaProp.setBounds(50,50,150,20);

        tengah.add(isiNamaProp);

        acceptSell.setFont(acceptSell.getFont().deriveFont(15f));
        acceptSell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                namaProp = isiNamaProp.getText();
                boolean cek = false;
                if (!(p.cekLot(namaProp)) && !(p.cekRailroads(namaProp))
                        && !(p.cekUtilities(namaProp))) {
                    Board_Game.gameLog.append("Serius lah Mas >:(\n");
                } else if (p.cekLot(namaProp)) {
                    double incomeSell = p.getLots(namaProp).getJualL(Board_Game.currPlayer,namaProp);
                    p.addmoney(incomeSell);
                    cek = true;
                } else if (p.cekRailroads(namaProp)) {
                    p.addmoney(Board_Game.currPlayer.getRailroads(namaProp).getJualR(Board_Game.currPlayer, namaProp));
                    cek = true;
                } else if (p.cekUtilities(namaProp)) {
                    p.addmoney(Board_Game.currPlayer.getUtilities(namaProp).getJualU(Board_Game.currPlayer, namaProp));
                    cek = true;
                }

                if(cek){
                    Board_Game.gameLog.append("Berhasil jual cui\n");
                }else{
                    Board_Game.gameLog.append("gagal jual cui\n");
                }
                setVisible(false);
                dispose();

                if(!p.bisaBayar(u.getSewa(u.getOwner()))){
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Uang MASIH gak cukup untuk bayar rent :(\n");
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda harus menjual LAGI property!!!\n");
                    if(p.numLots()==0 && p.numRailroads()==0 && p.numUtilities()==0){
                        dispose();
                        Winning_Frame layarMenang = new Winning_Frame(p);
                    }else{
                        Jual_Properti formJual2 = new Jual_Properti(pbaru,ubaru);
                    }
                }else{
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda berhasil mengumpulkan uang !\n");
                    p.takeMoney(u.getSewa(u.getOwner()));
                    Board_Game.gameLog.append("[ "+p.getName()+" ]"+" Anda lepas dari hutang !!!\n");

                }

            }
        });
        bawah.add(acceptSell);
        add(atas); add(tengah); add(bawah);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public Jual_Properti(Player p, IncomeTax it){
        super("Form Jual Properti");
        Player pbaru = p;
        IncomeTax itbaru = it;
        setSize(500,750);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        Border kotak = BorderFactory.createLineBorder(Color.gray, 1);

        JPanel atas = new JPanel();
        atas.setBorder(null);
        atas.setLayout(new GridLayout(1,1));

        JPanel tengah = new JPanel();
        tengah.setBorder(null);
        tengah.setLayout(new GridLayout(1,1));

        JPanel bawah = new JPanel();
        bawah.setBorder(null);
        //bawah.setLayout(new GridLayout(1,1));




        JTextArea listProps = new JTextArea();
        JScrollPane scroll = new JScrollPane(listProps);
        listProps.setEditable(false);
        listProps.setBorder(BorderFactory.createTitledBorder("Berikut List Properti Dimiliki !"));
        listProps.setFont(listProps.getFont().deriveFont(15f));

        String[] listLots = new String[100];
        String[] listRailroads = new String[100];
        String[] listUtility = new String[100];
        int[] listHouse = new int[100];

        listProps.append("Daftar Kekayaan : \n");
        for(int i=0;i<p.numLots();i++){
            listLots[i] = p.lots.get(i).getName();
            listHouse[i] = p.lots.get(i).getCountRumah();
            listProps.append(listLots[i] + ", rumah = "+listHouse[i]+"\n");
        }
        //kumpulan = kumpulan + "\n\n";
        listProps.append("\n\n");
        for(int i=0;i<p.numRailroads();i++){
            listRailroads[i] = p.railroads.get(i).getName();
            listProps.append(listRailroads[i]+"\n");
        }
        //kumpulan = kumpulan + "\n\n";
        listProps.append("\n\n");
        for(int i=0;i<p.numUtilities();i++){
            listUtility[i] = p.utilities.get(i).getName();
            listProps.append(listUtility[i]+"\n");
        }

        //listProps.setText(kumpulan);
        atas.add(scroll);

        isiNamaProp.setBorder(BorderFactory.createTitledBorder("Isi Nama Properti akan Dijual !"));
        isiNamaProp.setFont(isiNamaProp.getFont().deriveFont(14f));
        isiNamaProp.setBounds(50,50,150,20);

        tengah.add(isiNamaProp);

        acceptSell.setFont(acceptSell.getFont().deriveFont(15f));
        acceptSell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                namaProp = isiNamaProp.getText();
                boolean cek = false;
                if (!(p.cekLot(namaProp)) && !(p.cekRailroads(namaProp))
                        && !(p.cekUtilities(namaProp))) {
                    Board_Game.gameLog.append("Serius lah Mas >:(\n");
                } else if (p.cekLot(namaProp)) {
                    double incomeSell = p.getLots(namaProp).getJualL(Board_Game.currPlayer,namaProp);
                    p.addmoney(incomeSell);
                    cek = true;
                } else if (p.cekRailroads(namaProp)) {
                    p.addmoney(Board_Game.currPlayer.getRailroads(namaProp).getJualR(Board_Game.currPlayer, namaProp));
                    cek = true;
                } else if (p.cekUtilities(namaProp)) {
                    p.addmoney(Board_Game.currPlayer.getUtilities(namaProp).getJualU(Board_Game.currPlayer, namaProp));
                    cek = true;
                }

                if(cek){
                    Board_Game.gameLog.append("Berhasil jual cui\n");
                }else{
                    Board_Game.gameLog.append("gagal jual cui\n");
                }
                setVisible(false);
                dispose();

                if(!p.bisaBayar(200)){
                    if (!p.bisaBayar(200) && (p.numLots() != 0 || p.numRailroads() != 0 || p.numUtilities() != 0)) {
                        Board_Game.gameLog.append("[ " + p.getName() + " ]" + " Uang MASIH gak cukup untuk bayar rent :(\n");
                        Board_Game.gameLog.append("[ " + p.getName() + " ]" + " Anda harus menjual LAGI property!!!\n");
                        if(p.numLots()==0 && p.numRailroads()==0 && p.numUtilities()==0){
                            dispose();
                            Winning_Frame layarMenang = new Winning_Frame(p);
                        }else{
                            Jual_Properti formJual2 = new Jual_Properti(pbaru, itbaru);
                        }
                    }
                }else{
                    p.takeMoney(200);
                    //Board_Game.gameLog.append("[ " + p.getName() + " ]" + " Anda ")
                    Board_Game.gameLog.append("[ " + p.getName() + " ]" + " Anda berhasil mengumpulkan uang !\n");
                    Board_Game.gameLog.append("[ " + p.getName() + " ]" + " Anda lepas dari hutang !!!\n");

                }

            }
        });
        bawah.add(acceptSell);
        add(atas); add(tengah); add(bawah);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public Jual_Properti(Player p, LuxuryTax lt){
        super("Form Jual Properti");
        Player pbaru = p;
        LuxuryTax ltbaru = lt;
        setSize(500,750);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        Border kotak = BorderFactory.createLineBorder(Color.gray, 1);

        JPanel atas = new JPanel();
        atas.setBorder(null);
        atas.setLayout(new GridLayout(1,1));

        JPanel tengah = new JPanel();
        tengah.setBorder(null);
        tengah.setLayout(new GridLayout(1,1));

        JPanel bawah = new JPanel();
        bawah.setBorder(null);
        //bawah.setLayout(new GridLayout(1,1));




        JTextArea listProps = new JTextArea();
        JScrollPane scroll = new JScrollPane(listProps);
        listProps.setEditable(false);
        listProps.setBorder(BorderFactory.createTitledBorder("Berikut List Properti Dimiliki !"));
        listProps.setFont(listProps.getFont().deriveFont(15f));

        String[] listLots = new String[100];
        String[] listRailroads = new String[100];
        String[] listUtility = new String[100];
        int[] listHouse = new int[100];

        listProps.append("Daftar Kekayaan : \n");
        for(int i=0;i<p.numLots();i++){
            listLots[i] = p.lots.get(i).getName();
            listHouse[i] = p.lots.get(i).getCountRumah();
            listProps.append(listLots[i] + ", rumah = "+listHouse[i]+"\n");
        }
        //kumpulan = kumpulan + "\n\n";
        listProps.append("\n\n");
        for(int i=0;i<p.numRailroads();i++){
            listRailroads[i] = p.railroads.get(i).getName();
            listProps.append(listRailroads[i]+"\n");
        }
        //kumpulan = kumpulan + "\n\n";
        listProps.append("\n\n");
        for(int i=0;i<p.numUtilities();i++){
            listUtility[i] = p.utilities.get(i).getName();
            listProps.append(listUtility[i]+"\n");
        }

        //listProps.setText(kumpulan);
        atas.add(scroll);

        isiNamaProp.setBorder(BorderFactory.createTitledBorder("Isi Nama Properti akan Dijual !"));
        isiNamaProp.setFont(isiNamaProp.getFont().deriveFont(14f));
        isiNamaProp.setBounds(50,50,150,20);

        tengah.add(isiNamaProp);

        acceptSell.setFont(acceptSell.getFont().deriveFont(15f));
        acceptSell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                namaProp = isiNamaProp.getText();
                boolean cek = false;
                if (!(p.cekLot(namaProp)) && !(p.cekRailroads(namaProp))
                        && !(p.cekUtilities(namaProp))) {
                    Board_Game.gameLog.append("Serius lah Mas >:(\n");
                } else if (p.cekLot(namaProp)) {
                    double incomeSell = p.getLots(namaProp).getJualL(Board_Game.currPlayer,namaProp);
                    p.addmoney(incomeSell);
                    cek = true;
                } else if (p.cekRailroads(namaProp)) {
                    p.addmoney(Board_Game.currPlayer.getRailroads(namaProp).getJualR(Board_Game.currPlayer, namaProp));
                    cek = true;
                } else if (p.cekUtilities(namaProp)) {
                    p.addmoney(Board_Game.currPlayer.getUtilities(namaProp).getJualU(Board_Game.currPlayer, namaProp));
                    cek = true;
                }

                if(cek){
                    Board_Game.gameLog.append("Berhasil jual cui\n");
                }else{
                    Board_Game.gameLog.append("gagal jual cui\n");
                }
                setVisible(false);
                dispose();

                if(!p.bisaBayar(75)){
                    if (!p.bisaBayar(200) && (p.numLots() != 0 || p.numRailroads() != 0 || p.numUtilities() != 0)) {
                        Board_Game.gameLog.append("[ " + p.getName() + " ]" + " Uang MASIH gak cukup untuk bayar rent :(\n");
                        Board_Game.gameLog.append("[ " + p.getName() + " ]" + " Anda harus menjual LAGI property!!!\n");
                        if(p.numLots()==0 && p.numRailroads()==0 && p.numUtilities()==0){
                            dispose();
                            Winning_Frame layarMenang = new Winning_Frame(p);
                        }else{
                            Jual_Properti formJual2 = new Jual_Properti(pbaru, ltbaru);
                        }
                    }
                }else{
                    p.takeMoney(75);
                    //Board_Game.gameLog.append("[ " + p.getName() + " ]" + " Anda ")
                    Board_Game.gameLog.append("[ " + p.getName() + " ]" + " Anda berhasil mengumpulkan uang !\n");
                    Board_Game.gameLog.append("[ " + p.getName() + " ]" + " Anda lepas dari hutang !!!\n");

                }

            }
        });
        bawah.add(acceptSell);
        add(atas); add(tengah); add(bawah);
        setLocationRelativeTo(null);
        setVisible(true);

    }


}