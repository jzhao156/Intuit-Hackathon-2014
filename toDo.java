import java.util.*;

public class toDo
{
/* Integer[0] - index 
 * Integer[1] - part
 * Integer[2] - savings
 * Integer[3] - income
 */
    int index;
    int part;
    int delSav; // delta savings
    int delInc; // delta income
    public toDo(int ind, int par, int sav, int inc)
    {
        index = ind;
        part = par;
        delSav = sav;
        delInc = inc;
    }

    public int getIndex()
    {
        return index;
    }

    public int getPart()
    {
        return part;
    }

    public int getDelSav()
    {
        return delSav;
    }

    public int getDelInc()
    {
        return delInc;
    }
}
