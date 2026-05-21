package Exception;

public class InputMisMatch extends SmashUIException {
    public InputMisMatch(String message) {
        super("Ikke tilladt bruger input");
    }
}
