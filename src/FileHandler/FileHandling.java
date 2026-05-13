package FileHandler;

import Member.Member;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public interface FileHandling<G,T> {
    void save(G G);
    ArrayList<T> load();
}
