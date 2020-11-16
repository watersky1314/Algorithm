package sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 计数排序：非比较的排序算法，通过统计数组元素出现的次数，然后依次遍历标记数组，将其下标填充到原数组中，即完成排序
 * 计数排序是稳定的排序，其时间和空间复杂度均为O(n+k)
 */
public class CountingSort {

	public static void checkNums(int[] nums) {
		if (Objects.isNull(nums) || nums.length == 0) {
			throw new IllegalArgumentException("数组异常");
		}
	}

	public static void countingSort(int[] nums) {
		if (nums.length == 1) return;
		int max = nums[0];
		int min = nums[0];

		// 获取原数组最大元素值
		for (int i = 1; i < nums.length; i++) {
			max = max - nums[i] > 0 ? max : nums[i];
			min = min - nums[i] < 0 ? min : nums[i];
		}
		// 创建大小为len的标记数组，len取值规则：max-min+1和nums.lenth,取其大的值
		int len = max - min + 1 - nums.length >= 0 ? max - min + 1 : nums.length;
		int[] countNums = new int[len];
		for (int num : nums) {
			countNums[num]++;
		}
		// 遍历标记数组，将其下标填充入原数组中
		int index = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < countNums[i]; j++) {
				nums[index++] = i;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[10];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 10);
		}
		System.out.println("排序前：" + Arrays.toString(nums));
		checkNums(nums);
		countingSort(nums);
		System.out.println("排序后：" + Arrays.toString(nums));
	}
}
