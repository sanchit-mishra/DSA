import java.util.*;

public class BuySellStock{

	static int getStockProfit(int[] array){
		if(array.length == 0)
			return 0;

		int minStockPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] < minStockPrice){
				minStockPrice = array[i];
			}else if(array[i] - minStockPrice > maxProfit){
				maxProfit = array[i] - minStockPrice;
			}
		}

		return maxProfit;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int arraySize = sc.nextInt();

		int[] array = new int[arraySize];

		for(int i = 0; i < arraySize; i++){
			array[i] = sc.nextInt();
		}

		int profit = getStockProfit(array);

		System.out.println("Stock Profit: " + profit);
	}
}