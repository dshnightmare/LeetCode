public class RemoveDuplicatesSortedArray {
	public int removeDuplicates(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		int pre = A[0], num = 0;
		for(int i = 1; i < A.length; i++){
			if(A[i] == pre)
				num++;
			else {
				pre = A[i];
				A[i - num] = A[i];
			}
		}
		return A.length - num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1, 2, 2, 4, 4, 6};
		System.out.println(new RemoveDuplicatesSortedArray().removeDuplicates(A));
		for (int i : A) {
			System.out.print(i + " ");
		}
	}

}
