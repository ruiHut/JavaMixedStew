package jdk1_8新特性.Lambda表达式;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @program: java_
 * @description: 删除容器中的数据
 * @author: Mr.Zhou
 * @create: 2018-12-03 19:13
 **/

public class Lambda表达式实例删除容器中的数据 {
    public static void main(String[] args) {
        // 创建一个容器
        List<String>  list= Arrays.asList("hello" , "world", "!");
        // 直接使用Arrays创建的list 没有 ArrayList中很多方法直接调用 报UnsupportedOperationException错误
        List<String> lists = new ArrayList<>();
        for (String s :
                Arrays.asList("hello" , "world", "!" ,"nothing leave")) {
            lists.add(s);
        }

        /**
         * 使用迭代器删除
         */
        Iterator<String> it =  lists.iterator();
        while (it.hasNext()){
            String res = it.next();
            if (res.equals("hello"))
                it.remove();
        }

        /**
         * 使用removeIf 删除
         */
        lists.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("world");
            }
        });

        /**
         * 使用lambdl 表达式
         */
        lists.removeIf((player)->player.equals("!"));

        for (String s :
                lists) {
            System.out.println(lists);
        }
    }
}
