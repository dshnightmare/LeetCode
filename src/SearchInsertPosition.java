public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		return search(A, 0, A.length - 1, target);
	}

	private int search(int[] A, int left, int right, int target){
		if(left > right)
			return left;
		int mid = (left + right) / 2;
		if(A[mid] == target)
			return mid;
		else if(A[mid] < target)
			return search(A, mid + 1, right, target);
		else
			return search(A, left, mid - 1, target);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 3, 5, 6};
		System.out.println(new SearchInsertPosition().searchInsert(A, 5));
		System.out.println(new SearchInsertPosition().searchInsert(A, 2));
		System.out.println(new SearchInsertPosition().searchInsert(A, 7));
		System.out.println(new SearchInsertPosition().searchInsert(A, 0));
		System.out.println(new SearchInsertPosition().searchInsert(A, -1));
	}

}
