package Creatures;

import Obstacles.Treadmill;
import Obstacles.Wall;
import Action.Contender;
import Action.Obstacle;

public class Robot implements Contender {

    private final String name;
    private final int runLimit;
    private final int jumpLimit;
    private boolean isFinished;

    public Robot(String name) {
        this.name = name;
        this.runLimit = 10;
        this.jumpLimit = 10;
        // робот имеет фиксированные ттх
    }

    public String getName() {
        return name;
    }

    public int getMaxRun() {
        return runLimit;
    }

    public int getMaxJump() {
        return jumpLimit;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    @Override
    public void jump() {
        if (this.getMaxJump() < (Wall.getHeight())){
            System.out.println("Робот  " + getName() + " не перепрыгнул препятствие");
            setFinished(false);
        } else {
            System.out.println("Робот  " + getName() + " перепрыгнул препятствие");
            setFinished(true);
        }
    }

    @Override
    public void run() {
        if (this.getMaxRun() < (Treadmill.getLength())) {
            System.out.println("Робот  " + getName() + " не пробежал дистанцию");
            setFinished(false);
        } else {
            System.out.println("Робот  " + getName() + " пробежал дистанцию");
            setFinished(true);
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
