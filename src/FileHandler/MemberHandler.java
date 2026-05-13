package FileHandler;

import Member.*;
import Payment.Payment;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.EnumSet;

import static java.lang.Boolean.parseBoolean;


public class MemberHandler implements FileHandling<Member,Member>{
    private static final String MEMBER_FILE = "src/Data/members.csv";

    ArrayList<Member> memberList = new ArrayList<>();
    //ArrayList<Payment> paymentList = new ArrayList<>();

    public ArrayList<Member> load(){
    String line;
        Member newMember = null;
        EnumSet<GameTypes> gameType = null;
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
                gameType = Enum.valueOf(memberData[7]);
                exerciser = Exerciser.valueOf(memberData[8]);

                newMember = new Member(name, memberID, gender, birthYear, birthMonth, birthDayOfMonth, memberType, gameType, exerciser);




            memberList.add(newMember);


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

        try(PrintWriter writer = new PrintWriter(new FileWriter(MEMBER_FILE,true))){
           //Laver String med memberData og separarer med | mellem data, men fødsesdato er med -;

            String memberData =
                   member.getName() + "|" +
                           member.getMemberID() + "|" +
                           member.getGender() + "|" +
                           member.getBirthYear() + "|" +
                           member.getBirthMonth() + "|" +
                           member.birthDayOfMonth() + "|";


           writer.println(memberData + "\n");

           //insert exception here
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
