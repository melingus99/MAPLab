package Repository;
import Model.Stack_and_others.PrgState;
import Exception.MyException;
public interface MyIRepo {
    PrgState getCrtPrg();
    void logPrgStateExec() throws MyException;
    void addRepo(PrgState state);

}
