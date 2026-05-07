package Member;

public class Veteran extends Active {
        public Veteran(String name, int MemberID, char gender,int birthYear,int birthMonth,int birthDay){
            super(name,MemberID,gender,birthYear,birthMonth,birthDay);

        }
        @Override
        public double membersFee(){
           return 1125.0;
        }
    }

