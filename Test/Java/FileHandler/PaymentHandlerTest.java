package FileHandler;

import Member.*;
import Payment.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

class PaymentHandlerTest {

    @Test
    void save() {
        Payment p1 = new Payment(new Member("John", 1, 'm', 1995, 5,1, MemberType.JUNIOR, EnumSet.of(GameTypes.SINGLE), Exerciser.PASSIVE),true);
        PaymentHandler phandle = new PaymentHandler();
        phandle.save(p1);
        assertTrue(p1.hasPaid());
    }

    @Test
    void load() {
        ArrayList<PaymentLoader> plist;
        PaymentHandler phandle = new PaymentHandler();
        plist = phandle.load();
        for(PaymentLoader p : plist){
            System.out.println(p);
        }
    }
}