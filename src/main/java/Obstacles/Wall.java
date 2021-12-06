package Obstacles;

import Action.Obstacle;

import java.util.Random;

public class Wall implements Obstacle {

    private static int height;

    public Wall() {
        this.height = new Random().nextInt(7) + 2;
    }

    public static int getHeight() {
        return height;
    }
}