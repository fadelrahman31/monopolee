import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Winning_Frame extends JFrame {

    public Winning_Frame(Player p){
        super("Congratulations and Celebrations !!!");
        setSize(800,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));

        //Panel atas
        JLabel layerAtas = new JLabel("CONGRATULATIONS AND CELEBRATIONS !! (for you, not us)");
        layerAtas.setFont(layerAtas.getFont().deriveFont(25f));

        //Panel Tengah

        JTextArea layerTengah = new JTextArea();
        layerTengah.setEditable(false);
        if(p.getName().equals(Board_Game.daftarPemain[0].getName())){
            layerTengah.append(Board_Game.daftarPemain[1].getName()+ ", You're the chosen one !!\n");
        }else{
            layerTengah.append(Board_Game.daftarPemain[0].getName()+ ", You're the chosen one !!\n");
        }
        layerTengah.append("From kami : \n");
        layerTengah.append(">> 18217005        FADEL N RAHMAN \n");
        layerTengah.append(">> 18217011        DAVID PETRA  N \n");
        layerTengah.append(">> 18217020        NADYA ANSTASIA \n");
        layerTengah.append(">> 18217037        LIDYA  JESSICA \n");
        layerTengah.setFont(layerTengah.getFont().deriveFont(18f));

        //Panel Bawah
        JPanel layerBawah = new JPanel();
        JButton backHome = new JButton("Kembali ke Desktop QUI !!");
        backHome.setFont(backHome.getFont().deriveFont(13f));
        backHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*setVisible(false);
                dispose();
                Monopolee home = new Monopolee();
                Board_Game.gameLog.setCaretPosition(0);
                Board_Game.gameLog.setText("");
                home.setVisible(true);*/
                dispose();
                System.exit(0);

            }
        });
        layerBawah.add(backHome);

        add(layerAtas); add(layerTengah); add(layerBawah);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
