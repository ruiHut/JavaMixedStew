package 设计模式.单例模式;


/**
 * @program: java_
 * @description: 单例模式简单实现 懒加载 线程安全
 *              问题： 并不高效--》
 *              原因 ：在任何时候只能有一个线程调用 getInstance() 方法。但是同步操作只需要在第一次调用时才被需要，即第一次创建单例实例对象时
 *              。这就引出了双重检验锁
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

/**
 * 双重检查加锁 ， 线程安全
 * 双重检验加锁模式（double checked locking pattern），是一种使用同步块加锁的方法。程序员称其为双重检查锁，因为会有两次检查 uniqueInstance == null，一次是在同步块外，一次是在同步块内。为什么在同步块内还要再检验一次？
 *              因为可能会有多个线程一起进入同步块外的 if，如果在同步块内不进行二次检验的话就会生成多个实例了。
 *      问题 ： uniqueInstance = new Singleton()这句，这并非是一个原子操作
 *          事实上在 JVM 中这句话大概做了下面 3 件事情。
 *          1. 给 doubleCLDome 分配内存
 *          2. 调用 DoubleCLDome 的构造函数来初始化成员变量
 *          3. 将doubleCLDome对象指向分配的内存空间（执行完这步 uniqueInstance 就为非 null 了）
 *          但是在 JVM 的即时编译器中存在指令重排序的优化。
 *          也就是说上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3 也可能是 1-3-2。
 *          如果是后者，则在 3 执行完毕、2 未执行之前，被线程二抢占了，这时uniqueInstance已经是非 null 了（但却没有初始化），
 *          所以线程二会直接返回 uniqueInstance，然后使用，然后顺理成章地报错。
 *       解决方案:
 *          我们只需要将 uniqueInstance 变量声明成 volatile 就可以了。
 *  有些人认为使用 volatile 的原因是可见性，也就是可以保证线程在本地不会存有 uniqueInstance 的副本，每次都是去主内存中读取。
 *  但其实是不对的。使用 volatile 的主要原因是其另一个特性：禁止指令重排序优化。也就是说，在 volatile 变量的赋值操作后面会有一个内存屏障（生成的汇编代码上），读操作不会被重排序到内存屏障之前。
 *  比如上面的例子，取操作必须在执行完 1-2-3 之后或者 1-3-2 之后，不存在执行到 1-3 然后取到值的情况。
 *  从「先行发生原则」的角度理解的话，就是对于一个 volatile 变量的写操作都先行发生于后面对这个变量的读操作（这里的“后面”是时间上的先后顺序）。
 */

class DoubleCLDome{
    private static volatile DoubleCLDome doubleCLDome;  // 声明为volatile
    private DoubleCLDome(){

    }

    public static DoubleCLDome getInstance(){
        if (doubleCLDome == null){
            synchronized (DoubleCLDome.class){
                if (doubleCLDome == null){
                    doubleCLDome = new DoubleCLDome();
                }
            }
        }
        return doubleCLDome;
    }
}

/**
 * 急加载 static final field 线程安全
 * 这种方法非常简单，因为单例的实例被声明成 static 和 final 变量了，在第一次加载类到内存中时就会初始化，所以创建实例本身是线程安全的。
 * 这种写法如果完美的话，就没必要在啰嗦那么多双检锁的问题了。
 * 缺点是它不是一种懒加载模式（lazy initialization），单例会在加载类后一开始就被初始化，即使客户端没有调用 getInstance()方法。
 * 饿汉式的创建方式在一些场景中将无法使用：譬如 Singleton 实例的创建是依赖参数或者配置文件的，在 getInstance() 之前必须调用某个方法设置参数给它，那样这种单例写法就无法使用了。
 */

class Singleton{
    //类加载时就初始化
    private static final Singleton uniqueInstance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return uniqueInstance;
    }
}

/**
 * 静态内部类 static nested class 线程安全
 *
 *
 这种写法仍然使用JVM本身机制保证了线程安全问题；由于 SingletonHolder 是私有的，
 除了 getInstance() 之外没有办法访问它，因此它是懒加载的；同时读取实例的时候不会进行同步，没有性能缺陷；也不依赖 JDK 版本。
 */
class SingletonByStaticClass {
     private static class SingletonHolder {
         private static final SingletonByStaticClass uniqueInstance = new SingletonByStaticClass();
     }

     public static final SingletonByStaticClass getInstance() {
         return SingletonHolder.uniqueInstance;
     }
}

/**
 * 总结 ：一般情况下直接使用急加载就好了，如果明确要求要懒加载（lazy initialization）会倾向于使用静态内部类，
 * 如果涉及到反序列化创建对象时会试着使用枚举的方式来实现单例。
 */
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
