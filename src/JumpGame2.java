public class JumpGame2 {
	public int jump(int[] A) {
		int num = 0, cur = 0;
		while(cur < A.length - 1) {
			num++;
			if(cur + A[cur] >= A.length - 1)
				break;
			int max = cur + A[cur], index = cur, i;
			for(i = cur + 1; i <= cur + A[cur] && i < A.length; i++) {
				if(i + A[i] > max){
					max = i + A[i];
					index = i;
				}
			}
			cur = index;
		}
		return num;
	}
	
	public static void main(String[] args) {
		int[] num = {3, 2, 1};
		System.out.println(new JumpGame2().jump(num));
	}
}