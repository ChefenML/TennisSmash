//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    IO.println(String.format("Test Symbols:"));

    //windows tast + punktum: bringer emoji/symbol popup frem
    //mac er vidst cmd + alt(or ctrl) + space: bringer emoji/symbol popup frem


    checkmarks();

    LocalDate demi = LocalDate.of(2004,10,20);
    LocalDate current = LocalDate.now();

    Period different = Period.between(demi, current);
    System.out.println(different.getYears());


}

public static void checkmarks(){
    System.out.println("✅✔\uFE0F☑\uFE0F➖⛔🚫");
}