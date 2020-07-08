package sort;

import java.util.Arrays;

public class Test {
	public static int selectMid(int low, int mid, int high) {
		return low <= mid ? (mid <= high ? mid : Math.max(low, high)) : (low <= high ? low : Math.max(mid, high));
	}
	public static void main(String[] args) {
		int[] nums = new int[3];
		for(int i=0;i<nums.length;i++){
			nums[i] = (int)(Math.random()*100);
		}
		System.out.println("生成的数组："+ Arrays.toString(nums));
		int mid = selectMid(nums[0],nums[1],nums[2]);
		System.out.println(mid);
	}
}
