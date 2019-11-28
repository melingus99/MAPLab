package Model.Stmt;

import Model.Expressions.Exp;
import Model.Stack_and_others.MyIDictionary;
import Model.Stack_and_others.MyIHeap;
import Model.Stack_and_others.MyIStack;
import Model.Stack_and_others.PrgState;
import Model.Type.IntType;
import Model.Type.RefType;
import Model.Type.Type;
import Model.Value.IntValue;
import Model.Value.RefValue;
import Model.Value.Value;
import Exception.MyException;

import java.sql.Ref;

public class HeapAllocStmt implements IStmt{
    String name;
    Exp exp;

    public HeapAllocStmt(String n,Exp e){
        name=n;
        exp=e;
    }
    @Override
    public String toString() {
        return name+ exp.toString();
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk = state.getStk();
        MyIDictionary<String, Value> symTbl = state.getSymTable();
        MyIHeap<Integer,Value> heap=state.getHeap();
        if (symTbl.isDefined(name)) {
            if (symTbl.getValue(name).getType() instanceof RefType) {
                Value val=exp.eval(symTbl,heap);
                Type aux=symTbl.getValue(name).getType();
                if(new RefType(new RefType(val.getType())).equals(aux)){
                    Integer index=heap.getFree();
                    heap.add(index,val);
                    symTbl.update(name,new RefValue(index,val.getType()));
                }
                else throw new MyException("expression type does not correspond to the referenced type");
            }
            else throw new MyException("declared type of variable " + name+" is not a reftype");
        } else throw new MyException("variable "+name+" does not exists");
        return state;
    }
}
