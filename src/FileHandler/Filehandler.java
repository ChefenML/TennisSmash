package FileHandler;

import Member.Member;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Filehandler {
    private static final String MEMEBER_FILE = "src/Data/members.csv";
    private static final String PAYMENTS_FILE = "src/Data/payments.csv";
    private static final String TRAINING_FILE = "src/Data/training.csv";
    private static final String TOURNAMENT_FILE = "src/Data/TOURNAMENT.csv";

    ArrayList<Member> memberList = new ArrayList<>();

    public void loadMembers(){
    String line;

        try(BufferedReader reader = new BufferedReader(new FileReader(MEMEBER_FILE))){
            //try with resources, no need to close stuff
            //Læs CSV og del data ind i array-bidder opret ny member med data, bliv ved indtil tom line/null.
            //Pt står data splitter i csv til | <-måske vi ender på anden separator?
            while((line = reader.readLine()) != null){
            String[] memberData = line.split("\\|");



            String name = memberData[0];
            int memberID = Integer.parseInt(memberData[1]);
            char gender = line.charAt(Integer.parseInt(memberData[2]));//???
            int birthYear = Integer.parseInt(memberData[3]);
            int birthMonth = Integer.parseInt(memberData[4]);
            int birthDayOfMonth = Integer.parseInt(memberData[5]);
            LocalDate completeBirthday =  LocalDate.of(birthYear,birthMonth,birthDayOfMonth);


            Member newMember = new Member(name,gender,memberID,completeBirthday);

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
                e.printStackTrace();
        }
        catch (IOException e) {
                 throw new RuntimeException(e);
                e.printStackTrace();
        }
    }

    public void saveMember(Member member) {
        //try with resources, no need to close stuff

        try(PrintWriter writer = new PrintWriter(new FileWriter(MEMEBER_FILE,true))){
           //Laver String med memberData og separarer med | mellem data, men fødsesdato er med -;
            String memberData =
                   member.getName() + "|" +
                           member.getMemberID() + "|" +
                           member.getGender() + "|" +
                           member.getBirthYear() + "|" +
                           member.getBirthMonth() + "|" +
                           member.getBirthDayOfMonth();

           writer.println(memberData);

           //insert exception here
        } catch (IOException e) {
            throw new RuntimeException(e);
            e.printStackTrace();
        }
    }
}
