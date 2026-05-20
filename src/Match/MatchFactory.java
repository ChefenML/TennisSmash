package Match;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Member.GameTypes;
//
public class MatchFactory {


        private List<Match> matches = new ArrayList<>();

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
                if (m.member1 == memberId || m.member2 == memberId ||
                        m.member3 == memberId || m.member4 == memberId) {
                    result.add(m);
                }
            }
            return result;
        }
    }

