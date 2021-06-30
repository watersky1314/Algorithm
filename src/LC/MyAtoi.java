package LC;

public class MyAtoi {
	public static int myAtoi(String s) {
		StringBuilder numStr = new StringBuilder();
		s = s.trim();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) != '-' && s.charAt(i) != '+' && !Character.isDigit(s.charAt(i))) {
				return 0;
			}
			if (s.charAt(i) == '-' && (i + 1) < len && Character.isDigit(s.charAt(i + 1))) {
				numStr.append(s.charAt(i));
			}
			if (Character.isDigit(s.charAt(i))) {
				numStr.append(s.charAt(i));
			}
			if (i + 1 < len && !Character.isDigit(s.charAt(i + 1))) break;
		}
		return Integer.parseInt(numStr.toString());
	}

	public static void main(String[] args) {
		String s = "-42";
		System.out.println(myAtoi(s));
		System.out.println(Thread.currentThread().getName());
	}
}
