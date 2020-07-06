package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class SortTest {
    public static void main(String[] args) {
        int[] nums = new int[10];
        Random r = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100);
        }
        nums = new int[]{54, 50, 59, 60, 88, 53, 64, 76, 88, 17};
        System.out.println("排序前：" + Arrays.toString(nums));
        long starTime = System.currentTimeMillis();
//        BubbleSort.sort(nums);
//        SelectSort.sort(nums);
        InsertSort.sort(nums);
//        QuickSort.sort(nums, 0, nums.length-1);
//        System.out.println(QuickSort.k);
        long endTime = System.currentTimeMillis();
        System.out.println("排序后：" + Arrays.toString(nums));
        System.out.println("耗时：" + (endTime - starTime));

    }
}
