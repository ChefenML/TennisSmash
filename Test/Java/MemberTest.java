import Member.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static Member.Exerciser.EXERCISE;
import static Member.GameTypes.SINGLE;

class MemberTest {

    @Test
    void getNameShouldReturnName() {
        Member member = new Junior("John", 001, 'm', 1995, 5,1,GameTypes.SINGLE, Exerciser.EXERCISE);
        Member member = new Junior("John", 1, 'm', 1995, 5,1,SINGLE,EXERCISE);
            Assertions.assertEquals("John", member.getName());
    }
}