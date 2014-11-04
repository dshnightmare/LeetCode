/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class SortColors {
	public void sortColors(int[] A) {
		int p = -1, q = A.length;
		if(q == 0 || q == 1)
			return;
		int i = 0, j = A.length - 1;
		do {
			while(i <= j && A[i] != 2){
				if(A[i] == 0){
					if(p != -1){
						A[p] = 0;
						A[i] = 1;
						p++;
					}
				}else {
					if(p == -1)
						p = i;
				}
				i++;
			}
			while(i <= j && A[j] != 0){
				if(A[j] == 2){
					if(q != A.length){
						A[q]= 2;
						A[j] = 1;
						q--;
					}
				}else {
					if(q == A.length)
						q = j;
				}
				j--;
			}
			if(i >= j)
				break;
			int tmp = A[i];
			A[i] = A[j];
			A[j] = tmp;
		} while (i < j);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 0, 1, 2, 0, 2, 1, 2};
		new SortColors().sortColors(a);
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
	}

}
