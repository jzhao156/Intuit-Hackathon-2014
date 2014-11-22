import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.applet.*;
import objectdraw.*;

public class GameController extends WindowController implements ActionListener
{
    final int NP = -1;
    final int CP = 0;
    final int NC = 1;
    final int WS = 2;
    final int LS = 3;
    final int TH = 4;
    
    ArrayList< toDo > toDoArray;
    ArrayList< Integer > bl;
    Event event;
    private Player player;
    String[] optionStrings;
    
    public final int NUM_CHAR_PER_LINE = 60;
    
    int index = 0;
    
    // Used for the display labels
    public int daysLeft, moneyCnt, shipPartsCnt, incomeCnt;
    // Contains help and shop buttons
    private JPanel bottomPanel = new JPanel(new FlowLayout());
    // Contains the labels of info
    private JPanel topPanel = new JPanel(new FlowLayout());
    // Opens up shop
    private JButton shopButton;
    // Opens up help menu
    private JButton helpButton;
    // Labels in top panel displaying info about the game
    private JLabel days, money, parts, income;
    // Intro and help menu text
    private Text helpText1, helpText2, helpText3, helpText4, helpText5, helpText6, helpText7, helpText8, helpText9;
    // Text about each item in the shop
    private Text thrusterText, coreText, wingsText, cockpitText, lifeSupportText, pressShopText;
    
    // Rects around the prompt and options
    private FilledRect prompt;
    private FilledRect option1, option2, option3, option4;
    
    // Text for each of the prompt and options
    private Text promptText1, promptText2, promptText3, promptText4;
    private Text option1text1,option1text2, option2text1, option2text2, option3text1, option3text2, option4text1, option4text2;
    
    // Rect around the shop
    private FilledRect shopRect;
    // Rect around the help text
    private FilledRect helpTextRect;
    
    // Whether the help and shop menus are currently open
    private boolean curShowHelp = false;
    private boolean curShowShop = false;
    
    // Whether or not the game has been finished
    private boolean gameFinished = false;
    
    private boolean option1wasHidden, option2wasHidden, option3wasHidden, option4wasHidden;
    
    // Background of the game
    private VisibleImage space_Background;
    // Pictures of each item in the shop
    private VisibleImage thrusterPic, corePic, wingsPic, cockpitPic, lifeSupportPic;
    // Pictures of "Purchase" button in the shop
    private VisibleImage purchasePic1,  purchasePic2, purchasePic3, purchasePic4, purchasePic5;
    // Lose game screen
    private VisibleImage losePic;
    // Win game screen
    private VisibleImage winPic;

    //Random number generator
    private Random generator = new Random();
    
    xxActioNxx events;
    
    toDo pooper;
    
