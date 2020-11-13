package sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 归并排序：分治思想（分：以二分法无限将原序列拆分为两个子序列，直至子序列的元素为1；治：将子序列依次合并并使其有序）
 * 步骤：
 * 		1.递归二分法拆分两个子序列，直至子序列的元素为1；
 * 		2.申请临时空间序列，比较子序列元素，将排好序的元素放入临时空间中
 * 		3.将临时空间序列的元素放到原序列对应的位置
 */
public class MergeSort {

	public static void checkNums(int[] nums) {
		if (Objects.isNull(nums) || nums.length == 0) {
			throw new IllegalArgumentException("数组异常");
		}
	}

	// 拆分直至子序列元素为1
	public static void divide(int[] nums, int L, int R) {
		if (L == R) return;
		int mid = ((R - L) >> 1) + L;
		divide(nums, L, mid);
		divide(nums, mid + 1, R);
		mergeSort(nums, L, mid, R);
	}

	public static void mergeSort(int[] nums, int L, int mid, int R) {
		// 申请临时空间
		int[] temp = new int[R - L + 1];
		int i = L;
		int j = mid + 1;
		int k = 0;
		// 比较子序列的元素，哪个小就放入临时数组中
		while (i <= mid && j <= R) {
			temp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
		}
		// 循环退出后，把剩下元素放入临时数组中，以下两while循环只会执行其中一个
		while (i <= mid) {
			temp[k++] = nums[i++];
		}
		while (j<= R) {
			temp[k++] = nums[j++];
		}
		System.out.println("临时数组temp:" + Arrays.toString(temp));
		// 将临时数组复制到原数组对应的位置
		System.arraycopy(temp, 0, nums, L, temp.length);
		System.out.println("排序中：" + Arrays.toString(nums));
	}

	public static void main(String[] args) {
		int[] nums = {3, 2, 8, 5, 6, 4, 10, 9, 1, 7, 7};
		System.out.println(Arrays.toString(nums));
		checkNums(nums);
		divide(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}


}
