/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class MergeSortedArray {

	/**
	 * @param args
	 */
	public static void merge(int A[], int m, int B[], int n) {
		for (int i = m - 1; i >= 0; i--)
			A[i + n] = A[i];
		int i = n, j = 0, k = 0;
		while (i < m + n && j < n) {
			if (A[i] < B[j])
				A[k++] = A[i++];
			else
				A[k++] = B[j++];
		}
		while (i < m + n)
			A[k++] = A[i++];
		while (j < n)
			A[k++] = B[j++];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 3, 5, 7, 9, 0, 0, 0, 0 ,0};
		int[] b = {2, 4, 6, 8, 10};
		merge(a, 5, b, 5);
		for(int i = 0; i < 10; i++)
			System.out.println(a[i]);
	}

}
