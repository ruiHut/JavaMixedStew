package swordToOffer.basicKnowledge.sort;

public class InsertSort {
    
    public static void main(String[] args) {
        InsertSort s = new InsertSort();

        int[] values = new int[]{1, 2, 3, 2, 6, 7, 2};
        s.insertSort(values);
    }

    private void insertSort(int[] values) {
        if (values == null || values.length == 0)
            throw new RuntimeException("输入为空！");

        if (values.length == 1)
            return;

        for (int i = 1; i < values.length; i++) {
            int key = values[i];
            int j = i - 1;
            while (j >= 0 && values[j] > key) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = key;
        }
        
        return;

    }
}
