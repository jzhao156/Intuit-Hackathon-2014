import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.applet.*;

public class GameController extends JApplet implements ActionListener//, Mouselistener
{
    public int daysLeft, moneyCnt;
    private JPanel bigPanel = new JPanel();
    private JPanel bottomPanel = new JPanel(new FlowLayout());
    private JPanel topPanel = new JPanel(new FlowLayout());
    private JPanel imagePanel = new JPanel();
    private JButton shopButton;
    private JButton helpButton;
    private JLabel days, money;
    
    public void init ()
    {
        ImageIcon x = new ImageIcon(this.getClass().getResource("testImage.jpg"));
        JLabel test = new JLabel(x);
        
        shopButton = new JButton("Shop");
        helpButton = new JButton("Help");
        
        shopButton.addActionListener(this);
        helpButton.addActionListener(this);
        
        shopButton.setPreferredSize( new Dimension(300, 75));
        helpButton.setPreferredSize( new Dimension(300, 75));
        
        days = new JLabel("days left: " + daysLeft);
        money = new JLabel( "money" + "$" + moneyCnt);
        
        bottomPanel.add(test);
        bottomPanel.add(shopButton);
        bottomPanel.add(helpButton);
        topPanel.add(days);
        topPanel.add(money);
        
        bigPanel.setLayout( new BoxLayout(bigPanel,BoxLayout.Y_AXIS));
        bigPanel.add(topPanel);
        bigPanel.add(bottomPanel);
        
        add(bigPanel);
        
        this.validate();
        
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        //TODO
        if (evt.getSource() == shopButton)
        {
            System.out.println("Clicked the shop");
        }
        if (evt.getSource() == helpButton)
        {
            System.out.println("Clicked help");
        }
    }
}
