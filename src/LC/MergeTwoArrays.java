package LC;

import java.util.Arrays;

public class MergeTwoArrays {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		System.arraycopy(nums2, 0, nums1, m, n);
		if(nums1.length == 1) return;
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

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		merge(nums1, 3, nums2, 3);
		System.out.println(Arrays.toString(nums1));
	}
}
