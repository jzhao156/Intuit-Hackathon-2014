import java.util.ArrayList;

public class Player
{
    final int MONEY_DEFAULT = 100000;
    final int MONEY_INCOME  =  10000;
    final int NUM_OF_PARTS = 5;
    int bigMoney;
    int luck;
    /*  Nuclear Core = shipParts[0]
     *  Wing Set = shipParts[1]
     *  Thursters = shipParts[2]
     *  Life Support = shipParts[3]
     *  Cock Pit = shipParts[4]
     */
    
    ArrayList<Integer>[] shipParts = new ArrayList[ NUM_OF_PARTS ];
    
    //initialize
    public Player()
    {
        // initialize array thing
        for( int i = 0; i < shipParts.length; i++ )
            shipParts[i] = new ArrayList<Integer>();
        
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
        return shipParts[part].contains( Integer(val) );
    }
    // true if there, false if not there
    boolean removePart(int part, int val) {
        return shipParts[part].remove( Integer(val) );
    }

    int nextDay() {
        bigMoney += MONEY_INCOME;
        return bigMoney; 
    }

    int addMoneyy( int gettinMoney ) {
        bigMoney += gettinMoney;
        return bigMoney;
    }

    int subMoney( int losinMoney ) {
        //pick up yo hussle game
        //or die on earth
        bigMoney -= losinMoney;
        return bigMoney;
    }
}
