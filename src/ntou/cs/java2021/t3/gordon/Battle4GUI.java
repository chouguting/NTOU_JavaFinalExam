package ntou.cs.java2021.t3.gordon;

import javax.swing.*;

public class Battle4GUI extends Battle {

    public static final int CONTINUE = 1;
    public static final int OVER = 2;

    private JFrame gameFrame;
    private JTextField player1Hp;
    private JTextField player2Hp;

    public Battle4GUI(Role role1, Role role2, JFrame gameFrame, JTextField player1Hp, JTextField player2Hp) {
        super(role1, role2);
        this.gameFrame = gameFrame;
        this.player1Hp = player1Hp;
        this.player2Hp = player2Hp;
    }

    public int play(boolean firstPlayer) {
        if (firstPlayer) {
            int damageByRole1 = role1.attack(role2);
            if (role2.getHp() <= 0) {
                player2Hp.setText("0");
                JOptionPane.showMessageDialog(gameFrame, String.format("%s 打倒了 %s", role1.getName(), role2.getName()));
                return OVER;
            }
            player2Hp.setText(Integer.toString(role2.getHp()));
            return CONTINUE;
        } else {
            int damageByRole2 = role2.attack(role1);
            if (role1.getHp() <= 0) {
                player1Hp.setText("0");
                JOptionPane.showMessageDialog(gameFrame, String.format("%s 打倒了 %s", role2.getName(), role1.getName()));
                return OVER;
            }
            player1Hp.setText(Integer.toString(role1.getHp()));
            return CONTINUE;
        }
    }
}
