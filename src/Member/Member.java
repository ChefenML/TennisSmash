package Member;

public class Member implements SmashFee {

    //Private variable så vi kun kan tilgå dem i denne klasse. (Incapsulation)
    private String name;
    private int memberID;
    private char gender;
    private int birthYear;
    private int birthMonth;
    private int birthDay;


    //Konstruktør
    public Member(String name, int memberID, char gender, int birthYear, int birthMonth, int birthDay){
        this.name = name;
        this.memberID = memberID;
        this.gender = gender;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public int getMemberID() {
        return memberID;
    }

    public char getGender() {
        return gender;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }

    @Override
    public void membersFee() {

    }
}
