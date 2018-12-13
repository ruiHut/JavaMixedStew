package HashMap;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-13 09:48
 **/

public class Dome3_为速度而散列 {
    public static void main(String[] args) {

    }
}
/**
 * 鉴于dome2中SlowMap  所以我们为了提高速度会选择HashCode来实现Map映射。
 *线性查询是最慢的查询方式
 * 散列的意义在于速度 瓶颈在于对键的查询
 *      方案一 : 保持键的排序状态，然后使用Collections.binarySearch()（二分搜索数） 进行查询
 *      方案二 : 使用散列
 *                  实现过程 : 通过键对象生成一个数字 ，将其作为数组的下标 ，这个数字就是hashcode，
 *                      由定义在Object中的，且可能由你的类覆盖的hashCode()方法生成。（数学中叫做散列函数）
 *
 *                      tips：为啦解决数组容量固定的问题，不同的键可能产生相同的下标。因此数组多大就不重要了 ，任何键都可以找到它的位置
 *
 *      使用散列码查询一个值的过程：
 *              首先计算散列码
 *              ---》使用散列码查询数组（数组不直接保存数值，因为不同对象可能产生相同数组下标，数组保存值的list）
 *              --》对索引处的list使用equals（）方法进行线性查询
 *      这也就是为什么散列速度如此快的原因
 */

/**
 *  理解了散列的原因---》自己实现一个简单的散列Map
 */

class SimpleHashMap<K , V> extends AbstractMap<K , V>{

    static final int SIZE = 997;

    @SuppressWarnings("unchecked")
    LinkedList<Map.Entry<K , V>>[] buckets = new LinkedList[SIZE];

    public V put(K key ,V value){
        V oldValue = null;
        int index=  Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] == new LinkedList<Entry<K, V>>();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}