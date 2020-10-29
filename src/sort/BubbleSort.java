package sort;

import java.util.Objects;

/**
 * 冒泡排序：
 * 外层循环控制排序轮数，内层循环控制调换位置，最大排序次数n*(n-1)/2,因此时间复杂度O(n^2)，经过每一轮循环将最大数放在最后一个位置。
 * 优化方案：如果数组已经排序好了，最少需要经过n-1次比较，因此加上控制开关语句如下进行优化
 */
public class BubbleSort {

	public static void sort(int[] nums) {
		if (Objects.isNull(nums) || nums.length == 0) {
			return;
		}
		int k = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			boolean flag = true;
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					int t = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = t;
					flag = false;
				}
				k++;
			}

			if (flag) break;
		}
		System.out.println("最终排序的次数:" + k);
	}

	public static void bubbleSort(int[] nums, int n) {
		if (Objects.isNull(nums) || nums.length == 0) return;
		if (n == 1) return;
		boolean flag = true;
		for (int i = 0; i < n - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				int t = nums[i+1];
				nums[i+1] = nums[i];
				nums[i] = t;
				flag = false;
			}
		}
		if(flag) return;
		bubbleSort(nums, n-1);
	}
}
