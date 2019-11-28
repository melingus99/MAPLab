package Model.Stmt;
import Model.Stack_and_others.*;
import Exception.MyException;

import java.time.chrono.IsoChronology;

public class CompStmt implements IStmt {
    IStmt first;
    IStmt snd;

    public CompStmt(IStmt st, IStmt nd){
        first=st;
        snd=nd;
    }

    @Override
    public String toString() {
        return "("+first.toString() + ";" + snd.toString()+")";
    }

    public PrgState execute(PrgState state) throws MyException{
        MyIStack<IStmt> stk=state.getStk();
        stk.push(snd);
        stk.push(first);
        return state;
    }
}