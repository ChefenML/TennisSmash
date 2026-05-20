import java.time.LocalDate;
import java.util.EnumSet;

import static Member.Exerciser.EXERCISE;
import static Member.GameTypes.SINGLE;
import Member.Exerciser;
import Member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Member.*;


public class MemberTest2 {


        // --- Grænse 1: JUNIOR → SENIOR (18 år) ---

        @Test
        void ageShouldBe17() {
            Member member = new Member("John", 1, 'M', 2009, 5, 12, MemberType.JUNIOR, EnumSet.of(GameTypes.SINGLE), Exerciser.COMPETITIVE);
            Assertions.assertEquals(17, member.getAge());
        }

        @Test
        void ageShouldBe18() {
            Member member = new Member("John", 1, 'M', 2008, 5, 12, MemberType.SENIOR,EnumSet.of(GameTypes.SINGLE),Exerciser.COMPETITIVE);
            Assertions.assertEquals(18, member.getAge());
        }

        @Test
        void ageShouldBe19() {
            Member member = new Member("John", 1, 'M', 2007, 5, 12, MemberType.SENIOR,EnumSet.of(GameTypes.SINGLE), Exerciser.COMPETITIVE);
            Assertions.assertEquals(19, member.getAge());
        }

        // --- Grænse 2: SENIOR → VETERAN (60 år) ---

        @Test
        void ageShouldBe59() {
            Member member = new Member("John", 1, 'M', 1967, 5, 12, MemberType.SENIOR,EnumSet.of(GameTypes.SINGLE), Exerciser.COMPETITIVE);
            Assertions.assertEquals(59, member.getAge());
        }

        @Test
        void ageShouldBe60() {
            Member member = new Member("John", 1, 'M', 1966, 5, 12, MemberType.VETERAN,EnumSet.of(GameTypes.SINGLE), Exerciser.COMPETITIVE);
            Assertions.assertEquals(60, member.getAge());
        }

        @Test
        void ageShouldBe61() {
            Member member = new Member("John", 1, 'M', 1965, 5, 12, MemberType.VETERAN,EnumSet.of(GameTypes.SINGLE), Exerciser.COMPETITIVE);
            Assertions.assertEquals(61, member.getAge());
        }
    }

