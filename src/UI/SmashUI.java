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

        System.out.println("Welcome to the Smash Management System!"
                + "\n--------------------------------");

        while (running) {
            showRoleMenu();
            int choice = getIntegerInput();

            switch (choice){
                case 1 -> isChairman();
                case 2 -> isCashier();
                case 3 -> isTrainer();
                case 0 -> running = false;
                default ->  System.out.println(RED + "Invalid choice try again!" + RESET);
            }

        }

    // Here a selection of choices will be run and loope
    }

    private void showRoleMenu(){
        System.out.println("\nLOG IN SOM: ");
        System.out.println("1. Klubformand");
        System.out.println("2. Kasser");
        System.out.println("3. Træner");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
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
                default -> System.out.println(RED + "Invalid choice try again!" + RESET);
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
                default -> System.out.println(RED + "Invalid choice try again!" + RESET);
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
                default -> System.out.println(RED + "Invalid choice try again!" + RESET);
            }
        }
    }

    // This is a method to print out a selection of options to the output
    private void showChairmanMenu(){
        System.out.println("\n--- KLUBFORMAND MENU ---");
        System.out.println("1. Add New Member");
        System.out.println("2. View All Members");
        System.out.println("3. Save Data");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
    }

    private void showCashierMenu(){
        System.out.println("\n--- KASSER MENU ---");
        System.out.println("1. Vis forventede indbetalinger efter beløb");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
    }

    private void showTrainerMenu(){
        System.out.println("\n--- TRÆNER MENU ---");
        System.out.println("1. Registrer dagens bedste træningsresultat for en spiller");
        System.out.println("2. Indtast tuneringsresultater");
        System.out.println("3. Se top fem ranglister");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
    }

    // This will be a method for adding a member object to a list
    private void addNewMember(){
        Member testMember = new Member("John", 3, 'm', 1990, 5, 1, MemberType.SENIOR, EnumSet.of(GameTypes.SINGLE), Exerciser.EXERCISE);
        Member test2Member = new Member("John", 3, 'm', 1990, 5, 1, MemberType.SENIOR, EnumSet.of(GameTypes.DOUBLE), Exerciser.EXERCISE);
        //String name, int memberID, char gender, int birthYear, int birthMonth, int birthDayOfMonth, MemberType memberType, EnumSet.of(GameTypes.xxx) (adskilles med , ), Exerciser exerciser){
System.out.println(testMember.getClass().getSimpleName());
    }

    // This will be a method for showing all members
    private void showAllMembers(){
        ArrayList<Member> test = fileHandler.load();
        for (Member m : test) {

            System.out.println(m);
        }
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
