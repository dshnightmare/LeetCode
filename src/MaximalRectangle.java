public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		
	}
	
	public static void main(String[] args){
		char[][] matrix = {{'1', '1', '1', '1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1', '1', '1', '0'},
							{'1', '1', '1', '1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '1', '0', '0', '0'},
							{'0', '1', '1', '1', '1', '0', '0', '0'}};
		System.out.println(new MaximalRectangle().maximalRectangle(matrix));
	}
}