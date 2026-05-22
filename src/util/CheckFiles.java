package util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckFiles {
    private File match = new File("src/Data/match.csv");
    private File members = new File("src/Data/member.csv");
    private File payments = new File("src/Data/payments.csv");
    private List<File> fileList = new ArrayList<>(List.of(match, members, payments));


    public void checkForFile() {
        for (File l : fileList) {
            if (l.exists()) {
                System.out.println("Fil findes: " + l.getName());
            } else {
                try {
                    if(l.createNewFile()) {
                        System.out.println("Fil oprettet: " + l.getName());
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
