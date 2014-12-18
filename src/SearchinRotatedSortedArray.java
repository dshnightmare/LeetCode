public class SearchinRotatedSortedArray {
	public int search(int[] A, int target) {
		return bsearch(A, 0, A.length - 1, target);
	}

	private int bsearch(int[] A, int left, int right, int tag){
		if(left > right)
			return -1;
		int mid = (left + right) / 2;
		System.out.println(mid);
		if(A[mid] == tag)
			return mid;
		else if(A[mid] < tag){
			if(A[left] > A[right]){
				if(A[mid] > A[right])
					return bsearch(A, mid + 1, right, tag);
				else
				{
					if(tag > A[right])
						return bsearch(A, left, mid - 1, tag);
					else
						return bsearch(A, mid + 1, right, tag);
				}
			}
			else{
				return bsearch(A, mid + 1, right, tag);
			}
		}
		else {
			if(A[left] > A[right]){
				if(A[mid] <= A[right])
					return bsearch(A, left, mid - 1, tag);
				else{
					if(tag < A[left])
						return bsearch(A, mid + 1, right, tag);
					else
						return bsearch(A, left, mid - 1, tag);
				}
			}
			else{
				return bsearch(A, left, mid - 1, tag);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {5,1,2,3,4};
		System.out.println(new SearchinRotatedSortedArray().search(a, 1));
	}

}
