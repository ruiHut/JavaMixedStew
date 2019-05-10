package swordToOffer.basicKnowledge.sort;

/*
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 将已有序的子序列合并，得到完全有序的序列；
 * 即先使每个子序列有序，再使子序列段间有序。
 * 若将两个有序表合并成一个有序表，称为2-路归并。
 *
 * 时间复杂度 O（nlogn）
 * 空间复杂度 O（n）
 * 具有稳定性
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort sort = new MergeSort();

        int[] arr = new int[]{1, 2, 2, 4, 1, 6, 9, 1};
        sort.mergeSort(arr);

        for (int re : arr) {
            System.out.println(re);
        }
    }

    private void mergeSort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];

        mergeSortRecursive(arr, result, 0, len - 1);
        mergeSortIteration(arr);
    }

    private void mergeSortIteration(int[] arr) {
        int[] orderedArr = new int[arr.length];
        for (int i = 2; i < arr.length * 2; i *= 2) {
            for (int j = 0; j < (arr.length + i - 1) / i; j++) {
                int left = i * j;
                int mid = left + i / 2 >= arr.length ? (arr.length - 1) : (left + i / 2);
                int right = i * (j + 1) - 1 >= arr.length ? (arr.length - 1) : (i * (j + 1) - 1);
                int start = left, l = left, m = mid;
                while (l < mid && m <= right) {
                    if (arr[l] < arr[m]) {
                        orderedArr[start++] = arr[l++];
                    } else {
                        orderedArr[start++] = arr[m++];
                    }
                }
                while (l < mid)
                    orderedArr[start++] = arr[l++];
                while (m <= right)
                    orderedArr[start++] = arr[m++];
                System.arraycopy(orderedArr, left, arr, left, right - left + 1);

            }
        }
    }

    private void mergeSortRecursive(int[] arr, int[] result, int begin, int over) {
        // 递归终止条件
        if (begin >= over)
            return;

        int len = over - begin;
        int mid = (len >> 1) + begin;

        // redundant element 非必须定义元素
        int begin1 = begin, over1 = mid;
        int begin2 = mid + 1, over2 = over;

        mergeSortRecursive(arr, result, begin1, over1);
        mergeSortRecursive(arr, result, begin2, over2);

        int k = begin;
        while (begin1 <= over1 && begin2 <= over2)
            result[k++] = arr[begin1] < arr[begin2] ? arr[begin1++] : arr[begin2++];
        while (begin1 <= over1)
            result[k++] = arr[begin1++];
        while (begin2 <= over2)
            result[k++] = arr[begin2++];
        for (k = begin; k <= over; k++) {
            arr[k] = result[k];
        }
    }
}
