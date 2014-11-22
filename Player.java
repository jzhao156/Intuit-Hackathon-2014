import java.util.ArrayList;
import java.util.Random;
import java.lang.Integer;

public class Player
{
    final int MONEY_DEFAULT_SAVINGS = 90000;
    final int MONEY_DEFAULT_INCOME  =  10000;
    final int NUM_OF_PARTS = 5;

    final int LUCK_MIN = 1;
    final int LUCK_MAX = 100;

    int bigMoney;
    int income;
    int luck;
    /*  Nuclear Core = shipParts[0] | 0
     *  Wing Set = shipParts[1]     | 1
     *  Thursters = shipParts[2]    | 2
     *  Life Support = shipParts[3] | 3
     *  Cock Pit = shipParts[4]     | 4
     */
    
    //ArrayList<Integer>[] shipParts = new ArrayList[ NUM_OF_PARTS ];
    ArrayList<Integer> shipParts = new ArrayList<Integer>();
    
    Random rand = new Random();
    /* THIS IS WHEN THERE IS 'QUALITY' IMPLEMENTED!
    //initialize
    public Player()
    {
        // initialize array thing
        for( int i = 0; i < shipParts.length; i++ )
            shipParts[i] = new ArrayList<Integer>();
        salary = MONEY_INCOME;
        bigMoney = MONEY_DEFAULT;

    }

    public Player( int initMoney )
    {
        //initialize array thing
        for( int i = 0; i < shipParts.length; i++ )
            shipParts[i] = new ArrayList<Integer>();

        bigMoney = initMoney;
    }

    void addPart(int part, int val){
        shipParts[part].add(val);
    }

    boolean isPart(int part, int val) {
        return shipParts[part].contains( new Integer(val) );
    }
    // true if there, false if not there
    boolean removePart(int part, int val) {
        return shipParts[part].remove( new Integer(val) );
    }
    */

    //initialize
    public Player()
    {
        income = MONEY_DEFAULT_INCOME;
        bigMoney = MONEY_DEFAULT_SAVINGS;

    }

    boolean addPart( int part )
    {
        if( shipParts.contains( new Integer(part) ) )
            return false;
        shipParts.add( new Integer(part) );
        return true;
    }

    boolean isPart( int part )
    {
        return shipParts.contains( new Integer(part) );
    }

    boolean removePart( int part )
    {
        return shipParts.remove( new Integer(part) );
    }

    public Player( int sav, int inc )
    {
        income = inc;
        bigMoney = sav;
    }

    int nextDay() {
        bigMoney += income;
        luck = rand.nextInt(LUCK_MAX) + LUCK_MIN;
        return bigMoney; 
    }

    int addSavings( int gettinMoney ) {
        bigMoney += gettinMoney;
        return bigMoney;
    }

    int subSavings( int losinMoney ) {
        //pick up yo hussle game
        //or die on earth
        bigMoney -= losinMoney;
        return bigMoney;
    }

    int getLuck()
    {
        return luck;
    }

    int getIncome()
    {
        return income;
    }

    int addIncome( int gettinMoney )
    {
        income += gettinMoney;
        return income;
    }

    int subIncome( int losinMoney )
    {
        income -= losinMoney;
        return income;
    }
}
