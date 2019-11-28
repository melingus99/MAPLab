package Model.Stack_and_others;
import Model.Stmt.IStmt;
import Model.Value.IntValue;
import Model.Value.Value;
import Model.Stmt.IStmt;

import java.io.BufferedReader;
import java.io.Serializable;
public class PrgState{
    MyIStack<IStmt> exeStack;
    MyIDictionary<String, Value> symTable;
    MyIList<Value> out;
    MyIFileTable<String, BufferedReader> fileTable;
    MyIHeap<Integer,Value> heap;
    //IStmt originalProgram; //optional field, but good to have
    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String,Value> symtbl,
             MyIList<Value> ot,MyIFileTable<String,BufferedReader> ft, MyIHeap<Integer,Value> hp,IStmt prg){
        exeStack=stk;
        symTable=symtbl;
        out = ot;
        fileTable=ft;
        heap=hp;
        //originalProgram=(IStmt)prg.clone();//recreate the entire original prg
        stk.push(prg);
    }
  public MyIStack<IStmt> getStk(){
        return exeStack;
  }
  public MyIDictionary<String,Value> getSymTable(){
        return symTable;
    }
    public MyIHeap<Integer,Value> getHeap(){return heap;}
    public MyIList<Value> getOut(){return out;}
    public MyIFileTable<String,BufferedReader> getFileTable(){return fileTable;}
    public void setstk(MyIStack<IStmt> stack){exeStack=stack;}
   @Override
   public String toString(){return "State of the program is:\n"+this.exeStack+this.symTable+this.out;}

}