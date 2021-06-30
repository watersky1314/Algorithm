package LC;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		A t = new A();
		t.setA(1);
		List<A> list = new ArrayList<>();
		list.add(t);
		list.forEach(x->{
			x.setB(2);
		});
		System.out.println(list.get(0).getB());
	}
	private static class A{
		private Integer a;
		private Integer b;

		public Integer getA() {
			return a;
		}

		public void setA(Integer a) {
			this.a = a;
		}

		public Integer getB() {
			return b;
		}

		public void setB(Integer b) {
			this.b = b;
		}
	}
}
