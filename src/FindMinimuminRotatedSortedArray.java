public class FindMinimuminRotatedSortedArray {
	public int findMin(int[] num) {
		return search(num, 0, num.length - 1, num[0]);
	}
	
	private int search(int[] A, int left, int right, int min){
		if(left > right)
			return min;
		int mid = (left + right) / 2;
		if(A[mid] >= A[left]){
			return search(A, mid + 1, right, A[left] < min ? A[left] : min);
		}
		else {
			return search(A, left, mid - 1, A[mid] < min ? A[mid] : min);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1 ,2};
		System.out.println(new FindMinimuminRotatedSortedArray().findMin(num));
	}

}
