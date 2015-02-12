public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int length = gas.length, i;
		i = 0;
		while(i < length){
			// not a possible start station, skip
			if(gas[i] < cost[i]){
				i++;
				continue;
			}
			// start from i
			int start = i, sum = gas[start] - cost[start];
			i++;
			while(sum >= 0 && (i % length != start)){
				sum += (gas[i % length] - cost[i % length]);
				i++;
			}
			// there are two condition
			if(sum < 0)
				i--;
			if((i % length) == start)
				return start;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] gas = {2, 4}, cost = {3, 4};
		System.out.println(new GasStation().canCompleteCircuit(gas, cost));
	}
}