    public void begin ()
    {
        // Initialize ALL THE THINGS
        player = new Player();
        bl = new ArrayList<Integer>();
        event = new Event(player);
        
        moneyCnt = player.bigMoney;
        daysLeft = 20;
        shipPartsCnt = 0;
        incomeCnt = player.income;
        
        space_Background = new VisibleImage(getImage("Images/Space.png"), 0, 0, canvas);
        
        helpTextRect = new FilledRect(50, 40, 670, 250, canvas);
        helpTextRect.setColor(Color.WHITE);
        
        helpText1 = new Text("The world is in danger of being destroyed by giant spaghetti monsters. You are our only hope. You must ", 60, 50, canvas);
        helpText2 = new Text("wisely allocate your resources and properly assess risk to find a way to fund the construction of the best ", 60, 70, canvas);
        helpText3 = new Text("possible spaceship. You have only 20 days to do so. Good luck.", 60, 90, canvas);
        helpText4 = new Text("How To Play: In the game, there will be options for you to select. You must select ONE option to advance", 60, 120, canvas);
        helpText5 = new Text("to the next turn. Each option will contain a explanation as to how that decision will affect your financial", 60, 140, canvas);
        helpText6 = new Text("situation. REMEMBER, the goal is to obtain your FIVE spaceship parts. THE ONLY WAY TO BUY PARTS", 60, 160, canvas);
        helpText7 = new Text("IS THROUGH THE SHOP! When there are zero days/turns left and you have not finished buying your", 60, 180, canvas);
        helpText8 = new Text("parts, you will LOSE. If you run out of money, you will also lose! So be careful on how you spend money!", 60, 200, canvas);
        helpText9 = new Text("Click on this prompt to hide this text and return to the game.", 60, 250, canvas);
        
        prompt = new FilledRect(100, 35, 550, 100, canvas);
        prompt.setColor(Color.WHITE);
        
        option1 = new FilledRect(100, 165, 550, 70, canvas);
        option1.setColor(Color.WHITE);
        
        option2 = new FilledRect(100, 250, 550, 70, canvas);
        option2.setColor(Color.WHITE);
        
        option3 = new FilledRect(100, 335, 550, 70, canvas);
        option3.setColor(Color.WHITE);
        
        option4 = new FilledRect(100, 420, 550, 70, canvas);
        option4.setColor(Color.WHITE);
        
        shopRect = new FilledRect(50, 50, 650, 425, canvas);
        shopRect.setColor(Color.WHITE);
        
        shopRect.hide();
        
        thrusterText = new Text("Thrusters       $200,000", 200, 80, canvas);
        thrusterText.setFontSize(24);
        thrusterText.setBold(true);
        coreText = new Text("Nuclear Core  $200,000", 200, 160, canvas);
        coreText.setFontSize(24);
        coreText.setBold(true);
        wingsText = new Text("Jet Wings       $200,000", 200, 240, canvas);
        wingsText.setFontSize(24);
        wingsText.setBold(true);
        cockpitText = new Text( "Cockpit          $200,000", 200, 320, canvas);
        cockpitText.setFontSize(24);
        cockpitText.setBold(true);
        lifeSupportText = new Text("Life Support   $200,000", 200, 400, canvas);
        lifeSupportText.setFontSize(24);
        lifeSupportText.setBold(true);
        pressShopText = new Text("Press Shop to return to the game", 250, 460, canvas);
        
        thrusterText.hide();
        coreText.hide();
        wingsText.hide();
        cockpitText.hide();
        lifeSupportText.hide();
        pressShopText.hide();
        
        thrusterPic = new VisibleImage(getImage("Images/Thruster.jpg"), 80, 60, canvas);
        corePic = new VisibleImage(getImage("Images/Core.jpg"), 110, 140, canvas);
        wingsPic = new VisibleImage(getImage("Images/Wings.jpg"), 90, 220, canvas);
        cockpitPic = new VisibleImage(getImage("Images/Cockpit.jpg"), 80, 300, canvas);
        lifeSupportPic = new VisibleImage(getImage("Images/Lifesupport.jpg"), 90, 380, canvas);
        
        thrusterPic.hide();
        corePic.hide();
        wingsPic.hide();
        cockpitPic.hide();
        lifeSupportPic.hide();
        
        purchasePic1 = new VisibleImage(getImage("Images/Purchase.jpg"), 500, 60, canvas);
        purchasePic2 = new VisibleImage(getImage("Images/Purchase.jpg"), 500, 140, canvas);
        purchasePic3 = new VisibleImage(getImage("Images/Purchase.jpg"), 500, 220, canvas);
        purchasePic4 = new VisibleImage(getImage("Images/Purchase.jpg"), 500, 300, canvas);
        purchasePic5 = new VisibleImage(getImage("Images/Purchase.jpg"), 500, 380, canvas);
        
        purchasePic1.hide();
        purchasePic2.hide();
        purchasePic3.hide();
        purchasePic4.hide();
        purchasePic5.hide();
        
        shopButton = new JButton("Shop");
        helpButton = new JButton("Help");
        
        shopButton.addActionListener(this);
        helpButton.addActionListener(this);
        
        shopButton.setPreferredSize( new Dimension(300, 75));
        helpButton.setPreferredSize( new Dimension(300, 75));
        
        days = new JLabel("Days left: " + daysLeft + " ");
        parts = new JLabel("Ship Parts: " + shipPartsCnt + "/5 ");
        income = new JLabel("Income: " + "$" + incomeCnt + "/turn ");
        money = new JLabel( "Money: " + "$" + moneyCnt);
        
        days.setFont(days.getFont().deriveFont(18.0f));
        days.setForeground(Color.red);
        parts.setFont(parts.getFont().deriveFont(18.0f));
        income.setFont(income.getFont().deriveFont(18.0f));
        income.setForeground(Color.green);
        money.setFont(money.getFont().deriveFont(18.0f));
        money.setForeground(Color.green);
        
        bottomPanel.add(shopButton);
        bottomPanel.add(helpButton);
        topPanel.add(days);
        topPanel.add(parts);
        topPanel.add(income);
        topPanel.add(money);
        
        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);
        
