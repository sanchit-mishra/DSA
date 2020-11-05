//Celebrity Problem: 
//Elimintaion Approach - 1) Using Stack TC:O(N) && SC:O(N).
//					   - 2) Using Two Pointer TC:O(N) && SC:O(1).
import java.util.*;

class CelebrityProblem{

	static int findCeleb(int[][] celebMatrix, int size){
		Stack<Integer> stack = new Stack<Integer>();

		for(int i = 0; i < size; i++){
			stack.push(i);
		}

		while(stack.size() >= 2){
			int person1 = stack.pop();
			int person2 = stack.pop();

			if(celebMatrix[person2][person1] == 1){
				stack.push(person1);
			}else{
				stack.push(person2);
			}
		}

		int potentialCeleb = stack.pop();
		for(int i = 0; i < celebMatrix.length; i++){
			if(i != potentialCeleb){
				if(celebMatrix[potentialCeleb][i] == 1 || celebMatrix[i][potentialCeleb] == 0){
					System.out.println("No Celebrity");
					return -1;
				}
			}
		}
		return potentialCeleb;
	}


/*
	static int findCeleb(int[][] celebMatrix, int size){
		int a = 0;
		int b = size - 1;

		while(a < b){
			if(celebMatrix[a][b] == 1){
				a++;
			}else{
				b--;
			}
		}
		for(int i = 0; i < size; i++){
			if(i != a){
				if(celebMatrix[a][i] == 1 || celebMatrix[i][a] == 0){
					return -1;
				}
			}
		}
		return a;
	}
*/

	public static void main(String args[]){
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		int[][] celebMatrix = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				celebMatrix[i][j] = sc.nextInt();
			}
		}

		int id = findCeleb(celebMatrix,n);
		System.out.println("Celebrity Id: " + id);
	}
}