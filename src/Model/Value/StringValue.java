package Model.Value;
import Model.Type.*;

public class StringValue implements Value{
    String val;
    public StringValue(String v){val=v;}

    public String getVal() {return val;}
    @Override
    public String toString() {return val;}
    public Type getType() { return new BoolType();}

    @Override
    public boolean equals(Object another){
        if (another instanceof StringValue)
            return true;
        else
            return false;
    }
}