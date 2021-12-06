package Creatures;

import Action.Contender;

public class Team {

    private final String teamName;
    private final Contender[] teamArray;
    private int winPoints;

    public Team(String teamName, Contender memberOne, Contender memberTwo, Contender memberThree, Contender memberFour) {
        this.teamName = teamName;
        this.teamArray = new Contender[4];
        teamArray[0] = memberOne;
        teamArray[1] = memberTwo;
        teamArray[2] = memberThree;
        teamArray[3] = memberFour;
    }

    public String getTeamName() {

        return teamName;
    }

    public Contender[] getTeamArray() {

        return teamArray;
    }

    public int getWinPoints() {
        return winPoints;
    }

    public void setWinPoints(int winPoints) {
        this.winPoints = winPoints;
    }

    public void printInfo() {
        System.out.println("______________________");
        System.out.println("Обявляем участников :");
        System.out.println("Команда  " + getTeamName() + ".");
        System.out.println("Участники:");
        for (Contender contender : teamArray) {
            if (contender instanceof Human) {
                System.out.println("Человек " + ((Human) contender).getName() + " Высота прыжка  " + ((Human) contender).getJumpLimit() + " Выносливость " + ((Human) contender).getRunLimit());
            } else if (contender instanceof Cat) {
                System.out.println("Кот " + ((Cat) contender).getName() + " Высота прыжка  " + ((Cat) contender).getRunLimit()  +  " Выносливость " + ((Cat) contender).getJumpLimit());
            } else  {
                System.out.println("Робот " + ((Robot) contender).getName() + " Высота прыжка  " + ((Robot) contender).getMaxJump() + " Выносливость " + ((Robot) contender).getMaxRun());
            }
        }
    }

    public void showResults() {
        if (winPoints < 1) {
            System.out.println("Команда " + teamName + " не смогла пройти испытание");
        } else if (winPoints == 4) {
            System.out.println("Все участники комманды " + teamName + " прошли испытания");
        }else{
            System.out.println("Победители: ");
            for (int i = 0; i < teamArray.length; i++) {
                if (teamArray[i] instanceof Human) {
                    if (((Human) teamArray[i]).isItDone()) {
                        System.out.println("Человек " + ((Human) teamArray[i]).getName());
                    }
                } else if (teamArray[i] instanceof Cat) {
                    if (((Cat) teamArray[i]).isItDone()) {
                        System.out.println("Кот " + ((Cat) teamArray[i]).getName());
                    }
                } else if (teamArray[i] instanceof Robot) {
                    if (((Robot) teamArray[i]).isFinished()) {
                        System.out.println("Робот " + ((Robot) teamArray[i]).getName());
                    }
                }
            }
        }
    }
}