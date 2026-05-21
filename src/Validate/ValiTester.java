package Validate;

public class ValiTester {
    static void main(String[] args) {

        LocalDateValidator ldv = new LocalDateValidator();
        String date = "20/02/1984";
        String date2 = "202/02/1984";
        System.out.println(ldv.valiDate(date));
        System.out.println(ldv.valiDate(date2));

        NameValidator nv = new NameValidator();

        String name1 = "mikkel";
        String name2 = "m1kk31";
        System.out.println(nv.nameOnlyLetters(name1));
        System.out.println(nv.nameOnlyLetters(name2));
    }
}
