package Member;

public class Senior extends Active {
        public Senior(String name, int MemberID, char gender,int birthYear,int birthMonth,int birthDay){
            super(name,MemberID,gender,birthYear,birthMonth,birthDay);
        }
        @Override
        public double membersFee(){
           1500.0;
        }
}
