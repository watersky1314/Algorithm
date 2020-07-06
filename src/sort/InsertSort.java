package sort;

/**
 * 插入排序：将数组元素分为两部分，前面一部分是已经排好顺序的数组，后面一部分是无序数组。
 * 将无序数组的每一个元素与前面有序的数组进行比较，当比较得到前面有序数组元素存在比当前无序数组元素要大，
 * 那么就将当前无序元素插入有序数组那个位置，并且有序数组后面元素右移
 */
public class InsertSort {
    public static void sort(int[] nums) {
        int k = 0;//计算比较次数
        for (int i = 1; i < nums.length; i++) {//无序元素
            int t = nums[i];
            int j;
            for (j = i - 1; j >= 0 && nums[j] > t; j--) {//有序元素
                nums[j+1] = nums[j];
                k++;
            }
            nums[j+1] = t;
			k++;
        }
        System.out.println("排序总次数：" + k);
    }
}
