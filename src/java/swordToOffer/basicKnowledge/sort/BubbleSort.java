package swordToOffer.basicKnowledge.sort;

public class BubbleSort {
    private void swap(int[] values, int i, int j) {
        int temp = values[j];
        values[j] =  values[i];
        values[i] = temp;

    }

    private void bubbleSort(int[] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - 1; j++) {
                if (values[j] > values[j + 1])
                    swap(values, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();
        int[] values = new int[]{1, 2, 4, 5, 2, 4};
        b.bubbleSort(values);

        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }
}
