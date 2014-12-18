public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int col = search_col(matrix, 0, matrix.length - 1, target);
		return search_row(matrix[col], 0, matrix[col].length - 1, target);
	}
	
	private int search_col(int[][] matrix, int up, int low, int target){
		if(up >= low)
			return low;
		int mid = (up + low + 1) / 2;
		if(matrix[mid][0] == target)
			return mid;
		else if(matrix[mid][0] < target)
			return search_col(matrix, mid, low, target);
		else
			return search_col(matrix, up, mid - 1, target);
	}
	
	private boolean search_row(int[] row, int left, int right, int target){
		if(left > right)
			return false;
		int mid = (left + right) / 2;
		if(row[mid] == target)
			return true;
		else if(row[mid] > target)
			return search_row(row, left, mid - 1, target);
		else
			return search_row(row, mid + 1, right, target);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
		System.out.println(new Search2DMatrix().searchMatrix(a, 21));
	}

}
