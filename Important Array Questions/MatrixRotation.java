import java.util.*;

public class MatrixRotation{

	static void transposeMatrix(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = i; j < matrix[0].length; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	static void reverseMatrix(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length / 2; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix.length - 1- j];
				matrix[i][matrix.length - 1 - j] = temp;
			}
		}
	}

	static void displayMatrix(int[][] matrix){
		if(matrix.length == 0){
			System.out.println("Matrix is Empty"); 
			return;
		}

		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int row = sc.nextInt();
		int column = sc.nextInt();

		int[][] matrix = new int[row][column];

		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				matrix[i][j] = sc.nextInt();
			}
		}

		System.out.println("Matrix Before Rotation: ");
		displayMatrix(matrix);

		transposeMatrix(matrix);
		displayMatrix(matrix);

		reverseMatrix(matrix);

		System.out.println("Matrix After Rotation: ");
		displayMatrix(matrix);
	}
}