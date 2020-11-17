package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 基数排序：线性时间、非比较排序，分为最低位优先法（LSD）和最高位优先法（MSD），以LSD为实现方式：
 * 1、分配0-9共10个元素的标记数组；
 * 2、将待排数组统一为位数相同的整数，高位不足补0（必须是非负整数）；
 * 3、从最低位开始，按照数字从小到大排序，然后依次排到高位，即得到整个数组有序
 */
public class RadixSort {

	public static void checkNums(int[] nums) {
		if (Objects.isNull(nums) || nums.length == 0) {
			throw new IllegalArgumentException("数组异常");
		}
	}

	public static int getDigit(int[] nums) {
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			max = max - nums[i] >= 0 ? max : nums[i];
		}
		char[] maxChar = String.valueOf(max).toCharArray();
		return maxChar.length;
	}

	public static void radixSort(int[] nums, int digit) {
		List<int[]> markList = new ArrayList<>();
		for (int i = 1; i <= digit; i++) {
			int[] mark = new int[10];
			for (int num : nums) {
				mark[num % (10 * i)]++;
			}
			markList.add(mark);
		}
		for (int i = 0; i < markList.size(); i++) {

		}
	}
}
