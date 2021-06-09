package ntou.cs.java2021.t3.gordon;

import java.security.SecureRandom;

public class BattleTest {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();

        Role role1 = new Role("Captain America", 500 + random.nextInt(500), 100 + random.nextInt(156),
                20 + random.nextInt(80));
        Role role2 = new Role("Iron Man", 500 + random.nextInt(500), 100 + random.nextInt(156),
                20 + random.nextInt(80));

        Battle battle = new Battle(role1, role2);
        battle.play();
    }
}
