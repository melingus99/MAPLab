package Model.Stmt;
import Model.Expressions.Exp;
import Model.Stack_and_others.MyIDictionary;
import Model.Stack_and_others.MyIHeap;
import Model.Stack_and_others.MyIStack;
import Model.Stack_and_others.PrgState;
import Exception.MyException;
import Model.Type.BoolType;
import Model.Type.Type;
import Model.Value.Value;
import com.sun.jdi.BooleanType;

public class IfStmt implements IStmt{
    Exp exp;
    IStmt thenS;
    IStmt elseS;

    public IfStmt(Exp e, IStmt t, IStmt el) {exp=e; thenS=t;elseS=el;}
    @Override
    public String toString(){ return "IF("+ exp.toString()+") THEN(" +thenS.toString()
            +")ELSE("+elseS.toString()+")";}

    public PrgState execute(PrgState state) throws MyException{
        MyIStack<IStmt> stk = state.getStk();
        MyIDictionary<String, Value> symTbl = state.getSymTable();
        MyIHeap<Integer,Value> heap=state.getHeap();
        Value val = exp.eval(symTbl,heap);
        if (val.getType().equals(new BoolType())) {
            System.out.print(val.toString());
            if(val.toString().equals("true"))
            {
                stk.push(thenS);
            }
            else {
                stk.push(elseS);
            }
            state.setstk(stk);
        } else throw new MyException("conditional expression not a boolean");
        return state;
    }
 //...
}