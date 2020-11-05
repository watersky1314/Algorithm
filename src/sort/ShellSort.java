package sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 希尔排序：也称为“缩小增量排序”，其基本思想是将数组元素分解为多个子列表，每个列表进行直接插入排序
 */
public class ShellSort {

	public static void checkNums(int[] nums) {
		if (Objects.isNull(nums) || nums.length == 0) {
			throw new IllegalArgumentException("数组异常");
		}
	}

	public static void shellSort(int[] nums) {
		int N = nums.length;
		// 进行分组，最开始的增量(gap)为数组长度的一半
		for (int gap = N / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < N; i++) {
				int t = nums[i];
				int j;
				for (j = i - 1; j >= 0 && nums[j] >= t; j--) {
					nums[j + 1] = nums[j];
				}
				nums[j + 1] = t;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = {5, 7, 8, 3, 1, 2, 4, 6, 3, 3};
		checkNums(nums);
		System.out.println("排序前的数组：" + Arrays.toString(nums));
		shellSort(nums);
		System.out.println("排序后的数组：" + Arrays.toString(nums));
	}
}
