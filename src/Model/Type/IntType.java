package Model.Type;

import Model.Value.Value;

public class IntType implements Type{
    @Override
    public boolean equals(Object another){
        if (another instanceof IntType)
            return true;
        else
            return false;
    }

    @Override
    public Value defaultValue() {
        return null;
    }

    @Override
    public String toString() { return "int";}
}
