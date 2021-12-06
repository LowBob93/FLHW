package Obstacles;
import Action.Obstacle;
import java.util.Random;

public class Treadmill implements Obstacle {

    private static int lenght;

    public Treadmill() {
        this.lenght = new Random().nextInt(6) + 5;
    }

    public static int getLength() {
        return lenght;
    }
}