package Obstacles;

import Creatures.Cat;
import Creatures.Human;
import Creatures.Robot;
import Creatures.Team;
import Action.Obstacle;

public class Course {

    private final Obstacle[] barriers;

    public Course(Obstacle[] barriers) {
        this.barriers = barriers;
    }

    public void passTheCourse(Team team) {
        System.out.println("Старт!");
        System.out.println("___________");
        team.setWinPoints(4);
        for (int i = 0; i < team.getTeamArray().length; i++) {
            for (int j = 0; j < barriers.length; j++) {
                if (team.getTeamArray()[i] instanceof Cat) {
                    ((Cat) team.getTeamArray()[i]).isItDone(true);
                    ((Cat) team.getTeamArray()[i]).move(barriers[j]);
                    if (!((Cat) team.getTeamArray()[i]).isItDone()) {
                        team.setWinPoints(team.getWinPoints() -1 );
                        break;
                    }
                } else if (team.getTeamArray()[i] instanceof Human) {
                    ((Human) team.getTeamArray()[i]).isItDone(true);
                    ((Human) team.getTeamArray()[i]).move(barriers[j]);
                    if (!((Human) team.getTeamArray()[i]).isItDone()) {
                        team.setWinPoints(team.getWinPoints() -1 );
                        break;
                    }
                } else if (team.getTeamArray()[i] instanceof Robot) {
                    ((Robot) team.getTeamArray()[i]).setFinished(true);
                    ((Robot) team.getTeamArray()[i]).move(barriers[j]);
                    if (!((Robot) team.getTeamArray()[i]).isFinished()) {
                        team.setWinPoints(team.getWinPoints() -1 );
                        break;
                    }
                }
            }
        }
        System.out.println("Финиш!");
        System.out.println("___________");

    }
}
