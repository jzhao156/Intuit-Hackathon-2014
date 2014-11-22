import java.util.*;

public class Options
{
  private ArrayList<String> str = new ArrayList<String>();
  private ArrayList<Integer[]> vals = new ArrayList<Integer[]>();
  
  public Options(ArrayList<String> arg1, ArrayList<Integer[]> arg2)
  {
    this.str = arg1;
    this.vals = arg2;
  }
  
  public ArrayList<String> getString()
  {
    return this.str;
  }
  public ArrayList<Integer[]> getVals()
  {
    return this.vals;
  }
}