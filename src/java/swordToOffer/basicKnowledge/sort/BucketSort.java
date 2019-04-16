package swordToOffer.basicKnowledge.sort;

// 桶排序
// 需要额外的空间，且需要初始构建好桶集合
// 面对大量的数据，且数据存在默认范围的特点。例如年龄
public class BucketSort {
    public static void main(String[] args) {
        BucketSort b = new BucketSort();
        int[] values = {1, 2, 4, 5, 56, 76, 54, 21};
        b.ageSort(values);
    }

    private void ageSort(int[] values) {
        int len = values.length;

        // init age bucket
        int[] ageBucket = new int[99];
        for (int i = 0; i < ageBucket.length; i++) {
            ageBucket[i] = 0;
        }

        int low = ageBucket[0];
        int high = ageBucket[ageBucket.length -1];

        for (int i = 0; i < values.length; i++) {
            if (values[i] < low || values[i] > high)
                throw new RuntimeException("超出排序范围, value = " + values[i]);

            ++ageBucket[values[i]];
        }

        int index = 0;
        for (int i = 0; i < ageBucket.length; i++) {
            while (ageBucket[i] != 0) {
                values[index++] = ageBucket[i];
            }
        }
    }
}
