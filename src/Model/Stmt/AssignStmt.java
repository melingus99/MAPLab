package Model.Stmt;

import Model.Stmt.IStmt;
import Model.Expressions.Exp;
import Model.Stack_and_others.*;
import Model.Value.Value;
import Model.Type.Type;
import Exception.MyException;

public class AssignStmt implements IStmt {
    String id;
    Exp exp;

    public AssignStmt(String id,Exp exp){
        this.exp=exp;
        this.id=id;
    }
    @Override
    public String toString() {
        return id + "=" + exp.toString();
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk = state.getStk();
        MyIDictionary<String, Value> symTbl = state.getSymTable();
        MyIHeap<Integer,Value> heap=state.getHeap();
        Value val = exp.eval(symTbl,heap);
        if (symTbl.isDefined(id)) {
            Type typId = (symTbl.getValue(id)).getType();
            if (val.getType().equals(typId))
                symTbl.update(id, val);
            else
                throw new MyException("declared type of variable" + id + " and type of the assigned expression do not match");
        } else throw new MyException("the used variable" + id + " was not declared before");
        return state;
    }
}