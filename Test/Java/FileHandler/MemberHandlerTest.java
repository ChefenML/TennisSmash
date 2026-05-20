package FileHandler;

import Member.*;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

class MemberHandlerTest {

    @Test
    void load() {
    }

    @Test
    void getMembernameFromId() {
        MemberHandler memberhandler = new MemberHandler();
        Member john;
        john = memberhandler.getMembernameFromId(1); //test om vi får medlem 1
        System.out.println(john);
        assertEquals("John",john.getName());
    }
}