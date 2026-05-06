package SwingTest;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    JPanel panel;
    JLabel checked;
    JLabel unchecked;

    public Panel(){

        this.setPreferredSize(new Dimension(800,600));
        this.setBackground(Color.DARK_GRAY);

        panel = new JPanel();
        checked = new JLabel("✔");
        unchecked = new JLabel("❌");

        this.add(checked);
        this.add(unchecked);



    }
}
