package Match;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import FileHandler.MatchHandler;
import Member.*;
import util.GetUserInput;

//
public class MatchFactory {


    private List<Match> matches = new ArrayList<>();
    private GetUserInput getUserInput = new GetUserInput();
    private MatchHandler matchHandler = new MatchHandler();

    public void createMatch(){
        int member1 = 0;
        int member2 = 0;
        int member3 = 0;
        int member4 = 0;
        int result = 0;
        GameTypes gameTypes = getUserInput.getGameTypes();
        LocalDate date = getUserInput.getLocalDate();
        System.out.print("Indtast antal spillere: ");
        int antalspillere = getUserInput.getInt();
        
        switch(antalspillere){
            case 2 -> {
                System.out.println("Indtast spiller #1 medlem Id:");
                member1 = getUserInput.getInt();
                System.out.println("Indtast spiller #2 medlem Id:");
                member2 = getUserInput.getInt();
            }
            case 4 -> {
                member1 = getUserInput.getInt();
                System.out.println("Indtast spiller #1 medlem Id:");
                member2 = getUserInput.getInt();
                System.out.println("Indtast spiller #2 medlem Id:");
                member3 = getUserInput.getInt();
                System.out.println("Indtast spiller #3 medlem Id:");
                member4 = getUserInput.getInt();
                System.out.println("Indtast spiller #4 medlem Id:");
            }
            default -> System.out.println("Kun 2 eller 4 spillere tilladt");
        }

        if(antalspillere <3){
            addSingleMatch(member1,member2,result,date);
            System.out.println("Single kamp tilføjet.");

        }else {
            addDoubleMatch(member1,member2,member3,member4,result,gameTypes,date);
            System.out.println("Double kamp tilføjet.");
        }
    }

        // Opret single-match
        public void addSingleMatch(int member1, int member2, int result, LocalDate date) {
            Match createdMatch = new Match(member1, member2, result, date);
            matches.add(createdMatch);
            matchHandler.save(createdMatch);
        }

        // Opret double/mixed-match
        public void addDoubleMatch(int member1, int member2, int member3, int member4, int result, GameTypes gameTypes, LocalDate date) {
            Match createdMatch = new Match(member1, member2, member3, member4, result, gameTypes, date);
            matches.add(createdMatch);
            matchHandler.save(createdMatch);
        }

        // Hent alle matches
        public List<Match> getMatches() {
            return matches;
        }

        // Hent alle matches for en bestemt spiller
        public List<Match> getMatchesForMember(int memberId) {
            List<Match> result = new ArrayList<>();
            for (Match m : matches) {
                if (m.getMember1() == memberId || m.getMember2() == memberId ||
                        m.getMember3() == memberId || m.getMember4() == memberId) {
                    result.add(m);
                }
            }
            return result;
        }
    }

