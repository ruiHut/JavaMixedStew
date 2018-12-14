package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeedCode2
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-13 17:15
 **/

public class _3_没有重复字符的最长子串 {
    public static void main(String[] args) {
        String s = new String("qrsvbspk");
        Solution3 solution = new Solution3();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}

/**
 * 暴力解决第一次算法烂到超时
 * 问题： 使用 list.subList() 方法 当 重复元素过多 且元素总量很多时 算法速度爆炸慢
 */
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        List list = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));// key 为 字符串的数字 value 为子字符串长度
                if (list.size() >= result)
                    result = list.size();
            } else {
                // 重新从 包含的 key之后开始计算
                list = list.subList(list.indexOf(i) + 2, list.size());
                while (list.contains(s.charAt(i))) {
                    list = list.subList(list.indexOf(i) + 2, list.size());
                }
                list.add(s.charAt(i));
            }
        }
        return result;
    }
}

class Solution4 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        List list = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));// key 为 字符串的数字 value 为子字符串长度
                if (list.size() >= result)
                    result = list.size();
            } else {
                // 重新从 包含的 key之后开始计算
                list = list.subList(list.indexOf(i) + 2, list.size());
                while (list.contains(s.charAt(i))) {
                    list = list.subList(list.indexOf(i) + 2, list.size());
                }
                list.add(s.charAt(i));
            }
        }
        return result;
    }
}