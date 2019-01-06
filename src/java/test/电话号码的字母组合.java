package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-21 13:33
 **/

public class 电话号码的字母组合 {
    public static void main(String[] args) {
        String s = "2455";
        Solution2 solution2 = new Solution2();
        solution2.letterCombinations(s);
    }
}

class Solution2 {
    public List<String> letterCombinations(String digits) {
        String[] s = {"a_b_c" , "d_e_f" , "g_h_i" , "j_k_l" , "m_n_o" , "p_q_r_s" , "t_u_v" , "w_x_y_z"};
        List<String> list = Arrays.asList(s);
        char[] chars = digits.toCharArray();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < chars.length-1; i++) {
                String[] tmp = (list.get(Integer.parseInt(""+chars[i]) - 2)).split("_");
                List<String> tmpl  = Arrays.asList(tmp);
                res.addAll(tmpl);
        }
        System.out.println(res);
        return res;
    }
}