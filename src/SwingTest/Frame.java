package SwingTest;

import FileHandler.*;
import Member.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Frame extends JFrame implements ActionListener {
    Panel panel;
    JCheckBox check1,check2,check3;
    JButton but1;
    JComboBox memberName,GameTypes,Exerciser;
    JTextField fullName,gender,birthDayOfMonth,birthMonth,birthYear;
    JLabel fullNameLabel,genderLabel,birthDayOfMonthLabel,birthMonthLabel,birthYearLabel;
    ArrayList<Member> allmembers = new ArrayList<>();
    Filehandler filehandler = new Filehandler();
    public Frame(){
        this.setSize(500,500); //Flowmanager overwriter?
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tennis Smash");
        this.setLocationRelativeTo(null);
        //this.setResizable(true);

        //knap
        but1 = new JButton("CheckBox");
        but1.addActionListener(this);

        //Labels for text boxes
        fullNameLabel = new JLabel("Fornavn Efternavn");
        fullNameLabel.setVerticalTextPosition(SwingConstants.TOP);
        fullNameLabel.setVerticalAlignment(SwingConstants.TOP);
        genderLabel = new JLabel("Køn M/K");
        birthDayOfMonthLabel = new JLabel("Fødseldag dd");
        birthMonthLabel = new JLabel("Fødselmåned mm");
        birthYearLabel  = new JLabel("Fødselår åååå");

        //input felt hedder JTextField
        fullName = new JTextField("Navn Efternavn",10);
        gender = new JTextField("M",1);
        birthYear = new JTextField("åååå",4);
        birthMonth = new JTextField("mm",2);
        birthDayOfMonth = new JTextField("dd",2);
        //textField.setPreferredSize(new Dimension(200,20));

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
        memberName = new JComboBox(getNameArray());
        memberName.addActionListener(this);

        panel = new Panel();
        //Set text of comboxes
        check1.setText("Single");
        check2.setText("Double");
        check3.setText("Mixed");




            //adding all to frame
            this.add(but1); //Button
            this.add(check1); //Boxes
            this.add(check2);
            this.add(check3);
            this.add(fullNameLabel);
            this.add(fullName);
            this.add(genderLabel);
            this.add(gender);
            this.add(birthDayOfMonthLabel);
            this.add(birthDayOfMonth);
            this.add(birthMonthLabel);
            this.add(birthMonth);
            this.add(birthYearLabel);
            this.add(birthYear);

            this.add(memberName); //ComboBox (Drop downmenu)
        this.add(panel);
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
            System.out.println(fullName.getText());
            System.out.println("Single checked: " + check1.isSelected());
        }
        if(e.getSource()==but1){
            System.out.println("Double checked: " + check2.isSelected());
        }
        if(e.getSource()==but1){
            System.out.println("Mixed checked: " + check3.isSelected());
        }

        if(e.getSource()== memberName){
            int memberindex = memberName.getSelectedIndex();
            Member replacemem = allmembers.get(memberindex);
            fullName.setText(replacemem.getName());
            gender.setText(String.valueOf(replacemem.getGender()));
            birthYear.setText(String.valueOf(replacemem.getBirthYear()));
            birthMonth.setText(String.valueOf(replacemem.getBirthMonth()));
            birthDayOfMonth.setText(String.valueOf(replacemem.birthDayOfMonth()));
            System.out.println(memberName.getSelectedItem() + "@index: " + memberName.getSelectedIndex());

        }
    }
 public String[] getNameArray() {
     allmembers = filehandler.load();
     int countFrom = 0;

     String[] array = new String[allmembers.size()];
     for(Member m : allmembers){

        String b = m.getName();
        array[countFrom] = b;

         countFrom++;
     }

     return array;
 }

}
