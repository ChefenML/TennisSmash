package FileHandler;

import Member.*;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import static java.lang.Boolean.parseBoolean;

public class Filehandler implements FileHandling<Member>{
    private static final String MEMBER_FILE = "src/Data/members.csv";
    private static final String PAYMENTS_FILE = "src/Data/payments.csv";
    private static final String TRAINING_FILE = "src/Data/training.csv";
    private static final String TOURNAMENT_FILE = "src/Data/tournament.csv";

    ArrayList<Member> memberList = new ArrayList<>();
    //ArrayList<Payment> paymentList = new ArrayList<>();

    public ArrayList<Member> load(){
    String line;
        Member newMember = null;
        GameTypes gameType = null;
        Exerciser exerciser = null;
        MemberType memberType = null;

        try(BufferedReader reader = new BufferedReader(new FileReader(MEMBER_FILE))){
            //try with resources, no need to close stuff
            //Læs CSV og del data ind i array-bidder opret ny member med data, bliv ved indtil tom line/null.
            //Pt står data splitter i csv til | <-måske vi ender på anden separator?
            while((line = reader.readLine()) != null){
            String[] memberData = line.split("\\|");



            String name = memberData[0];
            int memberID = Integer.parseInt(memberData[1]);
            char gender = memberData[2].charAt(0);
            int birthYear = Integer.parseInt(memberData[3]);
            int birthMonth = Integer.parseInt(memberData[4]);
            int birthDayOfMonth = Integer.parseInt(memberData[5]);

            //opret tjek på parsed data om alder
            LocalDate completeBirthday =  LocalDate.of(birthYear,birthMonth,birthDayOfMonth);
            Period getPeriod = Period.between(completeBirthday,LocalDate.now());
            //Hvad sker der hvis String array er kortere end 7?
                memberType = MemberType.valueOf(memberData[6]);
                gameType = GameTypes.valueOf(memberData[7]);
                exerciser = Exerciser.valueOf(memberData[8]);

            //String name, int memberID, char gender, int birthYear, int birthMonth, int birthDayOfMonth, MemberType memberType, GameTypes gameTypes, Exerciser exerciser){
            //Bedre passive identifier?
//            if(memberData.length == 6)
//                {
//                    newMember = new Passive(name, memberID, gender, birthYear,birthMonth,birthDayOfMonth);
//                }
//
//            else if(getPeriod.getYears() < 18) {
//                newMember = new Junior(name, memberID, gender, birthYear,birthMonth,birthDayOfMonth,gameType,exerciser);
//            }
//            else if(getPeriod.getYears() >= 18 && getPeriod.getYears() < 60){
//                newMember = new Senior(name, memberID, gender, birthYear, birthMonth, birthDayOfMonth,gameType,exerciser);
//            }
//            else if(getPeriod.getYears() >= 60){
//                newMember = new Veteran(name, memberID, gender, birthYear, birthMonth, birthDayOfMonth,gameType,exerciser);
//            }
//            //backup if nothing else?
//            else

                newMember = new Member(name, memberID, gender, birthYear, birthMonth, birthDayOfMonth, memberType, gameType, exerciser);




            memberList.add(newMember);
            /* Member Data
            0 String name
            1 int memberID
            2 char gender
            3 int birtYear
            4 int bithmonth
            5 int birtDayOfMonth
            */

            }//insert exception handling here
            }
        catch (FileNotFoundException e) {
                 throw new RuntimeException(e);
        }
        catch (IOException e) {
                 throw new RuntimeException(e);
        }
        return memberList;
    }

    public void save(Member member) {
        //try with resources, no need to close stuff

        try(PrintWriter writer = new PrintWriter(new FileWriter(PAYMENTS_FILE,true))){
           //Laver String med memberData og separarer med | mellem data, men fødsesdato er med -;

            String memberData =
                   member.getName() + "|" +
                           member.getMemberID() + "|" +
                           member.getGender() + "|" +
                           member.getBirthYear() + "|" +
                           member.getBirthMonth() + "|" +
                           member.birthDayOfMonth() + "|";

            //Overvej switch case.
            //Midlertidig template, gentag 3 gange: "Junior, senior, veteran".
//            if (member.getClass().getSimpleName().equalsIgnoreCase("junior")) {
//                Junior junior = (Junior) member;
//                memberData +=
//                        junior.getGameType() + "|" +
//                                junior.getExercise() + "|";
//            }

           writer.println(memberData + "\n");

           //insert exception here
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public ArrayList<Payment> loadPayments() {
//        memberList = load();
//        Payment newPayment = null;
//        String line;
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(PAYMENTS_FILE))) {
//            //try with resources, no need to close stuff
//            //Læs CSV og del data ind i array-bidder opret ny member med data, bliv ved indtil tom line/null.
//            //Pt står data splitter i csv til | <-måske vi ender på anden separator?
//            while ((line = reader.readLine()) != null) {
//                String[] paymentData = line.split("\\|");
//
//
//                String name = paymentData[0];
//                int memberID = Integer.parseInt(paymentData[1]);
//                boolean hasPaid = parseBoolean(paymentData[2]);
//                int subscriptionPrice = Integer.parseInt(paymentData[3]);
//
//                newPayment = new Payment(name, memberID, hasPaid, subscriptionPrice);
////                        p.getMemberID()    + "|" +
////                        p.getName() + "|" +
////                        p.hasPaid() + "|" +
////                        p.getSubscription() + "|" +
//
//                }
//            paymentList.add(newPayment);
//
//
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return paymentList;
//    }
//
//        public void savePayments(Payment p){
//        try(PrintWriter writer = new PrintWriter(new FileWriter(PAYMENTS_FILE,true))){
//            //Laver String med memberData og separarer med | mellem data, men fødsesdato er med -;
//
//            String paymentData =
//                    p.getName() + "|" +
//                            p.getMemberID() + "|" +
//                            p.hasPaid() + "|" +
//                            p.getSubscription() + "|" +
//
//
//            //Overvej switch case.
//            //Midlertidig template, gentag 3 gange: "Junior, senior, veteran".
////            if (member.getClass().getSimpleName().equalsIgnoreCase("junior")) {
////                Junior junior = (Junior) member;
////                memberData +=
////                        junior.getGameType() + "|" +
////                                junior.getExercise() + "|";
////            }
//
//            writer.println(paymentData + "\n");
//
//            //insert exception here
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}
