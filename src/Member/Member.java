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
    private int birthDayOfMonth;


    //Konstruktør
    public Member(String name, int memberID, char gender, int birthYear, int birthMonth, int birthDayOfMonth){
        this.name = name;
        this.memberID = memberID;
        this.gender = gender;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDayOfMonth = birthDayOfMonth;
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
        return birthDayOfMonth;
    }

    //Metode til at udregne alder ved at tage stamdataen indtastet ved indmeldelse og sammenligne dem med dagens dato ved hjælp af LocalDateTime & Period.between.
    public Period getAge(){
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDayOfMonth);
        LocalDate today = LocalDate.now();
        return Period.between(birthDate, today);
    }

    //toString metode til at printe vores medlem i stedet for at få vise allokeret memory,
    //her bliver der implementere vores getAge metode, vi kalder på age.getYears der returnere alderen i hele tal
    public String toString(){
        Period age = getAge();
        return "Navn: " + name + " - MedlemsID: " + memberID + " - Køn: " + gender + " - Alder: " + age.getYears();
    }

    //Metoden fra vores interface SmashFee
    @Override
    public void membersFee() {
    }
}
