package LC;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 * 相关标签
 * 数组
 * 双指针
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xmi2l7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MergeTwoArrays {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		System.arraycopy(nums2, 0, nums1, m, n);
		if (nums1.length == 1) return;
		System.out.println(Arrays.toString(nums1));
		if (nums1[m - 1] <= nums1[m]) return;
		for (int i = m; i < m + n; i++) {//无序元素
			int t = nums1[i];
			int j;
			for (j = i - 1; j >= 0 && nums1[j] > t; j--) {
				nums1[j + 1] = nums1[j];
			}
			nums1[j + 1] = t;
		}
	}

	public static void merge1(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int t = m + n - 1;
		while (j >= 0) {
			nums1[t--] = (i >= 0 && nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
		}
	}

	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 0, 0, 0};
		int[] nums2 = {2, 5, 6};
		merge(nums1, 3, nums2, 3);
		System.out.println(Arrays.toString(nums1));
	}
}
