package sort;

import java.util.Arrays;

/**
 * 快速排序：运用了分治思想，取某个基准点值，将数组依次从左-->右进行遍历（寻找直到大于基准点的数）和从右-->左进行遍历（寻找直到小于基准点的数），
 * 然后交换位置，使得左边的元素小于基准点数值，右边元素大于基准点数值
 */
public class QuickSort {
	static int k = 0;

	public static int selectMid(int low, int mid, int high) {
		return low <= mid ? (mid <= high ? mid : Math.max(low, high)) : (low <= high ? low : Math.max(mid, high));
	}

	public static void sort(int[] nums, int L, int R, boolean flag) {
		int i = L;
		int j = R;
		// 基准点
		int m = (L + R) / 2;
		int p;
		if (flag) p = nums[m];
		else p = selectMid(nums[L], nums[m], nums[R]);
		while (i <= j) {
			//从左-->右扫描，寻找直到比基准点大于的数
			while (p > nums[i]) i++;

			//从右-->左扫描，寻找直到比基准点小于的数
			while (p < nums[j]) j--;
			//此时已经分别找到了比基准点小的数(右边)、比基准点大的数(左边)，它们进行交换
			if (i <= j) {
				int t = nums[i];
				nums[i] = nums[j];
				nums[j] = t;
				i++;
				j--;
				k++;
			}
		}
		//上面一个while保证了第一趟排序基准点的左边比基准点小，基准点的右边比基准点大。
		//“左边”再做排序，直到左边剩下一个数(递归出口)
		if (L < j) sort(nums, L, j, flag);
		//“右边”再做排序，直到右边剩下一个数(递归出口)
		if (i < R) sort(nums, i, R, flag);
	}
}
