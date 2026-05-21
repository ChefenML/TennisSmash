package util;

import Member.GameTypes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Member.GameTypes.*;

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
        System.out.println("1: SINGLE 2: DOUBLE 3: MIXED 8: PASSIVE");
        int choice = getInt();
        GameTypes gameTypes = null;
        switch(choice){
            case 1 -> gameTypes = SINGLE;
            case 2 -> gameTypes = DOUBLE;
            case 3 -> gameTypes = MIXED;
            case 4 -> gameTypes = PASSIVE;
        }
        return gameTypes;
    }

}
