public class BestTimeBuySellStock2 {
	public int maxProfit(int[] prices) {
		boolean hasStock = false;
		int price = 0, profit = 0;
		for(int i = 0; i < prices.length ; i++) {
			// four situation
			if(i + 1 == prices.length || prices[i] > prices[i + 1]){
				if(hasStock){
					profit += (prices[i] - price);
					hasStock = false;
				}
			}
			else{
				if(!hasStock){
					price = prices[i];
					hasStock = true;
				}
			}
		}
		return profit;
	}
	
	public static void main(String[] args) {
		int[] prices = {6,1,3,2,4,7};
		System.out.println(new BestTimeBuySellStock2().maxProfit(prices));
	}
}