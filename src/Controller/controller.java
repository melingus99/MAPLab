package Controller;

import Model.Stack_and_others.*;
import Model.Stmt.*;
import Exception.MyException;
import Model.Value.RefValue;
import Model.Value.Value;
import Repository.MyRepo;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class controller{
    MyRepo repo;
    Map<Integer,Value> unsafeGarbageCollector(List<Integer> symTableAddr, Map<Integer,Value>
            heap){
        return heap.entrySet().stream()
                .filter(e->symTableAddr.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));}
    List<Integer> getAddrFromSymTable(Collection<Value> symTableValues){
        return symTableValues.stream()
                .filter(v-> v instanceof RefValue)
                .map(v-> {RefValue v1 = (RefValue)v; return v1.getAddr();})
                .collect(Collectors.toList());
    }
    public controller(MyRepo somerepo){
        repo=somerepo;
    }
    public void addRepo(PrgState state){repo.addRepo(state);}
    public PrgState oneStep(PrgState state) throws MyException {
        MyIStack<IStmt> stk=state.getStk();
        if(stk.isEmpty()) {
            //throws new MyException("prgstate stack is empty");

        }
        IStmt crtStmt = stk.pop();

        return crtStmt.execute(state);
    }
    public void allStep() throws MyException{
        PrgState prg = repo.getCrtPrg();
        repo.logPrgStateExec();
        while (!prg.getStk().isEmpty()){
            oneStep(prg);
            repo.logPrgStateExec();
            prg.getHeap().setContent(unsafeGarbageCollector(
                    getAddrFromSymTable(prg.getSymTable().getContent().values()),
                    prg.getHeap().getContent()));

        }}

}
