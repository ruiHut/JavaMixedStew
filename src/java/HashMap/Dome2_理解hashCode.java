package HashMap;

import java.util.*;

/**
 * @program: java_
 * @description: 解释hash数据结构作用
 * @author: Mr.Zhou
 * @create: 2018-12-12 22:40
 **/

public class Dome2_理解hashCode {
    public static void main(String[] args) {

    }
}

/**
 * 利用数组实现key 与 values 的对应关系可以通过 key 轻松找到value
 * 实现原理 使用两个list数组分别存放key 和 value 且同一组key和value之间索引相同
 *
 * @param <K>
 * @param <V>
 */

class SlowMap<K, V> extends AbstractMap<K, V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    /**
     * 新增映射
     *
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value) {
        V oldValue = get(key);
        if (!keys.contains(key)) {
            // 新增一组 key - value
            keys.add(key);
            values.add(value);
        } else {
            values.set(values.indexOf(oldValue), value); // 将重复添加的key对应的values进行修改。
        }
        return oldValue; // 将删除value 返回
    }

    /**
     * 根据key 得到value
     *
     * @return
     */
    public V get(Object key) {    //*** key‘s type is object not K ***
        if (!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> Vi = values.iterator();
//        while (ki.hasNext())
//            set.add(new Map.Entry<K ,V>(ki.next() ,Vi.next()));

        return set;
    }
}
