package Model.Stack_and_others;

import java.util.HashMap;
import java.util.Map;

public class MyFileTable<K,V> implements MyIFileTable<K,V> {
    Map<K,V> dic=new HashMap<K, V>();

    public boolean isDefined(K key){
        return dic.containsKey(key);
    }
    public void update(K key,V val){
        dic.remove(key);
        dic.put(key,val);
    }

    public V getValue(K key){
        return dic.get(key);
    }

    public V lookup(K key){
        return dic.get(key);
    }

    public void add(K key, V val){
        dic.put(key,val);
    }
    @Override
    public String toString(){
        return "\t"+"filetbl is: "+dic+"\n";
    }
    public void delete(K key){ dic.remove(key);}
}
