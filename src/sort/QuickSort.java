package sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 快速排序：运用了分治思想，取某个基准点值，将数组依次从左-->右进行遍历（寻找直到大于基准点的数）和从右-->左进行遍历（寻找直到小于基准点的数），
 * 然后交换位置，使得左边的元素小于基准点数值，右边元素大于基准点数值
 */
public class QuickSort {

	public static void checkNums(int[] nums) {
		if (Objects.isNull(nums) || nums.length == 0) {
			throw new IllegalArgumentException("数组异常");
		}
	}

	public static void quickSort(int[] nums, int left, int right) {
		// 递归出口
		if (left >= right) return;
		// 选中第一个元素作为基准值
		int pivot = nums[left];
		int i = left;
		int j = right;
		System.out.println("left=" + left + ", right=" + right);
		while (i < j) {
			while (nums[i] < pivot && i < j) i++;
			while (nums[j] > pivot && i < j) j--;
			if (nums[i] == nums[j]) j--;
			if (i < j) {
				swap(nums, i, j);
			}
			System.out.println(Arrays.toString(nums));
		}
		System.out.println("i=" + i + ", j=" + j);
		System.out.println(Arrays.toString(nums));
		quickSort(nums, left, i - 1);
		quickSort(nums, i + 1, right);
	}

	public static void swap(int[] nums, int i, int j) {
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}

	public static void main(String[] args) {
		int[] nums = {1, 7, 1, 3, 10, 1, 9, 2, 5, 3};
		checkNums(nums);
		System.out.println(Arrays.toString(nums));
		quickSort(nums, 0, nums.length - 1);
	}
}
