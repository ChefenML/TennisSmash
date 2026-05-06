package SwingTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {
    Panel panel;
    JCheckBox check1,check2,check3;
    JButton but1;
    JComboBox combox;

    public Frame(){
        //knap
        but1 = new JButton("CheckBox");
        but1.addActionListener(this);



        //Checkboxes
        check1 = new JCheckBox();
        check1.setFocusable(false);
        check1.addActionListener(this);
        check2 = new JCheckBox();
        check2.setFocusable(false);
        check3 = new JCheckBox();
        check3.setFocusable(false);

        //Dropdown menu
        String[] ageCat = {"Junior","Senior","Veteran"};
        combox = new JComboBox(ageCat);
        combox.addActionListener(this);

        panel = new Panel();
        //Set text of comboxes
        check1.setText("Single");
        check2.setText("Double");
        check3.setText("Mixed");

        this.setLayout(new FlowLayout());
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
          this.setTitle("Tennis Smash");
            this.setResizable(true);


            //adding all to frame
            this.add(but1); //Button
            this.add(check1); //Boxes
            this.add(check2);
            this.add(check3);


            this.add(combox); //ComboBox (Drop downmenu)
        //this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    //do stuff when interacting with GUI
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==check1){
            System.out.println("cheacky cheeky #1");
        }
        if(e.getSource()==but1){

            System.out.println("Single checked: " + check1.isSelected());
        }
        if(e.getSource()==but1){
            System.out.println("Double checked: " + check2.isSelected());
        }
        if(e.getSource()==but1){
            System.out.println("Mixed checked: " + check3.isSelected());
        }

        if(e.getSource()==combox){
            System.out.println(combox.getSelectedItem());
            System.out.println(combox.getSelectedIndex());
        }
    }
}
