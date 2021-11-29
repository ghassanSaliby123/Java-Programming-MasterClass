package com.ghassan;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Team {
    private String teamTye;
    ArrayList<FootBall> myFootBallTeams;
    ArrayList<BasketBall> myBasketBallTeams;

    public Team(String teamTye) {
        this.teamTye = teamTye;
        if(teamTye == "FootBall"){
            myFootBallTeams = new ArrayList<>();
        }else if (teamTye == "BasketBall"){
            myBasketBallTeams = new ArrayList<>();
        }else {
            System.out.println("Enter your choice FootBall or BasketBall");
        }
    }

    public String getTeamTye() {
        return teamTye;
    }

    public ArrayList<FootBall> getMyFootBallTeams() {
        return myFootBallTeams;
    }

    public ArrayList<BasketBall> getMyBasketBallTeams() {
        return myBasketBallTeams;
    }
}
