package lab.w9;

public class Adventure {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Minsc",7,5,3);
        Thief thief = new Thief("Imoen",5,8,3);
        Wizard wizard = new Wizard("Elminster",3,5,7);

        System.out.println(warrior.describe() + "\n");
        System.out.println(thief.describe()+ "\n");
        System.out.println(wizard.describe());
        System.out.println(wizard.displayMagic() + "\n");

        System.out.println("Oh, a Illithid has come, and is attacking the Baldur's Gate city!\n");
        System.out.println(warrior.attackMonster());
        System.out.println(thief.attackMonster());
        System.out.println(wizard.attackMonster());

        System.out.println();
        Wizard gideon = new Wizard ("Gorion", 10, 10, 10);
        System.out.println(gideon.describe());
    }
}
