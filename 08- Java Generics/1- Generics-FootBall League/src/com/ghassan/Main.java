package com.ghassan;

public class Main {

    //This example implements the idea of Generic types
    //This example is about a league table for sport
    //League -> Teams -> Players -> Football Players
    public static void main(String[] args) {

        League<Team<FootballPlayer>> footBallLeague = new League<>("FootBall");
        Team<FootballPlayer> team1 = new Team<>("Team_1");
        Team<FootballPlayer> team2 = new Team<>("Team_2");
        Team<FootballPlayer> team3 = new Team<>("Team_3");
        Team<FootballPlayer> team4 = new Team<>("Team_4");

        footBallLeague.add(team1);
        footBallLeague.add(team2);
        footBallLeague.add(team3);
        footBallLeague.add(team4);

        team1.matchResult(team2,1,2);
        team3.matchResult(team4,2,4);
        team1.matchResult(team3,2,2);
        team2.matchResult(team4,3,2);
        team4.matchResult(team1,1,3);

        footBallLeague.showTable();
    }
}
