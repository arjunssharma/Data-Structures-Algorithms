package leetcode;

public class NumberOfIslands {

	int m, n;
	public int calculateNumberOfIslands(char grid[][]) {
		int count = 0;
		m = grid.length;
		if(m == 0)
			return 0;
		n = grid[0].length;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == '1') {
					marking(grid, i, j);
					count++;
				}
			}
		}
		
		return count;
	}
	
	public void marking(char grid[][], int i, int j) {
		if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1')
			return;
		
		grid[i][j] = 0;
		marking(grid, i + 1, j);
		marking(grid, i - 1, j);
		marking(grid, i , j + 1);
		marking(grid, i , j - 1);
	}
	
	public static void main(String args[]) {
		NumberOfIslands n = new NumberOfIslands();
		char grid[][] = {{'1','1','1'}, {'0','0','0'}, {'1','0','1'}};
		System.out.println(n.calculateNumberOfIslands(grid));
	}
}