import java.util.*;
  
public class Event
{
  private ArrayList<String> startPrompt= new ArrayList<String>();
  private ArrayList<String> prompts = new ArrayList<String>();
  private ArrayList<xxActioNxx> options= new ArrayList<xxActioNxx>();
  
  //cockpit,nuclear core, wings, life support, thrusters are the parts
  
  public Event(Player p)
  { 
    ////////////////////////////////////START PROMPT///////////////////////////////////////////////
    startPrompt.add("Welcome scientist.");
    startPrompt.add("The world is in danger of being destroyed by giant spaghetti monsters. You are our only hope. You"
                      + " must wisely allocate your resources and properly assess risk to find a way to fund the" + 
                      " construction of the best possible spaceship. You have only 20"+ 
                    " days to do so. Good luck.");
    /////////////////////////////////////PROMPTS & OPTIONS////////////////////////////////////////////
    
    //////////////////////////////////PARTS RELATED PROMPTS////////////////////////////////////////
    //prompts 0
    prompts.add("Juicy Puicy Aerospace Company is selling their 'state of the art' cock pit on the black market. You do not know" 
                  +" if the product is functional or not. You choose to:");
    ArrayList<String> zero = new ArrayList<String>();
    zero.add("take a gamble and buy the cockpit at the 'special' black market price $100,000");
    zero.add("not buy, because black market deals are shady."); 
    ArrayList<toDo> zeroV = new ArrayList<toDo>();
    Random generator = new Random();
    int pass = generator.nextInt(2);
    
    if(pass==1)
    {
      toDo zero0 = new toDo(0,0,-100000,0);
      zeroV.add(zero0);
    }
    else if(pass==0)
    {
      toDo zero0 = new toDo(0,-1,-100000,0);
      zeroV.add(zero0);
    }
    toDo zero1 = new toDo(0,-1,0,0);
    zeroV.add(zero1);
    Options o0 = new Options(zero,zeroV);
    options.add(o0);
    
    
    //prompt 1
    prompts.add("El Paco, a company specializing in advanced, experimental technology, is offering their " +
                "non-FAA approved nuclear engine to early buyers. You do not know if the product is functional " +
                "You choose to:");
    ArrayList<String> one = new ArrayList<String>();
    one.add("take a gamble and buy the nuclear engine at the 'early discount' price of $100,000");
    one.add("not buy, because what kind of company name is 'El Paco'?");
    ArrayList<toDo> oneV = new ArrayList<toDo>();
    pass = generator.nextInt(2);
    if(pass==1)
    {
      toDo one0 = new toDo(1,1,-100000,0);
      oneV.add(one0);
    }
    else if(pass==0)
    {
      toDo one0 = new toDo(1,-1,-100000,0);
      oneV.add(one0);
    }
    toDo one1 = new toDo(1,-1,0,0);
    oneV.add(one1);
    Options o1 = new Options(one,oneV);
    options.add(o1);
    
    
    
    //prompt 2
    prompts.add("Big Red Dog Airlines reports 'excess production' of their line of jet plane wings. They have placed it"
                  + "to be sold on the black market. They warn that the wings may be faulty. You choose to:");
    ArrayList<String> two = new ArrayList<String>();
    two.add("take a gamble and buy the jet wings at the black market price of $100,000.");
    two.add("not buy, obviously the wings are broken.");
    ArrayList<toDo> twoV = new ArrayList<toDo>();
    pass = generator.nextInt(2);
    if(pass==1)
    {
      toDo two0 = new toDo(2,2,-100000,0);
      twoV.add(two0);
    }
    else if(pass==0)
    {
      toDo two0 = new toDo(2,-1,-100000,0);
      twoV.add(two0);
    }
    toDo two1 = new toDo(2,-1,0,0);
    twoV.add(two1);
    Options o2 = new Options(two, twoV);
    options.add(o2);
    

    //prompt 3
    prompts.add("Swedish Bob Aeronautics Ltd.'s unreleased line of spacecraft life support systems have been stolen" +
                " and released on the black market. The dealer contacts you and offers you a 'low' price. He doesn't" +
                " diclose the condition of these systems. You choose to:");
    ArrayList<String> three = new ArrayList<String>();
    three.add("take a gamble and buy the life support systems at the black market price of $100,000");
    three.add("not buy, the support systems may be damaged.");
    ArrayList<toDo> threeV = new ArrayList<toDo>();
    pass = generator.nextInt(2);
    if(pass==1)
    {
      toDo three0 = new toDo(3,3,-100000,0);
      threeV.add(three0);
    }
    if(pass==0)
    {
      toDo three0 = new toDo(3,-1,-100000,0);
      threeV.add(three0);
    }
    toDo three1 = new toDo(3,-1,0,0);
    threeV.add(three1);
    Options o3 = new Options(three, threeV);
    options.add(o3);
    
    
    
    //prompt 4
    prompts.add("Ord Propulsion Laboratories is going out of business and selling all their patented jet thrusters for"
                  +" a clearance price. You don't know the quality of these thrusters. You choose to:");
    ArrayList<String> four = new ArrayList<String>();
    four.add("take a gamble and buy the thrusters at the clearance price.");
    four.add("not buy, the company is going out of business for a reason. The thrusters must be faulty.");
    ArrayList<toDo> fourV = new ArrayList<toDo>();
    pass = generator.nextInt(2);
    if(pass==1)
    {
      toDo four0 = new toDo(4,4,-100000,0);
      fourV.add(four0);
    }
    if(pass==0)
    {
      toDo four0 = new toDo(4,-1,-100000,0);
      fourV.add(four0);
    }
    toDo four1 = new toDo(4,-1,0,0);
    fourV.add(four1);
    Options o4 = new Options(four,fourV);
    options.add(o4);
    
     
    /////////////////////////////////////////MONEY-RELATED PROMPTS//////////////////////////////////////////////
    //prompt 5
    prompts.add("A benevolent benofactor gifts you $100,000. With this money, you choose to:");
    ArrayList<String> five = new ArrayList<String>();
    five.add("do nothing with it. Just take the $100,000.");
    five.add("invest in the recent rise in popularity of lemonade stands. Increase your daily income by $10,000.");
    five.add("take half of the gift: $50,000, and use the other half for investment: $5,000 increase in daily income.");
    ArrayList<toDo> fiveV = new ArrayList<toDo>();
    toDo five0 = new toDo(5,-1,100000,0);
    toDo five1 = new toDo(5, -1,0,10000);
    toDo five2 = new toDo(5,-1,50000,5000);
    fiveV.add(five0);
    fiveV.add(five1);
    fiveV.add(five2);
    Options o5 = new Options(five,fiveV);
    options.add(o5);
    
    
    
    //prompt 6
    prompts.add("The Harlem Globe Trotters have come out of retirement and the world is shaking with anticipation." +
                " Sensing an opportunity, you decide to:");
    ArrayList<String> six = new ArrayList<String>();
    six.add("Sponsor the team to do a global tour. You pay $100,000 but your daily income increases by $10,000.");
    six.add("Negotiate a deal to sell a Harlem Globe Trotters clothing line. You spend $250,000, but your income" +
              " increases by $30,000 each day.");
    six.add("nothing, because the Harlem Globe Trotters are overrated.");
    ArrayList<toDo> sixV = new ArrayList<toDo>();
    toDo six0 = new toDo(6,-1,-100000,10000);
    toDo six1 = new toDo(6,-1,-250000,30000);
    toDo six2 = new toDo(6,-1,0,0);
    sixV.add(six0);
    sixV.add(six1);
    sixV.add(six2);
    Options o6 = new Options(six,sixV);
    options.add(o6);
    
    
    
    
    //prompt 7
    prompts.add("Due to the current state of chaos, the government has declared a state of martial law. As a result,"+
                " you have been forced to pay a portion of your wealth to the government. You are given two choices."+
                " You choose to:");
    ArrayList<String> seven = new ArrayList<String>();
    seven.add("offer $15,000 of your daily income.");
    seven.add("offer a flat amount of $150,000.");
    seven.add("take your chances and ignore the government. (possibly random fine or possible no fine)");
    //lose 100-200k
    ArrayList<toDo> sevenV = new ArrayList<toDo>();
    toDo seven0 = new toDo(7,-1,0,-15000);
    toDo seven1 = new toDo(7,-1,-150000,0);
    pass = generator.nextInt(3); //so pass =0, 1, or 2
    toDo seven2 = new toDo(7,-1,-100000*pass,0);
    sevenV.add(seven0);
    sevenV.add(seven1);
    sevenV.add(seven2);
    Options o7 = new Options(seven,sevenV);
    options.add(o7);
    
    
    
    //prompt 8
    prompts.add("Your rival who has decided to build a bunker tries to buy you out. He offers you a large sum of money in"
                  +" in exchange for all your income sources. You decide to:");
    ArrayList<String> eight = new ArrayList<String>();
    eight.add("take him up on his offer. Your income is now 0, but you receive $500,000");
    eight.add("propose a counteroffer. You pay him $500,000 but he gives you his assets. Your daily income increases by $50,000");
    eight.add("decline. Engage in a staring contest and then walk away.");
    ArrayList<toDo> eightV = new ArrayList<toDo>();
    int income = p.getIncome();
    toDo eight0 = new toDo(8,-1,500000,-income);
    toDo eight1 = new toDo(8,-1,-500000,50000);
    toDo eight2 = new toDo(8,-1,0,0);
    eightV.add(eight0);
    eightV.add(eight1);
    eightV.add(eight2);
    Options o8 = new Options(eight,eightV);
    options.add(o8);
    
    
    
    //prompt 9
    prompts.add("The IRS notifies you that you've been avoiding your taxes. Given the current state of the world, they" +
                " decide to be nice and offer you two choices. You can choose to:");
    ArrayList<String> nine = new ArrayList<String>();
    nine.add("pay a flat $150,000 fine");
    nine.add("take a $15,000 cut to your daily income");
    nine.add("move to Switzerland( and take a $7,500 income cut and pay for plane tickets for $75,000)");
    ArrayList<toDo> nineV = new ArrayList<toDo>();
    toDo nine0 = new toDo(9,-1,-150000,0);
    toDo nine1 = new toDo(9,-1,0,-15000);
    toDo nine2 = new toDo(9,-1,-75000,-7500);
    nineV.add(nine0);
    nineV.add(nine1);
    nineV.add(nine2);
    Options o9 = new Options(nine,nineV);
    options.add(o9);
    
    
    
    
    //prompt 10
    prompts.add("As a result of your whopper addiction, you have been caught trying to steal a truck of whoppers. The"+
                " authorities, understanding your pain, decide to go easy on you. However you still have to pay a fine."
                +" You choose to:");
    ArrayList<String> ten = new ArrayList<String>();
    ten.add("Pay up: pay $50,000");
    ten.add("Bribe the cops to stay quiet until you finish your rocket (decrease daily income by $5,000)");
    ArrayList<toDo> tenV = new ArrayList<toDo>();
    toDo ten0 = new toDo(10,-1,-50000,0);
    toDo ten1 = new toDo(10,-1,0,-5000);
    tenV.add(ten0);
    tenV.add(ten1);
    Options o10 = new Options(ten,tenV);
    options.add(o10);
    
    
    
    
    //prompt 11
    prompts.add("The popular fast food chain Steven's Soul-Food Shack has gone public. Since you are close friends with"
                  +" the owner of the company, you have the option to capitalize on this grand opportunity. You decide"
                  +" to:");
    ArrayList<String> eleven = new ArrayList<String>();
    eleven.add("Buy 50% of his company's stocks. You pay $150,000 for this, but your daily income increases by $20,000");
    eleven.add("Buy 25% of his company's stocks. You pay $75,000 for this, but your daily income increases by $7,500");
    eleven.add("Buy 75% of his company's stocks. You pay $225,000 for this, but your daily income increases by $45,000");
    eleven.add("Do nothing. The company is doomed to fail anyways.");
    ArrayList<toDo> elevenV = new ArrayList<toDo>();
    toDo eleven0 = new toDo(11,-1,-150000,20000);
    toDo eleven1 = new toDo(11,-1,-75000,7500);
    toDo eleven2 = new toDo(11,-1,-225000,45000);
    toDo eleven3 = new toDo(11,-1,0,0);
    elevenV.add(eleven0);
    elevenV.add(eleven1);
    elevenV.add(eleven2);
    elevenV.add(eleven3);
    Options o11 = new Options(eleven,elevenV);
    options.add(o11);
    
    
    
    
    //prompt 12
    prompts.add("You decide to create your very own super PAC, a political action committee that you can use to further"
                  +" your own interests by lobbying in Congress. With this super PAC you decide to:");
    ArrayList<String> twelve = new ArrayList<String>();
    twelve.add("Pay $100,000 to lobby for Congress to increase your funding by $20,000 every day.");
    twelve.add("Pay $50,000 to lobby for Congress to increase your funding by $7,500 every day.");
    twelve.add("do nothing. Using money to manipulate the government is bad.");
    ArrayList<toDo> twelveV = new ArrayList<toDo>();
    toDo twelve0 = new toDo(12,-1,-100000,20000);
    toDo twelve1 = new toDo(12,-1,-50000,7500);
    toDo twelve2 = new toDo(12,-1,0,0);
    twelveV.add(twelve0);
    twelveV.add(twelve1);
    twelveV.add(twelve2);
    Options o12 = new Options(twelve,twelveV);
    options.add(o12);
    
    
    
    
    
    //prompt 13
    prompts.add("Your grandmother, with whom you are very close, has fallen ill. As her closest family member, you feel"
                  +" the obligation to help her however you can. However, you are busy with building your rocket so you"
                  +" decide to:");
    ArrayList<String> thirteen = new ArrayList<String>();
    thirteen.add("Allocate $10,000 per day to cover her day-to-day medical care.");
    thirteen.add("Set up a permanent medical fund for her by donating $150,000 to her hospital.");
    thirteen.add("You can't afford to divert funds but you call her to wish her well.");
    thirteen.add("Do nothing.");
    ArrayList<toDo> thirteenV = new ArrayList<toDo>();
    toDo thirteen0 = new toDo(13,-1,0,-10000);
    toDo thirteen1 = new toDo(13,-1,-150000,0);
    toDo thirteen2 = new toDo(13,-1,0,0);
    toDo thirteen3 = new toDo(13,-1,0,0);
    thirteenV.add(thirteen0);
    thirteenV.add(thirteen1);
    thirteenV.add(thirteen2);
    thirteenV.add(thirteen3);
    Options o13 = new Options(thirteen,thirteenV);
    options.add(o13);
    
    
    //prompt 14
    prompts.add("Your college roommate Gorrest Fump has recently hit great success in the fishing industry. He contacts"
                  +" you and offers to help you in your endeavors. He says you can choose to:");
    ArrayList<String> fourteen = new ArrayList<String>();
    fourteen.add("Accept a $200,000 flat donation");
    fourteen.add("Accept a $30,000 donation each day");
    fourteen.add("Accept a mix of a flat $100,000 donation as well as a daily $15,000 gift");
    fourteen.add("Accept nothing. You're an independent spirit.");
    ArrayList<toDo> fourteenV = new ArrayList<toDo>();
    toDo fourteen0 = new toDo(14,-1,200000,0);
    toDo fourteen1 = new toDo(14,-1,0,30000);
    toDo fourteen2 = new toDo(14,-1,100000,15000);
    toDo fourteen3 = new toDo(14,-1,0,0);
    fourteenV.add(fourteen0);
    fourteenV.add(fourteen1);
    fourteenV.add(fourteen2);
    fourteenV.add(fourteen3);
    Options o14 = new Options(fourteen, fourteenV);
    options.add(o14);
    
    
    
    
    ////////////////////////////////RANDOM-GEN EVENTS//////////////////////////////////
    String rand0 = ("Nothing interesting happens today.");
    toDo ev0 = new toDo(15,-1,0,0);
    ArrayList<toDo> list0 = new ArrayList<toDo>();
    list0.add(ev0);
    
    String rand1 = ("The government realizes it no longer needs the military since the world is ending. This frees up"+
               " enough excess budget that the government gifts you $150,000.");
    toDo ev1 = new toDo(16,-1,150000,0);
    ArrayList<toDo> list1 = new ArrayList<toDo>();
    list1.add(ev1);
    
    String rand2 = ("The riots induced by the impending apocalypse causes damage to your assets. You pay $50,000 to "+
               "replace them");
    toDo ev2 = new toDo(17,-1,-50000,0);
    ArrayList<toDo> list2 = new ArrayList<toDo>();
    list2.add(ev2);
    
    String rand3 =("Global stocks crash. A bunch of complex math results in your daily income being reduced by $5,000");
    toDo ev3 = new toDo(18,-1,0,-5000);
    ArrayList<toDo> list3 = new ArrayList<toDo>();
    list3.add(ev3);
    
    String rand4 = ("You decide to sell your old collection of video games. Apparently they're worth $100,000");
    toDo ev4 = new toDo(19,-1,100000,0);
    ArrayList<toDo> list4 = new ArrayList<toDo>();
    list4.add(ev4);
    
    RandomEvents event0 = new RandomEvents(rand0,list0);
    RandomEvents event1 = new RandomEvents(rand1,list1);
    RandomEvents event2 = new RandomEvents(rand2,list2);
    RandomEvents event3 = new RandomEvents(rand3,list3);
    RandomEvents event4 = new RandomEvents(rand4,list4);
    options.add(event0);
    options.add(event1);
    options.add(event2);
    options.add(event3);
    options.add(event4);
                 
  }
  
  public String getPrompt(int index)
  {
    return prompts.get(index);
  }
  public xxActioNxx getOptions(int index)
  {
    return options.get(index);
  }
  public static void main(String[] args)
  {
  }
}

  
