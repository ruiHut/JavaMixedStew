package swordToOffer.basicKnowledge.sort;

public class InsertSort {
    
    public static void main(String[] args) {
        InsertSort s = new InsertSort();

        int[] values = new int[]{1, 2, 3, 2, 6, 7, 2};
        s.insertSort2(values);
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }

    private void insertSort(int[] values) {
        if (values == null || values.length == 0)
            throw new RuntimeException("输入为空！");

        if (values.length == 1)
            return;

        for (int i = 1; i < values.length; i++) {
            // 保留key 找到该值插入位置后插入
            int key = values[i];
            int j = i - 1;
            while (j >= 0 && values[j] > key) {
                values[j + 1] = values[j];
                j--;
            }
            // 如果没有进入while 说明 以排序完成只需将key插入即可
            // 如果进入while 当while结束后 即将key插入value[j + 1] 即最后一个后移位置
            values[j + 1] = key;
        }
        
        return;

    }

    private void insertSort2(int[] values) {
        if (values == null || values.length == 0)
            throw new RuntimeException("输入为空！");

        if (values.length == 1)
            return;

        for (int i = 1; i < values.length; i++) {

            int key = values[i];
            int j = i - 1;
            for (; j >= 0  && values[j] > key; j--) {
                values[j + 1] = values[j];
            }

            values[j + 1] = key;
        }
    }
}
