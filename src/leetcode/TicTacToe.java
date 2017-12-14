package leetcode;

public class TicTacToe {

	private int columns[];
	private int rows[];
	private int diagonal = 0;
	private int antiDiagonal = 0;

	public TicTacToe(int n) {
		columns = new int[n];
		rows = new int[n];
	}

	public int move(int row, int col, int player) {
		int toAdd = player == 1 ? 1 : -1;
		rows[row] += toAdd;
		columns[col] += toAdd;

		if (col == row)
			diagonal += toAdd;

		if (col == (columns.length - row - 1))
			antiDiagonal += toAdd;

		int size = rows.length;
		if (Math.abs(rows[row]) == size || Math.abs(columns[col]) == size || Math.abs(diagonal) == size
				|| Math.abs(antiDiagonal) == size)
			return player;

		return 0;
	}
	
	public static void main(String args[]) {
		TicTacToe t = new TicTacToe(3);
		System.out.println(t.move(0, 0, 1));
		System.out.println(t.move(1, 2, 2));
		System.out.println(t.move(2, 2, 1));
		System.out.println(t.move(1, 0, 2));
		System.out.println(t.move(2, 2, 1));
	}
}
