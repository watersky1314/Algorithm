package search;

public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = {1, 3, 3, 3, 3, 6, 7, 8, 9, 10};
		int n = binarySearch(nums, 3);
		System.out.println(n);

	}

	static int binarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1; // 注意

		while (left <= right) { // 注意
			int mid = left + (right - left) / 2;
			System.out.println("left=" + left + ", right=" + right);
			if (nums[mid] == target && (mid >= 1 && nums[mid - 1] < target))
				return mid;
			else if (nums[mid] < target)
				left = mid + 1; // 注意
			else
				right = mid - 1; // 注意
		}
		return -1;
	}
}
