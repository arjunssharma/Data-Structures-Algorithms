import java.util.Arrays;

public class LongestNonDecreasingSubSequence {
	public static void main(String args[]) {
		 int s[] = { 2,5,1,7 };
		 findLNDS(s);
	}

	public static int findLNDS(int s[]) {
		int n = s.length;	
		//base case
		if (n == 0) {
			return 0;
		}
		int list[] = new int[n];
		int sequence[] = new int[n];
		int i, j, max = 0, maxIndex = 0;
		for (i = 0; i < n; i++){
			list[i] = 1;
			sequence[i] = -1;
			for (j = 0; j < i; j++){
				if (s[i] >= s[j] && list[i] < list[j] + 1) {
					list[i] = list[j] + 1;
					sequence[i] = j;
					if(max < list[i]) {
						max = list[i];
						maxIndex = i;
					}
				}
			}
//			System.out.println("i :" + i);
//			System.out.println("list: "+ Arrays.toString(list));
//			System.out.println("sequence: "+ Arrays.toString(sequence));
		}
		
//		System.out.println("Max: "+ max);
//		System.out.println("MaxIndex: "+ maxIndex);
//		System.out.println("sequence: "+Arrays.toString(sequence));
		int k = max - 1;
		int result[] = new int[max];
		while(true){
			result[k] = s[maxIndex];
			maxIndex = sequence[maxIndex];
			k--;
//			System.out.println("Resultant Array: "+Arrays.toString(result));
//			System.out.println("MaxIndex: "+maxIndex);
			if(maxIndex == -1){
				break;
			}
		}	
		System.out.println("Longest Non Decreasing Sub Sequence is: "+ Arrays.toString(result));		
		return max;
	}
}
