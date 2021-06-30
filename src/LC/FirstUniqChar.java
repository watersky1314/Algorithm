package LC;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {

	public static int firstUniqChar(String s) {
		Map<Character, Integer> m = new HashMap<>();
		char[] c = s.toCharArray();
		for (char value : c) {
			m.merge(value, 1, Integer::sum);
		}
		for (int i = 0; i < c.length; i++) {
			if (m.get(c[i]) == 1) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String s = "loveleetcode";
		System.out.println(firstUniqChar(s));

	}
}
