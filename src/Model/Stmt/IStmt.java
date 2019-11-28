package Model.Stmt;
import Model.Stack_and_others.PrgState;
import Exception.MyException;
public interface IStmt{
    PrgState execute(PrgState state) throws MyException;
    //which is the execution method for a statement.
}