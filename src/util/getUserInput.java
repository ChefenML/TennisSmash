package util;



import Member.Exerciser;
import Member.GameTypes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;


import static Member.GameTypes.*;


import static Member.Exerciser.*;


public class getUserInput {
    Scanner scanner = new Scanner(System.in);

    public int getInt(){
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }

    }

    public LocalDate getLocalDate(){
        try {
            LocalDate date;
            System.out.println("Skrive dato, følgende formatter tilladt: [d-M-yyyy] [d.M.yyyy] [d M yyyy] [d\\M\\yyyy] [d/M/yyyy] [d,M,yyyy]");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("[d-M-yyyy]" + "[d.M.yyyy]" + "[d M yyyy]"+ "[d\\M\\yyyy]"+ "[d/M/yyyy]"+ "[d,M,yyyy]");
            date = LocalDate.parse(scanner.nextLine(),dtf);
            return date;
        } catch (InputMismatchException e) {
            throw new RuntimeException(e);
        }
    }

    public GameTypes getGameTypes(){
        System.out.println("Vælg imellem:" );
        System.out.println("1: SINGLE 2: DOUBLE 3: MIXED");
        int choice = getInt();
        GameTypes gameTypes = null;
        switch(choice){
            case 1 -> gameTypes = SINGLE;
            case 2 -> gameTypes = DOUBLE;
            case 3 -> gameTypes = MIXED;
            default -> System.out.println("Kun 1-4 tilladt.");
        }
        return gameTypes;
    }
    //giver dette nogensinde problemer uden Datetimeformatter her modsat anden funktion?
    public LocalDate getTodaysDate(){
        LocalDate date = LocalDate.now();
        return date;
    }

        public Exerciser getExerciser(){
        System.out.println("Vælg Spillertype imellem:" );
        System.out.println("1: EXERCISE 2: COMPETITIVE");
        int choice = getInt();
            Exerciser exerciser = null;
        switch(choice){
            case 1 -> exerciser = EXERCISE;
            case 2 -> exerciser = COMPETITIVE;
            default -> System.out.println("Kun 1-3 tilladt.");
        }
        return exerciser;
    }

    public String getStringInput(String prompt){
        try {
            System.out.println(prompt);
            return scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Ugyldigt input");
            return getStringInput(prompt);
        }
    }

    public int getIntFromString(String prompt) {
        try {
            String input = getStringInput(prompt);
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Ugyldigt tal");
            return getIntFromString(prompt);
        }
    }
}
