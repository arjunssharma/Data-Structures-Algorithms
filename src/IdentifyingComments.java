import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdentifyingComments {
static final Pattern PATTERN = Pattern.compile("(//[^\\n]*)|(/\\*.*?\\*/)", Pattern.MULTILINE | Pattern.DOTALL);
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();
		while (sc.hasNextLine()) {
			sb.append(sc.nextLine());
			sb.append("\n");
		}
        String code = sb.toString();

		Matcher matcher = PATTERN.matcher(code);
		while (matcher.find()) {
			String comments = matcher.group();
			display(comments);
		}

		sc.close();
        
	}
    

	static void display(String comments) {
		Scanner sc = new Scanner(comments);

		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine().trim());
		}

		sc.close();
	}
}
