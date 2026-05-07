package Member;

public class Junior extends Active {
    public Junior(String name, int MemberID, char gender,int birthYear,int birthMonth,int birthDay,GameTypes gameType,Exerciser exercise){
        super(name,MemberID,gender,birthYear,birthMonth,birthDay,gameType,exercise);

    }
    @Override
    public double membersFee(){
return 800.0;
    }


}
