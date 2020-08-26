public class MinimumCostsToBuyTickets {
    public static int mincostTickets(int[] days, int[] costs) {
        if(days.length == 0)
            return 0;
        int n = days[days.length - 1];
        int amount[] = new int[n + 1]; //cost of each day
        boolean travel[] = new boolean[n + 1]; //whether travelled or not
        for(int day: days)
            travel[day] = true;
        amount[0] = 0;
        for(int i = 1; i <= n; i++){
            if(travel[i]){
                int min = amount[i - 1] + costs[0]; //if 1 day pass
                min = Math.min(min, (i < 7 ? 0 : amount[i - 7]) + costs[1]); //if 7-day pass
                min = Math.min(min, (i < 30 ? 0 : amount[i - 30]) + costs[2]); //if 30-day pass
                amount[i] = min;
            }
            else
                amount[i] = amount[i - 1]; //if didnt travel on ith day
        }
        return amount[n];
    }

    public static void main(String[] args) {
        int days[] = {1,4,6,7,8,20};
        int costs[] = {2,7,15};
        System.out.println(mincostTickets(days, costs));
    }
}
