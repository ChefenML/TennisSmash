package Sorting;

import Member.Member;

import java.util.Comparator;

public class CompareName implements Comparator<Member> {

    //Bruger det implementerede interface Comparator til at oprette compare metoden
    //for vores getName() metode fra Member klassen. (Her skal der ikke parses, da vi har den indbyggede metode .compareTo)
    public int compare(Member m1, Member m2){
        //Bruger if statement til at sætte store og små bogstaver lig hinanden
        //Altså: Return 0 (Betyder de er ens, da compare metoden returnere -1, 0 eller 1)
        if (m1.getName().equalsIgnoreCase(m2.getName())){
            return 0;
        }
        else return m1.getName().compareTo(m2.getName());
    }
}
