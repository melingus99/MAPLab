package Model.Value;
import Model.Type.*;

public class BoolValue implements Value{
    boolean val;
    public BoolValue(boolean v){val=v;}

    public boolean getVal() {return val;}
    @Override
    public String toString() {return ""+val;}
    public Type getType() { return new BoolType();}

    @Override
    public boolean equals(Object another){
        if (another instanceof BoolValue)
            return true;
        else
            return false;
    }
}