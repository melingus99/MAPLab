package Model.Stmt;

import Model.Expressions.Exp;
import Model.Stack_and_others.*;
import Exception.MyException;
import Model.Type.BoolType;
import Model.Type.StringType;
import Model.Value.StringValue;
import Model.Value.Value;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class openRFile implements IStmt {
    Exp exp;

    public openRFile(Exp e){exp=e;}

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk = state.getStk();
        MyIDictionary<String, Value> symTbl = state.getSymTable();
        MyIFileTable<String,BufferedReader> FTabel= state.getFileTable();
        MyIHeap<Integer,Value> heap=state.getHeap();
        Value val=exp.eval(symTbl,heap);
        if(val.getType().equals(new BoolType())){
            if(symTbl.isDefined(exp.toString())){
                try {
                    File file = new File(symTbl.getValue(exp.toString()).toString());
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    FTabel.add(val.toString(),br);
                }
                catch (Exception exc){
                    throw new MyException("file does not exists");
                }
            }
            else{
                throw new MyException("file already opened");
            }
        }
        else{
            throw new MyException("type not String");
        }
        return state;
    }

}
