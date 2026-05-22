package Sorting;

import Member.*;

import java.util.ArrayList;
import java.util.Collections;

public class MemberSorter {
    public static void sortByAge(ArrayList<Member> members){
    Collections.sort(members, new CompareAge());
    }

    public static void sortByMemberID(ArrayList<Member> members) {
        Collections.sort(members, new CompareMemberID());
    }

    public static void sortByName(ArrayList<Member> members) {
        Collections.sort(members, new CompareName());
    }
}
