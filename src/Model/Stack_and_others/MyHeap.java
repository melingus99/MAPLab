package Model.Stack_and_others;

import Model.Value.IntValue;

import java.util.HashMap;
import java.util.Map;

public class MyHeap<K,V> implements MyIHeap<K,V>{
    Map<K,V> heap=new HashMap<K, V>();
    int index=0;

    public void update(K key,V val){
        heap.remove(key);
        heap.put(key,val);
    }

    public V getValue(K key){
        return heap.get(key);
    }

    public boolean isDefined(K key){
        return heap.containsKey(key);
    }

    public V lookup(K key){
        return heap.get(key);
    }
    public void add(K key,V val){index++;heap.put(key,val);};

    public int getFree(){return index;}

    @Override
    public String toString(){
        return "\t"+"symtbl is: "+heap+"\n";
    }

    public Map<K,V> getContent(){
        return heap;
    }
    public void setContent(Map<K,V> map){
        heap=map;
    }
}
