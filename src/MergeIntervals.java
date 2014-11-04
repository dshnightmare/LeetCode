import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> r = new ArrayList<>();
		if(intervals.size() == 0)
			return r;
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if(o1.start == o2.start)
					return o1.end - o2.end;
				return o1.start - o2.start;
			}
		});
		Interval cur = new Interval(intervals.get(0).start, intervals.get(0).end);
		for(int i = 1; i < intervals.size(); i++){
			Interval tmp = intervals.get(i);
			if(tmp.start <= cur.end)
			{
				cur.end = tmp.end > cur.end ? tmp.end : cur.end;
			}
			else {
				r.add(cur);
				cur = new Interval(tmp.start, tmp.end);
			}
		}
		r.add(cur);
		return r;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MergeIntervals().test();
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
	
	void test(){
		List<Interval> list = new ArrayList<>();
		list.add(new Interval(1, 3));
		list.add(new Interval(2, 6));
		list.add(new Interval(8, 10));
		list.add(new Interval(15, 18));
		list = merge(list);
		for (Interval interval : list) {
			System.out.print("{" + interval.start + ", " + interval.end + "} ");
		}
	}
}
