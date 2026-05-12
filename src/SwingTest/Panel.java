package SwingTest;

import FileHandler.Filehandler;
import Member.Member;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class Panel extends JPanel {
    JPanel panel,tableHead;
    JLabel userNameLabel,memberIdLabel,genderLabel,birthYearLabel,birthMonth,birthDay,gameTypeLabel,exerciseLabel;
    JLabel unchecked,checked;
    JTable userTable;
    JScrollPane scrollPane;
    ArrayList<Member> memberList;
    Filehandler fileHandler;
    String[][] member2dArray;
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

    public void create2dArray(){
       member2dArray = new String[memberList.size()][9];
       int i = 0;
       for(Member m : memberList){
            member2dArray =  m.getName(),m.getMemberID(),m.getGender(), m.getBirthYear(),m.getBirthMonth(),m.birthDayOfMonth(), m.getMemberType(),m.getGameTypes(),m.getExerciser();
            i++;
            //John|1|M|1995|3|20|SENIOR|PASSIVE|PASSIVE
        }
    }
    public void fillMembers(){
        memberList = fileHandler.loadMembers();
    }
}