        this.validate();
        // Only display shop things (for now anyway)
        nextDay();
        helpAction();
        
        
    }
    
    // If either button clicked
    public void actionPerformed(ActionEvent evt)
    {
        if (evt.getSource() == shopButton)
        {
            shopAction();
        }
        if (evt.getSource() == helpButton)
        {
            helpAction();
        }
    }
    // add global vars
    public void nextDay()
    {
        option1wasHidden = false;
        option2wasHidden = false;
        option3wasHidden = false;
        option4wasHidden = false;
        if (daysLeft != 20)
        {
            player.addPart( pooper.getPart() );
            player.addIncome( pooper.getDelInc() );
            player.addSavings( pooper.getDelSav() );
        }
        if (player.getShipSize() == 5)
        {
            days.setText("Days left: " + daysLeft + " ");
            parts.setText("Ship Parts: " + player.getShipSize() + "/5 ");
            income.setText("Income: " + "$" + player.getIncome() + "/turn ");
            money.setText( "Money: " + "$" + player.getSavings());
            winGame();
            return;
        }
        
        if (player.getSavings() < 0 || daysLeft == 0)
        {
            days.setText("Days left: " + daysLeft + " ");
            parts.setText("Ship Parts: " + player.getShipSize() + "/5 ");
            income.setText("Income: " + "$" + player.getIncome() + "/turn ");
            money.setText( "Money: " + "$" + player.getSavings());
            loseGame();
            return;
        }
        
        // Job
        player.addSavings(player.getIncome());
        
        // If possible, get options
        int temp = generator.nextInt(20);
        while (bl.contains (new Integer(temp)))
        {
            temp = generator.nextInt(20);
        }
        
        events = event.getOptions(temp);
        
        // Get prompt string here
        String stringPrompt = "";
        
        bl.add( new Integer(temp) );
        
        // Get rid of previous days prompt and options
        if (promptText1 != null)
        {
            promptText1.hide();
            promptText1 = null;
        }
        if (promptText2 != null)
        {
            promptText2.hide();
            promptText2 = null;

        }
        if (promptText3 != null)
        {
            promptText3.hide();
            promptText3 = null;

        }
        if (promptText4 != null)
        {
            promptText4.hide();
            promptText4 = null;

        }
        if (option1text1 != null)
        {
            option1text1.hide();
            option1text1 = null;
        }
        if (option1text2 != null)
        {
            option1text2.hide();
            option1text2 = null;
        }
        if (option2text1 != null)
        {
            option2text1.hide();
            option2text1 = null;
        }
        if (option2text2 != null)
        {
            option2text2.hide();
            option2text2 = null;
        }
        if (option3text1 != null)
        {
            option3text1.hide();
            option3text1 = null;
        }
        if (option3text2 != null)
        {
            option3text2.hide();
            option3text2 = null;
        }
        if (option4text1 != null)
        {
            option4text1.hide();
            option4text1 = null;
        }
        if (option4text2 != null)
        {
            option4text2.hide();
            option4text2 = null;
        }
        if (option1.isHidden())
        {
            option1.show();
        }
        if (option2.isHidden())
        {
            option2.show();
        }
        if (option3.isHidden())
        {
            option3.show();
        }
        if (option4.isHidden())
        {
            option4.show();
        }
        
        if( events instanceof Options )
        {
            stringPrompt = event.getPrompt( temp );
            // do optionArray stuff
            Options op = (Options) events;
            ArrayList<String> al = op.getString();
            for( int i = 0; i < al.size();i++)
            {
                ArrayList<String> optionSeparated = wrapText(al.get(i));
                // Set first option
                if( i == 0 )
                {
                    option1text1 = new Text(optionSeparated.get(0), 130, 165, canvas);
                    option1text1.setFontSize(16);
                    if (optionSeparated.size() > 1)
                    {
                        option1text2 = new Text(optionSeparated.get(1), 130, 190, canvas);
                        option1text2.setFontSize(16);
                    }
                }
                // Set second option
                if( i == 1 )
                {
                    option2text1 = new Text(optionSeparated.get(0), 130, 250, canvas);
                    option2text1.setFontSize(16);
                    if (optionSeparated.size() > 1)
                    {
                        option2text2 = new Text(optionSeparated.get(1), 130, 275, canvas);
                        option2text2.setFontSize(16);
                    }
                }
                // Set third option
                if( i == 2 )
                {
                    option3text1 = new Text(optionSeparated.get(0), 130, 335, canvas);
                    option3text1.setFontSize(16);
                    if (optionSeparated.size() > 1)
                    {
                        option3text2 = new Text(optionSeparated.get(1), 130, 360, canvas);
                        option3text2.setFontSize(16);
                    }
                }
                // Set fourth option
                if( i == 3 )
                {
                    option4text1 = new Text(optionSeparated.get(0), 130, 420, canvas);
                    option4text1.setFontSize(16);
                    if (optionSeparated.size() > 1)
                    {
                        option4text2 = new Text(optionSeparated.get(1), 130, 445, canvas);
                        option4text2.setFontSize(16);
                    }
                }
            }

            if(al.size() == 1) {
                option2.hide();
                option3.hide();
                option4.hide();
                option2wasHidden = true;
                option3wasHidden = true;
                option4wasHidden = true;
            }
            else if(al.size() == 2) {
                option3.hide();
                option4.hide();
                option3wasHidden = true;
                option4wasHidden = true;
            }
            else if(al.size() == 3) {
                option4.hide();
                option4wasHidden = true;
            }
            else { }
            
        }
        else
        {
            stringPrompt = event.getPrompt( temp );
            // remove rects covering options
            option1.hide();
            option2.hide();
            option3.hide();
            option4.hide();
            option1wasHidden = true;
            option2wasHidden = true;
            option3wasHidden = true;
            option4wasHidden = true;
        }
        
        ArrayList<String> separated_strings = wrapText(stringPrompt);
        
        for( int i = 0; i < separated_strings.size(); i++ )
        {
            if (i == 0)
            //set first
            {
                promptText1 = new Text(separated_strings.get(i), 105, 35, canvas);
                promptText1.setBold(true);
                promptText1.setFontSize(16);
            }
            if (i == 1)
            // set second
            {
                promptText2 = new Text(separated_strings.get(i), 105, 60, canvas);
                promptText2.setBold(true);
                promptText2.setFontSize(16);
            }
            if (i == 2)
            {
                promptText3 = new Text(separated_strings.get(i), 105, 85, canvas);
                promptText3.setBold(true);
                promptText3.setFontSize(16);
            }
            if (i == 3)
            {
                promptText4 = new Text(separated_strings.get(i), 105, 110, canvas);
                promptText4.setBold(true);
                promptText4.setFontSize(16);
            }
        }
        
        days.setText("Days left: " + daysLeft + " ");
        parts.setText("Ship Parts: " + player.getShipSize() + "/5 ");
        income.setText("Income: " + "$" + player.getIncome() + "/turn ");
        money.setText( "Money: " + "$" + player.getSavings());
        
        daysLeft--;

    }
    
    public ArrayList<String> wrapText(String input)
    {
        String s = new String();
        StringTokenizer st = new StringTokenizer(input);
        
        ArrayList<String> output = new ArrayList<String>();
        
        while( st.hasMoreTokens())
        {
            String temp = st.nextToken();
            if ( (s.length() + temp.length()) > NUM_CHAR_PER_LINE)
            {
                // Get last word
                output.add(s);
                s = new String();
            }
            
            s += temp + " ";
        }
        
        output.add(s);
        
        return output;
    }
    
    // Opens and closes shop
    public void shopAction()
    {
        if (gameFinished)
        {
            return;
        }
        
        if (curShowShop)
        {
            // Hide the shop and go back to main menu
            shopRect.hide();
            thrusterText.hide();
            coreText.hide();
            wingsText.hide();
            cockpitText.hide();
            lifeSupportText.hide();
            purchasePic1.hide();
            purchasePic2.hide();
            purchasePic3.hide();
            purchasePic4.hide();
            purchasePic5.hide();
            thrusterPic.hide();
            corePic.hide();
            wingsPic.hide();
            cockpitPic.hide();
            lifeSupportPic.hide();
            pressShopText.hide();
            
            if(prompt.isHidden()) { prompt.show(); };
            if(!option1wasHidden) { option1.show(); };
            if(!option2wasHidden) { option2.show(); };
            if(!option3wasHidden) { option3.show(); };
            if(!option4wasHidden) { option4.show(); };
            
            if(promptText1 != null && promptText1.isHidden()) {promptText1.show();};
            if(promptText2 != null && promptText2.isHidden()) {promptText2.show();};
            if(promptText3 != null && promptText3.isHidden()) {promptText3.show();};
            if(promptText4 != null && promptText4.isHidden()) {promptText4.show();};
            if(option1text1 != null && option1text1.isHidden()) {option1text1.show();};
            if(option1text2 != null && option1text2.isHidden()) {option1text2.show();};
            if(option2text1 != null && option2text1.isHidden()) {option2text1.show();};
            if(option2text2 != null && option2text2.isHidden()) {option2text2.show();};
            if(option3text1 != null && option3text1.isHidden()) {option3text1.show();};
            if(option3text2 != null && option3text2.isHidden()) {option3text2.show();};
            if(option4text1 != null && option4text1.isHidden()) {option4text1.show();};
            if(option4text2 != null && option4text2.isHidden()) {option4text2.show();};
            
            curShowShop = false;
        }
        else
        {
            // Show the shop, check if coming from help or main menu
            if(curShowHelp)
            {
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
                
                curShowHelp = false;
            }
            else
            {
                if(!prompt.isHidden()) { prompt.hide(); };
                if(!option1.isHidden()) { option1.hide(); };
                if(!option2.isHidden()) { option2.hide(); };
                if(!option3.isHidden()) { option3.hide(); };
                if(!option4.isHidden()) { option4.hide(); };
                
                if(promptText1 != null && !promptText1.isHidden()) {promptText1.hide();};
                if(promptText2 != null && !promptText2.isHidden()) {promptText2.hide();};
                if(promptText3 != null && !promptText3.isHidden()) {promptText3.hide();};
                if(promptText4 != null && !promptText4.isHidden()) {promptText4.hide();};
                if(option1text1 != null && !option1text1.isHidden()) {option1text1.hide();};
                if(option1text2 != null && !option1text2.isHidden()) {option1text2.hide();};
                if(option2text1 != null && !option2text1.isHidden()) {option2text1.hide();};
                if(option2text2 != null && !option2text2.isHidden()) {option2text2.hide();};
                if(option3text1 != null && !option3text1.isHidden()) {option3text1.hide();};
                if(option3text2 != null && !option3text2.isHidden()) {option3text2.hide();};
                if(option4text1 != null && !option4text1.isHidden()) {option4text1.hide();};
                if(option4text2 != null && !option4text2.isHidden()) {option4text2.hide();};
            }
            // Now show the shop
            shopRect.show();
            if (player.isPart(TH))
            {
                thrusterText.setText("Thrusters -SOLD-");
                purchasePic1.hide();
            }
            else
            {
                purchasePic1.show();
            }
            if (player.isPart(NC))
            {
                coreText.setText("Nuclear Core -SOLD-");
                purchasePic2.hide();
            }
            else
            {
                purchasePic2.show();
            }
            if (player.isPart(WS))
            {
                wingsText.setText("Jet Wings -SOLD-");
                purchasePic3.hide();
            }
            else
            {
                purchasePic3.show();
            }
            if (player.isPart(CP))
            {
                cockpitText.setText("Cockpit -SOLD-");
                purchasePic4.hide();
            }
            else
            {
                purchasePic4.show();
            }
            if (player.isPart(LS))
            {
                lifeSupportText.setText("Life Support -SOLD-");
                purchasePic5.hide();
            }
            else
            {
                purchasePic5.show();
            }
            thrusterText.show();
            coreText.show();
            wingsText.show();
            cockpitText.show();
            lifeSupportText.show();
            pressShopText.show();
            thrusterPic.show();
            corePic.show();
            wingsPic.show();
            cockpitPic.show();
            lifeSupportPic.show();
            
            curShowShop = true;
        }
    }
    
    // Hides and closes help menu
    public void helpAction()
    {
        
        // If the game is finished, help button shouldn't do anything
        if (gameFinished)
        {
            return;
        }
        if(curShowHelp)
        {
            // Shop currently being shown and needs to be hidden
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
            if(!option1wasHidden) { option1.show(); };
            if(!option2wasHidden) { option2.show(); };
            if(!option3wasHidden) { option3.show(); };
            if(!option4wasHidden) { option4.show(); };
            
            if(promptText1 != null && promptText1.isHidden()) {promptText1.show();};
            if(promptText2 != null && promptText2.isHidden()) {promptText2.show();};
            if(promptText3 != null && promptText3.isHidden()) {promptText3.show();};
            if(promptText4 != null && promptText4.isHidden()) {promptText4.show();};
            if(option1text1 != null && option1text1.isHidden()) {option1text1.show();};
            if(option1text2 != null && option1text2.isHidden()) {option1text2.show();};
            if(option2text1 != null && option2text1.isHidden()) {option2text1.show();};
            if(option2text2 != null && option2text2.isHidden()) {option2text2.show();};
            if(option3text1 != null && option3text1.isHidden()) {option3text1.show();};
            if(option3text2 != null && option3text2.isHidden()) {option3text2.show();};
            if(option4text1 != null && option4text1.isHidden()) {option4text1.show();};
            if(option4text2 != null && option4text2.isHidden()) {option4text2.show();};
            
            curShowHelp = false;
        }
        else {
            // Shop not being displayed and needs to be shown, first check if coming from
            // main menu or the shop screen
            if (curShowShop)
            {
                shopRect.hide();
                thrusterText.hide();
                coreText.hide();
                wingsText.hide();
                cockpitText.hide();
                lifeSupportText.hide();
                pressShopText.hide();
                purchasePic1.hide();
                purchasePic2.hide();
                purchasePic3.hide();
                purchasePic4.hide();
                purchasePic5.hide();
                thrusterPic.hide();
                corePic.hide();
                wingsPic.hide();
                cockpitPic.hide();
                lifeSupportPic.hide();
                curShowShop = false;
            }
            if(!prompt.isHidden()) { prompt.hide(); };
            if(!option1.isHidden()) { option1.hide(); };
            if(!option2.isHidden()) { option2.hide(); };
            if(!option3.isHidden()) { option3.hide(); };
            if(!option4.isHidden()) { option4.hide(); };
            
            if(promptText1 != null && !promptText1.isHidden()) {promptText1.hide();};
            if(promptText2 != null && !promptText2.isHidden()) {promptText2.hide();};
            if(promptText3 != null && !promptText3.isHidden()) {promptText3.hide();};
            if(promptText4 != null && !promptText4.isHidden()) {promptText4.hide();};
            if(option1text1 != null && !option1text1.isHidden()) {option1text1.hide();};
            if(option1text2 != null && !option1text2.isHidden()) {option1text2.hide();};
            if(option2text1 != null && !option2text1.isHidden()) {option2text1.hide();};
            if(option2text2 != null && !option2text2.isHidden()) {option2text2.hide();};
            if(option3text1 != null && !option3text1.isHidden()) {option3text1.hide();};
            if(option3text2 != null && !option3text2.isHidden()) {option3text2.hide();};
            if(option4text1 != null && !option4text1.isHidden()) {option4text1.hide();};
            if(option4text2 != null && !option4text2.isHidden()) {option4text2.hide();};
            
            // Now show help
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
            
            curShowHelp = true;
        }
    }
    
    public void loseGame()
    {
        losePic = new VisibleImage(getImage("images/LoseScreen.jpg"), 0 ,0, canvas);
        gameFinished = true;
        player = new Player();
        daysLeft = 20;
    }
    
    public void winGame()
    {
        winPic = new VisibleImage(getImage("images/WinScreen.jpg"), 0, 0, canvas);
        gameFinished = true;
        player = new Player();
        daysLeft = 20;
    }
    
    public void onMouseClick(Location mousePosition)
    {
        // Reset the game
        if (gameFinished)
        {
            gameFinished = false;
            if (losePic != null)
            {
                losePic.hide();
            }
            else if (winPic != null)
            {
                winPic.hide();
            }
            topPanel.remove(days);
            topPanel.remove(parts);
            topPanel.remove(income);
            topPanel.remove(money);
            bottomPanel.remove(shopButton);
            bottomPanel.remove(helpButton);
            begin();
            return;
            
        }
        
        if (curShowShop && purchasePic1.contains(mousePosition) && !purchasePic1.isHidden())
        {
            if (player.getSavings() >= 200000)
            {
                player.addPart(TH);
                player.addSavings(-200000);
                if (player.getShipSize() == 5)
                {
                    days.setText("Days left: " + daysLeft + " ");
                    parts.setText("Ship Parts: " + player.getShipSize() + "/5 ");
                    income.setText("Income: " + "$" + player.getIncome() + "/turn ");
                    money.setText( "Money: " + "$" + player.getSavings());
                    winGame();
                    return;
                }
                money.setText( "Money: " + "$" + player.getSavings());
                parts.setText("Ship Parts: " + player.getShipSize() + "/5 ");
                curShowShop = false;
                shopAction();
                return;
            }
        }
        
        if (curShowShop && purchasePic2.contains(mousePosition) && !purchasePic2.isHidden())
        {
            if (player.getSavings() >= 200000)
            {
                player.addPart(NC);
                player.addSavings(-200000);
                if (player.getShipSize() == 5)
                {
                    days.setText("Days left: " + daysLeft + " ");
                    parts.setText("Ship Parts: " + player.getShipSize() + "/5 ");
                    income.setText("Income: " + "$" + player.getIncome() + "/turn ");
                    money.setText( "Money: " + "$" + player.getSavings());
                    winGame();
                    return;
                }
                money.setText( "Money: " + "$" + player.getSavings());
                parts.setText("Ship Parts: " + player.getShipSize() + "/5 ");
                curShowShop = false;
                shopAction();
                return;
            }
        }
        
        if (curShowShop && purchasePic3.contains(mousePosition) && !purchasePic3.isHidden())
        {
            if (player.getSavings() >= 200000)
            {
                player.addPart(WS);
                player.addSavings(-200000);
                if (player.getShipSize() == 5)
                {
                    days.setText("Days left: " + daysLeft + " ");
                    parts.setText("Ship Parts: " + player.getShipSize() + "/5 ");
                    income.setText("Income: " + "$" + player.getIncome() + "/turn ");
                    money.setText( "Money: " + "$" + player.getSavings());
                    winGame();
                    return;
                }
                money.setText( "Money: " + "$" + player.getSavings());
                parts.setText("Ship Parts: " + player.getShipSize() + "/5 ");
                curShowShop = false;
                shopAction();
                return;
            }
        }
        
        if (curShowShop && purchasePic4.contains(mousePosition) && !purchasePic4.isHidden())
        {
            if (player.getSavings() >= 200000)
            {
                player.addPart(CP);
                player.addSavings(-200000);
                if (player.getShipSize() == 5)
                {
                    days.setText("Days left: " + daysLeft + " ");
                    parts.setText("Ship Parts: " + player.getShipSize() + "/5 ");
                    income.setText("Income: " + "$" + player.getIncome() + "/turn ");
                    money.setText( "Money: " + "$" + player.getSavings());
                    winGame();
                    return;
                }
                money.setText( "Money: " + "$" + player.getSavings());
                parts.setText("Ship Parts: " + player.getShipSize() + "/5 ");
                curShowShop = false;
                shopAction();
                return;
            }
        }
        
        if (curShowShop && purchasePic5.contains(mousePosition) && !purchasePic5.isHidden())
        {
            if (player.getSavings() >= 200000)
            {
                player.addPart(LS);
                player.addSavings(-200000);
                if (player.getShipSize() == 5)
                {
                    days.setText("Days left: " + daysLeft + " ");
                    parts.setText("Ship Parts: " + player.getShipSize() + "/5 ");
                    income.setText("Income: " + "$" + player.getIncome() + "/turn ");
                    money.setText( "Money: " + "$" + player.getSavings());
                    winGame();
                    return;
                }
                money.setText( "Money: " + "$" + player.getSavings());
                parts.setText("Ship Parts: " + player.getShipSize() + "/5 ");
                curShowShop = false;
                shopAction();
                return;
            }
        }
        
        if (option1.isHidden() && option2.isHidden() && option3.isHidden() && option4.isHidden() && !curShowShop && !curShowHelp)
        {
            ArrayList<toDo> todo = events.getToDoArray();
            pooper = ( todo.get( 0 ) );
            nextDay();
            return;
        }
        if(option1.contains(mousePosition) && !option1.isHidden())
        {
            ArrayList<toDo> todo = events.getToDoArray();
            pooper = ( todo.get( 0 ) );
            nextDay();
            return;
        }
        if(option2.contains(mousePosition) && !option2.isHidden())
        {
            ArrayList<toDo> todo = events.getToDoArray();
            pooper = ( todo.get(1) );
            nextDay();
            return;
        }
        if(option3.contains(mousePosition) && !option3.isHidden())
        {
            ArrayList<toDo> todo = events.getToDoArray();
            pooper = ( todo.get(2) );
            nextDay();
            return;
        }
        if(option4.contains(mousePosition) && !option4.isHidden())
        {
            ArrayList<toDo> todo = events.getToDoArray();
            pooper = ( todo.get(3) );
            nextDay();
            return;
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
