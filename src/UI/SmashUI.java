package UI;
import Match.MatchFactory;
import Member.*;
import Member.MemberFactory;
import FileHandler.*;
import Payment.Payment;
import Sorting.MemberSorter;
import Exception.*;
import SwingTest.EasterEggFrame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
    private PaymentHandler paymentHandler;
    private MatchHandler matchHandler;
    private MatchFactory matchFactory;

    // Creates a constructor to make sure the class has the necessary tools
    public SmashUI() throws SmashUIException {
        this.factory = new MemberFactory();
        this.fileHandler = new MemberHandler();
        this.scanner = new Scanner(System.in);
        this.paymentHandler = new PaymentHandler();
        matchHandler = new MatchHandler();
        matchFactory = new MatchFactory();
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
                case 666 -> new EasterEggFrame();
                case 0 -> running = false;
                default ->  System.out.println(RED + "Fejl. Prøv igen!" + RESET);
            }

        }

    // Here a selection of choices will be run and loope
    }

    private void showRoleMenu(){
        System.out.println("\nLOG IND SOM: ");
        System.out.println(GREEN + "1." + RESET + " Klubformand");
        System.out.println(GREEN + "2." + RESET + " Kasser");
        System.out.println(GREEN + "3." + RESET + " Træner");
        System.out.println(GREEN + "0." + RESET + " Afslut");
        System.out.print(YELLOW + "Vælg en mulighed: " + RESET);
    }


    private void isChairman(){
        boolean running = true;

        while (running) {
            showChairmanMenu();
            int choice = getIntegerInput();

            switch (choice){
                case 1 -> addNewMember();
                case 2 -> showAllMembers();
                case 3 -> sortMembers();
                case 4 -> saveAndExit();
                case 5 -> fileHandler.sortMemberByName();
                case 6 -> fileHandler.sortMemberByAge();
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
                case 3 -> matchHandler.showMatches();
                case 4 -> createMatch();
                case 5 -> matchHandler.createTypeArray(SINGLE);
                case 0 -> running = false;
                default -> System.out.println(RED + "Fejl. Prøv igen!" + RESET);
            }
        }
    }

    private void isCashier(){
        //paymentHandler.load();
        boolean running = true;

        while (running) {
            showCashierMenu();
            int choice = getIntegerInput();

            switch (choice){
                case 1 -> paymentHandler.getPaymentList();
                case 2 -> paymentHandler.getSortedPaymentList();
                case 3 -> paymentHandler.getListArrears();
                case 0 -> running = false;
                default -> System.out.println(RED + "Fejl. Prøv igen!" + RESET);
            }
        }
    }

    // This is a method to print out a selection of options to the output
    private void showChairmanMenu(){
        System.out.println("\n--- KLUBFORMAND MENU ---");
        System.out.println(GREEN + "1." + RESET + " Tilføj nyt medlem");
        System.out.println(GREEN + "2." + RESET + " Vis liste over alle medlemmere");
        System.out.println(GREEN + "3." + RESET + " Vis liste sorteret");
        System.out.println(GREEN + "4." + RESET + " Gem ændringer");
        System.out.println(GREEN + "0." + RESET + " Afslut");
        System.out.print(YELLOW + "Vælg en mulighed: " + RESET);

    }

    private void showCashierMenu(){
        System.out.println("\n--- KASSER MENU ---");
        System.out.println(GREEN + "1." + RESET + " Vis forventede indbetalinger usorteret");
        System.out.println(GREEN + "2." + RESET + " Vis forventede indbetalinger sorteret efter beløb");
        System.out.println(GREEN + "3." + RESET + " Vis medlemmer i restance sorteret efter beløb eller navn");
        System.out.println(GREEN + "0." + RESET + " Afslut");
        System.out.print(YELLOW + "Vælg en mulighed: " + RESET);
    }

    private void showTrainerMenu(){
        System.out.println("\n--- TRÆNER MENU ---");
        System.out.println(GREEN + "1." + RESET + " Registrer dagens bedste træningsresultat for en spiller");
        System.out.println(GREEN + "2." + RESET + " Indtast tuneringsresultater");
        System.out.println(GREEN + "4." + RESET + " Opret en kamp");
        System.out.println(GREEN + "5." + RESET + " Se top 5 ranglister");
        System.out.println(GREEN + "0." + RESET + " Afslut");
        System.out.print(YELLOW + "Vælg en mulighed: " + RESET);
    }

    private void getTopFive(){
        System.out.println(GREEN + "1." + RESET + "Single");
        System.out.println(GREEN + "2." + RESET + "Double");
        System.out.println(GREEN + "3." + RESET + "Mixed");
        System.out.println(YELLOW + "Vælg en mulighed: " + RESET);
        int choice = getIntegerInput();

        switch (choice){
            case 1 -> getTopFiveSingle();
            case 2 -> getTopFiveDouble();
            case 3 -> getTopFiveMixed();
            default ->  System.out.println(RED + "Fejl. Prøv igen!" + RESET);

        }
    }

    private void sortMembersMenu(){
        System.out.println("Sorter efter:");
        System.out.println("1. Navn");
        System.out.println("2. Alder");
        System.out.println(YELLOW + "Vælg en mulighed: " + RESET);
    }

    // This will be a method for adding a member object to a list
    private void addNewMember(){
        fileHandler.isMemberLoaded(); //check list
        System.out.println("Indtast navn: ");
        String name = scanner.nextLine();


        int memberID = fileHandler.generatorMemberId();
        System.out.println(name + " memberID: " + memberID);

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


        System.out.println("Har ny oprettet medlem betalt? (True / False)");
        boolean hasPaid = Boolean.parseBoolean(scanner.nextLine().toLowerCase());

        Member newMember = new Member(name, memberID, gender, birthYear, birthMonth, birthDayOfMonth, memberType, gameTypes, exerciser);
        Payment newPayment = new Payment(newMember, hasPaid);
        fileHandler.save(newMember); // kalder save metoden i MemberHandler og sender det nye member med så det gemmes i CSV filen
        paymentHandler.save(newPayment); //opretter samtidig betaling og sætter betaling true/false.
        System.out.println("Ny bruger: " + GREEN + name + RESET + " gemt");


    }

    private void registerBestResult(){

    }

    private void getTopFiveSingle(){
        matchHandler.createTypeArray(GameTypes.SINGLE);
       // matchHandler.printTop5();
    }

    private void getTopFiveDouble(){
        matchHandler.createTypeArray(GameTypes.DOUBLE);
       // matchHandler.printTop5();
    }

    private void getTopFiveMixed(){
        matchHandler.createTypeArray(GameTypes.MIXED);
       // matchHandler.printTop5();
    }

    // This will be a method for showing all members
    private void showAllMembers(){
        fileHandler.showMembers();

    }

    private void sortMembers(){
        sortMembersMenu();
        int choice = getIntegerInput();
        sortMembersMenu();

        if (choice == 1) {
            fileHandler.sortMemberByName();
        } else if (choice == 2) {
            fileHandler.sortMemberByAge();
        }
    }


    private void createMatch(){
        matchFactory.createMatch();
        System.out.println(matchFactory.getMatches());
    }

    private void registerTournamentResult(){


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
