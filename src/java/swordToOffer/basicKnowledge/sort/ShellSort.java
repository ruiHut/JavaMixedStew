package swordToOffer.basicKnowledge.sort;

// 1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。
// 它与插入排序的不同之处在于，它会优先比较距离较远的元素.
// 希尔排序又叫缩小增量排序。
// 希尔排序是基于插入排序的以下两点性质而提出改进方法的：
//      插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率
//      但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位
public class ShellSort {
    public static void main(String[] args) {
        ShellSort s = new ShellSort();

        int[] arr = new int[]{1, 2, 4, 5, 78, 2, 3, 4};

        int[] res = s.shellSort(arr);
    }

    private int[] shellSort(int[] arr) {
        if (arr.length == 0)
            throw new IllegalArgumentException("ShellSort shellSort is failed array length equal 0!");

        if (arr.length == 1)
            return arr;


        for (int gap = arr.length >> 1; gap > 0; gap >>= 1) {
            for (int i = gap; i < arr.length; i++) {
                int key = arr[i];
                int j = i - gap;
                for (; j >= 0 && arr[j] > key; j -= gap) {
                    arr[j - gap] = arr[j];
                }
                arr[j + gap] = key;
            }
        }

        return arr;
    }
}
