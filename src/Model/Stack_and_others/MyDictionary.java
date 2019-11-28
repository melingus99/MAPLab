package Model.Stack_and_others;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class MyDictionary<K,V> implements MyIDictionary<K,V>{
    Map<K,V> dic=new HashMap<K, V>();

    public void update(K key,V val){
        dic.remove(key);
        dic.put(key,val);
    }

    public V getValue(K key){
        return dic.get(key);
    }

    public boolean isDefined(K key){
        return dic.containsKey(key);
        }

        public V lookup(K key){
        return dic.get(key);
        }
        public void add(K key, V val){
        dic.put(key,val);
        }
        @Override
    public String toString(){
        return "\t"+"symtbl is: "+dic+"\n";
        }

        public Map<K,V> getContent(){
        return dic;
        }
}
