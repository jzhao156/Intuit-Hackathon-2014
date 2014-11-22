Stuff to add to Events.java

import java.util.*; // or java.util.HashMap;

//global variable!!
final int MONEY_DEL_INCOME_PART = 10000;

final int FOUR = 4;

//helps you when doing part #
final int NP = -1; //no part
final int CP = 0;
final int NC = 1;
final int WS = 2;
final int LS = 3;
final int TH = 4;

ArrayList<Options> options;

HashMap< Integer, ArrayList< todo > > toDoArray;
ArrayList<Integer> bl; // black list
ArrayList< toDo > tempArray;
toDo temptoDo;
Options tempOptions;
Player player;

public Events( Player p )
{
//add these initilizations
player = p;
toDoArray = new HashMap<Integer,  ArrayList< todo > >();

bl = new ArrayList<Integer>();
}

//getting new prompt:
int temp = rand( prompts.size() );

while( bl.contains( new Integer(temp) ) )
    temp = rand( prompts.size() );

//when event is picked:
// example - buy pre order right now, 
// next day add toDo that adds cock pit and salary
//
// affects options
tempOptions = options.get( temp );
tempArray = tempOptions.getVals();
for(int i = 0; i < tempArray.length(); i++)
{
    temptoDo = tempArray.get( i );
    if( ! bl.contains( temptoDo.getIndex() ) )
        bl.add( temptoDo.getIndex() );
    player.addPart( temptoDo.getPart() );
    player.addIncome( temptoDo.getDelInc() );
    player.addSavings( temptoDo.getDelSav() );
}

// if true, bought. if false, not enuf funds
// meant for shop to use!!!!
// for shop: make sure to update savings and whatever!!!
public boolean buy( int part, int cost )
{
    if( player.getSavings() < cost )
        return false;
    player.addPartIncome( part, MONEY_DEL_INCOME_PART );
    player.subSavings( cost );
    return true;
}

//get todays stuff
tempArray = toDoArray.get( new Integer(0) );

// do todays stuff :D !
for( int i = 0; i < tempArray.size(); i++ )
{
    temptoDo = tempArray.get( i );
    if( ! bl.contains( temptoDo.getIndex() ) )
        bl.add( temptoDo.getIndex() );
    player.addPart( temptoDo.getPart() );
    player.addIncome( temptoDo.getDelInc() );
    player.addSavings( temptoDo.getDelSav() );
}

//after day is done, push toDo 1 day forward
for(int i = 1; i < toDoArray.size(); i++)
{
    if (toDoArray.containsKey( new Integer(i) ) )
    {
        toDoArray.put( new Integer(i-1) , toDo.get( new Integer(i) ) );    
        toDoArray.remove( new Integer(i) );
    }
}
