package codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class HugeNumbers {
	public static void main(String args[]) throws NumberFormatException, IOException {
		FileReader sampleFile = new FileReader("src/codejam/A-small-attempt2.in");
		BufferedReader br = new BufferedReader(sampleFile);
		File fout = new File("src/codejam/out.txt");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; ++i) {
			String array[] = br.readLine().split(" ");
			int a = Integer.parseInt(array[0]);
			int n = Integer.parseInt(array[1]);
			int p = Integer.parseInt(array[2]);
			int answer = (int) (Math.pow(a, calculateFactorial(n)) % p);
			bw.write("Case #" + i + ": " + answer);
			if(i!=t)
			bw.newLine();
		}
		
		bw.close();
		br.close();
	}
	
	public static int calculateFactorial(int n) {
		int fact = 1;
		if(n == 0 || n == 1){
			return 1;
		}
		else {
			for(int i = 1; i <= n; i++) {
				fact *= i;
			}
		}
		return fact;
	}
}
