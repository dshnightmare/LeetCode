public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		int num = 0;
		for(int i = 0; i < A.length; i++){
			if(A[i] == elem)
				num++;
			else
				A[i - num] = A[i];
		}
		return A.length - num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1, 2, 3, 4, 3, 6};
		System.out.println(new RemoveElement().removeElement(A, 3));
		for (int i : A) {
			System.out.print(i + " ");
		}
	}

}
