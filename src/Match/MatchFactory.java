package Match;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Member.*;
import UI.SmashUI;
import util.getUserInput;

//
public class MatchFactory {


    private List<Match> matches = new ArrayList<>();
    private getUserInput getUserInput = new getUserInput();

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
                member1 = getUserInput.getInt();
                member2 = getUserInput.getInt();
            }
            case 4 -> {
                member1 = getUserInput.getInt();
                member2 = getUserInput.getInt();
                member3 = getUserInput.getInt();
                member4 = getUserInput.getInt();
            }
            default -> System.out.println("Kun 2 eller 4 spillere tilladt");
        }

        if(antalspillere <3){
            addSingleMatch(member1,member2,result,date);
            System.out.println("Single kamp tilføjet.");
        }else
            addDoubleMatch(member1,member2,member3,member4,result,gameTypes,date);
            System.out.println("Double kamp tilføjet.");
    }

        // Opret single-match
        public void addSingleMatch(int member1, int member2, int result, LocalDate date) {
            matches.add(new Match(member1, member2, result, date));
        }

        // Opret double/mixed-match
        public void addDoubleMatch(int member1, int member2, int member3, int member4,
                                   int result, GameTypes gameTypes, LocalDate date) {
            matches.add(new Match(member1, member2, member3, member4, result, gameTypes, date));
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

