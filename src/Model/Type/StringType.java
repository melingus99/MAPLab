package Model.Type;

import Model.Value.Value;

public class StringType implements Type {
    @Override
    public boolean equals(Object another){
        if (another instanceof StringType)
            return true;
        else
            return false;
    }
    @Override
    public String toString() { return "String";}

    public Value defaultValue() {
        return null;
    }
}
