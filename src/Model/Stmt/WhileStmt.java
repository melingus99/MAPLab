package Model.Stmt;

import Model.Expressions.Exp;
import Model.Stack_and_others.MyIDictionary;
import Model.Stack_and_others.MyIHeap;
import Model.Stack_and_others.MyIStack;
import Model.Stack_and_others.PrgState;
import Model.Type.BoolType;
import Model.Value.Value;
import Exception.MyException;
public class WhileStmt implements IStmt {
    Exp exp;
    IStmt Statement;
    public WhileStmt(Exp e,IStmt stmt) {exp=e;Statement=stmt;}
    @Override
    public String toString(){ return "While("+ exp.toString()+")"+Statement.toString();}

    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk = state.getStk();
        MyIDictionary<String, Value> symTbl = state.getSymTable();
        MyIHeap<Integer,Value> heap=state.getHeap();
        Value val = exp.eval(symTbl,heap);
        if (val.getType().equals(new BoolType())) {
            if(val.toString().equals("true")){
                stk.push(this);
                stk.push(Statement);
            }
            state.setstk(stk);
        } else throw new MyException("conditional expression not a boolean");
        return state;
    }
}
