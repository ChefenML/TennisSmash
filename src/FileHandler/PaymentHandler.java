package FileHandler;

import Member.Member;
import Payment.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.SortedMap;

import static Member.Colors.*;
import static java.lang.Boolean.parseBoolean;

public class PaymentHandler implements FileHandling<Payment, PaymentLoader>{

    private static final String PAYMENTS_FILE = "src/Data/payments.csv";
    private ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<PaymentLoader> paymentList = new ArrayList<>();
    private MemberHandler filehandler = new MemberHandler();
    private Scanner scanner = new Scanner(System.in);

    public PaymentHandler(){
        paymentList = load();
    }

    @Override
    public void save(Payment p) {
        try(PrintWriter writer = new PrintWriter(new FileWriter(PAYMENTS_FILE,true))){
            //Laver String med PaymentData og separarer med |, ved dog ikke hvordan final Payment class ser ud

            String paymentData =
                    p.getName() + "|" +
                    p.getMemberId() + "|" +
                    p.hasPaid() + "|" +
                    p.getSubscriptionPrice();

                    writer.println(paymentData);

            //insert custom exception here
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        paymentList.add(new PaymentLoader(p.getMemberId(),p.hasPaid()));
    }


    @Override
    public ArrayList<PaymentLoader> load() {

            PaymentLoader newPaymentLoader;
            String line;

            try (BufferedReader reader = new BufferedReader(new FileReader(PAYMENTS_FILE))) {
                //try with resources, no need to close stuff
                //Læs CSV og del data ind i array-bidder opret ny member med data, bliv ved indtil tom line/null.
                //Pt står data splitter i csv til | <-måske vi ender på anden separator?
                while ((line = reader.readLine()) != null) {
                    String[] paymentData = line.split("\\|");

                //Read data
                    String name = paymentData[0];
                    int memberID = Integer.parseInt(paymentData[1]);
                    boolean hasPaid = parseBoolean(paymentData[2]);
                    double subscriptionPrice = Double.parseDouble(paymentData[3]);
                //create Payment
                    newPaymentLoader = new PaymentLoader(memberID, hasPaid);
//                        p.getMemberID()    + "|" +
//                        p.getName() + "|" +
//                        p.hasPaid() + "|" +
//                        p.getSubscription() + "|" +

                    paymentList.add(newPaymentLoader);
                }





            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        return paymentList;
        }

        public ArrayList<PaymentLoader> getPaymentList(){
            ArrayList<PaymentLoader> newList = new ArrayList<>();
            for(PaymentLoader p : paymentList){

                newList.add(p);
            }
            return newList;
        }

        public void getListArrears(){
            ArrayList<PaymentLoader> paymentList = getPaymentList();

            System.out.println("\n--- UNDERMENU ---");

            System.out.println(GREEN + "1. " + RESET + "Få liste af folk uden restance");
            System.out.println(GREEN + "2. " + RESET + "Få liste af folk med restance");
            System.out.print(YELLOW + "Vælg en mulighed: " + RESET);

            int choice = getIntegerInput();

            for (PaymentLoader pay : paymentList){
                if (!pay.getPaidStatus() & choice == 1){
                    System.out.println("\n" + pay);
                } else if (pay.getPaidStatus() & choice == 2) {
                    System.out.println("\n" + pay);
                }
            }
        }

        public void getSortedPaymentList(){
        Collections.sort(paymentList);
        for(PaymentLoader p : paymentList){
        }


    }

    private int getIntegerInput(){
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}

