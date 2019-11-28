package Model.Expressions;
import Model.Expressions.Exp;
import Model.Stack_and_others.MyIHeap;
import Model.Value.Value;
import Exception.MyException;
import Model.Stack_and_others.MyIDictionary;
public class ValueExp implements Exp{
    Value e;
    public ValueExp(Value e){
        this.e=e;
    }
    @Override
    public Value eval(MyIDictionary<String,Value> tbl, MyIHeap<Integer,Value> heap) throws MyException{return e;}
    @Override
    public String toString(){
        return ""+e.toString();
    }
}