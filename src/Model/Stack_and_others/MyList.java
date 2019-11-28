package Model.Stack_and_others;
import java.util.ArrayList;
import java.util.List;
public class MyList<T> implements MyIList<T> {
    ArrayList<T> out= new ArrayList<T>();

    @Override
    public String toString(){
        return"\t list is:"+out+"\n";
    }
    @Override
    public void add(T val){
        out.add(val);
    }
}
