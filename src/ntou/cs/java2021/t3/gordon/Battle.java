package ntou.cs.java2021.t3.gordon;

public class Battle {
    Role role1;
    Role role2;

    public Battle(Role role1, Role role2) {
        this.role1 = role1;
        this.role2 = role2;
    }

    public void play() {
        while (true) {
            int damageByRole1 = role1.attack(role2);
            System.out.println(role1.getName() + " causes damage: " + damageByRole1);
            if (role2.getHp() <= 0) {
                System.out.println(String.format("%s defeats %s!", role1.getName(), role2.getName()));
                break;
            }
            System.out.printf("%s's HP becomes %,d%n", role2.getName(), role2.getHp());

            int damageByRole2 = role2.attack(role1);
            System.out.println(role2.getName() + " causes damage: " + damageByRole2);
            if (role1.getHp() <= 0) {
                System.out.println(String.format("%s defeats %s!", role2.getName(), role1.getName()));
                break;
            }
            System.out.printf("%s's HP becomes %,d%n", role1.getName(), role1.getHp());

        }

    }
}
