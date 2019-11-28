package Model.Stmt;

import Model.Expressions.Exp;
import Model.Stack_and_others.*;
import Model.Type.BoolType;
import Model.Type.StringType;
import Model.Value.Value;
import Exception.MyException;

import java.io.BufferedReader;

public class closeRFile implements IStmt {

    Exp exp;

    public closeRFile(Exp e){
        exp=e;
    }
    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk = state.getStk();
        MyIDictionary<String, Value> symTbl = state.getSymTable();
        MyIHeap<Integer,Value> heap=state.getHeap();
        MyIFileTable<String, BufferedReader> FTabel= state.getFileTable();
        Value val=exp.eval(symTbl,heap);
        if(val.getType().equals(new BoolType())){
            try{
                BufferedReader br=FTabel.getValue(val.toString());
                br.close();
                FTabel.delete(val.toString());
            }
            catch (Exception exc){
                throw new MyException("file not opened");
            }
        }
        else{
            throw new MyException("type not String");
        }
        return state;
    }
}
