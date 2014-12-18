public class SearchinRotatedSortedArray2 {
	public boolean search(int[] A, int target) {
		return bsearch(A, 0, A.length - 1, target);
	}

	private boolean bsearch(int[] A, int left, int right, int target){
		if(left > right)
			return false;
		int mid = (left + right) / 2;
		if(A[mid] == target)
			return true;
		if(A[mid] > A[left]){
			if(A[left] <= target && target < A[mid])
				return bsearch(A, left, mid - 1, target);
			else
				return bsearch(A, mid + 1, right, target);
		}
		else if(A[mid] < A[left]){
			if(A[mid] < target && target <= A[right])
				return bsearch(A, mid + 1, right, target);
			else
				return bsearch(A, left, mid - 1, target);
		}
		else{
			return bsearch(A, left + 1, right, target);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
