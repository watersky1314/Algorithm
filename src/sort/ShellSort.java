package sort;

import java.util.Arrays;
import java.util.Objects;

public class ShellSort {

	public static void shellSort(int[] nums) {
		if (Objects.isNull(nums)) {
			throw new IllegalArgumentException("数组异常");
		}
		if (nums.length == 0 || nums.length == 1) return;
		int N = nums.length;
		// 进行分组，最开始的增量(gap)为数组长度的一半
		for (int gap = N / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < N; i++) {
				if (nums[i] < nums[i - gap]) {
					swap(nums, i, i - gap);
				}
				System.out.println(Arrays.toString(nums));
			}
		}
	}

	public static void swap(int[] nums, int i, int j) {
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}

	public static void main(String[] args) {
		int[] nums = {5, 7, 8, 3, 1, 2, 4, 6};
		shellSort(nums);
	}
}
