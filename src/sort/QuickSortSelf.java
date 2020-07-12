package sort;

import java.util.Arrays;

public class QuickSortSelf {

	public static void sort(int[] nums, int leftBound, int rightBound) {
		if (leftBound >= rightBound) return;
		//选取基准值
		int pivot = nums[leftBound];
		//选取前后两指针
		int left = leftBound + 1;
		int right = rightBound;
		while (left < right) {
			while (left <= right && pivot >= nums[left]) left++;
			while (left <= right && pivot < nums[right]) right--;
			if (left < right) {
				swap(nums, left, right);
			}

		}
		System.out.println("left=" + left + ",right=" + right);
		System.out.println(Arrays.toString(nums));
		swap(nums, leftBound, right);
		sort(nums, leftBound, right - 1);
		sort(nums, right + 1, rightBound);
	}

	public static void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

	public static void main(String[] args) {
		int[] nums = new int[10];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 100);
		}
		nums = new int[]{2, 5, 76, 14, 57, 4, 61, 29, 72, 2, 18, 5};
		System.out.println("排序前：" + Arrays.toString(nums));
		sort(nums, 0, nums.length - 1);
		System.out.println("排序后：" + Arrays.toString(nums));
	}
}
