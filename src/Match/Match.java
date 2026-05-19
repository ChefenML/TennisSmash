package Match;

import Member.*;

import java.time.LocalDate;

public class Match {
    Member member1;
    Member member2;
    Member member3;
    Member member4;
    int result;
    GameTypes gameTypes;
    LocalDate date;
    //Single Match data
    public Match(Member member1, Member member2, int result, GameTypes gameTypes, LocalDate date){
        this.member1 = member1;
        this.member2 = member2;
        this.result = result;
        this.gameTypes = gameTypes;
        this.date = date;

    }
    //Overloaded constructor for doubles & Mixed
    public Match(Member member1, Member member2,Member member3, Member member4, int result, GameTypes gameTypes, LocalDate date){
        this.member1 = member1;
        this.member2 = member2;
        this.member3 = member3;
        this.member4 = member4;
        this.result = result;
        this.gameTypes = gameTypes;
        this.date = date;

    }

    public LocalDate getDate(){
        return date;
    }

    public int getResult(){
        return result;
    }

    public int getWinSize(){
        return Math.abs(result);
    }
}
