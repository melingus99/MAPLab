package Model.Value;
import Model.Type.Type;
import Model.Type.RefType;
public class RefValue implements Value{
    int address;
    Type locationType;
    public RefValue(int addr, Type sometype){
        address=addr;
        locationType=sometype;
    }
    public int getAddr() {return address;}
    @Override
    public Type getType() { return new RefType(locationType);}
}