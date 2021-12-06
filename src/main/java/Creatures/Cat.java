package Creatures;
import Obstacles.Treadmill;
import Obstacles.Wall;
import Action.Contender;
import Action.Obstacle;

import java.util.Random;

public class Cat implements Contender {

    private final String name;
    private final int runLimit;
    private final int jumpLimit;
    private boolean isItDone;

    public Cat(String name) {
        this.name = name;
        this.jumpLimit = new Random().nextInt(12) + 4;
        this.runLimit = new Random().nextInt(7) + 3;
    }

    public String getName() {
        return name;
    }

    public int getRunLimit() {
        return runLimit;
    }
    public int getJumpLimit() {
        return jumpLimit;
    }
    public boolean isItDone() {
        return isItDone;
    }
    public void isItDone(boolean done) {
        isItDone = done;
    }
    @Override
    public void jump() {
            if (this.getJumpLimit() < (Wall.getHeight())){
        System.out.println("Кот  " + getName() + " не перепрыгнул препятствие");
        isItDone(false);
    } else {
            System.out.println("Кот  " + getName() + " перепрыгнул препятствие");
            isItDone(true);
        }
    }

    @Override
    public void run() {
        if (this.getRunLimit() < (Treadmill.getLength())) {
            System.out.println("Кот  " + getName() + " не пробежал дистанцию");
            isItDone(false);
        } else {
            System.out.println("Кот  " + getName() + " пробежал дистанцию");
            isItDone(true);
        }
    }
    @Override
    public void move(Obstacle obstacle) {
        if (obstacle instanceof Wall) {
            jump();
        } else {
            run();
            }
        }
    }
