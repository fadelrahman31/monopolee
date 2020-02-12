

import java.awt.*;  
import java.awt.event.*;  
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


    public class New_Game_IsiNama_2 extends JFrame implements ActionListener{  
        
        JTextField isi1 = new JTextField();
        JTextField isi2 = new JTextField();
        JButton startGame = new JButton("START GAME !!");
        
        public static void main(String[] args) {

            New_Game_IsiNama_2 layer2 = new New_Game_IsiNama_2();
        }
    
        public New_Game_IsiNama_2(){
            super("Isi Nama Player");
            setSize(450,375);
            setResizable(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(new GridLayout(2,1));
            Border kotak = BorderFactory.createLineBorder(Color.gray, 1);
            
            JPanel atas = new JPanel();
                atas.setBorder(null);
                atas.setLayout(new GridLayout(1,2));
            JPanel bawah = new JPanel();
                bawah.setBorder(null);
                bawah.setLayout(new GridBagLayout());
            add(atas);add(bawah);
            
            JPanel kiri = new JPanel();
                kiri.setBorder(null);
                kiri.setLayout(new GridLayout(2,1));
                atas.add(kiri);
                
                    JLabel nama1 = new JLabel("Masukkan Nama Pemain 1 !");
                    nama1.setFont(nama1.getFont().deriveFont(15f));
            
                    
                    isi1.setFont(isi1.getFont().deriveFont(14f));
                    isi1.setBounds(50,50,150,20);
                    
                    kiri.add(nama1);kiri.add(isi1);
                    
            JPanel kanan = new JPanel();
                kanan.setBorder(null);
                kanan.setLayout(new GridLayout(2,1));
                atas.add(kanan);
                
                    JLabel nama2 = new JLabel("Masukkan Nama Pemain 2 !");
                    nama2.setFont(nama2.getFont().deriveFont(15f));
                    
                    
                    isi2.setFont(isi2.getFont().deriveFont(14f));
                    isi2.setBounds(50,50,150,20);
                    
                    kanan.add(nama2);kanan.add(isi2);
            
             
                startGame.setFont(startGame.getFont().deriveFont(15f));
                startGame.addActionListener(this);
                bawah.add(startGame);
                    
            setLocationRelativeTo(null);
            setVisible(true);
            
        }  
        
        public void actionPerformed(ActionEvent e){
            String nama1 = isi1.getText();
            String nama2 = isi2.getText();
            Board_Game.daftarPemain[0] = new Player(nama1,1000,0);
            Board_Game.daftarPemain[1] = new Player(nama2,1000,0);
            
            Board_Game runtime = new Board_Game();
            runtime.setVisible(true);
            
        }

    
        
    }  