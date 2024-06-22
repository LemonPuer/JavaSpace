package d_exer2;

import java.util.*;

/**
 * @author Lemon
 * @create 2022-09-21-10:40
 */
public class DAO<T> {
    Map<String,T> a=new HashMap<>();
    public void save(String id,T entity){
        a.put(id,entity);
    }
    public T get(String id){
        return a.get(id);
    }
    public void update(String id,T entity){
        a.replace(id,entity);
    }
    public List<T> list(){
//        List<T> l=new ArrayList<>();
//        l.addAll(a.values());
        return new ArrayList<T>(a.values());
    }
    public void delete(String id){
        a.remove(id);
    }
}
