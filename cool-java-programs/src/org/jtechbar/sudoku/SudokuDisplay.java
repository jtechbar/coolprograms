package org.jtechbar.sudoku;

public class SudokuDisplay {
	
	public void display(int[][] sudokuArray) {
		int size=sudokuArray.length;
		
		for(int row=0;row<size;row++) {
			if(row%3==0) {
				System.out.println("  --------------------------");
			}
			for(int column=0;column<size;column++) {
				if(column%3==0) {
					System.out.print(" | ");
				}
				System.out.print(sudokuArray[row][column]+" ");
			}
			System.out.println("|");
		}
		System.out.println("  --------------------------");
	}

}
