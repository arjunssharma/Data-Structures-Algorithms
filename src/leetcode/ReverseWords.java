package leetcode;

public class ReverseWords {

	public void reverseWord(char []s) {
		reverse(s, 0, s.length - 1);
		int r = 0;
		while(r < s.length) {
			int l = r;
			while(r < s.length && s[r] != ' ')
				r++;
			
			reverse(s, l, r - 1);
			r++;
		}
	}
	
	private void reverse(char s[], int left, int right) {
		while(left < right) {
			char temp = s[left];
			s[left++] = s[right];
			s[right--] = temp;
		}
	}
	
	public static void main(String args[]) {
		ReverseWords r = new ReverseWords();
		char s[] = {'m','y', ' ', 'n', 'a', 'm', 'e', ' ', 'i', 's', ' ', 'a','r','j','u','n'};
		r.reverseWord(s);
		System.out.println(new String(s));
	}
}