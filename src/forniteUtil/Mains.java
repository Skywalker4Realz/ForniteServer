package forniteUtil;

import java.util.Stack;

public class Mains {

	public static void main(String[] args) {
		
		ForniteStack<Integer> list = new ForniteStack<Integer>();
		
		for (int i = 0; i < 1; i++) {
			list.push(i);
		}
		list.pop();
		System.out.println(list.top());

		Stack<Integer> a = new Stack<Integer>();
		
	}

}
