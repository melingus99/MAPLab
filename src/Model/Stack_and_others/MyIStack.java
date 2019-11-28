package Model.Stack_and_others;
import java.util.Stack;
public interface MyIStack<T>{
    //MyIStack<T> getStk();
    T pop();
    void push(T v);
    boolean isEmpty();
    T top();

}