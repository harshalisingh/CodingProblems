package leetcode.DP;

public class CountAllPathsFromTopLeftToBottomRight {

	public int count(int [][] arrA, int row, int col){
		//base case
		//check if last row OR column is reached since after that only one path
		//is possible to reach to the bottom right corner.
		if(row==arrA.length-1 || col==arrA.length-1){
			return 1;
		}
		return count(arrA, row+1, col) + count(arrA, row, col+1);
	}

	public int countDP(int [][] arrA){
		int result [][] = new int[arrA.length][arrA.length];

		//base case: if we have one cell then there is only one way
		result[0][0] = 1;

		//no of paths to reach in any cell in first row = 1
		for (int i = 0; i <result.length ; i++) {
			result[0][i] = 1;
		}

		//no of paths to reach in any cell in first col = 1
		for (int i = 0; i <result.length ; i++) {
			result[i][0] = 1;
		}

		for (int i = 1; i <result.length ; i++) {
			for (int j = 1; j <result.length ; j++) {
				result[i][j] = result[i-1][j] + result[i][j-1];
			}
		}

		return result[arrA.length-1][arrA.length-1];
	}

	public static void main(String[] args) {
		int arrA [][] = {{1,1,1},{1,1,1},{1,1,1}};
		CountAllPathsFromTopLeftToBottomRight noOfPaths = new CountAllPathsFromTopLeftToBottomRight();
		System.out.println("No Of Path (Recursion):- " +noOfPaths.count(arrA,0,0));
		System.out.println("No Of Path (DP):- " +noOfPaths.countDP(arrA));
	}
}
