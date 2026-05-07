package Member;

public class Junior extends Active {
    public Junior(String name, int MemberID, char gender,int birthYear,int birthMonth,int birthDay){
        super(name,MemberID,gender,birthYear,birthMonth,birthDay);

    }
    @Override
    public double membersFee(){
return 800.0;
    }


}
