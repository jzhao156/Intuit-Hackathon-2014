import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

public class GameController extends JApplet implements ActionListener//, Mouselistener
{
    private JPanel bottomPanel = new JPanel(new FlowLayout());
    private JPanel imagePanel = new JPanel();
    private JButton shopButton;
    private JButton helpButton;
    
    public void init ()
    {
        ImageIcon x = new ImageIcon(this.getClass().getResource("testImage.jpg"));
        JLabel test = new JLabel(x);
        
        shopButton = new JButton("Shop");
        helpButton = new JButton("Help");
        
        bottomPanel.add(test);
        bottomPanel.add(shopButton);
        bottomPanel.add(helpButton);
        
        add(bottomPanel);
        
        shopButton.addActionListener(this);
        helpButton.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        //TODO
        System.out.println("Poop");
    }
}
