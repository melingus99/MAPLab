package Model.Expressions;
import Model.Value.*;
import Exception.MyException;
import Model.Type.*;
import Model.Stack_and_others.*;
public class ArithExp implements Exp{
    Exp e1;
    Exp e2;
    int op; //1-plus, 2-minus, 3-star, 4-divide

    public ArithExp(String op,Exp e1,Exp e2){
        this.e1=e1;
        this.e2=e2;
        if(op=="+"){
            this.op=1;
        }
        else if(op=="-"){
            this.op=2;
        }
        else if(op=="*"){
            this.op=3;
        }
        else{
            this.op=4;
        }
    }

    public Value eval(MyIDictionary<String,Value> tbl,MyIHeap<Integer,Value> heap) throws MyException{
        int n11=0,n22=0;
        Value v1,v2;
        v1= e1.eval(tbl,heap);
        if (v1.getType().equals(new IntType())) {
            v2 = e2.eval(tbl,heap);
            if (v2.getType().equals(new IntType())) {
                IntValue i1 = (IntValue)v1;
                IntValue i2 = (IntValue)v2;
                int n1,n2;
                n1= i1.getVal();
                n2 = i2.getVal();
                if (op==1) return new IntValue(n1+n2);
                if (op ==2) return new IntValue(n1-n2);
                if(op==3) return new IntValue(n1*n2);
                if(op==4)
                    if(n2==0) throw new MyException("division by zero");
                    else return new IntValue(n1/n2);
            }else
                throw new MyException("second operand is not an integer");
        }else
            throw new MyException("first operand is not an integer");
        return new IntValue(n11+n22);
    }
    @Override
    public String toString(){
        if(this.op==1){
            return e1.toString()+"+"+e2.toString();
        }
        if(this.op==2){
            return e1.toString()+"-"+e2.toString();
        }
        if(this.op==3){
            return e1.toString()+"*"+e2.toString();
        }
        if(this.op==4){
            return e1.toString()+"/"+e2.toString();
        }
        return null;
    }
}
