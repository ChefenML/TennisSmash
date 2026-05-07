package Member;

import java.time.LocalDate;
import java.time.Period;

public abstract class Member implements SmashFee {

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

    //Getters
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

    public Period getAge(){
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        LocalDate today = LocalDate.now();
        return Period.between(birthDate, today);
    }

    @Override
    public void membersFee() {

    }
}
