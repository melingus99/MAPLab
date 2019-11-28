package Model.Stmt;

import Model.Expressions.Exp;
import Model.Stack_and_others.*;
import Model.Type.BoolType;
import Model.Type.StringType;
import Model.Type.Type;
import Model.Value.IntValue;
import Model.Value.StringValue;
import Model.Value.Value;
import Exception.MyException;
import Model.Type.IntType;

import java.io.BufferedReader;

public class readFile implements IStmt{
    Exp exp;
    String var;

    public readFile(Exp e,String v){
        exp=e;
        var=v;
    }
    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk = state.getStk();
        MyIDictionary<String, Value> symTbl = state.getSymTable();
        MyIHeap<Integer,Value> heap=state.getHeap();
        Value val = exp.eval(symTbl,heap);
        MyIFileTable<String, BufferedReader> FTabel= state.getFileTable();
        if(symTbl.isDefined(var)){
            if(symTbl.getValue(var).getType().equals(new IntType())){
                if (val.getType().equals(new BoolType())){
                    try{
                        BufferedReader br =FTabel.getValue(val.toString());
                        symTbl.update(var,new IntValue(Integer.parseInt(br.readLine())));
                    }
                    catch (Exception exc){
                        throw new MyException("file not opened");
                    }
                }
                else{
                    throw new MyException("not string type");
                }
            }
            else{
                throw new MyException("not int type");
            }
        }
        else{
            throw new MyException("variable not defined");
        }
        return state;
    }
}
