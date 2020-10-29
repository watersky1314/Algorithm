package sort;

import java.util.Arrays;
import java.util.Objects;

public class QuickSort1 {

	public static void quickSort(int[] nums, int left, int right) {
		if (Objects.isNull(nums) || nums.length == 0) {
			return;
		}
		// 选取第一个元素作为基准点
		int pivot = nums[left];
		while (left < right) {
			while (nums[left] < pivot) left++;
			while (nums[right] > pivot) right--;
			if (left < right) {
				swap(nums, left, right);
//				System.out.println(Arrays.toString(nums));
			}
		}
//		quickSort(nums, left, nums.length-1);
//		quickSort(nums, 0, right);
	}

	public static void swap(int[] nums, int i, int j) {
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}

	public static void main(String[] args) {
		int[] nums = {6,4,3,7,8,1,5,9,10,2};
		quickSort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}
}
