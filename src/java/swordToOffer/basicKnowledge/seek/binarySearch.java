package swordToOffer.basicKnowledge.seek;

// 二分查找
// 元素必须有序，如果无序先排序
// 最坏情况下，关键词比较次数 log2（n+1), 且期望时间复杂度为 O(log2N)
//
//   折半查找的前提条件是需要有序表顺序存储，对于静态查找表，一次排序后不再变化，折半查找能得到不错的效率。
// 但对于需要频繁执行插入或删除操作的数据集来说，维护有序的排序会带来不小的工作量，那就不建议使用。
// 折半查找的前提条件是需要有序表顺序存储，对于静态查找表，一次排序后不再变化，折半查找能得到不错的效率。
// 但对于需要频繁执行插入或删除操作的数据集来说，维护有序的排序会带来不小的工作量，那就不建议使用。
public class binarySearch {
    public static void main(String[] args) {
        binarySearch s = new binarySearch();
        int[] values = {1, 2, 4, 5, 6, 7, 8, 8, 9};
        System.out.println(s.search1(values, 8, 0, 8));
    }


    // 二分查找 循环
    // low, high 决定查找
    public int search1(int[] data, int target, int low,  int high) {
        if (data.length == 0)
            throw new IllegalArgumentException("输入长度为0，data" + data);
        if (low > high || data.length - 1 < high)
            throw new IllegalArgumentException("输入区间不合法, data.length = " + data.length + " low =" + low + " high=" + high);

        while (low <= high) {
            int midIndex = low + high >> 1;

            if (target < data[midIndex])
                high = midIndex - 1;
            if (target == data[midIndex])
                return midIndex;
            if (target > data[midIndex])
                low = midIndex + 1;
        }

        return -1;
    }
}
