import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.applet.*;
import objectdraw.*;

public class GameController extends WindowController implements ActionListener
{
    public int daysLeft, moneyCnt;
    private JPanel bottomPanel = new JPanel(new FlowLayout());
    private JPanel topPanel = new JPanel(new FlowLayout());
    private JPanel imagePanel = new JPanel();
    private JButton shopButton;
    private JButton helpButton;
    private JLabel days, money;
    private Text helpText1, helpText2, helpText3, helpText4, helpText5, helpText6, helpText7, helpText8, helpText9;
    
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
        
        helpTextRect = new FilledRect(50, 40, 670, 250, canvas);
        helpTextRect.setColor(Color.WHITE);
        
        helpText1 = new Text("Welcome to Spaceship Escape Finance Game! Greetings future resident! Your home planet, once beautiful", 60, 50, canvas);
        helpText2 = new Text("and thriving, has reached the end of it's days and in just 20 days it will explode! You need to generate", 60, 70, canvas);
        helpText3 = new Text("enough money to buy 5 spaceship parts to rocket away to safety!", 60, 90, canvas);
        helpText4 = new Text("How To Play: In the game, there will be options for you to select. You must select ONE option to advance", 60, 120, canvas);
        helpText5 = new Text("to the next turn. Each option will contain a explanation as to how that decision will affect your financial", 60, 140, canvas);
        helpText6 = new Text("situation. REMEMBER, the goal is to obtain your FIVE spaceship parts. THE ONLY WAY TO BUY PARTS", 60, 160, canvas);
        helpText7 = new Text("IS THROUGH THE SHOP! When there are zero days/turns left and you have not finished buying your", 60, 180, canvas);
        helpText8 = new Text("parts, you will LOSE. If you run out of money, you will also lose! So be careful on how you spend money!", 60, 200, canvas);
        helpText9 = new Text("Click on this prompt to hide this text and return to the game.", 60, 250, canvas);
        
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
        
        helpAction();
        
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        //TODO
        if (evt.getSource() == shopButton)
        {
        }
        if (evt.getSource() == helpButton)
        {
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
            helpText7.hide();
            helpText8.hide();
            helpText9.hide();
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
            helpText7.show();
            helpText8.show();
            helpText9.show();
            
            if(!prompt.isHidden()) { prompt.hide(); };
            if(!option1.isHidden()) { option1.hide(); };
            if(!option2.isHidden()) { option2.hide(); };
            if(!option3.isHidden()) { option3.hide(); };
            if(!option4.isHidden()) { option4.hide(); };
            
            curShowHelp = true;
        }
    }
    
    public void onMouseClick(Location mousePosition)
    {
        if(option1.contains(mousePosition) && !option1.isHidden())
        {
            //do option 1
        }
        if(option2.contains(mousePosition) && !option2.isHidden())
        {
            //do option 2
        }
        if(option3.contains(mousePosition) && !option3.isHidden())
        {
            //do option 3
        }
        if(option4.contains(mousePosition) && !option4.isHidden())
        {
            //do option 4
        }
        if(helpTextRect.contains(mousePosition) && !helpTextRect.isHidden())
        {
            helpAction();
        }
    }
    public void onMouseDrag(Location mousePosition)
    {
        //empty constructor
    }
    public void onMouseRelease(Location mousePosition)
    {
        //empty constructor
    }
    public void onMouseExit(Location mousePosition)
    {
        //empty constructor
    }
    public void onMouseEnter(Location mousePosition)
    {
        //empty constructor
    }
}
