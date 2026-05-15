package Member;

import java.time.LocalDate;
import java.time.Period;
import java.util.EnumSet;

public class Member implements SmashFee {

    //Private variable så vi kun kan tilgå dem i denne klasse. (Incapsulation)
    private String name;
    private MemberType memberType;
    private int memberID;
    private char gender;
    private int birthYear;
    private int birthMonth;
    private int birthDayOfMonth;
    private EnumSet<GameTypes> gameTypes;
    private Exerciser exerciser;

    //Konstruktør
    public Member(String name, int memberID, char gender, int birthYear, int birthMonth, int birthDayOfMonth, MemberType memberType, EnumSet<GameTypes> gameTypes, Exerciser exerciser){
        this.name = name;
        this.memberID = memberID;
        this.gender = gender;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDayOfMonth = birthDayOfMonth;
        this.memberType = memberType;
        this.gameTypes = gameTypes;
        this.exerciser = exerciser;

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

    public int birthDayOfMonth() {
        return birthDayOfMonth;
    }

    public String getMemberType(){
        return memberType.name();
    }

    public EnumSet<GameTypes> getGameTypes(){
        return gameTypes;
    }

    public String getExerciser(){
        return exerciser.name();
    }


    //Metode til at udregne alder ved at tage stamdataene: birthYear, birthMonth & birthDayOfMonth, indtastet ved indmeldelse,
    // og sammenligne dem med dagens dato ved hjælp af LocalDateTime & Period.between.
    public int getAge(){
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDayOfMonth);
        LocalDate today = LocalDate.now();
        return Period.between(birthDate, today).getYears();
    }

    //toString metode til at printe vores medlem i stedet for at få vise allokeret memory,
    //her bliver der implementere vores getAge metode, vi kalder på age.getYears der returnere alderen i hele tal

    //ø i køn laver noget hyperlink lign. (Kig det igennem)
    public String toString(){
        return "Navn: " + name + " - MedlemsID: " + memberID + " - Kon: " + gender + " - Alder: " + getAge() + " - GameTypes: " + getGameTypes();
    }

    //Metoden fra vores interface SmashFee
    @Override
    public double membersFee(){
        return memberType.getFee();

    }
}
