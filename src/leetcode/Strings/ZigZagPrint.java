package leetcode.Strings;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagPrint {
	public static void main(String[] args){
		System.out.println(convert("PAYPALISHIRING", 4));
	}
	public static String convert(String s, int nRows) {
	    char[] c = s.toCharArray();
	    int len = c.length;
	    StringBuilder[] sb = new StringBuilder[nRows];
	    for (int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();
	    
	    int i = 0;
	    while (i < len) {
	        for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
	            sb[idx].append(c[i++]);
	        for (int idx = nRows-2; idx > 0 && i < len; idx--) // obliquely up
	            sb[idx].append(c[i++]);
	    }
	    for (int idx = 1; idx < nRows; idx++) //append rest of stringbuilders to 1st one
	        sb[0].append(sb[idx]);
	    return sb[0].toString();
	}
}
