package ntou.cs.java2021.t3.gordon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

public class GameGUI extends JFrame implements ActionListener {

    private String player1Name;
    private String player2Name;

    private Role player1;
    private Role player2;

    private Battle4GUI battle;

    private JPanel player1Zone;
    private JPanel player2Zone;

    private JTextField player1Hp;
    private JTextField player2Hp;

    private JLabel player1Image;
    private JLabel player2Image;

    private JButton player1Attack;
    private JButton player2Attack;

    public GameGUI(String player1Name, String player2Name) {
        super("Simple Battle");
        setLayout(new GridLayout(1, 2));

        this.player1Name = player1Name;
        this.player2Name = player2Name;

        createRoles();

        player1Zone = new JPanel();
        player1Zone.setLayout(new BorderLayout());

        JPanel player1Status = new JPanel();
        player1Status.add(new JLabel("目前生命值："));

        player1Hp = new JTextField("" + player1.getHp());
        player1Hp.setEditable(false);
        player1Status.add(player1Hp);
        add(player1Status);
        player1Zone.add(player1Status, BorderLayout.NORTH);

        Icon player1Icon = new ImageIcon(getClass().getResource(player1.getName() + ".png"));
        player1Image = new JLabel(player1Icon);

        player1Zone.add(player1Image, BorderLayout.CENTER);

        player1Attack = new JButton("Attack!");
        player1Attack.addActionListener(this);
        player1Zone.add(player1Attack, BorderLayout.SOUTH);

        player2Zone = new JPanel();
        player2Zone.setLayout(new BorderLayout());

        JPanel player2Status = new JPanel();
        player2Status.add(new JLabel("目前生命值："));

        player2Hp = new JTextField("" + player2.getHp());
        player2Hp.setEditable(false);
        player2Status.add(player2Hp);
        player2Zone.add(player2Status, BorderLayout.NORTH);

        Icon player2Icon = new ImageIcon(getClass().getResource(player2.getName() + ".png"));
        player2Image = new JLabel(player2Icon);

        player2Zone.add(player2Image, BorderLayout.CENTER);

        player2Attack = new JButton("Attack!");
        player2Attack.addActionListener(this);
        player2Zone.add(player2Attack, BorderLayout.SOUTH);

        add(player1Zone);
        add(player2Zone);

        battle = new Battle4GUI(player1, player2, this, player1Hp, player2Hp);
    }

    public void createRoles() {

        SecureRandom random = new SecureRandom();

        player1 = new Role(player1Name, 500 + random.nextInt(500), 100 + random.nextInt(156), 20 + random.nextInt(80));
        player2 = new Role(player2Name, 500 + random.nextInt(500), 100 + random.nextInt(156), 20 + random.nextInt(80));
        System.out.printf("%s%n%s%n", player1, player2);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == player1Attack) {
            battle.play(true);
            player1Attack.setEnabled(false);
            player2Attack.setEnabled(true);
        }
        if (e.getSource() == player2Attack) {
            battle.play(false);
            player1Attack.setEnabled(true);
            player2Attack.setEnabled(false);
        }
    }

}
