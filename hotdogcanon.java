
//add job

//process events

//empty/reset array

//options appear
 // if options, options appear
 // if randomevent, options dissappear

//???

actionListener( ): // 0 - 3 selection
    
    int selection;
    if event.whatever == Option0
        selection = 0;
    else if whatever == OPtion1
        selection = 1;
    else if whatever == Option2
        selection = 2;
    else if whatever == Option3
        selection = 3;

    if( selection != null ) // not randomevent
{

    nextDay();
    //add toDo of option selected and then add that toDo to toDoArray.
}else{
    // add toDo of option selected and add toDo to toDoArray
    nextDay();
}









    if( events instanceof Options )
        
        toDoArray.add( events.getToDoArray().get( selection ) );
    else
        toDoArray.add( events.getToDoArray().get( 
// when randomEvent
actionListener










// hi jerry
//
// i kicked ur dog
// sry m8
//

//globe vars
//
//




ArrayList< xxActioNxx > events;
ArrayList< toDo > toDoArray; // woof!!!
ArrayList< Integer > bl;
Event event;
Player player;
String[] optionStrings;

    public controller()
    {
        // do these initializatiosdf!!
        
        bl = new ArrayList<Integer>();
        player = new Player();
        event = new Event( player );
        events = event.getOptions();
        toDoArray = new ArrayList<toDo>(); // do this!!
        nextDay();
    }

void nextDay()
{
    //add job to toDoArray
    toDoArray.add( new toDo( -1, -1, 10000, 0 ) ); // adding job!!
    //process toDoArray
    for(int i = 0; i < toDoArray.size(); i++)
    {
        toDo tempT = toDoArray.get(i);
        player.addPart( tempT.getPart() );
        player.addIncome( tempT.getDelInc() );
        player.addSavings( tempT.getDelSav() );
    }
    //set empty toDoArray
    toDoArray = new ArrayList<toDo>();
    //get new toDos here!
    //
    int temp = rand (events.size());
    while( bl.contains( new Integer(temp) )
            temp = rand( events.size() );
    bl.add( temp );
    // GET PROMPT STRING HERE!!!
    String prompt = event.getPrompt( temp );
    
        
    // IF POSSIBLE, GET OPTIONS
    xxActioNxx tempA = events.get( temp );
    if( tempA instanceof Options )
    {
        optionStrings = new String[tempA.getString().size()];

        for(int i = 0; i < optionStrings.length; i ++)
        // PUT YOUR OPTION STRING INTO UR STRINGS
        // ?? = 
        optionStrings[i] = tempA.getString().get(i);
    } else {
        // TURN OFF PLACES WHERE OPTIONS WOULD BE.
        // THIS IS A RANDOM EVENT. NO OPTIONS!!11
        optionStrings = (String[]) null;
    }
    
    // go to next screen, homepage
}
