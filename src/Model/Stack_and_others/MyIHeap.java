package Model.Stack_and_others;

import java.util.HashMap;
import java.util.Map;

public interface MyIHeap<K,V> {

    void update(K key,V val);
    V getValue(K key);
    boolean isDefined(K key);
    V lookup(K key);
    void add(K key,V val);
    int getFree();
    Map<K,V> getContent();
    void setContent(Map<K,V> map);
}