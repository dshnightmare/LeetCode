
public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		if(A.length == 0)
			return 1;
		for(int i = 0; i < A.length; i++){
			int target = A[i], tmp;
			while(target > 0 && target - 1 < A.length && target != A[target - 1]){
				tmp = A[target - 1];
				A[target - 1] = target;
				target = A[i] = tmp;
			}
		}
		for(int i = 0; i < A.length; i++){
			if(A[i] != i + 1)
				return i + 1;
		}
		return A.length + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3, 4, -1, 1};
		System.out.println(new FirstMissingPositive().firstMissingPositive(A));
	}

}