import java.util.HashMap;
import java.util.Map;

public class DuplicateEmail {
	
	public static void main(String args[]) {
		String emails[] = {"...+.@xyz.com", "...+@x.yz.com", "...++@xy.z.com"};
		System.out.println(solution(emails));
	}
	
	public static int solution(String[] L) {
		// write your code in Java SE 8
		Map<String, Integer> map = new HashMap<>();
		int count = 0;
		for (String email : L) {
			String split[] = email.split("@");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < split[0].length(); i++) {
				if (split[0].charAt(i) == '+')
					break;
				if (split[0].charAt(i) != '.')
					sb.append(split[0].charAt(i));
			}
			String modified = sb.toString() + split[1];
			map.put(modified, map.getOrDefault(modified, 0) + 1);
		}

		for (String key : map.keySet()) {
			if (map.get(key) > 1)
				count++;
		}

		return count;
	}
}