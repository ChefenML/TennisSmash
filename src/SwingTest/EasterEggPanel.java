package SwingTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EasterEggPanel extends JPanel implements ActionListener {
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;


    Image mikkel,oliver,demi,cille,iddi;
    Timer timer;


    //Velocity

    int mikXVelocity = 1;
    int mikYVelocity = -1;
    int demiXvolocity = -1;
    int demiYvolocity = 1;
    int oliverXVelocity = 1;
    int oliverYVelocity = 1;
    int cilleXVelocity = -1;
    int cilleYVelocity = -1;
    int iddiXvelocity = 1;
    int iddiYvelocity = 0;

    //Start kordinator
    int iddix = 0;
    int iddiy = 0;

    int oliverx = 215;
    int olivery = 180;

    int cillex = 215;
    int cilley = 180;

    int demix = 215;
    int demiy = 180;


    int mikx = 215;
    int miky = 180;

    JLabel easterEgg = new JLabel("Easter Egg: Floating Nerds");


    EasterEggPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        this.add(easterEgg);

        // this.add(getWidth);

        mikkel = new ImageIcon("src/SwingTest/mikkel.png").getImage();
        oliver = new ImageIcon("src/SwingTest/oliver.png").getImage();
        cille = new ImageIcon("src/SwingTest/cille.png").getImage();
        demi = new ImageIcon("src/SwingTest/demi.png").getImage();
        iddi = new ImageIcon("src/SwingTest/iddi.png").getImage();
        timer = new Timer(10,this);
        timer.start();
    }

    public void paint(Graphics g){
        super.paint(g);

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(mikkel,mikx,miky,null);
        //g2D.drawString("Mikkel",xMik,yMik);
        //g2D.fillArc(xMik,yMik,50,50,0,360);
        g2D.drawImage(oliver,oliverx,olivery,null);
        g2D.drawImage(cille,cillex,cilley,null);
        g2D.drawImage(demi,demix,demiy,null);
        g2D.drawImage(iddi,iddix,iddiy,null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //head
        if(mikx>=PANEL_WIDTH - mikkel.getWidth(null) || mikx<0)
        {
            mikXVelocity = mikXVelocity * -1;
        }


        if(miky>=PANEL_HEIGHT - mikkel.getHeight(null) || miky<0)
        {
            mikYVelocity     = mikYVelocity * -1;
        }

        miky = miky + mikYVelocity;
        mikx = mikx + mikXVelocity;

        //demi
        if(demix >= (PANEL_WIDTH-86) || demix<0){
            demiXvolocity = demiXvolocity * -1;
        }

        if(demiy >= (PANEL_HEIGHT-84) || demiy<0){
            demiYvolocity = demiYvolocity * -1;
        }

        demix = demix + demiXvolocity;
        demiy = demiy + demiYvolocity;

//Oliver

        if(oliverx >= (PANEL_WIDTH-86) || oliverx<0){
            oliverXVelocity = oliverXVelocity * -1;
        }

        if(olivery >= (PANEL_HEIGHT-84) || olivery<0){
            oliverYVelocity = oliverYVelocity * -1;
        }

        oliverx = oliverx + oliverXVelocity;
        olivery = olivery + oliverYVelocity;

        //Cille

        if(cillex >= (PANEL_WIDTH-86) || cillex<0){
            cilleXVelocity = cilleXVelocity * -1;
        }

        if(cilley >= (PANEL_HEIGHT-84) || cilley<0){
            cilleYVelocity = cilleYVelocity * -1;
        }

        cillex = cillex + cilleXVelocity;
        cilley = cilley + cilleYVelocity;

        //iddi

        if(iddix == 410 && iddiy == 0) {
            iddiXvelocity = 0;
            iddiYvelocity = 1;
        }else if(iddiy == 380 && iddix == 410) {
            iddiXvelocity = -1;
            iddiYvelocity = 0;
        } else

        if(iddix == 0 && iddiy == 380) {
            iddiXvelocity = 0;
            iddiYvelocity = -1;
        } else
        if(iddiy == 0 && iddix == 0 ) {
            iddiXvelocity = 1;
            iddiYvelocity = 0;
        }



        iddix = iddix + iddiXvelocity;
        iddiy = iddiy + iddiYvelocity;




        repaint();
    }
}


