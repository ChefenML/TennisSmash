package SwingTest;

import javax.swing.*;

public class EasterEggFrame extends JFrame {
    EasterEggPanel panel;

    public EasterEggFrame(){
        panel = new EasterEggPanel();



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("666 EasterEgg: Floating NERDS");
        this.setResizable(true);
        this.setIconImage(panel.mikkel);



        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
