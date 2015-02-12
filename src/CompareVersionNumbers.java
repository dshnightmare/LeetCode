public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		String[] r1 = version1.split("\\."), r2 = version2.split("\\.");
		int length = Math.max(r1.length, r2.length);
		for(int i = 0; i < length; i++){
			int num1 = i < r1.length ? Integer.parseInt(r1[i]) : 0;
			int num2 = i < r2.length ? Integer.parseInt(r2[i]) : 0;
			if(num1 > num2)
				return 1;
			else if(num1 < num2)
				return -1;
		}
		return 0;
	}
	
	public static void main(String[] args){
		System.out.println(new CompareVersionNumbers().compareVersion("1.0", "1"));
	}
}