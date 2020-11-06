package sort;

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

	public static void mergeSort(int[] nums, int[] result, int start, int end) {
		int mid = (end - start) >> 1 + start;
		mergeSort(nums, result, start, mid);
		mergeSort(nums, result, mid+1, end);


	}


}
