package sort;

/**
 * 选择排序：
 * 外层循环控制排序的轮数，也就是元素的个数n-1轮，内层循环，将每轮第一个元素同后面元素进行比较，
 * 将比较后的最小值放在每一轮的第一位（从小到大排序），选择排序排序次数始终是n*(n-1)/2,因此时间复杂度为O(n^2)
 */
public class SelectSort {

    public static void sort(int[] nums) {
        int k=0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
                k++;
            }
        }
        System.out.println("排序总次数："+k);
    }

}
