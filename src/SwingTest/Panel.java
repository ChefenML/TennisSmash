package SwingTest;

import FileHandler.Filehandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Panel extends JPanel {
    JPanel panel,tableHead;
    JLabel userNameLabel,memberIdLabel,genderLabel,birthYearLabel,birthMonth,birthDay,gameTypeLabel,exerciseLabel;
    JLabel unchecked,checked;
    JTable userTable;
    JScrollPane scrollPane;


    public Panel() {
        panel = new JPanel();
        this.setPreferredSize(new Dimension(800,600));
//        this.setLayout(null);
        //this.setLayout(new GridBagLayout());

//        userNameLabel = new JLabel("Navn");
//        memberIdLabel = new JLabel("Medlem");
//        genderLabel = new JLabel("Køn");
//
//        //Table stuff
//
//        scrollPane = new JScrollPane(userTable);

        String[] tableNames = {"Navn", "Medlem", "Køn"};
        String[][] tableData = {
                {"Fakenavn1","1","M"},
                {"Fakenavn2","2","F"},
                {"Fakenavn3","3","F"},
                {"Fakenavn4","4","M"}
        };
        userTable = new JTable(tableData,tableNames);
//        userTable.getTableHeader().setBounds(50,30,700,20);
//        userTable.setBounds(50,50,700,200);


        this.add(userTable.getTableHeader(),BorderLayout.NORTH);
        this.add(userTable,BorderLayout.SOUTH);



        this.setVisible(true);





    }
}
