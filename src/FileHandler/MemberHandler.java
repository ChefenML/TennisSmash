package FileHandler;

import Member.*;
import Payment.Payment;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;

import static java.lang.Boolean.parseBoolean;


public class MemberHandler implements FileHandling<Member,Member>{
    private static final String MEMBER_FILE = "src/Data/members.csv";

    ArrayList<Member> memberList = new ArrayList<>();
    //ArrayList<Payment> paymentList = new ArrayList<>();

    public MemberHandler(){
        memberList = load();
    }

    public ArrayList<Member> load(){
    String line;
        Member newMember = null;
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

                //Kig på det her senere EnumSet.of(memberData[7]);
                //Evt. gem det som EnumSet<GameType> GameTypes = EnumSet.of(GameType.SINGLE, GameType.DOUBLE, GameType.MIXED);
                //Hener kolonne 7 og spitter på komma, da et medlem kan have flere GameTypes
                                String[] gameTypeStrings = memberData[7].split(",");
                                //Opretter et tomt EnumSet til at holde medlemmets GameTypes
                                EnumSet<GameTypes> gameTypes = EnumSet.noneOf(GameTypes.class);
                                //Går gennem hvert GameType navn og konverter det til en enum-værdi (fx GameTypes.SINGLE) og  tilføjer til EnumSet
                                for (String gt : gameTypeStrings) {
                                    gameTypes.add(GameTypes.valueOf(gt));
                                }
              //  gameType.add(GameTypes.valueOf(Arrays.toString(memberData[7].split(","))));
                exerciser = Exerciser.valueOf(memberData[8]);

                newMember = new Member(name, memberID, gender, birthYear, birthMonth, birthDayOfMonth, memberType, gameTypes, exerciser);




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
        String gameTypesString = "";

        try(PrintWriter writer = new PrintWriter(new FileWriter(MEMBER_FILE,true))){

            // konverterer EnumSet til fx "SINGLE, MIXED" uden []

            for (GameTypes gt : member.getGameTypes()) { //hvis brugeren kun har indtastet én værdi i EnumSettet, så kører loopet kun én gang og gameTypeString bliver fx "SINGLE"
                // tilføjer kun komma hvis der allerede er en værdi i strengen. så der ikke står ",SINGLE,MIXED"
                if (!gameTypesString.isEmpty()) {
                    gameTypesString += ",";
                }
                // tilføjer enum-værdiens navn som tekst
                gameTypesString += gt.name();
                }

           //Laver String med memberData og separarer med | mellem data, men fødsesdato er med -;

            String memberData =
                   member.getName() + "|" +
                           generatorMemberId() + "|" +
                           member.getGender() + "|" +
                           member.getBirthYear() + "|" +
                           member.getBirthMonth() + "|" +
                           member.birthDayOfMonth() + "|" +
                           member.getMemberType() + "|" +
                           gameTypesString+ "|" +
                           member.getExerciser();


           writer.println(memberData);

           //insert exception here
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        memberList.add(member);
    }

    public int generatorMemberId(){
        return memberList.size()+1;
    }

    public void showMembers(){
        //ArrayList<Member> member = load();
        for(Member m : memberList){
            System.out.println(m);
        }
    }

}
