package Repository;
import Model.Expressions.ArithExp;
import Model.Expressions.ValueExp;
import Model.Expressions.VarExp;
import Model.Stack_and_others.*;
import Model.Stmt.*;
import Model.Type.BoolType;
import Model.Type.IntType;
import Model.Value.BoolValue;
import Model.Value.IntValue;
import Model.Value.Value;
import Exception.MyException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class MyRepo {
    PrgState repo;
    int length;
    String logFilePath;
    PrintWriter logFile;

    public void addRepo(PrgState state){
        repo=state;
        length++;
    }
    public MyRepo(PrgState state,String path) throws MyException{
        repo=state;
        length=0;
        logFilePath=path;

    }
    public PrgState getCrtPrg(){
        return repo;
    }
    public void logPrgStateExec() throws MyException {
        try{
            logFile= new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
            logFile.print(repo.toString());
            logFile.close();
        }
        catch (Exception exc){
            throw new MyException("file does not exists");
        }
    }

    @Override
    public String toString(){return repo.toString();}
}
