import java.util.*;

public class Options
{
  private ArrayList<String> str = new ArrayList<String>();
  private ArrayList<toDo> vals = new ArrayList<toDo>();
  
  public Options(ArrayList<String> arg1, ArrayList<toDo> arg2)
  {
    this.str = arg1;
    this.vals = arg2;
  }
  
  public ArrayList<String> getString()
  {
    return this.str;
  }
  public ArrayList<toDo> getVals()
  {
    return this.vals;
  }
}