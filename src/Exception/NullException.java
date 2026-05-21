package Exception;

public class NullException extends SmashUIException {
    public NullException(String message) {
        super("Det forsøgte element er null");
    }
}
