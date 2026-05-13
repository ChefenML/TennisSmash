package Sorting;

import Member.Member;

import java.util.Comparator;

public class CompareMemberID implements Comparator<Member> {

    //Bruger det implementerede interface Comparator til at oprette compare metoden
    //for vores getMemberID() metode fra Member klassen. (Parser Integer, da en int ikke har indbygget .compareTo)
    public int compare(Member m1, Member m2){
        return Integer.compare(m1.getMemberID(), m2.getMemberID());
    }
}