package Model.Stack_and_others;
import Model.Stmt.IStmt;
import java.util.Stack;

public class MyStack<T> implements MyIStack<T>{
    Stack<T> stack=new Stack<T>(); //a field whose type CollectionType is an appropriate
    // generic java library collection

    public T top(){
        return stack.firstElement();
    }
    public T pop(){
        T someT=stack.pop();
        return someT;
    }
    public void push(T v){
        stack.push(v);
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    @Override
    public String toString() {
        if (stack.empty()) {
            return "\t stack is empty"+"\n";
        } else {
            return "\t"+"stack is:" + stack+"\n";
        }
    }
}