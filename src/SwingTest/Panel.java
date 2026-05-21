package SwingTest;

import FileHandler.MemberHandler;
import Member.Member;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel extends JPanel {
    JPanel panel,tableHead;
    JLabel userNameLabel,memberIdLabel,genderLabel,birthYearLabel,birthMonth,birthDay,gameTypeLabel,exerciseLabel;
    JLabel unchecked,checked;
    JTable userTable;
    JScrollPane scrollPane;
    MemberHandler fileHandler = new MemberHandler();
    ArrayList<Member> memberList = fileHandler.load();;
    Object[][] member2dArray;

    public Panel() {
        //memberList = fileHandler.load();//fillMembers();
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


        Object[] tableNames = {"Navn", "Medlem", "Køn", "Fødselsår", "Fødselsmåned", "Fødselsdag","MedlemsType","Disciplin","PRO/AM"};
        Object[][] tableData = create2dArray();


        userTable = new JTable(tableData,tableNames);
//        userTable.getTableHeader().setBounds(50,30,700,20);
//        userTable.setBounds(50,50,700,200);


        this.add(userTable.getTableHeader(),BorderLayout.NORTH);
        this.add(userTable,BorderLayout.SOUTH);


        //Scroller for table
      //  JScrollPane scroppPane = new JScrollPane(userTable);
        scrollPane = new JScrollPane(userTable);
        this.add(scrollPane);

        this.setVisible(true);





    }

    public Object[][] create2dArray(){
       int arraySize =memberList.size();
        member2dArray = new Object[arraySize][9];
       int i = 0;
       for(Member m : memberList){
           Object[] b = {m.getName(), m.getMemberID(), m.getGender(), m.getBirthYear(), m.getBirthMonth(), m.birthDayOfMonth(), m.getMemberType(), m.getGameTypes(), m.getExerciser()};
           member2dArray[i] = b;
           i++;
       }
        return member2dArray;
    }

//    public void fillMembers(){
//        memberList = fileHandler.load();
//    }
}
