
public class RabinKarpSubstring {

	private final int prime = 3;
	
	public int findSubstring(char text[], char[] pattern) {
		int m = pattern.length;
		int n = text.length;
		int textHash = calculateHash(text, m - 1);
		int patternHash = calculateHash(pattern, m - 1);
		for (int i = 1; i <= n - m + 1; i++) {
			if (textHash == patternHash && checkStringsEqual(text, i - 1, i + m - 2, pattern, 0, m - 1))
				return i - 1;
			if (i < n - m + 1)
				textHash = reCalculateHash(text, i - 1, i + m - 1, textHash, m);
		}
		return -1;
	}

	public boolean checkStringsEqual(char text[], int textStart, int textEnd, 
			char pattern[], int patternStart, int patternEnd) {	
		for(int i = textStart, j = patternStart; i <= textEnd && j <= patternEnd; i++, j++) {
			if(text[i] != pattern[j])
				return false;
		}
		
		return true;
	}

	public int reCalculateHash(char text[], int oldIndex, int newIndex, int oldHashValue, int patternLength) {
		int newHashValue = oldHashValue - text[oldIndex];
		newHashValue = newHashValue / prime;
		newHashValue += text[newIndex] * Math.pow(prime, patternLength - 1);
		return newHashValue;
	}

	public int calculateHash(char str[], int length) {
		int hashValue = 0;
		for (int i = 0; i <= length; i++) {
			hashValue += str[i]*Math.pow(prime, i);
		}
		return hashValue;
	}
	
	
	public static void main(String args[]) {
		char text[] = "arjun_sharma".toCharArray();
		char pattern[] = "shar".toCharArray();
		System.out.println(new RabinKarpSubstring().findSubstring(text, pattern));
	}
}
