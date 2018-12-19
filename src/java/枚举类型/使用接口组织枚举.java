package 枚举类型;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-19 14:14
 **/

  interface Foods {
   enum Appetizer implements Foods{
       SALAD , SOUP ;
   }
    enum MainCourse implements Foods{
        SALAD , SOUP ;
    }

}

enum  Dome3 {
      APPEJIZER(Foods.Appetizer.class);

      private Foods[] value;
    Dome3(Class<Foods.Appetizer> appetizerClass) {
        value =appetizerClass.getEnumConstants();
    }
    public Foods randomSelection() {
        return Enums.random(value);
    }
}
/**
 * 想用enum来表示不同类别的食物 ，同时还希望每个enum元素仍然保持Food类型
 */
public class 使用接口组织枚举 {
    public static void main(String[] args) {
        Foods food = Foods.Appetizer.SALAD;
        food = Foods.MainCourse.SALAD;
    }
}
