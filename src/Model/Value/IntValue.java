package Model.Value;
import Model.Type.*;
public class IntValue implements Value{
    int val;
    public IntValue(int v){val=v;}

    public int getVal() {return val;}
    @Override
    public String toString() {return " "+val;}
    public Type getType() { return new IntType();}

    @Override
    public boolean equals(Object another){
        if (another instanceof IntValue)
            return true;
        else
            return false;
    }
}
