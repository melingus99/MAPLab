package Model.Expressions;

import Model.Stack_and_others.MyIDictionary;
import Model.Stack_and_others.MyIHeap;
import Model.Stack_and_others.PrgState;
import Model.Stmt.IStmt;
import Model.Type.IntType;
import Model.Type.RefType;
import Model.Value.RefValue;
import Model.Value.Value;
import Exception.MyException;

import java.sql.Ref;

public class WriteHeapStmt implements IStmt {
    Exp exp;
    String name;

    public WriteHeapStmt(Exp e, String name) {
        this.exp = e;
        this.name = name;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String,Value> tbl=state.getSymTable();
        MyIHeap<Integer,Value> heap=state.getHeap();
        Value val = exp.eval(tbl, heap);
        if (tbl.isDefined(name)) {
            if (tbl.getValue(name).getType().equals(new RefType(new IntType()))) {
                RefValue rval = (RefValue) tbl.getValue(name);
                if (heap.isDefined(rval.getAddr())) {
                    if (val.getType().equals(heap.getValue(rval.getAddr()).getType())) {
                        heap.update(rval.getAddr(), val);
                    } else throw new MyException("type of expression does not match type of referenced variable");
                } else throw new MyException("addres does not exists in heap");
            } else throw new MyException("type of the variable is not a reference type");
        } else throw new MyException("variable not existent");
        return state;
    }

    @Override
    public String toString() {
        return "" + exp.toString();
    }
}
