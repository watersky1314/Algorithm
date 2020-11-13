package sort;

import java.util.Objects;

/**
 * 堆排序：完全二叉树结构，采用选择排序
 */
public class HeapSort {

	public static void checkNums(int[] nums) {
		if (Objects.isNull(nums) || nums.length == 0) {
			throw new IllegalArgumentException("数组异常");
		}
	}

	public static void heapSort(int[] nums) {
		int i = 0;
		while (i >= 0) {
			i = (nums.length >> 1) - 1;
		}
	}
}
