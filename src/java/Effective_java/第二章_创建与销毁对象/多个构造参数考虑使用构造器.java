package Effective_java.第二章_创建与销毁对象;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-07 20:40
 **/

public class 多个构造参数考虑使用构造器 {
    public static void main(String[] args) {
        User.Builder builder = new User.Builder(1, "jim", "123456")
                .age(15)
                .remark("is good boy");
        User user = new User(builder);
        user.doLogin();
    }
}

/**
 * 当拥有多个参数时，我们可有如下方式创建对象
 * 1. 多重构造方法， 对每一种可能需要实现的对象初始化进行添加构造方法实现
 * 2. javaBeans, setting 方法
 * 3. 构造器 Builder模式 + 链式构造
 */

class User {
    // 必要参数
    private final int id;
    private final String userName;
    private final String password;
    // 可选参数
    private final int age;
    private final String remark;

    public User(Builder builder) {
        id = builder.id;
        userName = builder.userName;
        password = builder.password;
        age = builder.age;
        remark = builder.remark;
    }

    public static class Builder implements javafx.util.Builder<User> {
        private final int id;
        private final String userName;
        private final String password;

        // 可选参数 设置默认大小
        private int age = 0;
        private String remark = "";

        public Builder(int id, String userName, String password) {
            this.id = id;
            this.userName = userName;
            this.password = password;
        }

        public Builder age(int val) {
            age = val;
            return this;
        }

        public Builder remark(String val) {
            remark = val;
            return this;
        }

        @Override
        public User build() {
            // 对可选参数增加验证
            if (age < 10)
                throw new IllegalStateException("age must > 10");
            return new User(this);
        }
    }

    public void doLogin(){
        if (userName == "jim" && password == "123456")
            System.out.println("登录成功");
        else
            System.out.println("用户名或密码不正确");
    }

}
