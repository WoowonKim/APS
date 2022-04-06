import java.util.Scanner;

public class Main {
	static int[][] sudoku;
	static int emptyR, emptyC;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sudoku = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = sc.nextInt();
			}
		}
		int[] empty = findEmpty();

		for (int i = 1; i <= 9; i++) {
			backTrack(empty[0], empty[1], i);
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(sudoku[i][j]+" ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static boolean backTrack(int row, int col, int num) {
		if (!checkRow(row, col, num))
			return false;
		if (!checkCol(row, col, num))
			return false;
		if (!checkBox(row, col, num))
			return false;

		sudoku[row][col] = num;
		
		int[] empty = findEmpty();
		
		if (empty[0] == 9 && empty[1] == 9)
			return true;

		for (int i = 1; i <= 9; i++) {
			if (backTrack(empty[0], empty[1], i))
				return true;
		}
		
		sudoku[row][col] = 0;
		return false;

	}

	private static boolean checkBox(int row, int col, int num) {
		int stRow = (row / 3) * 3;
		int stCol = (col / 3) * 3;
		for (int i = stRow; i < stRow + 3; i++) {
			for (int j = stCol; j < stCol + 3; j++) {
				if (sudoku[i][j] == num)
					return false;
			}
		}
		return true;
	}

	private static boolean checkCol(int row, int col, int num) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][col] == num)
				return false;
		}
		return true;
	}

	private static boolean checkRow(int row, int col, int num) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[row][i] == num)
				return false;
		}
		return true;
	}

	private static int[] findEmpty() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudoku[i][j] == 0)
					return new int[] { i, j };
			}
		}
		return new int[] { 9, 9 };
	}

}
