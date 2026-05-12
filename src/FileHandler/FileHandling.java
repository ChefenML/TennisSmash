package FileHandler;

import Member.Member;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public interface FileHandling<T> {
    void save(T t);
    ArrayList<T> load();
}
