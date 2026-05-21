package Validate;

public class NameValidator {

    public boolean nameOnlyLetters(String name) {

            if(name.matches(".*\\d+.*")) {
                System.out.println("Navn indeholder forbudte karakter.");
                return false;
            }


            System.out.println("Navn: " + name + " gemt.");
            return true;

    }

}

