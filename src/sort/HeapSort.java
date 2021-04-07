package sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 堆排序：完全二叉树结构，采用选择排序
 * <p>
 * 父节点的下标 =（子节点的下标-1）>> 1
 * 左子节点的下标 = 父节点的下标 * 2 + 1
 * 右子节点的下标 = 父节点的下标 * 2 + 2
 */
public class HeapSort {

	public static void checkNums(int[] nums) {
		if (Objects.isNull(nums) || nums.length == 0) {
			throw new IllegalArgumentException("数组异常");
		}
	}

	public static void buildMaxHeap(int[] nums, int heapSize) {
		// 递归出口
		if (heapSize == 1) return;
		// 找到末尾非叶子节点，并进行比较排序，得到堆顶元素为最大
		for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
			heapSort(nums, i, heapSize);
		}
		// 交换堆顶与堆尾值
		swap(nums, 0, heapSize - 1);
		buildMaxHeap(nums, --heapSize);
	}

	public static void heapSort(int[] nums, int i, int heapSize) {
		// 左子节点
		int left = 2 * i + 1;
		// 右子节点
		int right = 2 * i + 2;

		// 比较当前节点与左子节点大小
		if (nums[i] < nums[left]) {
			swap(nums, i, left);
		}
		// 判断是否存在右子节点，存在，则比较节点与右子节点大小
		if (right < heapSize && nums[i] < nums[right]) {
			swap(nums, i, right);
		}

	}

	public static void swap(int[] nums, int i, int j) {
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}

	public static void main(String[] args) {
		int[] nums = new int[10];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 10);
		}
		System.out.println("排序前：" + Arrays.toString(nums));
		checkNums(nums);
		buildMaxHeap(nums, nums.length);
		System.out.println("排序后：" + Arrays.toString(nums));
	}
}
