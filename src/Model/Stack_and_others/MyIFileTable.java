package Model.Stack_and_others;

public interface MyIFileTable<K,V> {

    void update(K key,V val);
    V getValue(K key);
    boolean isDefined(K key);
    V lookup(K key);
    void add(K key,V val);
    void delete(K key);

}
