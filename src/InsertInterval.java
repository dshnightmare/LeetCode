import java.util.LinkedList;
import java.util.List;

/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class InsertInterval {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if(intervals == null)
			intervals = new LinkedList<>();
		int left = bsearch_start(intervals, 0, intervals.size() - 1, newInterval.start);
		int right = bsearch_end(intervals, 0, intervals.size() - 1, newInterval.end);
		Interval t = new Interval();
		if(left >= intervals.size())
			t.start = newInterval.start;
		else{
			t.start = intervals.get(left).start < newInterval.start ? intervals.get(left).start : newInterval.start;
		}
		if(right < 0)
			t.end = newInterval.end;
		else
			t.end = intervals.get(right).end > newInterval.end ? intervals.get(right).end : newInterval.end;
		if(left < intervals.size())
			for(int i = left; i <= right; i++)
				intervals.remove(left);
		intervals.add(left, t);
		return intervals;
	}
	
	private int bsearch_start(List<Interval> intervals, int left, int right, int start){
		if(left > right)
			return left;
		int mid = (left + right) / 2;
		if(intervals.get(mid).end == start)
			return mid;
		else if(intervals.get(mid).end > start){
			if(left == mid)
				return left;
			else
				return bsearch_start(intervals, left, mid, start);
		}
		else
			return bsearch_start(intervals, mid + 1, right, start);
	}
	
	private int bsearch_end(List<Interval> intervals, int left, int right, int end){
		if(left > right){
			return right;
		}
		int mid = (left + right + 1) / 2;
		if(intervals.get(mid).start == end)
			return mid;
		else if(intervals.get(mid).start > end)
			return bsearch_end(intervals, left, mid - 1, end);
		else{
			if(mid == right)
				return right;
			else
				return bsearch_end(intervals, mid, right, end);
		}
	}
	
	private void test(){
		List<Interval> list = new LinkedList<>();
//		list.add(new Interval(1, 2));
//		list.add(new Interval(3, 5));
//		list.add(new Interval(6, 7));
//		list.add(new Interval(8, 10));
//		list.add(new Interval(12, 16));
		list = insert(list, new Interval(4, 9));
		for (Interval interval : list) {
			System.out.printf("[%d, %d]\n", interval.start, interval.end);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InsertInterval().test();
	}

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

}
