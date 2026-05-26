package App;

import UI.SmashUI;

import Exception.*;
import util.*;

public class SmashApp {
    static void main(String[] args) throws SmashUIException {
        //Kør tjekup på om filerne findes
        CheckFiles startupCheck = new CheckFiles();
        startupCheck.checkForFile();

        //Start Program userinterface
        SmashUI ui = new SmashUI();
        ui.start();
     }
}
