import java.util.*;

public class RandomEvents extends xxActioNxx
{
    private String event;
    
    public RandomEvents( String ev, ArrayList<toDo> arg2 )
    {
        toDoArray = arg2;
        event = ev;
    }
    
    public ArrayList<toDo> getToDoArray()
    {
        return toDoArray;
    }
}
