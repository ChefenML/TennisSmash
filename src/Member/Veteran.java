package Member;

public class Veteran extends Active {
        public Veteran(String name, int MemberID, char gender,int birthYear,int birthMonth,int birthDay,GameTypes gameType,Exerciser exercise){
            super(name,MemberID,gender,birthYear,birthMonth,birthDay,gameType,exercise);

        }
        @Override
        public double membersFee(){
           return 1125.0;
        }
    }

