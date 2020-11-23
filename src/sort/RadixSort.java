package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 基数排序：线性时间、非比较排序，分为最低位优先法（LSD）和最高位优先法（MSD），以LSD为实现方式：
 * 1、分配0-9共10个元素的标记数组；
 * 2、将待排数组统一为位数相同的整数，高位不足补0（必须是非负整数）；
 * 3、从最低位开始，按照数字从小到大排序，然后依次排到高位，即得到整个数组有序
 */
public class RadixSort {

	/**
	 * 检查数组
	 *
	 * @param nums 待排序数组
	 */
	public static void checkNums(int[] nums) {
		if (Objects.isNull(nums) || nums.length == 0) {
			throw new IllegalArgumentException("数组异常");
		}
	}

	/**
	 * 获取数组最大数的位数
	 *
	 * @param nums 待排数组
	 * @return 数组最大值位数
	 */
	public static int getMaxLength(int[] nums) {
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			max = max - nums[i] >= 0 ? max : nums[i];
		}
		char[] maxChar = String.valueOf(max).toCharArray();
		return maxChar.length;
	}

	/**
	 * 获取元素指定位数的数字
	 *
	 * @param num 元素值
	 * @param d   位数
	 * @return 元素指定位置的值
	 */
	public static int getDigitValue(int num, int d) {
		return num%(new Double(Math.pow(10d, d)).intValue())/(new Double(Math.pow(10d, d-1)).intValue());
	}

	public static void radixSort(int[] nums, int digit, int maxLength) {
		// 递归出口
		if (digit > maxLength) return;
		// 标记数组
		int len = 10;
		int[] count = new int[len];
		// 临时数组
		int[] temp = new int[nums.length];
		for (int num : nums) {
			System.out.println("第"+digit+"位上的数值："+getDigitValue(num,digit));
			count[getDigitValue(num, digit)]++;
		}

		// 将标记数组的元素值变成待排元素的位置索引
		for (int i = 1; i < len; i++) {
			count[i] = count[i] + count[i - 1];
		}
		System.out.println(Arrays.toString(count));
		for (int num : nums) {
			int d = getDigitValue(num, digit);
			temp[count[d] - 1] = num;
			count[d]--;
		}
		System.out.println(Arrays.toString(count));
		nums = Arrays.copyOf(temp, nums.length);
		radixSort(nums, digit + 1, maxLength);
	}

	public static void main(String[] args) {
		int[] nums = new int[10];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 10);
		}
		nums = new int[]{0, 3, 9, 2, 6, 9, 6, 7, 8, 2};
		System.out.println("排序前：" + Arrays.toString(nums));
		checkNums(nums);
		int maxLength = getMaxLength(nums);
		System.out.println("maxLength=" + maxLength);
		radixSort(nums, 1, maxLength);
		System.out.println("排序后：" + Arrays.toString(nums));
	}
}
