package 设计模式.单例模式;


/**
 * @program: java_
 * @description: 单例模式简单实现
 * @author: Mr.Zhou
 * @create: 2018-12-04 18:42
 **/

public class SingelDome {

    // 先声明一个对象 ， 并持有一个对象
    private static SingelDome singelDome;

    // 1. 私有化构造函数
    private SingelDome(){
        this.singelDome =new SingelDome();
    }

    // 2. 获取对象 , 加锁 且设为static
    public static synchronized SingelDome getInstance(){
        return singelDome;
    }

    public void Show(){
        System.out.println("this is singelDome");
    }
}

class Dome{
    public static void main(String[] args) {
        SingelDome singelDome1 = SingelDome.getInstance();
        singelDome1.Show();
        SingelDome singelDome2 = SingelDome.getInstance();
        if (singelDome1.getClass() == singelDome2.getClass())
            System.out.println("引用指定同一个对象");
        if (singelDome1.equals(singelDome2)){
            System.out.println("引用为两个引用");
        }else
            System.out.println("这不是单例");
    }
}
