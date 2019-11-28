package Model.Expressions;
import Model.Stack_and_others.MyIHeap;
import Model.Value.Value;
import Exception.MyException;
import Model.Stack_and_others.MyIDictionary;
public class VarExp implements Exp{
    String id;
    public VarExp(String id){
    this.id=id;
    }
    public Value eval(MyIDictionary<String,Value> tbl, MyIHeap<Integer,Value> heap) throws MyException
    {return tbl.lookup(id);}
    @Override
    public String toString(){
        return id;
    }
}