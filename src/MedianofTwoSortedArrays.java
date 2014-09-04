import javax.security.auth.kerberos.KerberosKey;
import javax.sql.rowset.serial.SerialArray;


/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class MedianofTwoSortedArrays {

	public double findMedianSortedArrays(int A[], int B[]) {
		int i = (A.length + B.length + 1) >> 1;
		int j = (A.length + B.length + 2) >> 1;
		return (0.0 + search(i, A, 0, A.length, B, 0, B.length) + search(j, A, 0, A.length, B, 0, B.length)) / 2;
	}

	public int search(int target, int[] A, int m, int n, int[] B, int p, int q)
	{
		if(n > q)
			return search(target, B, p, q, A, m, n);
		if(n == 0)
			return B[p + target - 1];
		if(target == 1)
			return A[m] < B[p] ? A[m] : B[p];
		int i = n < (target / 2) ? n : (target / 2);
		int j = q < (target / 2) ? q : (target / 2);
		if(A[m + i - 1] > B[p + j - 1])
			return search(target - j, A, m, n, B, p + j, q - j);
		else
			return search(target - i, A, m + i, n - i, B, p, q);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2}, B = {};
		System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(A, B));

	}

}
