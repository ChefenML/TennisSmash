package Sorting;

import Member.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

public class MemberSorterTest {


    @Test
    void sortByAgeYoungestFirst() {

        // Laver en ArrayListe og nogle medlemmer der har forskellig alder
        ArrayList<Member> members = new ArrayList<>();

        Member bob = new Member("Bob", 1, 'M', 1974, 1, 1,
                MemberType.VETERAN,
                EnumSet.of(GameTypes.SINGLE),
                Exerciser.COMPETITIVE);

        Member john = new Member("John", 2, 'K', 2004, 1, 1,
                MemberType.JUNIOR,
                EnumSet.of(GameTypes.SINGLE),
                Exerciser.COMPETITIVE);

        Member lars = new Member("Lars", 3, 'M', 1989, 1, 1,
                MemberType.SENIOR,
                EnumSet.of(GameTypes.SINGLE),
                Exerciser.COMPETITIVE);

        members.add(bob);
        members.add(john);
        members.add(lars);

        //Kalder vores sorteringsmetode fra MemberSorter der bruger comparatoren til at sammenligne alder (Integer.compare(m1.getAge(), m2.getAge()))
        MemberSorter.sortByAge(members);

        //Forventet: John, så Lars og så Bob
        assertEquals("John", members.get(0).getName());
        assertEquals("Lars",  members.get(1).getName());
        assertEquals("Bob",   members.get(2).getName());
    }


    @Test
    void sortByMemberID() {
        // Laver en ArrayListe og nogle medlemmer der har både forskellige navne, men også samme navne men en af dem har stort startbogstav, den anden småt.
        ArrayList<Member> members = new ArrayList<>();

        Member bob = new Member("Bob", 6, 'M', 1974, 1, 1,
                MemberType.VETERAN,
                EnumSet.of(GameTypes.SINGLE),
                Exerciser.COMPETITIVE);

        Member bob2 = new Member("bob", 5,'M', 1974, 1, 1,
                MemberType.VETERAN,
                EnumSet.of(GameTypes.SINGLE),
                Exerciser.COMPETITIVE);

        Member john = new Member("John", 4,'K', 2004, 1, 1,
                MemberType.JUNIOR,
                EnumSet.of(GameTypes.SINGLE),
                Exerciser.COMPETITIVE);

        Member john2 = new Member("john", 3,'K', 2004, 1, 1,
                MemberType.JUNIOR,
                EnumSet.of(GameTypes.SINGLE),
                Exerciser.COMPETITIVE);

        Member lars = new Member("Lars", 2,'M', 1989, 1, 1,
                MemberType.SENIOR,
                EnumSet.of(GameTypes.SINGLE),
                Exerciser.COMPETITIVE);

        Member lars2 = new Member("lars", 1,'M', 1989, 1, 1,
                MemberType.SENIOR,
                EnumSet.of(GameTypes.SINGLE),
                Exerciser.COMPETITIVE);

        //Tilføjer dem til ArrayListen
        members.add(bob);
        members.add(bob2);
        members.add(john);
        members.add(john2);
        members.add(lars);
        members.add(lars2);

        //Kalder på metoden sortByMemberID() fra MemberSorter, der bruger comparator.
        MemberSorter.sortByMemberID(members);

        //Forventet: lars, Lars, john John, bob og så Bob
        assertEquals("lars", members.get(0).getName());
        assertEquals("Lars", members.get(1).getName());
        assertEquals("john",  members.get(2).getName());
        assertEquals("John",  members.get(3).getName());
        assertEquals("bob",   members.get(4).getName());
        assertEquals("Bob",   members.get(5).getName());
    }


@Test
void sortByName_AlfabetiskAndNotCaseSensitive() {
    // Laver en ArrayListe og nogle medlemmer der har både forskellige navne, men også samme navne men en af dem har stort startbogstav, den anden småt.
    ArrayList<Member> members = new ArrayList<>();

    Member bob = new Member("Bob", 1, 'M', 1974, 1, 1,
            MemberType.VETERAN,
            EnumSet.of(GameTypes.SINGLE),
            Exerciser.COMPETITIVE);

    Member bob2 = new Member("bob", 2,'M', 1974, 1, 1,
            MemberType.VETERAN,
            EnumSet.of(GameTypes.SINGLE),
            Exerciser.COMPETITIVE);

    Member john = new Member("John", 3,'K', 2004, 1, 1,
            MemberType.JUNIOR,
            EnumSet.of(GameTypes.SINGLE),
            Exerciser.COMPETITIVE);

    Member john2 = new Member("john", 4,'K', 2004, 1, 1,
            MemberType.JUNIOR,
            EnumSet.of(GameTypes.SINGLE),
            Exerciser.COMPETITIVE);

    Member lars = new Member("Lars", 5,'M', 1989, 1, 1,
            MemberType.SENIOR,
            EnumSet.of(GameTypes.SINGLE),
            Exerciser.COMPETITIVE);

    Member lars2 = new Member("lars", 6,'M', 1989, 1, 1,
            MemberType.SENIOR,
            EnumSet.of(GameTypes.SINGLE),
            Exerciser.COMPETITIVE);

    members.add(bob);
    members.add(bob2);
    members.add(john);
    members.add(john2);
    members.add(lars);
    members.add(lars2);


    MemberSorter.sortByName(members);

    //Forventet: Bob, så bob, så John, så john, så Lars, så lars
    assertEquals("Bob", members.get(0).getName());
    assertEquals("bob", members.get(1).getName());
    assertEquals("John",  members.get(2).getName());
    assertEquals("john",  members.get(3).getName());
    assertEquals("Lars",   members.get(4).getName());
    assertEquals("lars",   members.get(5).getName());
}

}