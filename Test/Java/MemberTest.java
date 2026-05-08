import Member.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberTest {

    @Test
    void getNameShouldReturnName() {
        Member member = new Junior("John", 001, 'm', 1995, 5,1,GameTypes.SINGLE, Exerciser.EXERCISE);
            Assertions.assertEquals("John", member.getName());
    }
}