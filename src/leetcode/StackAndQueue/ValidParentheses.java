package leetcode.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
	public boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}
