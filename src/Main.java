import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Scanner myscanner = new Scanner(System.in);
    static Random randomgenerator = new Random();


    public static void main(String[] args) {
        System.out.println("Welcome to BASH A MONSTER!!!!! 😈🔨\n--------------------------------");
        String name;
        var player = new Player(randomgenerator.nextInt(60, 81));
        var goomba = new Goomba();

        while (true) {

            do {
                System.out.println("What do you want to name your character?");
                name = myscanner.nextLine();
                if (name.isBlank()) {
                    player.name = "Steve";
                    break;
                } else {
                    player.name = name;
                    break;
                }
            } while (true);

            do {
                System.out.println("\nStats for: " + player.name + "\nMana: " + player.mana + "\nHp: " + player.hp);
                System.out.println("\nDo you want to attack and use 10 mana? Or wait and have a chance gain 10 mana? (y/n)");
                String choice = myscanner.nextLine();
                if (choice.equalsIgnoreCase("y")) {
                    goomba.hp = attack(player.hp, goomba.hp);
                    player.mana -= 10;
                    System.out.println(player.name + " attacked the Goomba which now has " + goomba.hp + "hp left");
                    if (player.hp <= 0) {
                        System.out.println("Game over... ☠️");
                        break;
                    } else if (goomba.hp <= 0) {
                        System.out.println("You win!");
                        break;
                    }


                    player.hp = attack(goomba.hp, player.hp);
                    System.out.println("Goomba counter attacks you. You now have " + player.hp + "hp left");
                    if (player.hp <= 0) {
                        System.out.println("Game over... ☠️");
                        break;
                    } else if (goomba.hp <= 0) {
                        System.out.println("You win!");
                        break;
                    }


                } else if (choice.equalsIgnoreCase("n")) {

                    if (randomgenerator.nextInt(1, 3) == 1) {
                        System.out.println("Goomba attacked you, you gained no mana");
                        player.hp = attack(goomba.hp, player.hp);
                    } else {
                        System.out.println("Goomba missed the attack, you gained 10 mana");
                        player.mana += 10;
                    }


                    if (player.hp <= 0) {
                        System.out.println("Game over... ☠️");
                        break;
                    } else if (goomba.hp <= 0) {
                        System.out.println("You win!");
                        break;
                    }
                } else {
                    System.out.println("Not a valid choice.");
                }
            } while (true);

            break;

        }


    }


    public static int attack(int attackerHp, int reciverHp) {
        int damage = randomgenerator.nextInt(10, 21);
        if (reciverHp - damage <= 0) {
            reciverHp = 0;
            return reciverHp;
            // TODO: Game-Over for the attack-reciver
        } else {
            reciverHp -= damage;
            return reciverHp;
        }
    }

}