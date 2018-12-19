package 枚举类型;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-19 14:42
 **/


enum  Dome4 {
    APPEJIZER(Foods.Appetizer.class);

    private Foods[] value;
    Dome4(Class<Foods.Appetizer> appetizerClass) {
        value =appetizerClass.getEnumConstants();
    }
    public Foods randomSelection() {
        return Enums.random(value);
    }
}

/**
 * 当需要和一大堆类型打交道时，接口就不如enum好用了
 */
public class 使用枚举组织枚举类型 {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            for (Dome4 dome4 :
                    Dome4.values()) {
                Foods foods = dome4.randomSelection();
                System.out.println(foods); //SOUP SALA
            }
        }
    }
}
