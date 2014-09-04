import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int[] r = new int[2];
		int index1, index2;
		ArrayList<MyInt> inumber = new ArrayList<>();
		for(int i = 0; i < numbers.length; i++)
			inumber.add(new MyInt(numbers[i], i + 1));
		Collections.sort(inumber);
		int i = 0, j = numbers.length - 1;
		while(i < j)
		{
			if(inumber.get(i).value + inumber.get(j).value < target)
			{
				i++;
			}
			else if(inumber.get(i).value + inumber.get(j).value > target)
			{
				j--;
			}
			else {
				index1 = inumber.get(i).index;
				index2 = inumber.get(j).index;
				if(index1 < index2)
				{
					r[0] = index1;
					r[1] = index2;
				}
				else {
					r[0] = index2;
					r[1] = index1;
				}
				break;
			}
		}
//		HashMap<Integer, Integer> map = new HashMap<>();
//		
//		for(int i = 0; i < numbers.length; i++)
//		{
//			map.put(numbers[i], i);
//		}
//		for(int value : map.keySet())
//		{
//			if(map.containsKey(target - value))
//			{
//				index1 = map.get(value) + 1;
//				index2 = map.get(target - value) + 1;
//				if(index1 < index2)
//				{
//					r[0] = index1;
//					r[1] = index2;
//				}
//				else {
//					r[0] = index2;
//					r[1] = index1;
//				}
//				return r;
//			}
//		}
		return r;
	}

	public class MyInt implements Comparable<MyInt>
	{
		public int value;
		public int index;
		
		public MyInt(int _value, int _index){
			value = _value;
			index = _index;
		}
		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(MyInt o) {
			// TODO Auto-generated method stub
			return value - o.value;
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {0,4,3,0}, result;
		result = new TwoSum().twoSum(numbers, 0);
		System.out.println(result[0] + "    " + result[1]);
	}

}
