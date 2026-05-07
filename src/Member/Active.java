package Member;

public abstract class Active extends Member {
    private GameTypes gameType;
    private Exerciser exercise;

    public Active(String name, int memberID, char gender, int birthYear, int birthMonth, int birthDayOfMonth, GameTypes gameType, Exerciser exercise) {
        super(name, memberID, gender, birthYear, birthMonth, birthDayOfMonth);
        this.gameType = gameType;
        this.exercise = exercise;
    }
    @Override public double membersFee() {
        return  0.0;
    }

    public GameTypes getGameType() {
        return gameType;
    }

    public Exerciser getExercise() {
        return exercise;
    }



}
