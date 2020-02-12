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

public class Board_Game extends JFrame{
        private static final Insets insets = new Insets(0, 0, 0, 0);
        public static Player daftarPemain[] = new Player[2];
        public static Player currPlayer;
        public static Board Runtime  = new Board();
        JPanel p = new JPanel();
        JPanel p2 = new JPanel();
        public static JPanel buttons[][] = new JPanel[11][11];
        JLabel labels[][] = new JLabel[11][11];
        public static JPanel pemain1 = new JPanel();
        public static JPanel pemain2 = new JPanel();

        //deklarasi semua komponen
        JButton properti = new JButton("List Props");
        static JButton rollDadu = new JButton("Roll Dadu");
        JButton endTurn = new JButton("End Turn");
        static JButton move = new JButton("Move Position");
        JButton sell = new JButton("Sell Tempat");

        JButton properti2 = new JButton("List Props");
        static JButton rollDadu2 = new JButton("Roll Dadu");
        JButton endTurn2 = new JButton("End Turn");
        static JButton move2 = new JButton("Move Position");
        JButton sell2 = new JButton("Sell Tempat");

        JLabel timer = new JLabel("Timer : ");

        Timer timerTimer = new Timer(1000, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                timer.setText("Timer : "+xoxo);
                xoxo--;
                if(xoxo<0){
                    if(statusP1){
                        properti.setEnabled(false);
                        rollDadu.setEnabled(false);
                        buy1.setEnabled(false);
                        move.setEnabled(false);
                        sell.setEnabled(false);
                        endTurn.setEnabled(false);

                        doubledadu2 = 0;
                        properti2.setEnabled(true);
                        rollDadu2.setEnabled(true);
                        buy2.setEnabled(true);
                        move2.setEnabled(true);
                        endTurn2.setEnabled(true);
                        sell2.setEnabled(true);

                        statusP1 = false;
                        statusP2 = true;
                        // timerTimer.start();
                        gameLog.append(">> Giliran P1 Selesai ! \n");
                        gameLog.append(">> ======= P2 ======== \n");
                        currPlayer = daftarPemain[1];
                        xoxo = 29;
                    }else if(statusP2){
                        properti2.setEnabled(false);
                        rollDadu2.setEnabled(false);
                        buy2.setEnabled(false);
                        move2.setEnabled(false);
                        endTurn2.setEnabled(false);
                        sell2.setEnabled(false);

                        doubledadu = 0;
                        properti.setEnabled(true);
                        rollDadu.setEnabled(true);
                        buy1.setEnabled(true);
                        move.setEnabled(true);
                        sell.setEnabled(true);
                        endTurn.setEnabled(true);

                        statusP2 = false;
                        statusP1 = true;
                        // timerTimer.start();
                        gameLog.append(">> Giliran P2 Selesai ! \n");
                        gameLog.append(">> ======= P1 ======== \n");
                        currPlayer = daftarPemain[0];
                        xoxo = 29;
                    }
                }
            }
        });
        
        int dadusatu = 0;
        int dadudua = 0;
        int totaldadu = 0;
        int countDouble = 0;
        static int doubledadu = 0;
        static Dice daduku = new Dice();
        
        int dadusatu2 = 0;
        int dadudua2 = 0;
        int totaldadu2 = 0;
        int countDouble2 = 0;
        static int doubledadu2 = 0;
        static Dice daduku2 = new Dice();

        int current;
        int finale;
        int xoxo = 30;

        boolean tidakMenang = false;
        boolean statusP1 = true;
        boolean statusP2 = false;
        public static JTextArea gameLog = new JTextArea();
        public static JButton buy1 = new JButton("Buy Tempat");
        public static JButton buy2 = new JButton("Buy Tempat");
        
        public static void main(String[] args){
            Runnable runnable = new Runnable(){
                @Override
                public void run(){
                    Board_Game mainObj = new Board_Game();
                }
            };
            SwingUtilities.invokeLater(runnable);
            //Board_Game game = new Board_Game();
               
        }
        public Board_Game(){
            //PANEL SEBELAH KIRI
            super("Monopoly");
            setSize(1366,768);
            setResizable(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(new GridLayout(1,2,1,1));
            p.setLayout(new GridLayout(11,11,2,2));
            p.setBackground(Color.white);
            Border border = BorderFactory.createLineBorder(new Color(138,170,229), 2);
            currPlayer = daftarPemain[0];
            //Looping untuk membuat baris pertama peta game
            for(int i=0;i<11;i++){
                for(int j=0;j<11;j++){
                  buttons[i][j] = new JPanel();
                  buttons[i][j].setBorder(null);
                  buttons[i][j].setBackground(Color.WHITE);
                }
            }
            
            //Looping Mengisi Nama Kota pada Papan Permainan
            
            GridBagConstraints c = new GridBagConstraints();
            //Baris Atas
            String[] title = new String[1000];
            int k = 20;
            for(int i=0;i<11;i++){
                title[k] = Runtime.getTileInfo(k).getName();
                labels[0][i] = new JLabel(title[k]);
                labels[0][i].setVerticalAlignment(SwingConstants.CENTER);
                buttons[0][i].setLayout(new GridBagLayout());
                addComponent(buttons[0][i],labels[0][i],0,2,4,3,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
                k++;
            }
            
            //Kolom Sebelah Kiri
            int l = 19;
            for(int i=1;i<=9;i++){
                title[l] = Runtime.getTileInfo(l).getName();
                labels[i][0] = new JLabel(title[l]);
                labels[i][0].setVerticalAlignment(SwingConstants.CENTER);
                buttons[i][0].setLayout(new GridBagLayout());
                addComponent(buttons[i][0],labels[i][0],0,2,4,3,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
                l--;
            }
            
            //Kolom Sebelah Kanan
            int m = 31;
            for(int i=1;i<=9;i++){
                title[m] = Runtime.getTileInfo(m).getName();
                labels[i][10] = new JLabel(title[m]);
                labels[i][10].setVerticalAlignment(SwingConstants.CENTER);
                buttons[i][10].setLayout(new GridBagLayout());
                addComponent(buttons[i][10],labels[i][10],0,2,4,3,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
                m++;
            }
            
            //Baris Bawah
            int n = 10;
            for(int i=0;i<11;i++){
                title[n] = Runtime.getTileInfo(n).getName();
                labels[10][i] = new JLabel(title[n]);
                labels[10][i].setVerticalAlignment(SwingConstants.CENTER);
                buttons[10][i].setLayout(new GridBagLayout());
                addComponent(buttons[10][i],labels[10][i],0,2,4,3,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
                n--;
            }
            
            pemain1.setOpaque(true);
            pemain1.setBackground(Color.BLACK);
            pemain1.setBorder(BorderFactory.createLineBorder(Color.white,5));
            addComponent(buttons[10][10],pemain1,0,0,2,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            
            pemain2.setOpaque(true);
            pemain2.setBackground(Color.blue);
            pemain2.setBorder(BorderFactory.createLineBorder(Color.white,5));
            addComponent(buttons[10][10],pemain2,0,1,2,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            
            
            //Mewarnai Background tiap Tile Kota
            //Blok Cicadas dan Padasuka
            buttons[10][9].setBackground(Color.magenta);
            labels[10][9].setForeground(Color.white);
            buttons[10][7].setBackground(Color.magenta);
            labels[10][7].setForeground(Color.white);
            
            //Blok Antapani Cicaheum Ujungberung
            buttons[10][4].setBackground(Color.CYAN);
            buttons[10][2].setBackground(Color.CYAN);
            buttons[10][1].setBackground(Color.CYAN);
            
            //Blok Batununggal Kopo Burangrang
            buttons[1][0].setBackground(Color.orange);
            buttons[2][0].setBackground(Color.orange);
            buttons[4][0].setBackground(Color.orange);
            
            //Blok Cilaki Citarum Cihapit
            buttons[6][0].setBackground(Color.pink);
            buttons[7][0].setBackground(Color.pink);
            buttons[9][0].setBackground(Color.pink);
                    
            //Blok Merdeka Braga Riau
            buttons[0][1].setBackground(Color.red);
            buttons[0][3].setBackground(Color.red);
            buttons[0][4].setBackground(Color.red);
            labels[0][1].setForeground(Color.white);
            labels[0][3].setForeground(Color.white);
            labels[0][4].setForeground(Color.white);
            
            //Blok Pajajaran Cipaganti Pasirkaliki
            buttons[0][6].setBackground(Color.yellow);
            buttons[0][7].setBackground(Color.yellow);
            buttons[0][9].setBackground(Color.yellow);
            
            //Blok Sarijadi Pasteur Sukajadi
            buttons[1][10].setBackground(Color.green);
            buttons[2][10].setBackground(Color.green);
            buttons[4][10].setBackground(Color.green);
            
            buttons[7][10].setBackground(Color.BLUE);
            buttons[9][10].setBackground(Color.blue);
            labels[7][10].setForeground(Color.white);
            labels[9][10].setForeground(Color.white);
            
            //Blok STASIUN
            buttons[5][0].setBackground(Color.lightGray);
            buttons[0][5].setBackground(Color.lightGray);        
            buttons[10][5].setBackground(Color.lightGray);
            buttons[5][10].setBackground(Color.lightGray);
            
            //Blok PLN PDAM
            buttons[0][8].setBackground(new Color(205,255,255));
            buttons[8][0].setBackground(new Color(230,223,68));
            
            //Blok Community Chest
            buttons[10][8].setBackground(new Color(142,186,67));
            buttons[3][0].setBackground(new Color(142,186,67));
            buttons[3][10].setBackground(new Color(142,186,67));        
                    
            
            //Blok Chance
            buttons[0][2].setBackground(new Color(250,103,117));
            buttons[10][3].setBackground(new Color(250,103,117));
            buttons[6][10].setBackground(new Color(250,103,117));
            
            //Blok Tax
            buttons[10][6].setBackground(new Color(98,109,113));
            buttons[8][10].setBackground(new Color(98,109,113));
            labels[10][6].setForeground(Color.white);
            labels[8][10].setForeground(Color.white);
            
            
            //Looping untuk menghilangkan label di tengah Papan permainan
            for(int i=1;i<=9;i++){
                for(int j=1;j<=9;j++){
                    buttons[i][j].setVisible(false);
                }
            }

            //Looping untuk menambahkan Panel pada Panel
            p.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            for(int i=0;i<11;i++){
                for(int j=0;j<11;j++){
                    p.add(buttons[i][j]);
                }
            }
            
            
            //Judul Permainan di Tengah Papan
            JLabel M = new JLabel("M");
            M.setFont(M.getFont().deriveFont(30f));
            M.setForeground(new Color(138,170,229));
            buttons[1][1].add(M);
            buttons[1][1].setBorder(null);
            buttons[1][1].setVisible(true);
            
            JLabel M1 = new JLabel("O");
            M1.setFont(M1.getFont().deriveFont(30f));
            M1.setForeground(new Color(138,170,229));
            buttons[2][2].add(M1);
            buttons[2][2].setBorder(null);
            buttons[2][2].setVisible(true);
            
            JLabel M2 = new JLabel("N");
            M2.setFont(M2.getFont().deriveFont(30f));
            M2.setForeground(new Color(138,170,229));
            buttons[3][3].add(M2);
            buttons[3][3].setBorder(null);
            buttons[3][3].setVisible(true);
            
            JLabel M3 = new JLabel("O");
            M3.setFont(M3.getFont().deriveFont(30f));
            M3.setForeground(new Color(138,170,229));
            buttons[4][4].add(M3);
            buttons[4][4].setBorder(null);
            buttons[4][4].setVisible(true);
            
            JLabel M4 = new JLabel("P");
            M4.setFont(M4.getFont().deriveFont(30f));
            M4.setForeground(new Color(138,170,229));
            buttons[5][5].add(M4);
            buttons[5][5].setBorder(null);
            buttons[5][5].setVisible(true);
            
            JLabel M5 = new JLabel("O");
            M5.setFont(M5.getFont().deriveFont(30f));
            M5.setForeground(new Color(138,170,229));
            buttons[6][6].add(M5);
            buttons[6][6].setBorder(null);
            buttons[6][6].setVisible(true);
            
            JLabel M6 = new JLabel("L");
            M6.setFont(M6.getFont().deriveFont(30f));
            M6.setForeground(new Color(138,170,229));
            buttons[7][7].add(M6);
            buttons[7][7].setBorder(null);
            buttons[7][7].setVisible(true);
            
            JLabel M7 = new JLabel("E");
            M7.setFont(M7.getFont().deriveFont(30f));
            M7.setForeground(new Color(138,170,229));
            buttons[8][8].add(M7);
            buttons[8][8].setBorder(null);
            buttons[8][8].setVisible(true);
            
            JLabel M8 = new JLabel("E");
            M8.setFont(M8.getFont().deriveFont(30f));
            M8.setForeground(new Color(138,170,229));
            buttons[9][9].add(M8);
            buttons[9][9].setBorder(null);
            buttons[9][9].setVisible(true);
            
            
            //PANEL SEBELAH KANAN
            p2.setLayout(new GridLayout(1,2,0,0));

            timer.setFont(timer.getFont().deriveFont(14f));



            timerTimer.start();

            
            //PANEL SEBELAH KANAN bagian KIRI - PLAYER SIDE VIEW
            JPanel p2kiri = new JPanel();
            
            Border bordeer = BorderFactory.createLineBorder(new Color(154, 171, 161),2);
            Border kotak = BorderFactory.createLineBorder(new Color(255, 255, 255),2);
            p2kiri.setBackground(Color.white);
            p2kiri.setBorder(bordeer);
            p2kiri.setLayout(new GridLayout(2,1));
            //Panel Player 1
            JPanel p2kiriP1 = new JPanel();
            p2kiriP1.setBorder(bordeer);
            p2kiriP1.setBackground(Color.white);
            p2kiriP1.setLayout(new GridLayout(5,1));
            String namaP1 = daftarPemain[0].getName();
            //int uangP1 = (int) daftarPemain[0].getBalance();
            //int position1 = daftarPemain[0].getCursor();
            
            JLabel namaPemain = new JLabel("Pemain 1 : "+namaP1);
                namaPemain.setFont(namaPemain.getFont().deriveFont(14f));
                namaPemain.setBorder(kotak);
                p2kiriP1.add(namaPemain);
            JLabel currentMoney = new JLabel();
                currentMoney.setFont(currentMoney.getFont().deriveFont(14f));
                currentMoney.setBorder(kotak);
                Timer myTimer = new Timer(100, new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        currentMoney.setText("Money : "+daftarPemain[0].getBalance());
                    }
                });
                p2kiriP1.add(currentMoney);
                myTimer.start();
            JLabel currentPos = new JLabel();
                currentPos.setFont(currentPos.getFont().deriveFont(14f));
                currentPos.setBorder(kotak);
                Timer timerLokasi = new Timer(100, new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        int kursor = daftarPemain[0].getCursor();
                        String now = Runtime.getTileInfo(kursor).getName();
                        currentPos.setText("Position : "+now);
                    }
                });
                timerLokasi.start();
                int lokasi = daftarPemain[0].getCursor();
                p2kiriP1.add(currentPos);

            JPanel p2kiriP1row4 = new JPanel();
            p2kiriP1row4.setLayout(new GridLayout(1,3));




                properti.setFont(properti.getFont().deriveFont(14f));
                properti.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        String[] listLots = new String[100];
                        String[] listRailroads = new String[100];
                        String[] listUtility = new String[100];
                        int[] listHouse = new int[100];

                        String kumpulan = "Daftar Kekayaan : \n";
                        for(int i=0;i<daftarPemain[0].numLots();i++){
                            listLots[i] = daftarPemain[0].lots.get(i).getName();
                            listHouse[i] = Board_Game.daftarPemain[0].lots.get(i).getCountRumah();
                            kumpulan = kumpulan + "\n" + listLots[i] + ", rumah = "+listHouse[i];
                        }
                        kumpulan = kumpulan + "\n\n";
                        for(int i=0;i<daftarPemain[0].numRailroads();i++){
                            listRailroads[i] = daftarPemain[0].railroads.get(i).getName();
                            kumpulan = kumpulan + "\n" +listRailroads[i];
                        }
                        kumpulan = kumpulan + "\n\n";
                        for(int i=0;i<daftarPemain[0].numUtilities();i++){
                            listUtility[i] = daftarPemain[0].utilities.get(i).getName();
                            kumpulan = kumpulan + "\n" + listUtility[i];
                        }
                        JOptionPane.showMessageDialog(null, kumpulan);
                        gameLog.append("[ "+currPlayer.getName()+" ]"+" >> Show P1 Properties\n");
                    }
                });
                p2kiriP1row4.add(properti);


            rollDadu.setFont(rollDadu.getFont().deriveFont(14f));
            //add the listener to jbutton to handled the "pressed" event
            rollDadu.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(daftarPemain[0].isDiJail()){
                        rollDadu.setEnabled(false);
                        move.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "[ "+currPlayer.getName() + " ]"+", you're locked In!", "You're  in jail!", JOptionPane.INFORMATION_MESSAGE);
                        moveJail(daftarPemain[0]);
                    }else {

                        totaldadu = daduku.roll();
                        dadusatu = daduku.getDiceOne();
                        dadudua = daduku.getDiceTwo();

                        if (daduku.isDouble()) {
                            doubledadu++;
                        }
                        current = daftarPemain[0].getCursor();
                        finale = current + totaldadu;
                        // System.out.println("CURSOR FINALE DARI ROLL DADU = "+finale);
                        if (finale > 39) {
                            finale = finale % 40;
                            gameLog.append("[ " + currPlayer.getName() + " ]" + " Mendapat uang dari Bank sebanyak 200 !\n");
                            currPlayer.addmoney(200);
                        }
                        daftarPemain[0].setCursor(finale);
                        //handleDouble(currPlayer);

                        if (dadusatu != dadudua) {
                            rollDadu.setEnabled(false);
                        }
                        //else{
                        // countDouble++;
                        //}


                        gameLog.append("[ " + currPlayer.getName() + " ]" + " >> Anda Mendapat Dadu Sebanyak " + totaldadu + "\n");
                    }
                }
            });


            endTurn.setFont(endTurn.getFont().deriveFont(14f));
            endTurn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    properti.setEnabled(false);
                    rollDadu.setEnabled(false);
                    buy1.setEnabled(false);
                    move.setEnabled(false);
                    sell.setEnabled(false);
                    endTurn.setEnabled(false);

                    doubledadu2 = 0;
                    properti2.setEnabled(true);
                    rollDadu2.setEnabled(true);
                    buy2.setEnabled(true);
                    move2.setEnabled(true);
                    endTurn2.setEnabled(true);
                    sell2.setEnabled(true);

                    currPlayer = daftarPemain[1];
                    gameLog.append(">> Giliran P1 Selesai ! \n");
                    gameLog.append(">> ======= P2 ======== \n");

                    timerTimer.stop();
                    xoxo = 29;
                    timerTimer.start();

                }
            });

            p2kiriP1row4.add(rollDadu); p2kiriP1row4.add(endTurn);
            p2kiriP1.add(p2kiriP1row4);

            JPanel p2kiriP1row5 = new JPanel();
            p2kiriP1row5.setLayout(new GridLayout(1,3));

            //P2 Kiri Row 5 - Tombol Buy

            buy1.setFont(buy1.getFont().deriveFont(14f));
            buy1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    Runtime.getTileInfo(currPlayer.getCursor()).handleBuyPlayer(currPlayer);
                }
            });
            p2kiriP1row5.add(buy1);

            //P2 Kiri Row 5 - Tombol Move

            move.setFont(move.getFont().deriveFont(14f));
            move.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    int currentCursor = daftarPemain[0].getCursor();
                    int finalX = getPosX(currentCursor);
                    int finalY = getPosY(currentCursor);
                    //addComponent(buttons[finalX][finalY],pemain1,0,0,2,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
                    gameLog.append("[ " + currPlayer.getName() + " ]" + " >> Anda Berpindah tempat !\n");
                    if (dadusatu != dadudua) {
                        addComponent(buttons[finalX][finalY], pemain1, 0, 0, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH);
                        Runtime.getTileInfo(currentCursor).handlePlayer(currPlayer);
                        buy1.setEnabled(true);
                        move.setEnabled(false);
                    } else {
                        timerTimer.stop();
                        xoxo = 30;
                        timerTimer.start();
                        gameLog.append("[ " + currPlayer.getName() + " ]" + " >> Anda mendapat dadu kembar !\n");


                        if (doubledadu == 1) {
                            addComponent(buttons[finalX][finalY], pemain1, 0, 0, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH);
                            move.setEnabled(true);//nyakla tombol movenya
                            buy1.setEnabled(true);
                            gameLog.append("[ " + currPlayer.getName() + " ]" + " >> Sekali double !\n");
                            Runtime.getTileInfo(currentCursor).handlePlayer(currPlayer);
                        } else if (doubledadu == 2) {
                            addComponent(buttons[finalX][finalY], pemain1, 0, 0, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH);
                            buy1.setEnabled(true);
                            move.setEnabled(true);
                            rollDadu.setEnabled(true);
                            gameLog.append("[ " + currPlayer.getName() + " ]" + " >> Dua kali double !\n");
                            Runtime.getTileInfo(currentCursor).handlePlayer(currPlayer);
                        } else if (doubledadu == 3) {
                            addComponent(buttons[finalX][finalY], pemain1, 0, 0, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH);
                            buy1.setEnabled(true);
                            move.setEnabled(true);
                            rollDadu.setEnabled(true);
                            gameLog.append("[ " + currPlayer.getName() + " ]" + " >> Tiga kali double !\n");
                            Runtime.getTileInfo(currentCursor).handlePlayer(currPlayer);
                        } else if (doubledadu == 4) {
                            JOptionPane.showMessageDialog(null, "[ "+currPlayer.getName() + " ]"+", you're locked In!", "You're  in jail!", JOptionPane.INFORMATION_MESSAGE);
                            moveJail(currPlayer);
                            gameLog.append("[ " + currPlayer.getName() + " ]" + " >> Anda masuk penjara !\n");

                        } else{
                            addComponent(buttons[finalX][finalY], pemain1, 0, 0, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH);
                            Runtime.getTileInfo(currentCursor).handlePlayer(currPlayer);
                            buy1.setEnabled(true);
                        }
                    }
                }
            });
            p2kiriP1row5.add(move);

            //P2 Kiri Row 5 - Tombol Sell

            sell.setFont(sell.getFont().deriveFont(14f));
            //TODO ISI LISTENER TOMBOL SELL
            sell.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Jual_Properti layerjual = new Jual_Properti(currPlayer);
                    layerjual.setVisible(true);
                }
            });
            p2kiriP1row5.add(sell);

            p2kiriP1.add(p2kiriP1row5);


            //Panel Player 2
            JPanel p2kiriP2 = new JPanel();
            p2kiriP2.setBorder(bordeer);
            p2kiriP2.setBackground(Color.white);
            p2kiriP2.setLayout(new GridLayout(5,1));
            String namaP2 = daftarPemain[1].getName();
            int uangP2 = (int) daftarPemain[1].getBalance();
            
            JLabel namaPemain2 = new JLabel("Pemain 2 : "+namaP2);
                namaPemain2.setFont(namaPemain.getFont().deriveFont(14f));
                namaPemain2.setBorder(kotak);
                p2kiriP2.add(namaPemain2);
            JLabel currentMoney2 = new JLabel();
                currentMoney2.setFont(currentMoney.getFont().deriveFont(14f));
                currentMoney2.setBorder(kotak);
                Timer myTimer2 = new Timer(100, new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        currentMoney2.setText("Money : "+daftarPemain[1].getBalance());
                    }
                });
                myTimer2.start();
                p2kiriP2.add(currentMoney2);
            JLabel currentPos2 = new JLabel();
                currentPos2.setFont(currentPos.getFont().deriveFont(14f));
                currentPos2.setBorder(kotak);
                Timer timerLokasi2 = new Timer(100, new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e){
                       int kursor2 = daftarPemain[1].getCursor();
                       String now2 = Runtime.getTileInfo(kursor2).getName();
                       currentPos2.setText("Position : "+now2);
                   }
                });
                timerLokasi2.start();
                p2kiriP2.add(currentPos2);

            //Panel 2 Kiri P2 - Row 4
            JPanel p2kiriP2row4 = new JPanel();
            p2kiriP2row4.setLayout(new GridLayout(1,3));
            properti2.setEnabled(false);
            rollDadu2.setEnabled(false);
            endTurn2.setEnabled(false);
            buy2.setEnabled(false);
            move2.setEnabled(false);
            sell2.setEnabled(false);


                properti2.setFont(properti.getFont().deriveFont(14f));
                properti2.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        String[] listLots2 = new String[100];
                        String[] listRailroads2 = new String[100];
                        String[] listUtility2 = new String[100];
                        int[] listHouse2 = new int[100];

                        String kumpulan2 = "Daftar Kekayaan : \n";
                        for(int i=0;i<daftarPemain[1].numLots();i++){
                            listLots2[i] = daftarPemain[1].lots.get(i).getName();
                            listHouse2[i] = Board_Game.daftarPemain[1].lots.get(i).getCountRumah();
                            kumpulan2 = kumpulan2 + "\n" + listLots2[i] + ", rumah = "+listHouse2[i];
                        }
                        kumpulan2 = kumpulan2 + "\n\n";
                        for(int i=0;i<daftarPemain[1].numRailroads();i++){
                            listRailroads2[i] = daftarPemain[1].railroads.get(i).getName();
                            kumpulan2 = kumpulan2 + "\n" +listRailroads2[i];
                        }
                        kumpulan2 = kumpulan2 + "\n\n";
                        for(int i=0;i<daftarPemain[1].numUtilities();i++){
                            listUtility2[i] = daftarPemain[1].utilities.get(i).getName();
                            kumpulan2 = kumpulan2 + "\n" + listUtility2[i];
                        }

                        JOptionPane.showMessageDialog(null, kumpulan2);
                        gameLog.append("[ "+currPlayer.getName()+" ]"+" >> Show P2 Properties\n");
                    }
                });
                p2kiriP2row4.add(properti2);


            rollDadu2.setFont(rollDadu.getFont().deriveFont(14f));
            //add the listener to jbutton to handled the "pressed" event
            rollDadu2.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(daftarPemain[1].isDiJail()){
                        rollDadu2.setEnabled(false);
                        move2.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "[ "+currPlayer.getName() + " ]"+", you're locked In!", "You're  in jail!", JOptionPane.INFORMATION_MESSAGE);
                        moveJail(daftarPemain[1]);
                    }else {
                        totaldadu2 = daduku2.roll();
                        dadusatu2 = daduku2.getDiceOne();
                        dadudua2 = daduku2.getDiceTwo();
                        if (daduku2.isDouble()) {
                            doubledadu2++;
                        }
                        int current2 = daftarPemain[1].getCursor();
                        int finale2 = current2 + totaldadu2;
                        if (finale2 > 39) {
                            finale2 = finale2 % 40;
                            gameLog.append("[ " + currPlayer.getName() + " ]" + " Mendapat uang dari Bank sebanyak 200 !\n");
                            currPlayer.addmoney(200);
                        }
                        daftarPemain[1].setCursor(finale2);
                        if (dadusatu2 != dadudua2) {
                            rollDadu2.setEnabled(false);
                        }
                        gameLog.append("[ " + currPlayer.getName() + " ]" + " >> Anda Mendapat Dadu Sebanyak " + totaldadu2 + "\n");

                    }
                }
            });


            endTurn2.setFont(endTurn2.getFont().deriveFont(14f));
            endTurn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    properti2.setEnabled(false);
                    rollDadu2.setEnabled(false);
                    buy2.setEnabled(false);
                    move2.setEnabled(false);
                    endTurn2.setEnabled(false);
                    sell2.setEnabled(false);

                    doubledadu = 0;
                    properti.setEnabled(true);
                    rollDadu.setEnabled(true);
                    buy1.setEnabled(true);
                    move.setEnabled(true);
                    sell.setEnabled(true);
                    endTurn.setEnabled(true);

                    currPlayer = daftarPemain[0];
                    gameLog.append(">> Giliran P2 Selesai ! \n");
                    gameLog.append(">> ======= P1 ======== \n");
                    timerTimer.stop();
                    xoxo = 29;
                    timerTimer.start();
                }
            });

            p2kiriP2row4.add(rollDadu2); p2kiriP2row4.add(endTurn2);

            p2kiriP2.add(p2kiriP2row4);

            //Panel 2 Kiri P2 - Row 5
            JPanel p2kiriP2row5 = new JPanel();
            p2kiriP2row5.setLayout(new GridLayout(1,3));


            buy2.setFont(buy2.getFont().deriveFont(14f));
            buy2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    Runtime.getTileInfo(currPlayer.getCursor()).handleBuyPlayer(currPlayer);
                }
            });
            p2kiriP2row5.add(buy2);


            move2.setFont(move2.getFont().deriveFont(14f));
            move2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    int currentCursor2 = daftarPemain[1].getCursor();
                    int finalX2 = getPosX(currentCursor2);
                    int finalY2 = getPosY(currentCursor2);
                    //addComponent(buttons[finalX2][finalY2],pemain2,0,1,2,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
                    gameLog.append("[ "+currPlayer.getName()+" ]"+" >> Anda Berpindah tempat !\n");
                    if(dadusatu2!=dadudua2){
                        addComponent(buttons[finalX2][finalY2],pemain2,0,1,2,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
                        Runtime.getTileInfo(currentCursor2).handlePlayer(currPlayer);
                        buy2.setEnabled(true);
                        move2.setEnabled(false);
                    }else{
                        timerTimer.stop();
                        xoxo = 30;
                        timerTimer.start();
                        gameLog.append("[ "+currPlayer.getName()+" ]"+" >> Anda mendapat dadu kembar !\n");

                        if (doubledadu2 == 1) {
                            addComponent(buttons[finalX2][finalY2], pemain2, 0, 0, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH);
                            move2.setEnabled(true);//nyakla tombol movenya
                            buy2.setEnabled(true);
                            gameLog.append("[ " + currPlayer.getName() + " ]" + " >> Sekali double !\n");
                            Runtime.getTileInfo(currentCursor2).handlePlayer(currPlayer);
                        } else if (doubledadu2 == 2) {
                            addComponent(buttons[finalX2][finalY2], pemain2, 0, 0, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH);
                            buy2.setEnabled(true);
                            move2.setEnabled(true);
                            rollDadu2.setEnabled(true);
                            gameLog.append("[ " + currPlayer.getName() + " ]" + " >> Dua kali double !\n");
                            Runtime.getTileInfo(currentCursor2).handlePlayer(currPlayer);
                        } else if (doubledadu2 == 3) {
                            addComponent(buttons[finalX2][finalY2], pemain2, 0, 0, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH);
                            buy2.setEnabled(true);
                            move2.setEnabled(true);
                            rollDadu2.setEnabled(true);
                            gameLog.append("[ " + currPlayer.getName() + " ]" + " >> Tiga kali double !\n");
                            Runtime.getTileInfo(currentCursor2).handlePlayer(currPlayer);
                        } else if (doubledadu2 == 4) {
                            JOptionPane.showMessageDialog(null, "[ "+currPlayer.getName() + " ]"+", you're locked In!", "You're  in jail!", JOptionPane.INFORMATION_MESSAGE);
                            moveJail(currPlayer);
                            gameLog.append("[ " + currPlayer.getName() + " ]" + " >> Anda masuk penjara !\n");

                        } else{
                            addComponent(buttons[finalX2][finalY2], pemain2, 0, 0, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH);Runtime.getTileInfo(currentCursor2).handlePlayer(currPlayer);
                            Runtime.getTileInfo(currentCursor2).handlePlayer(currPlayer);
                            buy2.setEnabled(true);
                        }
                    }
                    //Runtime.getTileInfo(currentCursor2).handlePlayer(currPlayer);
                }
            });
            p2kiriP2row5.add(move2);


            sell2.setFont(sell2.getFont().deriveFont(14f));
            //TODO ISI LISTENER SELL 2
            sell2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Jual_Properti layerjual2 = new Jual_Properti(currPlayer);
                    layerjual2.setVisible(true);
                }
            });
            p2kiriP2row5.add(sell2);

            p2kiriP2.add(p2kiriP2row5);


            //add untuk panel kiri
            p2kiri.add(p2kiriP1); p2kiri.add(p2kiriP2);
            
            
            //PANEL SEBELAH KANAN Bagian KANAN
            JPanel p2kanan = new JPanel();
            p2kanan.setBackground(Color.white);
            p2kanan.setBorder(bordeer);
            //p2kanan.setLayout(new GridLayout(3,1));
            
            //Panel Sebelah Kanan Bawah Kiri
            JPanel p2kananRow1 = new JPanel();
            p2kananRow1.setBorder(javax.swing.BorderFactory.createTitledBorder("Game Status"));
            p2kananRow1.setBackground(Color.white);
            p2kananRow1.setPreferredSize(new Dimension(375,75));
            p2kananRow1.setLayout(new GridLayout(2,1));
                

                    JLabel currentPlayer = new JLabel();
                    currentPlayer.setFont(currentPlayer.getFont().deriveFont(14f));

            Timer pemainTerkini = new Timer(100,new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            currentPlayer.setText("Current Player : "+currPlayer.getName());
                        }
                    });
                    pemainTerkini.start();
                


                p2kananRow1.add(currentPlayer); p2kananRow1.add(timer);
                
            p2kanan.add(p2kananRow1);

               JPanel p2kananRow2 = new JPanel();
                JScrollPane scroll = new JScrollPane(gameLog);

               gameLog.setEditable(false);
               gameLog.setBackground(new java.awt.Color(255, 255, 255));
               gameLog.setColumns(56);
               gameLog.setFont(new java.awt.Font("Courier New",0,10));
               gameLog.setForeground(new java.awt.Color(255,255,255));
               //gameLog.setRows(12);
               gameLog.setRows(39);
               gameLog.setTabSize(30);
               gameLog.setBorder(javax.swing.BorderFactory.createTitledBorder("Game Log"));
               gameLog.setDisabledTextColor(new java.awt.Color(4, 4, 4));
               gameLog.setEnabled(false);
              // Timer gemlog = new Timer(100, new ActionListener(){
              //     @Override
              //     public void actionPerformed(ActionEvent e) {
                       gameLog.append("MONOPOLEE GAME LOG\n");
                       gameLog.append(">> GAME STARTED !\n");
               //    }
              // });
               //gemlog.start();


               p2kananRow2.add(scroll);
               //p2kananRow2.setViewport(gameLog);

            p2kanan.add(p2kananRow2);

            

            p2.add(p2kiri); p2.add(p2kanan);
            

            //TAMBAH PANEL KE FRAME UTAMA
            add(p);
            add(p2);
            setLocationRelativeTo(null);
            setVisible(true);


            }
            
        
        public static int getPosX(int cursor){
            if(cursor>=0 && cursor<=10){
                return 10;
            }else if(cursor>=11 && cursor <=20)
                {
                    switch (cursor){
                    case 11 : return 9;
                    case 12 : return 8;
                    case 13 : return 7;
                    case 14 : return 6;
                    case 15 : return 5;
                    case 16 : return 4;
                    case 17 : return 3;
                    case 18 : return 2;    
                    case 19 : return 1;
                    case 20 : return 0;    
                }
            }else if(cursor>=21 && cursor<=30){
                return 0;
            }else if(cursor>=31 && cursor<=39){
                {
                    switch (cursor){
                    case 31 : return 1;
                    case 32 : return 2;
                    case 33 : return 3;
                    case 34 : return 4;
                    case 35 : return 5;
                    case 36 : return 6;
                    case 37 : return 7;
                    case 38 : return 8;    
                    case 39 : return 9;
                    }
                }
            }else if(cursor>39){
                cursor = cursor % 40;
                if(cursor>=0 && cursor<=10){
                return 10;
            }else if(cursor>=11 && cursor <=20)
                {
                    switch (cursor){
                    case 11 : return 9;
                    case 12 : return 8;
                    case 13 : return 7;
                    case 14 : return 6;
                    case 15 : return 5;
                    case 16 : return 4;
                    case 17 : return 3;
                    case 18 : return 2;    
                    case 19 : return 1;
                    case 20 : return 0;    
                }
            }else if(cursor>=21 && cursor<=30){
                return 0;
            }else if(cursor>=31 && cursor<=39){
                {
                    switch (cursor){
                    case 31 : return 1;
                    case 32 : return 2;
                    case 33 : return 3;
                    case 34 : return 4;
                    case 35 : return 5;
                    case 36 : return 6;
                    case 37 : return 7;
                    case 38 : return 8;    
                    case 39 : return 9;
                    }
                }
            }
            }
            return 0;
        }
        
        public static int getPosY(int cursor){
            if(cursor>=0 && cursor<=10){
                    switch (cursor){
                    case 0 : return 10;
                    case 1 : return 9;
                    case 2 : return 8;
                    case 3 : return 7;
                    case 4 : return 6;
                    case 5 : return 5;
                    case 6 : return 4;
                    case 7 : return 3;    
                    case 8 : return 2;
                    case 9 : return 1;    
                    case 10 : return 0;
                }
            }else if(cursor>=11 && cursor <=20){
                return 0;
            }else if(cursor>=21 && cursor<=30){
                switch (cursor){
                    case 21 : return 1;
                    case 22 : return 2;
                    case 23 : return 3;
                    case 24 : return 4;
                    case 25 : return 5;
                    case 26 : return 6;
                    case 27 : return 7;    
                    case 28 : return 8;
                    case 29 : return 9;    
                    case 30 : return 10;
                }
            }else if(cursor>=31 && cursor<=39){
                return 10;
            }else if(cursor>39){
                cursor = cursor % 40;
                if(cursor>=0 && cursor<=10){
                    switch (cursor){
                    case 0 : return 10;
                    case 1 : return 9;
                    case 2 : return 8;
                    case 3 : return 7;
                    case 4 : return 6;
                    case 5 : return 5;
                    case 6 : return 4;
                    case 7 : return 3;    
                    case 8 : return 2;
                    case 9 : return 1;    
                    case 10 : return 0;
                }
            }else if(cursor>=11 && cursor <=20){
                return 0;
            }else if(cursor>=21 && cursor<=30){
                switch (cursor){
                    case 21 : return 1;
                    case 22 : return 2;
                    case 23 : return 3;
                    case 24 : return 4;
                    case 25 : return 5;
                    case 26 : return 6;
                    case 27 : return 7;    
                    case 28 : return 8;
                    case 29 : return 9;    
                    case 30 : return 10;
                }
            }else if(cursor>=31 && cursor<=39){
                return 10;
            }
            }
            return 0;
        }
        /*
        private void locationPLayer(Player p){
            int x = getPosX(p.getCursor());
            int y = getPosY(p.getCursor());
            pemain1.setVisible(true);
            //buttons[x][y].add(pemain1);
            
        }*/
        
        public static void addComponent(Container container, Component component, int gridx, int gridy,int gridwidth, int gridheight, int anchor, int fill) {
            GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0,anchor, fill, insets, 0, 0);
            container.add(component, gbc);
        }
