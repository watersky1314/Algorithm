package sort;

import java.util.Arrays;
import java.util.Random;

public class SortTest {
    public static void main(String[] args) {
        int[] nums = new int[10];
        Random r = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100);
        }
//        nums = new int[]{4, 9, 14, 28, 38, 39, 67, 76, 92, 95};
        System.out.println("排序前：" + Arrays.toString(nums));
        long starTime = System.currentTimeMillis();
//        BubbleSort.sort(nums);
//        SelectionSort.sort(nums);
//        InsertionSort.sort(nums);
        QuickSort.sort(nums, 0, nums.length-1);
        System.out.println(QuickSort.k);
//        QuickSort2.quickSort(nums, 0, nums.length-1);
        long endTime = System.currentTimeMillis();
        System.out.println("排序后：" + Arrays.toString(nums));
        System.out.println("耗时：" + (endTime - starTime));

    }
}
