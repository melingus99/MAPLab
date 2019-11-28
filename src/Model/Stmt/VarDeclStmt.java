package Model.Stmt;
import Model.Stack_and_others.MyIDictionary;
import Model.Stack_and_others.MyIStack;
import Model.Stack_and_others.PrgState;
import Model.Type.*;
import Exception.MyException;
import Model.Value.*;

public class VarDeclStmt implements IStmt {
    String name;
    Type typ;

    public VarDeclStmt(String name, Type type) {
        this.name = name;
        typ = type;
    }

    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk = state.getStk();
        MyIDictionary<String, Value> symtbl = state.getSymTable();
        if (!symtbl.isDefined(name)) {
            if (typ.equals(new IntType())) {
                Value val = new IntValue(0);
                symtbl.add(name, val);
            } else if(typ.equals(new BoolType())){
                Value val = new BoolValue(false);
                symtbl.add(name, val);
            }
            else if(typ.equals(new StringType())){
                Value val= new StringValue("");
                symtbl.add(name,val);
            }
            else {
                Value val=new RefValue(0,typ);
                symtbl.add(name,val);
            }
        } else {
            throw new MyException("variable already declared");
        }
        return state;
    }
    @Override
    public String toString(){
        if (typ.equals(new IntType())) {
            return "int" + name;
        }
        else if(typ.equals(new BoolType())){
            return"bool"+name;
            }
        else{
            return "string "+name;
        }
    }
}