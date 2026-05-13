package FileHandler;

import Member.Member;
import Payment.*;
import java.io.*;
import java.util.ArrayList;

import static java.lang.Boolean.parseBoolean;

public class PaymentHandler implements FileHandling<Payment, PaymentLoader>{
    private static final String PAYMENTS_FILE = "src/Data/payments.csv";
    ArrayList<Member> memberList = new ArrayList<>();
    ArrayList<PaymentLoader> paymentList = new ArrayList<>();
    Filehandler filehandler = new Filehandler();

    @Override
    public void save(Payment p) {
        try(PrintWriter writer = new PrintWriter(new FileWriter(PAYMENTS_FILE,true))){
            //Laver String med PaymentData og separarer med |, ved dog ikke hvordan final Payment class ser ud

            String paymentData =
                    p.getName() + "|" +
                    p.getMemberId() + "|" +
                    p.hasPaid() + "|" +
                    p.getSubscriptionPrice() + "|";

                    writer.println(paymentData + "\n");

            //insert custom exception here
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public ArrayList<PaymentLoader> load() {

            memberList = filehandler.load();
            PaymentLoader newPaymentLoader = null;
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
                    int subscriptionPrice = Integer.parseInt(paymentData[3]);
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

    }

