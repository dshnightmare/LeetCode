public class SearchForRange {
	public int[] searchRange(int[] A, int target) {
		int[] r = new int[2];
		r[0] = search_up(A, 0, A.length - 1, target);
		r[1] = search_low(A, 0, A.length - 1, target);
		return r;
	}

	int search_up(int[] A, int left, int right, int target) {
		if(left > right)
			return -1;
		int mid = (left + right + 1) / 2;
		if(A[mid] == target)
		{
			int tmp = search_up(A, left, mid - 1, target);
			if(tmp == -1)
				return mid;
			else
				return tmp;
		}
		else if(A[mid] < target)
			return search_up(A, mid + 1, right, target);
		else
			return search_up(A, left, mid - 1, target);
	}

	int search_low(int[] A, int left, int right, int target) {
		if(left > right)
			return -1;
		int mid = (left + right + 1) / 2;
		if(A[mid] == target)
		{
			int tmp = search_low(A, mid + 1, right, target);
			if(tmp == -1)
				return mid;
			else
				return tmp;
		}
		else if(A[mid] < target)
			return search_low(A, mid + 1, right, target);
		else
			return search_low(A, left, mid - 1, target);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {5, 7, 7, 8, 8, 10};
		new SearchForRange().searchRange(A, 11);
	}

}
