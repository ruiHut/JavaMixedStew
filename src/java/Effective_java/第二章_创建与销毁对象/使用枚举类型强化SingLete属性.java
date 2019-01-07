package Effective_java.第二章_创建与销毁对象;

import java.io.Serializable;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-07 21:33
 **/

public class 使用枚举类型强化SingLete属性 {
    public static void main(String[] args) {
    }
}

class Singleton {
    private static final Singleton SINGLETON = new Singleton();
    private Singleton(){}
}

enum Elivs implements Serializable {
    SINGLETON;
    private String username;
    public String getUsername(){
        return username;
    }

    public void setUsername(String val){
        this.username = val;
    }
}