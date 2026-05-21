package Match;

import Member.*;

import java.time.LocalDate;

import static Member.GameTypes.SINGLE;

public class Match {
    int member1, member2, member3, member4;
    int result;
    GameTypes gameTypes;
    LocalDate date;
    //Single Match data
    public Match(int member1, int member2, int result, LocalDate date){
        this.member1 = member1;
        this.member2 = member2;
        this.result = result;
        this.gameTypes = SINGLE;
        this.date = date;

    }
    //Overloaded constructor for doubles & Mixed
    public Match(int member1, int member2, int member3, int member4, int result, GameTypes gameTypes, LocalDate date){
        this.member1 = member1;
        this.member2 = member2;
        this.member3 = member3;
        this.member4 = member4;
        this.result = result;
        this.gameTypes = gameTypes;
        this.date = date;

    }

//    public int getMemberId(){
//        return member.get
//    }

    public GameTypes getGameType(){
        return gameTypes;
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


    public String toString(){
        if(this.gameTypes == SINGLE){
            return
                    member1 + "," +
                            member2 + "," +
                            result + "|" +
                            gameTypes + "|" +
                            date;


        } else return
                member1 + "," +
                        member2 + "," +
                        member3 + "," +
                        member4 + "|" +
                        result + "|" +
                        gameTypes + "|" +
                        date;
    }
}
