import Member.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static Member.Exerciser.EXERCISE;
import static Member.GameTypes.SINGLE;

class MemberTest {

    @Test
    void getNameShouldReturnName() {
        Member member1 = new Member("John", 1, 'm', 1995, 5,1,MemberType.JUNIOR, GameTypes.SINGLE, Exerciser.PASSIVE);
        Member member2 = new Member("John", 1, 'm', 1995, 5,1,MemberType.VETERAN,GameTypes.SINGLE, Exerciser.EXERCISE);
            Assertions.assertEquals("John", member1.getName());
    }

    @Test
    void getMemberFee() {
        Member member1 = new Member("John", 1, 'm', 1995, 5,1,MemberType.JUNIOR, GameTypes.SINGLE, Exerciser.PASSIVE);
        Member member2 = new Member("John", 1, 'm', 1995, 5,1,MemberType.VETERAN,GameTypes.SINGLE, Exerciser.EXERCISE);
        Member member3 = new Member("John", 1, 'm', 1995, 5,1,MemberType.SENIOR,GameTypes.SINGLE, Exerciser.EXERCISE);
        Member member4 = new Member("John", 1, 'm', 1995, 5,1,MemberType.PASSIVE,GameTypes.SINGLE, Exerciser.EXERCISE);
        Assertions.assertEquals(800, member1.membersFee());
        Assertions.assertEquals(1125, member2.membersFee());
        Assertions.assertEquals(1500, member3.membersFee());
        Assertions.assertEquals(250, member4.membersFee());
    }
}