package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class SortTest {
    public static void main(String[] args) {
        int[] nums = new int[100000];
        Random r = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100000);
        }
//        nums = new int[]{10,9,8,7,6,5,4,3,2,1};
        System.out.println("排序前：" + Arrays.toString(nums));
        long starTime = System.currentTimeMillis();
//        BubbleSort.sort(nums);
//        SelectSort.sort(nums);
//        InsertSort.sort(nums);
		int[] copyNums  = Arrays.copyOf(nums, 100000);
		//取中点值
        QuickSort.sort(nums, 0, nums.length-1, true);
        System.out.println(QuickSort.k);
//		System.out.println("copyNums:"+Arrays.toString(copyNums));
		//取中间值
		QuickSort.sort(copyNums, 0, nums.length-1, false);
		System.out.println(QuickSort.k);
        long endTime = System.currentTimeMillis();
        System.out.println("排序后：" + Arrays.toString(nums));
        System.out.println("耗时：" + (endTime - starTime));

    }

}
