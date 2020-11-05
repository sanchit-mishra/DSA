import java.util.*;

public class MatrixZero{

	static void displayMatrix(int[][] matrix, int row, int column){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
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

		System.out.println("Matrix Before: ");

		displayMatrix(matrix, row, column);

		int col0 = 1;

		for(int i = 0; i < row; i++){
			if(matrix[i][0] == 0)
				col0 = 0;
			for(int j = 1; j < column; j++){
				if(matrix[i][j] == 0)
					matrix[i][0] = matrix[0][j] = 0;
			}
		}
		
		for(int i = row - 1; i >= 0; i--){
			for(int j = column - 1; j >= 1; j--){
				if(matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			if(col0 == 0)
				matrix[i][0] = 0;
			}
		}

		System.out.println("Matrix After: ");

		displayMatrix(matrix, row, column);
	}
}