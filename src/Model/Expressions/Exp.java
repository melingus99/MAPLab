package Model.Expressions;
import Model.Stack_and_others.MyIHeap;
import Model.Value.Value;
import Model.Stack_and_others.MyIDictionary;
import Exception.MyException;
public interface Exp {
    Value eval(MyIDictionary<String,Value> tbl, MyIHeap<Integer,Value> heap) throws MyException;
}
