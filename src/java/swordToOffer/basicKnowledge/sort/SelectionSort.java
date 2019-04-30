package swordToOffer.basicKnowledge.sort;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();

        int[] arr = new int[]{1, 2, 5, 5, 3, 6, 2};
        int[] res = s.selectionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int key = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[key] > arr[j])
                    key = j;
            }
            swap(arr, i, key);
        }

        return arr;
    }


    private void swap(int[] arr, int i, int key) {
        int temp = arr[i];
        arr[i] = temp;
        arr[key] = temp;
    }
}
