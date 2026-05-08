package UI;
import Member.*;
import Member.MemberFactory;
import FileHandler.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;

import static Member.Exerciser.EXERCISE;
import static Member.GameTypes.SINGLE;

public class SmashUI {
    private MemberFactory factory;
    private Filehandler fileHandler;
    private Scanner scanner;

    // Creates a constructor to make sure the class has the necessary tools
    public SmashUI() throws IOException {
        this.factory = new MemberFactory();
        this.fileHandler = new Filehandler();
        this.scanner = new Scanner(System.in);
    }

    // This is the start method used in the app
    public void start() {
        boolean running = true;

        System.out.println("Welcome to the Smash Management System!"
                + "\n--------------------------------");

    // Here a selection of choices will be run and looped
        while (running) {
            showMainMenu();
            int choice = getIntegerInput();

            switch (choice){
                case 1 -> addNewMember();
                case 2 -> showAllMembers();
                case 3 -> saveAndExit();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice try again!");
            }
        }
    }

    // This is a method to print out a selection of options to the output
    private void showMainMenu(){
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1. Add New Member");
        System.out.println("2. View All Members");
        System.out.println("3. Save Data");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
    }

    // This will be a method for adding a member object to a list
    private void addNewMember(){
        Member testMember = new Senior("John", 3, 'm', 1990, 5, 1, SINGLE, EXERCISE);
        System.out.println(testMember.getClass().getSimpleName());
    }

    // This will be a method for showing all members
    private void showAllMembers(){
        ArrayList<Member> test = fileHandler.loadMembers();
        for (Member m : test) {

            System.out.println(m);
        }
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
