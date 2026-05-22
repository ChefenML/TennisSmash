package Validate;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class LocalDateValidator {

    public boolean valiDate(String date){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("[d-M-yyyy]" + "[d.M.yyyy]" + "[d M yyyy]"+ "[d\\M\\yyyy]"+ "[d/M/yyyy]"+ "[d,M,yyyy]");
        try
        {
            dtf.parse(date);
            System.out.println("Dato: " + date + " modtaget i korrekt format.");
            return true;
        }
        catch(DateTimeParseException e){
            System.out.println("Følgende dato format tilladt: d-M-åååå, d.M.ååååå, d M åååå, d/M/åååå, d,M,åååå.");
            System.out.println("Følgende dato ikke tilladt: " + date);
        }
    return false;
    }

}
