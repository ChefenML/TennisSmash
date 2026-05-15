package Sorting;

import Member.Member;

import java.util.Comparator;

public class CompareName implements Comparator<Member> {

    //Bruger det implementerede interface Comparator til at oprette compare metoden
    //for vores getName() metode fra Member klassen. (Her skal der ikke parses, da vi har den indbyggede metode .compareTo)
    //Vi bruger .compareToIgnoreCase for at den ikke er case sensitiv.
    public int compare(Member m1, Member m2){
   return m1.getName().compareToIgnoreCase(m2.getName());
    }
}
