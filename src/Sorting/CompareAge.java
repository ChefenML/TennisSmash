package Sorting;

import Member.Member;

import java.util.Comparator;

public class CompareAge implements Comparator<Member> {

    //Bruger det implementerede interface Comparator til at oprette compare metoden
    //for vores getAge() metode fra Member klassen. (Parser Integer, da den ikke har indbygget .compareTo)
    public int compare(Member m1, Member m2){
        return Integer.compare(m1.getAge(), m2.getAge());
    }
}
