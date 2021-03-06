package sort;

import java.util.HashMap;
import java.util.Map;

/**
 * 桶排序：线性时间、非比较的排序算法，将数组
 */
public class BucketSort {

		public static int majorityElement(int[] nums) {
			int m = nums.length>>1;
			Map<Integer,Integer> countMap = new HashMap<>();
			for (int j : nums) {
				countMap.putIfAbsent(j, 0);
				if(countMap.get(j) + 1 > m) return j;
				countMap.put(j, countMap.get(j) + 1);

			}
			return 0;

		}

	public static void main(String[] args) {
		int[] nums = {3,2,3};
		System.out.println(majorityElement(nums));
	}
}
