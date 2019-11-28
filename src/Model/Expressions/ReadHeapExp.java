package Model.Expressions;

import Model.Stack_and_others.MyIDictionary;
import Model.Stack_and_others.MyIHeap;
import Model.Type.RefType;
import Model.Value.RefValue;
import Model.Value.Value;
import Exception.MyException;

import java.sql.Ref;

public class ReadHeapExp implements Exp {
    Exp exp;
    public ReadHeapExp(Exp e){
        this.exp=e;
    }
    @Override
    public Value eval(MyIDictionary<String,Value> tbl,MyIHeap<Integer,Value> heap) throws MyException {
        Value val=exp.eval(tbl,heap);
        Value vale;
        RefValue rval=(RefValue)val;
        if(val instanceof RefValue){
            if(heap.isDefined(rval.getAddr())){
                vale=heap.getValue(rval.getAddr());
            }
            else throw new MyException("addres does not exists in heap");
        }
        else throw new MyException("value in symbol table not a ref value");
        return vale;
    }
    @Override
    public String toString(){
        return ""+exp.toString();
    }
}
