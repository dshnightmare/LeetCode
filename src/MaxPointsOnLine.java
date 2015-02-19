import java.util.HashMap;

public class MaxPointsOnLine {
	// ax + by + 1 = 0
	public int maxPoints(Point[] points) {
		if(points.length <= 2)
			return points.length;
		HashMap<Integer, Integer> map; 
		int max = 2;
		for(int i = 0; i < points.length; i++) {
			map = new HashMap<>();
			int maxcount = 1, overlap = 0;
			for(int j = i + 1; j < points.length; j++) {
				double dx = points[i].x - points[j].x;
				double dy = points[i].y - points[j].y;
				if(Math.abs(dx) < 1e-6 && Math.abs(dy) < 1e-6){
					overlap++;
					continue;
				}
				int ratio = (int)(Math.abs(dy) / (Math.abs(dx) + Math.abs(dy)) * 1e6);
				if(dx * dy < 0)
					ratio = -ratio;
				if(map.containsKey(ratio)){
					map.put(ratio, map.get(ratio) + 1);
				}
				else{
					map.put(ratio, 2);
				}
				if(maxcount < map.get(ratio))
					maxcount = map.get(ratio);
			}
			maxcount += overlap;
			if(maxcount > max)
				max = maxcount;
		}
		return max;
	}
	
	class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	
	public void test() {
		
	}
	
	public static void main(String[] args) {
		
	}
}