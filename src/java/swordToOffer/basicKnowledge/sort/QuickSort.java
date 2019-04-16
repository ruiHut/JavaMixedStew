package swordToOffer.basicKnowledge.sort;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort sort = new QuickSort();

        int[] values = {1, 2, 3, 4, 1, 5, 3, 5, 6};
        sort.quickSort(values, 9, 0, 8);
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }

    private void quickSort(int[] values, int length, int start, int end) {
        if (start == end)
            return;

        int index = partition(values, length, start, end);
        if (index > start)
            quickSort(values, length, start, index - 1);
        if (index < end)
            quickSort(values, length, index + 1, end);
    }

    private int partition(int[] data, int length, int start, int end) {
        if (data == null || length <= 0 || start < 0 || end >= length)
            throw new IllegalArgumentException("输入不合法：data= " + data + " length= " + length + " start= " + start + " end= " + end);

        int index = randomInRange(start, end);
        swap(data, index, end);

        int small = start - 1;
        for (index = start; index < end; ++index) {
            if (data[index] < data[end]) {
                ++small;
                if (small != index)
                    swap(data, index, small);
            }
        }

        ++small;
        swap(data, small, end);

        return small;
    }

    private void swap(int[] data, int x, int y) {
        int tmp = data[x];
        data[x] = data[y];
        data[y] = tmp;
    }

    public int randomInRange(int start, int end) {
        return start + (int) (Math.random() * (end - start + 1));
    }
}
