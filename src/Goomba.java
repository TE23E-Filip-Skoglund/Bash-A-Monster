import java.util.Random;

public class Goomba {
    // Declare basic variables for the class
    int hp;
    int level;

    static Random randomgenerator = new Random();

    // Set default hp to random from minimum 20 and to maximum 51
    Goomba() {
        hp = randomgenerator.nextInt(20, 51);
    }

    // Adds 20 hp per level on creation (if level is inputed)
    Goomba(int level) {
        this.level = level;
        hp = randomgenerator.nextInt(20, 51) + 20 * level;
    }

}
