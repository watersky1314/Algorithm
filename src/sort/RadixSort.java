package sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 基数排序：线性时间、非比较排序，分为最低位优先法（LSD）和最高位优先法（MSD），以LSD为实现方式：
 * 1、以待排数组元素最大为基准，获取数组最大位数，同时将数组统一为位数相同的整数，高位不足补0（这里只考虑非负整数）；
 * 2、从最低位开始，按照每位数字从小到大，统计到0-9共10个元素的桶中，数组下标对应该数字，数值对应出现次数；
 * 3、将桶的数值变成待排数组元素的位置索引；
 * 4、根据桶的元素数值，遍历待排数组，将其依次放入临时数组中；
 * 5、将临时数组拷贝到待排数组；
 * 6、重复上述步骤，直到高位，即得到整个数组有序
 *
 * 基数排序的时间复杂度为：O(d*(n+radix))
 * 空间复杂度为：O(n+d*(n+radix))
 * 【n：待排元素的个数，d：待排数组元素最大值的位数，radix：桶的大小，这里分0-9十个桶】
 */
public class RadixSort {

	/**
	 * 检查数组
	 * @param nums 待排序数组
	 */
	public static void checkNums(int[] nums) {
		if (Objects.isNull(nums) || nums.length == 0) {
			throw new IllegalArgumentException("数组异常");
		}
	}

	/**
	 * 获取数组最大数的位数
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
	 * @param num 元素值
	 * @param d   位数
	 * @return 元素指定位置的值
	 */
	public static int getDigitValue(int num, int d) {
		return num % (new Double(Math.pow(10d, d)).intValue()) / (new Double(Math.pow(10d, d - 1)).intValue());
	}

	/**
	 * 基数排序
	 * @param nums 待排数组
	 * @param digit 待排数组排序的位数
	 * @param maxLength 待排数组元素的最大位数
	 */
	public static void radixSort(int[] nums, int digit, int maxLength) {
		// 递归出口
		if (digit > maxLength) return;
		// 桶
		int len = 10;
		int[] bucket = new int[len];
		// 临时数组
		int[] temp = new int[nums.length];
		for (int num : nums) {
			bucket[getDigitValue(num, digit)]++;
		}
		// 将桶的元素值变成待排元素的位置索引
		for (int i = 1; i < len; i++) {
			bucket[i] = bucket[i] + bucket[i - 1];
		}
		System.out.println(Arrays.toString(bucket));
		for (int i = nums.length - 1; i >= 0; i--) {
			int d = getDigitValue(nums[i], digit);
			temp[bucket[d] - 1] = nums[i];
			--bucket[d];
		}
		System.arraycopy(temp, 0, nums, 0, temp.length);
		radixSort(nums, digit + 1, maxLength);
	}

	public static void main(String[] args) {
		int[] nums = new int[10];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 1000);
		}
		System.out.println("排序前：" + Arrays.toString(nums));
		checkNums(nums);
		int maxLength = getMaxLength(nums);
		radixSort(nums, 1, maxLength);
		System.out.println("排序后：" + Arrays.toString(nums));
	}
}
