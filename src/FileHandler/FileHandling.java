package FileHandler;

import java.util.ArrayList;

public interface FileHandling<G,T> {
    void save(G G);
    ArrayList<T> load();
}
