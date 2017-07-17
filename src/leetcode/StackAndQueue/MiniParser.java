package leetcode.StackAndQueue;
import java.util.Stack;

public class MiniParser {
	/* if it's '[', we just construct a new nested integer and push it onto the stack
	 * if it's a number, we parse the whole number and add to the previous nested integer object
	 * if it's ',', we'll just continue;
	 * if it's ']', we'll just pop one nested integer from the working stack and assign it to the result
	 */
	public NestedInteger deserialize(String s) {
		if (s.isEmpty()) return null;
		if (s.charAt(0) != '[') // ERROR: special case
			return new NestedInteger(Integer.valueOf(s));

		Stack<NestedInteger> stack = new Stack<>();
		NestedInteger curr = null;
		int l = 0; // l shall point to the start of a number substring; 
		// r shall point to the end+1 of a number substring
		for (int r = 0; r < s.length(); r++) {
			char ch = s.charAt(r);
			if (ch == '[') {
				if (curr != null) {
					stack.push(curr);
				}
				curr = new NestedInteger();
				l = r+1;
			} else if (ch == ']') {
				String num = s.substring(l, r);
				if (!num.isEmpty())
					curr.add(new NestedInteger(Integer.valueOf(num)));
				if (!stack.isEmpty()) {
					NestedInteger pop = stack.pop();
					pop.add(curr);
					curr = pop;
				}
				l = r+1;
			} else if (ch == ',') {
				if (s.charAt(r-1) != ']') {
					String num = s.substring(l, r);
					curr.add(new NestedInteger(Integer.valueOf(num)));
				}
				l = r+1;
			}
		}

		return curr;
	}
	
	public static void main(String[] args){
		MiniParser mp = new MiniParser();
		String s = "[123,[456,[789]]]";
		mp.deserialize(s);
	}
}
