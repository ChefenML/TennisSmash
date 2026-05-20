package FileHandler;

import Member.*;
import Match.*;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.EnumSet;

public class MatchHandler {

    private static final String MATCH_FILE = "src/Data/match.csv";

    private ArrayList<Match> matchList = new ArrayList<>();
    MemberHandler memberhandler;

    public MatchHandler(){
        matchList = load();
    }

    public ArrayList<Match> load(){
        String line;
        Match newMatch = null;


        try(BufferedReader reader = new BufferedReader(new FileReader(MATCH_FILE))){
            //try with resources, no need to close stuff
            //Læs CSV og del data ind i array-bidder opret ny member med data, bliv ved indtil tom line/null.
            //Pt står data splitter i csv til | <-måske vi ender på anden separator?
            while((line = reader.readLine()) != null) {
                String[] matchData = line.split("\\|");

                String[] memberIds = matchData[0].split(",");
                int matchResult = Integer.parseInt(matchData[1]);
                GameTypes gameTypes = GameTypes.valueOf(matchData[2]);
                LocalDate date = LocalDate.parse(matchData[3]);

                if (memberIds.length < 3) {
                    newMatch = new Match(
                            Integer.parseInt(memberIds[0]),
                            Integer.parseInt(memberIds[1]),
                            matchResult, date);
                } else {
                    newMatch = new Match(
                            Integer.parseInt(memberIds[0]),
                            Integer.parseInt(memberIds[1]),
                            Integer.parseInt(memberIds[2]),
                            Integer.parseInt(memberIds[3]),
                            matchResult, gameTypes, date);
            }


                matchList.add(newMatch);


            }//insert exception handling here
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return matchList;
    }

    public void save(Match match) {


        try(PrintWriter writer = new PrintWriter(new FileWriter(MATCH_FILE,true))){



        //det her ku være et problem bare at have lavet toString save... Måske lave dedikeret String toCsv funktion i Match
            writer.println(match);

            //insert exception here
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        matchList.add(match);
    }

    public int generatorMatchId(){
        return matchList.size()+1;
    }

    public void showMatches(){

        for(Match m : matchList){
            System.out.println(m);
        }
    }

}
