package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	
	public List<Integer> spiral(int [][]matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if(matrix.length == 0)
			return result;
		
		int row1 = 0;
		int row2 = matrix.length - 1;
		int column1 = 0;
		int column2 = matrix[0].length - 1;
		
		while(row1 <= row2 && column1 <= column2) {
			for(int c = column1; c <= column2; c++)
				result.add(matrix[row1][c]);
			
			for(int r = row1 + 1; r <= row2; r++)
				result.add(matrix[r][column2]);
				
		    if(row1 < row2 && column1 < column2) {
		    	for(int c = column2 - 1; c > column1; c--)
		    		result.add(matrix[row2][c]);
		    	
		    	for(int r = row2; r > row1; r--)
		    		result.add(matrix[r][column1]);
		    }
		    	
		    row1++;
		    row2--;
		    column1++;
		    column2--;
		}
		
		return result;
	}
	
	public static void main(String args[]) {
		SpiralMatrix m = new SpiralMatrix();
		int matrix[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		List<Integer> result = m.spiral(matrix);
		System.out.println(result);
	}
}
