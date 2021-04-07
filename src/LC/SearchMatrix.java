package LC;

import java.util.ArrayList;
import java.util.List;

public class SearchMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
		boolean flag = searchMatrix(matrix, 5);
		System.out.println(flag);
		List<Long> list = new ArrayList<>();
		list.add(1L);
		System.out.println(list);
		System.out.println();
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length - 1;
		int n = matrix[0].length - 1;
		int low = 0;
		int high = m;
		while (low < high) {
			int mid = (high - low) / 2 + low;
			if (matrix[mid][0] == target || matrix[mid][n] == target) return true;
			if (matrix[mid][0] < target && matrix[mid][n] > target) {
				int left = 1;
				int right = n - 1;
				while (left < right) {
					int t = (right - left) / 2 + left;
					if (matrix[mid][1] == target || matrix[mid][n - 1] == target) return true;
					if (matrix[mid][t] < target) {
						right = t - 1;
					} else {
						left = t + 1;
					}
				}
				return false;
			}
			if (matrix[mid][n] < target) {
				low = mid + 1;
			} else if (matrix[mid][0] > target) {
				high = mid - 1;
			}
		}
		return false;
	}
}
