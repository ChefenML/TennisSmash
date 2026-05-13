package FileHandler;

import java.util.ArrayList;

public class TournamentHandler implements FileHandling<Tournament,TournamentLoader> {
    private static final String TOURNAMENT_FILE = "src/Data/tournament.csv";

    @Override
    public void save(Tournament G) {

    }

    @Override
    public ArrayList<TournamentLoad> load() {
        return null;
    }
}
