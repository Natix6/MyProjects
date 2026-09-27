import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Repository<T extends Identifiable> {

    Map<Integer, T> map = new HashMap<>();

    public void add(T item) {
        map.put(item.getId(), item);
    }

    public T get(int id) {
        return map.get(id);
    }

    public boolean contains(int id) {
        return map.containsKey(id);
    }

    public Map<Integer, T> getAll() {
        return Collections.unmodifiableMap(map); 
    }

    public Set<Integer> getKeys() {
        return map.keySet();
    }

    public void remove(int key) {
        map.remove(key);
    }


    
}
