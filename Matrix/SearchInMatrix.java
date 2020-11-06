//Java Program to search element in 2D Matrix.
//TC: O(logn) && SC: O(1).
import java.util.*;

class SearchInMatrix{

    static boolean searchInMatrix(int[][] matrix, int target){
        
        if(matrix.length == 0)
            return false;
        
        int row = matrix.length;
        int column = matrix[0].length;
        
        int low = 0;
        int high = row*column - 1;
        
        while(low <= high){
            int mid = (low + (high - low) / 2);
            if(matrix[mid / column][mid % column] == target)
                return true;
            else if(matrix[mid / column][mid % column] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
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

        int element = sc.nextInt();

        boolean found = searchInMatrix(matrix, element);
        
        if(found){
            System.out.println("Element Found");
        }else{
            System.out.println("Element Not Found");
        }
    }
}