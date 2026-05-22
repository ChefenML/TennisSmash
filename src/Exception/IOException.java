package Exception;

public class IOException extends SmashUIException {
    public IOException(String message) {
        super("Noget gik galt ved læsning/skrivning af/til fil");
    }
}
