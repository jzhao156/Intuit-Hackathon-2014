import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.applet.*;
import objectdraw.*;

public class GameController extends WindowController implements ActionListener//, Mouselistener
{
    public int daysLeft, moneyCnt;
    private JPanel bottomPanel = new JPanel(new FlowLayout());
    private JPanel topPanel = new JPanel(new FlowLayout());
    private JPanel imagePanel = new JPanel();
    private JButton shopButton;
    private JButton helpButton;
    private JLabel days, money;
    private Text helpText1, helpText2, helpText3, helpText4, helpText5, helpText6;
    
    private FilledRect prompt;
    private FilledRect option1, option2, option3, option4;
    
    private FilledRect helpTextRect;
    
    private Player player;
    
    private boolean curShowHelp = false;
    
    private VisibleImage space_Background;
    
    public void begin ()
    {
        player = new Player();
        
        moneyCnt = player.bigMoney;
        daysLeft = 20;
        
        space_Background = new VisibleImage(getImage("Space.png"), 0, 0, canvas);
        
        helpTextRect = new FilledRect(50, 40, 670, 180, canvas);
        helpTextRect.setColor(Color.WHITE);
        
        helpText1 = new Text("Welcome to UC Financial Aid Simulator Help System!\nHow To Play:\n In the game, there will be options", 60, 50, canvas);
        helpText2 = new Text("for you to select. You must select ONE option to advance to the next turn. Each option will contain a ", 60, 70, canvas);
        helpText3 = new Text("explanation as to how that decision will affect your financial situation. REMEMBER, the goal is to obtain", 60, 90, canvas);
        helpText4 = new Text("your FIVE spaceship parts. THE ONLY WAY TO BUY PARTS IS THROUGH SHOP! When there are", 60, 110, canvas);
        helpText5 = new Text("zero days/turns left and you have not finished buying your parts, you will LOSE.", 60, 130, canvas);
        helpText6 = new Text("Click help again to hide this text and return to the game.", 60, 180, canvas);
        
        helpText1.hide();
        helpText2.hide();
        helpText3.hide();
        helpText4.hide();
        helpText5.hide();
        helpText6.hide();
        helpTextRect.hide();
        
        prompt = new FilledRect(125, 35, 500, 100, canvas);
        prompt.setColor(Color.WHITE);
        
        option1 = new FilledRect(125, 165, 500, 70, canvas);
        option1.setColor(Color.WHITE);
        
        option2 = new FilledRect(125, 250, 500, 70, canvas);
        option2.setColor(Color.WHITE);
        
        option3 = new FilledRect(125, 335, 500, 70, canvas);
        option3.setColor(Color.WHITE);
        
        option4 = new FilledRect(125, 420, 500, 70, canvas);
        option4.setColor(Color.WHITE);
        
        shopButton = new JButton("Shop");
        helpButton = new JButton("Help");
        
        shopButton.addActionListener(this);
        helpButton.addActionListener(this);
        
        shopButton.setPreferredSize( new Dimension(300, 75));
        helpButton.setPreferredSize( new Dimension(300, 75));
        
        days = new JLabel("Days left: " + daysLeft + "        ");
        money = new JLabel( "Money: " + "$" + moneyCnt);
        
        days.setFont(days.getFont().deriveFont(24.0f));
        days.setForeground(Color.red);
        money.setFont(money.getFont().deriveFont(24.0f));
        money.setForeground(Color.green);
        
        bottomPanel.add(shopButton);
        bottomPanel.add(helpButton);
        topPanel.add(days);
        topPanel.add(money);
        
        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);
        
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
            this.helpAction();
        }
    }
    
    public void helpAction()
    {
        if(curShowHelp) {
            helpText1.hide();
            helpText2.hide();
            helpText3.hide();
            helpText4.hide();
            helpText5.hide();
            helpText6.hide();
            helpTextRect.hide();
            
            if(prompt.isHidden()) { prompt.show(); };
            if(option1.isHidden()) { option1.show(); };
            if(option2.isHidden()) { option2.show(); };
            if(option3.isHidden()) { option3.show(); };
            if(option4.isHidden()) { option4.show(); };
            
            curShowHelp = false;
        }
        else {
            helpTextRect.show();
            helpText1.show();
            helpText2.show();
            helpText3.show();
            helpText4.show();
            helpText5.show();
            helpText6.show();
            
            if(!prompt.isHidden()) { prompt.hide(); };
            if(!option1.isHidden()) { option1.hide(); };
            if(!option2.isHidden()) { option2.hide(); };
            if(!option3.isHidden()) { option3.hide(); };
            if(!option4.isHidden()) { option4.hide(); };
            
            curShowHelp = true;
        }
    }
}
