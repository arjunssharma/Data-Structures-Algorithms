package leetcode;

import java.util.Arrays;

public class GameOfLife {
	public static void gameOfLife(int[][] board) {
		if (board == null || board.length == 0)
			return;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int lives = live_neighbor(board, i, j);

				if (board[i][j] == 0 && lives == 3)
					board[i][j] = 2;

				if (board[i][j] == 1 && (lives == 2 || lives == 3))
					board[i][j] = 3;
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++)
				board[i][j] >>= 1;
		}
	}

	public static int live_neighbor(int board[][], int row, int col) {
		int count = 0;
		int row_min = Math.max(row - 1, 0);
		int row_max = Math.min(row + 1, board.length - 1);
		int col_min = Math.max(col - 1, 0);
		int col_max = Math.min(col + 1, board[0].length - 1);
		for (int i = row_min; i <= row_max; i++) {
			for (int j = col_min; j <= col_max; j++) {
				if (i == row && j == col)
					continue;
				if (board[i][j] % 2 == 1)
					count++;
			}
		}

		return count;
	}

	public static void main(String args[]) {
		int board[][] = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		gameOfLife(board);
		for(int i = 0; i < board.length; i++)
			System.out.println(Arrays.toString(board[i]));
	}
}