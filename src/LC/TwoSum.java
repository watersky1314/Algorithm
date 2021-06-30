package LC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoSum {
	public static int[] solution(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			if(map.get(target-nums[i])!=null){
				return new int[]{map.get(target-nums[i]),i};
			}
			map.put(nums[i],i);
			System.out.println(map);
		}
		return null;
	}
	public static void main(String[] args) {
//		int[] nums = new int[]{2,7,11,15,9};
//		int[] targetArr =solution(nums, 9);
//		System.out.println(Arrays.toString(targetArr));


			List<String> list = Stream.of("a","b","c").collect(Collectors.toList());
			String str = String.join(",", list);
			System.out.println(str);

	}

}
