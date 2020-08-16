/*
 * you can do only two transactions of buy sell, you cant buy unless you sell previous
 */
public class BuySellStock3 {
	
	public static int maxProfit(int[] prices) {
		int t1buy = Integer.MAX_VALUE; //transaction1 buy
		int t2buy = Integer.MAX_VALUE; //transaction2 buy
		
		int t1profit = 0, t2profit = 0; //profits
		
		for(int price: prices) { //pick each price
			t1buy = Math.min(t1buy, price); //pick current or stick to old whichever minimum
			t1profit = Math.max(t1profit, price - t1buy); //SP - CP or current whichever max
			//reinvest profit of t1
			t2buy = Math.min(t2buy, price - t1profit); //buy2 must be minimum of current price - previous profit
			t2profit = Math.max(t2profit, price - t2buy); //SP - CP
			
		}
		return t2profit;
	}
	
	public static void main(String[] args) {
		int[] prices = {3,3,5,0,0,3,1,4};
		System.out.println(maxProfit(prices));
	}
}
