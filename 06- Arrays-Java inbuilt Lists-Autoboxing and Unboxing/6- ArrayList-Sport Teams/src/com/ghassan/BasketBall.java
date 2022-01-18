package com.ghassan;

public class BasketBall {
    private String name;
    private int playersNumber;
    private int score;
    private int winMatches;
    private int lostMatches;
    private int drawMatches;

    private BasketBall(String name) {
        this.name = name;
        this.playersNumber = 5;
        this.score= 0;
        this.winMatches= 0;
        this.lostMatches = 0;
        this.drawMatches = 0;
    }
    public void playMatch(int teamPoints, int otherTeamPoints){
        if(teamPoints > otherTeamPoints){
            System.out.println("Team "+this.getName()+ " Won.");
            this.winMatches++;
            this.score += 3;
        }else if(teamPoints < otherTeamPoints) {
            System.out.println("Team " + this.getName() + "lost.");
            this.lostMatches++;
            this.score += 0;
        }
        else {
            System.out.println("There is a draw");
            drawMatches++;
            this.score += 1;
        }
    }
    public void showRecords(){
        System.out.println(this.name+"\n" +
                "Total Played Matches: "+(this.winMatches+ this.lostMatches+this.drawMatches)+"\n" +
                "Wins:" + this.winMatches+"     "+ "Losts :"+ this.lostMatches+
                "       "+"Draws :"+ this.drawMatches+"\n" +
                "Total Score :"+this.score );
    }
    public static BasketBall createNewTeam(String name){
            return new BasketBall( name);
    }

    public String getName() {
        return name;
    }

    public int getPlayersNumber() {
        return playersNumber;
    }

    public int getScore() {
        return score;
    }

    public int getWinMatches() {
        return winMatches;
    }

    public int getLostMatches() {
        return lostMatches;
    }

    public int getDrawMatches() {
        return drawMatches;
    }
}
