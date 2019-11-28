package Model.Expressions;
import Model.Stack_and_others.MyIHeap;
import Model.Type.BoolType;
import Model.Value.BoolValue;
import Model.Value.Value;
import Model.Stack_and_others.MyIDictionary;
import Exception.MyException;
public class LogicExp implements Exp{
    Exp e1;
    Exp e2;
    int op;
 public LogicExp (Exp e1,Exp e2,int op){
     this.e1=e1;
     this.e2=e2;
     this.op=op;
 }
    @Override
    public Value eval(MyIDictionary<String,Value> tbl, MyIHeap<Integer,Value> heap) throws MyException{
     boolean n11=false,n22=false;
        Value v1,v2;
        v1= e1.eval(tbl,heap);
        if (v1.getType().equals(new BoolType())) {
            v2 = e2.eval(tbl,heap);
            if (v2.getType().equals(new BoolType())) {
                BoolValue i1 = (BoolValue)v1;
                BoolValue i2 = (BoolValue)v2;
                boolean n1,n2;
                n1= i1.getVal();
                n2 = i2.getVal();
                if (op==1) return new BoolValue(n1&&n2);
                if (op ==2) return new BoolValue(n1||n2);
            }else
                throw new MyException("second operand is not a boolean");
        }else
            throw new MyException("first operand is not a boolean");
        return new BoolValue(n11&&n22);}

    @Override
    public String toString(){
        return "logic expression";
    }
}