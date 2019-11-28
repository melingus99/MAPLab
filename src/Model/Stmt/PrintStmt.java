package Model.Stmt;
import Model.Expressions.Exp;
import Model.Stack_and_others.*;
import Exception.MyException;
import Model.Value.Value;

public class PrintStmt implements IStmt{
    Exp exp;
    public PrintStmt(Exp exp){
        this.exp=exp;
    }
    @Override
    public String toString(){ return "print(" +exp.toString()+")";}
    public PrgState execute(PrgState state) throws MyException{
        MyIStack<IStmt> stk=state.getStk();
        MyIDictionary<String, Value> symtbl= state.getSymTable();
        MyIList<Value> out= state.getOut();
        MyIHeap<Integer,Value> heap=state.getHeap();
        Value e=exp.eval(symtbl,heap);
        out.add(e);
        System.out.print(out);
        return state;
    }
 //...
}