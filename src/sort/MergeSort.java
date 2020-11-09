package sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 归并排序：先将序列以二分法拆分两个子序列，然后继续拆分，直至所有子序列的元素个数为1。根据分解路径对每个子序列进行排序并上溯合并
 */
public class MergeSort {

	public static void checkNums(int[] nums) {
		if (Objects.isNull(nums) || nums.length == 0) {
			throw new IllegalArgumentException("数组异常");
		}
	}

	public static int[] mergeSort(int[] nums, int start, int end) {
		if (start == end) return new int[]{nums[start]};
		int mid = (end - start) >> 1 + start;
		int[] leftArr = mergeSort(nums, start, mid);//左序序列
		int[] rightArr = mergeSort(nums, mid + 1, end);//右序序列
		int[] result = new int[leftArr.length + rightArr.length];
		int i = 0, j = 0, k = 0;
		while (i < leftArr.length && j < rightArr.length) {
			result[k++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
		}
		while (i < leftArr.length) {
			result[k++] = leftArr[i++];
		}
		while (j < rightArr.length) {
			result[k++] = rightArr[j++];
		}
		System.out.println(Arrays.toString(nums));
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {3, 2, 8, 5, 6, 4, 10, 9, 1, 7};
		nums = mergeSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}


}
