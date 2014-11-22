import java.util.*;

public class Options extends xxActioNxx
{
  private ArrayList<String> str = new ArrayList<String>();
  //private ArrayList<toDo> toDoArray = new ArrayList<toDo>();
  
  public Options(ArrayList<String> arg1, ArrayList<toDo> arg2)
  {
    this.str = arg1;
    this.toDoArray = arg2;
  }
  
  public ArrayList<String> getString()
  {
    return this.str;
  }
  public ArrayList<toDo> getToDoArray()
  {
    return this.toDoArray;
  }
}
