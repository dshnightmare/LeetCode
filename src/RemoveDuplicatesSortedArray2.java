
public class RemoveDuplicatesSortedArray2 {
	public int removeDuplicates(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		int pre = A[0], num = 0, count = 0;
		for(int i = 1; i < A.length; i++){
			if(A[i] == pre && count > 0){
				num++;
			}
			else {
				if(A[i] == pre)
					count++;
				else
					count = 0;
				pre = A[i];
				A[i - num] = A[i];
			}
		}
		return A.length - num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 1, 1};
		System.out.println(new RemoveDuplicatesSortedArray2().removeDuplicates(A));
	}

}
