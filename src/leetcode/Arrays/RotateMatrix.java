package leetcode.Arrays;

/** You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
 *  https://leetcode.com/problems/rotate-image/#/description
 */
public class RotateMatrix {
	public void rotate90Clockwise(int[][] matrix) {
		int len = matrix.length;

		//1. Flip the rows horizontally
		for(int i = 0; i < len / 2; i++) {
			int[] tmp = matrix[i];
			matrix[i] = matrix[len - 1 - i];
			matrix[len - 1 - i] = tmp;
		}

		System.out.println("=====================");

		//2. Transpose the matrix
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}

	public void rotate90AntiClockwise(int[][] matrix) {
		int len = matrix.length;

		//1. Transpose the matrix
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}

		System.out.println("=====================");

		//2. Flip the rows horizontally
		for(int i = 0; i < len / 2; i++) {
			int[] tmp = matrix[i];
			matrix[i] = matrix[len - 1 - i];
			matrix[len - 1 - i] = tmp;
		}
	}

	private static void printmatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}		
	}

	public static void main(String[] args){
		RotateMatrix rm = new RotateMatrix();
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};


		printmatrix(matrix);
		rm.rotate90Clockwise(matrix);

		printmatrix(matrix);
	}
}
