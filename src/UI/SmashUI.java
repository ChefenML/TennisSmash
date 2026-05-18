package UI;
import Member.*;
import Member.MemberFactory;
import FileHandler.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Scanner;
import java.util.logging.FileHandler;

import static Member.Colors.*;
import static Member.Exerciser.EXERCISE;
import static Member.GameTypes.SINGLE;

public class SmashUI {
    private MemberFactory factory;
    private MemberHandler fileHandler;
    private Scanner scanner;

    // Creates a constructor to make sure the class has the necessary tools
    public SmashUI() throws IOException {
        this.factory = new MemberFactory();
        this.fileHandler = new MemberHandler();
        this.scanner = new Scanner(System.in);
    }

    // This is the start method used in the app
    public void start() {
        boolean running = true;

        System.out.println("Velkommen til Smash Management System!"
                + "\n--------------------------------");

        while (running) {
            showRoleMenu();
            int choice = getIntegerInput();

            switch (choice){
                case 1 -> isChairman();
                case 2 -> isCashier();
                case 3 -> isTrainer();
                case 0 -> running = false;
                default ->  System.out.println(RED + "Fejl. Prøv igen!" + RESET);
            }

        }

    // Here a selection of choices will be run and loope
    }

    private void showRoleMenu(){
        System.out.println("\nLOG IND SOM: ");
        System.out.println("1. Klubformand");
        System.out.println("2. Kasser");
        System.out.println("3. Træner");
        System.out.println("0. Afslut");
        System.out.print("Vælg en mulighed: ");
    }


    private void isChairman(){
        boolean running = true;

        while (running) {
            showChairmanMenu();
            int choice = getIntegerInput();

            switch (choice){
                case 1 -> addNewMember();
                case 2 -> showAllMembers();
                case 3 -> saveAndExit();
                case 0 -> running = false;
                default -> System.out.println(RED + "Fejl. Prøv igen!" + RESET);
            }
        }
    }

    private void isTrainer(){
        boolean running = true;

        while (running) {
            showTrainerMenu();
            int choice = getIntegerInput();

            switch (choice){
                case 1 -> registerBestResult();
                case 2 -> registerTournamentResult();
                case 3 -> getTopFive();
                case 4 -> saveAndExit();
                case 0 -> running = false;
                default -> System.out.println(RED + "Fejl. Prøv igen!" + RESET);
            }
        }
    }

    private void isCashier(){
        boolean running = true;

        while (running) {
            showCashierMenu();
            int choice = getIntegerInput();

            switch (choice){
                case 1 -> getPaymentList();
                case 0 -> running = false;
                default -> System.out.println(RED + "Fejl. Prøv igen!" + RESET);
            }
        }
    }

    // This is a method to print out a selection of options to the output
    private void showChairmanMenu(){
        System.out.println("\n--- KLUBFORMAND MENU ---");
        System.out.println("1. Tilføj nyt medlem");
        System.out.println("2. Vis liste over alle medlemmere");
        System.out.println("3. Gem ændringer");
        System.out.println("0. Afslut");
        System.out.print("Vælg en mulighed: ");
    }

    private void showCashierMenu(){
        System.out.println("\n--- KASSER MENU ---");
        System.out.println("1. Vis forventede indbetalinger efter beløb");
        System.out.println("0. Afslut");
        System.out.print("Vælg en mulighed: ");
    }

    private void showTrainerMenu(){
        System.out.println("\n--- TRÆNER MENU ---");
        System.out.println("1. Registrer dagens bedste træningsresultat for en spiller");
        System.out.println("2. Indtast tuneringsresultater");
        System.out.println("3. Se top 5 ranglister");
        System.out.println("0. Afslut");
        System.out.print("Vælg en mulighed: ");
    }

    // This will be a method for adding a member object to a list
    private void addNewMember(){
        System.out.println("Indtast navn: ");
        String name = scanner.nextLine();

        System.out.println("Indtast memberID: ");
        int memberID = Integer.parseInt(scanner.nextLine());

        System.out.println("Indtast køn (M for mand, F for kvinde): ");
        char gender = scanner.nextLine().charAt(0); // charAt(0) tager det første tegn i strengen"" og giver et char''. fx "M" bliver til 'M'

        System.out.println("Indtast fødselsåret (Eks. 1998 eller 2005): ");
        int birthYear = Integer.parseInt(scanner.nextLine());

        System.out.println("Indtast fødselsmåned (Eks. 3 eller 11: ");
        int birthMonth = Integer.parseInt(scanner.nextLine());

        System.out.println("Indtast dagen medlemmet er født (Eks 2 eller 20: ");
        int birthDayOfMonth = Integer.parseInt(scanner.nextLine());

        System.out.println("Indtast medlemstype (vælg én: JUNIOR, SENIOR, VETERAN): ");
        MemberType memberType = MemberType.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Indtast disciplin (vælg én eller flere: SINGLE, DOUBLE, MIXED, PASSIVE): ");
        String[] gameTypeStrings = scanner.nextLine().toUpperCase().split(","); // læser det brugeren taster, fx "single,double" - gør til store bogstaver og splitter på komma, så vi får ["SINGLE", "DOUBLE"].
        EnumSet<GameTypes> gameTypes = EnumSet.noneOf(GameTypes.class); // opretter et tomt EnumSet som kan modtage GameTypes. ligesom i MemberHandler.java
        for (String gt : gameTypeStrings) { // går igennem listen én ad gangen. fx først "SINGLE", så "DOUBLE"
            gameTypes.add(GameTypes.valueOf(gt.trim())); // trim fjerner evt. mellemrum så fx SINGLE, DOUBLE også virker. Derefter konverterer valueof teksten til enum-værdien og tilføjer til EnumSet
            // så efter loopet er færdigt, indeholder gameTypes alle de værdier brugeren tastede ind
        }

        System.out.println("Indtast om brugeren er motionist, konkurrencespiller eller er passivt medlem (vælg én: COMPETITIVE, EXERCISE, PASSIVE): ");
        Exerciser exerciser = Exerciser.valueOf(scanner.nextLine().toUpperCase());

        Member newMember = new Member(name, memberID, gender, birthYear, birthMonth, birthDayOfMonth, memberType, gameTypes, exerciser);
        fileHandler.save(newMember); // kalder save metoden i MemberHandler og sender det nye member med så det gemmes i CSV filen




    }

    // This will be a method for showing all members
    private void showAllMembers(){
        fileHandler.showMembers();

    }

    private void getPaymentList(){

    }

    private void registerBestResult(){

    }

    private void registerTournamentResult(){

    }

    private void getTopFive(){

    }

    // This will save and close the program
    private void saveAndExit(){

    }

    // This is an exception for handling integers
    private int getIntegerInput(){
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}