/*
        public static void moveJail(Player pemain){
            int currentCursor = 10;
            int finalX = getPosX(currentCursor);
            int finalY = getPosY(currentCursor);
            pemain.setCursor(currentCursor);
            if(pemain.getName().equals(daftarPemain[0].getName())){
                addComponent(buttons[finalX][finalY],pemain1,0,0,2,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
                gameLog.append("[ "+pemain.getName()+" ]"+" Anda Masuk PENJARA !!\n");
            }else{
                addComponent(buttons[finalX][finalY],pemain2,0,0,2,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
                gameLog.append("[ "+pemain.getName()+" ]"+" Anda Masuk PENJARA !!\n");
            }

        }*/
        public static void moveCard(Player pemain){
            int currentCursor = pemain.getCursor();
            int finalX = getPosX(currentCursor);
            int finalY = getPosY(currentCursor);
            if(pemain.getName().equals(daftarPemain[0].getName())){
                addComponent(buttons[finalX][finalY],pemain1,0,0,2,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            }else{
                addComponent(buttons[finalX][finalY],pemain2,0,0,2,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            }
        }


        public static void moveJail(Player pemain){
            int currentCursor = 10;
            int finalX = getPosX(currentCursor);
            int finalY = getPosY(currentCursor);
            boolean found = false;
            boolean found2 = false;
            pemain.setCursor(currentCursor);
            if(pemain.getName().equals(daftarPemain[0].getName())){
                addComponent(buttons[finalX][finalY],pemain1,0,0,2,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
                gameLog.append("[ "+pemain.getName()+" ]"+" Anda Masuk PENJARA !!\n");
                String[] response = {"Bayar","Kartu","Double"};
                int x = JOptionPane.showOptionDialog (null,"Mau gimana", "Masuk Penjara", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, response, response[0]);

                while(!found) {
                    if (x == 0) {
                        if (daftarPemain[0].getBalance() < 100) {
                            JOptionPane.showMessageDialog(null, "[ "+pemain.getName()+" ]"+" Sorry you dont have enough money !");
                            x = JOptionPane.showOptionDialog(null, "Mau gimana", "Masuk Penjara", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, response, response[0]);
                        } else {
                            JOptionPane.showMessageDialog(null, "[ "+pemain.getName()+" ]"+" Okay, you could get out now !");
                            double balancenow = daftarPemain[0].getBalance();
                            balancenow = balancenow - 100;
                            daftarPemain[0].setBalance(balancenow);
                            daftarPemain[0].setDiJail(false);
                            doubledadu = 0;
                            move.setEnabled(false);
                            rollDadu.setEnabled(false);
                            found = true;

                        }
                    } else if (x == 1) {

                        if (daftarPemain[0].getJailcard() == 0) {
                            JOptionPane.showMessageDialog(null, "[ "+pemain.getName()+" ]"+" Sorry u ga ada kartu free jail");
                            x = JOptionPane.showOptionDialog(null, "Mau gimana", "Masuk Penjara", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, response, response[0]);
                        } else {
                            JOptionPane.showMessageDialog(null, "[ "+pemain.getName()+" ]"+" Okay, u punya kartu free jail, you could get out now !");
                            daftarPemain[0].usefreejail();
                            daftarPemain[0].setDiJail(false);
                            doubledadu = 0;
                            found = true;
                        }

                    }
                    else if (x==2) {
                        double totaldadu = 0;

                        daduku.roll();

                        //daduku.setDiceOne(2);
                        //daduku.setDiceTwo(2);

                        if(daduku.isDouble()){
                            JOptionPane.showMessageDialog(null,"[ "+pemain.getName()+" ]"+" OKAY, u BOLEH keluar karena roll DOUBLE");

                            found = true;
                            daftarPemain[0].setDiJail(false);
                            doubledadu = 0;

                        }
                        else{
                            JOptionPane.showMessageDialog(null,"[ "+pemain.getName()+" ]"+" SORRY u GA boleh keluar karena roll ga DOUBLE");
                            move.setEnabled(false);
                            rollDadu.setEnabled(false);
                            daftarPemain[0].setDiJail(true);
                            found =true;
                        }
                    }
                    move.setEnabled(false);

                }
            }else{
                addComponent(buttons[finalX][finalY],pemain2,0,0,2,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
                gameLog.append("[ "+pemain.getName()+" ]"+" Anda Masuk PENJARA !!\n");
                String[] response2 = {"Bayar","Kartu","Double"};
                int x2 = JOptionPane.showOptionDialog (null,"Mau gimana", "Masuk Penjara", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, response2, response2[0]);

                while(!found2) {
                    if (x2 == 0) {
                        if (daftarPemain[1].getBalance() < 100) {
                            JOptionPane.showMessageDialog(null, "[ "+pemain.getName()+" ]"+" Sorry you dont have enough money !");
                            x2 = JOptionPane.showOptionDialog(null, "Mau gimana", "Masuk Penjara", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, response2, response2[0]);
                        } else {
                            JOptionPane.showMessageDialog(null, "[ "+pemain.getName()+" ]"+" Okay, you could get out now !");
                            double balancenow2 = daftarPemain[1].getBalance();
                            balancenow2 = balancenow2 - 100;
                            daftarPemain[1].setBalance(balancenow2);
                            daftarPemain[1].setDiJail(false);
                            doubledadu2 = 0;
                            move2.setEnabled(false);
                            rollDadu2.setEnabled(false);
                            found2 = true;

                        }
                    } else if (x2 == 1) {

                        if (daftarPemain[1].getJailcard() == 0) {
                            JOptionPane.showMessageDialog(null, "[ "+pemain.getName()+" ]"+" Sorry u ga ada kartu free jail");
                            x2 = JOptionPane.showOptionDialog(null, "Mau gimana", "Masuk Penjara", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, response2, response2[0]);
                        } else {
                            JOptionPane.showMessageDialog(null, "[ "+pemain.getName()+" ]"+" Okay, u punya kartu free jail, you could get out now !");
                            daftarPemain[1].usefreejail();
                            daftarPemain[1].setDiJail(false);
                            doubledadu2 = 0;
                            found2 = true;
                        }

                    }
                    else if (x2==2) {
                        double totaldadu = 0;

                        daduku2.roll();
                        if(daduku2.isDouble()){
                            JOptionPane.showMessageDialog(null,"[ "+pemain.getName()+" ]"+" OKAY, u BOLEH keluar karena roll DOUBLE");
                            found2 = true;
                            daftarPemain[1].setDiJail(false);
                            doubledadu2 = 0;
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"[ "+pemain.getName()+" ]"+" SORRY u GA boleh keluar karena roll ga DOUBLE");
                            move2.setEnabled(false);
                            rollDadu2.setEnabled(false);
                            daftarPemain[1].setDiJail(true);
                            found2 =true;
                        }
                    }
                    move2.setEnabled(false);

                }
            }
        }

}    
