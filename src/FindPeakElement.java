public class FindPeakElement {
	public int findPeakElement(int[] num) {
		return search(num, 0, num.length - 1);
	}

	private int search(int[] num, int left, int right){
		int mid = left + (right - left) / 2;
		if((mid == 0 || num[mid - 1] < num[mid]) && 
				((mid == (num.length - 1)) || (num[mid] > num[mid + 1]))){
			return mid;
		}
		else if(mid > 0 && num[mid - 1] > num[mid])
			return search(num, left, mid - 1);
		else
			return search(num, mid + 1, right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
